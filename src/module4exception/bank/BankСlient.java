package module4exception.bank;

public class BankСlient {

    private boolean problemWithLow;
    private boolean badCriditHistory;

    public BankСlient() {
    }

    public BankСlient(boolean rpoblemWithLow, boolean badCriditHistory) {
        this.problemWithLow = rpoblemWithLow;
        this.badCriditHistory = badCriditHistory;
    }

    public boolean isProblemWithLow() {
        return problemWithLow;
    }

    public void setProblemWithLow(boolean problemWithLow) {
        this.problemWithLow = problemWithLow;
    }

    public boolean isBadCriditHistory() {
        return badCriditHistory;
    }

    public void setBadCriditHistory(boolean badCriditHistory) {
        this.badCriditHistory = badCriditHistory;
    }
}
