package module7functionalinterfaces;

import java.util.*;
import java.util.function.Consumer;

public class PracticalTask7_2_13 {

    public static void main(String[] args) {
        String randomFrom = "randomFrom"; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "ranomTo";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );


        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );


        // Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();
        // Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";

        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список зарплат, которые были ему отправлены.

        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";

    }


    public static class MailService<T> implements Consumer<Message<T>> {

        private static class MyMap<K, V> extends HashMap<K, V> {
            @Override
            public V get(Object key) {
                V temp = super.get(key);
                try {
                    if (temp == null) {
                        temp = (V) Collections.emptyList();
                    }
                } catch (ClassCastException ignore) {
                }
                return temp;
            }
        }


        private Map<String, List<T>> mailBox;

        public MailService() {
            mailBox = new MyMap<>();
        }

        @Override
        public void accept(Message<T> message) {
            List<T> listValue;
            if (mailBox.containsKey(message.getTo())) {
                listValue = mailBox.get(message.getTo());
            } else {
                listValue = new LinkedList<>();
            }
            listValue.add(message.getContent());
            mailBox.put(message.getTo(), listValue);
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }
    }


    public static class Salary implements Message<Integer> {

        private String from;
        private String to;
        private Integer content;

        public Salary(String from, String to, Integer content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public Integer getContent() {
            return content;
        }
    }

    public static class MailMessage implements Message<String> {

        private String from;
        private String to;
        private String content;

        public MailMessage(String from, String to, String message) {
            this.from = from;
            this.to = to;
            this.content = message;

        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public String getContent() {
            return content;
        }


    }

    public static interface Message<T> {
        public String getTo();

        public String getFrom();

        public T getContent();
    }
}
