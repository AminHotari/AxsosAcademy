import java.util.Random;
public class BankAccount{
    private double checkingBalance;
    private double savingBalance;
    private static int numberOfAccount = 0;
    private static double totalAmount = 0.0;
    // private static double totalAmount1 = 0.0;
    // private long accountNumber = 0;

    public BankAccount (double checkingBalance, double savingBalance){
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numberOfAccount ++;
        // accountNumber = accountNumber();
        // totalAmount = checkingBalance + savingBalance;
    }

    // public static int numberOfAccount(){
    //     return numberOfAccount;
    // }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public void depositMoney(String type,double money){
        if(type == "checkingBalance"){
            double addMoney = getCheckingBalance()+money;
            totalAmount += money;
            System.out.println("Total money is: "+ totalAmount);
        }
        if(type == "savingBalance"){
            double addSave = getSavingBalance()+money;
            totalAmount += money;
            System.out.println("Total money is: "+ totalAmount);

        }
    }

    public void withDraw(String type, double money){
        if( type == "checkingBalance"){
            if(totalAmount > money){
                double drawMoney = getCheckingBalance() - money;
                totalAmount -= money;
                System.out.println("Your balance is: "+ totalAmount);
            }
            else{
                System.out.println("Your balance not enough,it is: "+totalAmount);
            }                
        }
        if(type == "savingBalance"){
            if(totalAmount > money){
                double drawMoney = getSavingBalance() + money;
                totalAmount -= money;
                System.out.println("Your balance is: "+ totalAmount);
            }
            else{
                System.out.println("Your balance not enough, it is: "+ totalAmount);
            }
        }
        
    }

    public void totalMoney(){
        System.out.println("Your total money is: "+ totalAmount);
    }

    // public void totalMoney(String type){
    //     if(type == "checkingBalance"){
    //         System.out.println("------Total money for checkingBalance---------");
    //         System.out.println("Your total money is: "+ totalAmount);
    //     }
    //     if(type == "savingBalance"){
    //         System.out.println("------Total money for savingBalance---------");
    //         System.out.println("Your total money is: "+ totalAmount1);
    //     }

        
    // }

        
    // private long accountNumber(){
    //     Random randomNumbers = new Random();
    //     long randomNum = randomNumbers.nextLong();
    //     return randomNum;    
    // }

}