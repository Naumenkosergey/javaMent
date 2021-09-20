package module4exception.bank;

public class Worker implements BankWorker{
    @Override
    public boolean checkClientForCredit(BankСlient bankСlient) throws BadCreditHistoryException, ProblemWithLawException {
        if (bankСlient.isBadCriditHistory()) {
            throw new BadCreditHistoryException("Проблемы с банковской историей");
        }
        else if (bankСlient.isProblemWithLow()) {
            throw new ProblemWithLawException("");
        }
        return true;
    }
}
