package module4exception;


import module4exception.bank.*;

/*Есть класс BankClient - это класс, описывающий клиента банка.

Есть интерфейс BankWorker. Объект класса, который реализует этот интерфейс является работником банка,
в задачу которого входит одобрение или отклонение заявок на кредиты.

У него есть метод checkClientForCredit, который на вход принимает экземпляр BankClient и возвращает true,
если всё впорядке и кредит переданному клиенту можно выдавать, или false - если клиент не подходит под
условия кредита. Также, этот метод может выбросить исключение BadCreditHistoryException, если у клиента
плохая кредитная история. Или ProblemWithLawException, если у клиента есть проблемы с законом.

Ваша задача:

Реализовать метод getCreditForClient, который принимает работника банка и клиента, который хочет получить кредит.
 Метод должен возвращать true - если кредит выдать можно и все условия соблюдены и false если есть какие-то проблемы.
 Если клиенту отказали в выдаче кредита по причине плохой банковской истории - метод должен выводить в консоль сообщение
 "Проблемы с банковской историей", если клиенту отказали по причине проблем с законом то ничего выводить
 на экран не нужно.*/
public class PracticalTask4_2_6 {

    public static void main(String[] args) {
        BankWorker bankWorker = new Worker();
        BankСlient petr = new BankСlient(false, false);
        BankСlient serg = new BankСlient(false, true);
        BankСlient dima = new BankСlient(true, false);
        BankСlient dasha = new BankСlient(true, true);

        getCreditForClient(bankWorker, petr);
        getCreditForClient(bankWorker, serg);
        getCreditForClient(bankWorker, dima);
        getCreditForClient(bankWorker, dasha);
    }

    public static boolean getCreditForClient(BankWorker bankWorker, BankСlient bankСlient) {

        try {
           return bankWorker.checkClientForCredit(bankСlient);
        } catch (BadCreditHistoryException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (ProblemWithLawException e) {
            return false;
        }
    }
}
