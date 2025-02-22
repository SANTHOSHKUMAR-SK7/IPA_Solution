package Bank;

import java.util.Scanner;

public class Bank_Account_IPA {
    public static void main(String[] args){
        Bank[] arr = new Bank[3];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter a Account Number of Person "+(i+1)+" : ");
            int accNum = in.nextInt();in.nextLine();
            System.out.print("Enter a Account HolderName : ");
            String name  = in.nextLine();
            System.out.print("Enter a Account Balance : ");
            double bal =in.nextDouble();in.nextLine();
            arr[i]= new Bank(accNum,name,bal);
        }
        System.out.print("Enter a Target account number : ");
        int tarNo = in.nextInt();in.nextLine();
        System.out.print("Enter a withdraw Amount : ");
        double withdrawAmount = in.nextDouble();in.nextLine();
        System.out.print("Enter a deposit Amount : ");
        double depositAmount= in.nextDouble();
        double withdraw = withdraw(arr,tarNo,withdrawAmount);
        double deposit = deposit(arr,tarNo,depositAmount);
        if(withdraw == -2){
            System.out.println("Account Number Not Found");
        }
        if(withdraw == -1){
            System.out.println("Insufficient Balance");
        }
        if(withdraw>=0){
            System.out.println("After Withdraw : "+withdraw);
        }

        if(deposit == -1){
            System.out.println("Account Number Not Found");
        }
        if(deposit>=0){
            System.out.println("After Deposit : "+deposit);
        }

    }
    static double withdraw(Bank[] bank,int accNo,double Amount){
        for (int i = 0; i < bank.length; i++) {
            if(bank[i].getAccountNumber() == accNo){
                if(bank[i].getBalance() >= Amount) {
                    double newBal = bank[i].getBalance() - Amount;
                    bank[i].setBalance(newBal);
                    return bank[i].getBalance();
                }
                else{
                    return -1;
                }
            }

        }
        return -2;
    }
    static double deposit (Bank[] arr, int accNo,double amount){
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i].getAccountNumber() == accNo){
                double temp = arr[i].getBalance() +amount;
                arr[i].setBalance(temp);
                return arr[i].getBalance();
            }
        }
        return -1;
    }

}

class Bank{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    Bank(int accNo,String accName, double balance){
        this.accountNumber = accNo;
        this.accountHolderName = accName;
        this.balance = balance;
    }

    int getAccountNumber(){
        return accountNumber;
    }

    String getAccountHolderName(){
        return accountHolderName;
    }
    double getBalance(){
        return balance;
    }

    void setAccountNumber(int accNo){
        this.accountNumber = accNo;
    }

    void setAccountHolderName(String name){
        this.accountHolderName =name;
    }
    void setBalance(double bal){
        this.balance = bal;
    }
}