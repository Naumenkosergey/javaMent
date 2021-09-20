package module4exception.messagetask;

import java.util.logging.*;

/**
 * Класс, в котором скрыта логика настоящей почты
 */
public class RealMailService implements MailService {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    static int counter = 0;
    String name;

    public RealMailService() {
        counter++;
        name = "RealMailService" + counter;
    }

    public RealMailService(String name) {
        counter++;
        this.name = name;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        System.out.println("RealMailService" + name + "");
        return mail;
    }

    /**
     * Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
     * Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
     * Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех
     * посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору,
     * он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
     */
    public static class Thief implements MailService {
        private int minPrice;
        private int stolenValue;

        public Thief(int minCost) {
            this.minPrice = minCost;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            MailPackage mailPackage;
            if (mail instanceof MailPackage) {
                mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getPrice() > minPrice) {
                    stolenValue += mailPackage.getContent().getPrice();
                    return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(),
                            new Package("stones instead of" + mailPackage.getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }

    /**
     * 2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется
     * от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
     * MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
     * полей почты):
     * 2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем
     * WARN: Detected target mail correspondence: from {from} to {to} "{message}"
     * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
     */
    public static class Spy implements MailService {

        //        private static Logger LOGGER = Logger.getLogger(Spy.class.getName());
        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            MailMessage message;
            if (mail instanceof MailMessage) {
                message = (MailMessage) mail;
                if (!message.getTo().equals(AUSTIN_POWERS) && !message.getFrom().equals(AUSTIN_POWERS)) {
                    logger.log(Level.INFO, "Usual correspondence:{0} to {1}",
                            new Object[]{message.getFrom(), message.getTo()});
                } else {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{message.getFrom(), message.getTo(), message.getMessage()});
                }
            }
            return mail;
        }
    }

    /**
     * Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
     * если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
     * ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку,
     * состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
     * Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
     */
    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            MailPackage mailPackage;
            if (mail instanceof MailPackage) {
                mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getContent().contains(WEAPONS) ||
                        mailPackage.getContent().getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                } else if (mailPackage.getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    /**
     * UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
     * почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
     * в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker
     * должен быть конструктор от массива MailService (результат вызова processMail первого элемента массива передается на
     * вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
     * экземпляр RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.
     */
    public static class UntrustworthyMailWorker implements MailService {

        private RealMailService realMailService;
        private MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            realMailService = new RealMailService("RealMaileservice");
            this.mailServices = mailServices;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable sendable = mail;
            for (MailService services : mailServices) {
                sendable = services.processMail(sendable);
            }
            return getRealMailService().processMail(sendable);
        }
    }

    public static class IllegalPackageException extends RuntimeException {

        public IllegalPackageException() {

        }
    }

    public static class StolenPackageException extends RuntimeException {

        public StolenPackageException() {
        }
    }

    static class Main {
        private static final Logger logger = Logger.getLogger("Spy");

        public static void main(String[] args) {
            Handler handlerToConsole = new ConsoleHandler();
            handlerToConsole.setLevel(Level.OFF);
            Formatter formatter = new SimpleFormatter();
            handlerToConsole.setFormatter(formatter);
            logger.addHandler(handlerToConsole);

            AbstractSendable letter = new MailMessage("Austin Powers", "Austin Powers", "Hello my friend");
            AbstractSendable letter1 = new MailMessage("From_Somebody", "To_Somebody", "Hello Somebody");
            AbstractSendable parcel = new MailPackage("hui hui", "Austin Powers", new Package("Hello my friend", 10));
            AbstractSendable parcel1 = new MailPackage("Sanata", "Austin Powers", new Package(" 1 stones 3", 6));
            AbstractSendable parcel2 = new MailPackage("Barbara", "Bomberman", new Package("weapons", 4));

            MailService spy = new Spy(logger);
            spy.processMail(letter);
            spy.processMail(letter1);
            spy.processMail(parcel);

            MailService inspector = new Inspector();
            inspector.processMail(parcel);

            MailService thief = new Thief(5);
            thief.processMail(letter);
            thief.processMail(letter1);
            thief.processMail(parcel);
            thief.processMail(parcel1);
            thief.processMail(parcel2);

            MailService[] mailServices = new MailService[]{spy, thief, inspector};
            MailService untrustedworker = new UntrustworthyMailWorker(mailServices);
        }
    }
}

