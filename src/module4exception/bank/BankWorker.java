package module4exception.bank;

public interface BankWorker {

    boolean checkClientForCredit(BankСlient bankСlient) throws BadCreditHistoryException, ProblemWithLawException;
}
