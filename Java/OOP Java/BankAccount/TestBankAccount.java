public class TestBankAccount{
    public static void main(String[] args){
        BankAccount account = new BankAccount(2,4);
        account.depositMoney("checkingBalance", 20);
        account.depositMoney("savingBalance", 30);
        // System.out.println(BankAccount.numberOfAccount());
        account.withDraw("savingBalance", 40);
        account.withDraw("checkingBalance", 10);
        account.totalMoney();
        // account.totalMoney("checkingBalance");
        // account.totalMoney("savingBalance");
    }
}