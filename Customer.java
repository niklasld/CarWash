import java.util.*;

public class Customer {
   private double cardBalance = 0;
   private int ID = 0;
   private int run = 1;
   
   public Customer(double cardBalance, int ID) {
      if(cardBalance>=200) {
         this.cardBalance = cardBalance;
         this.ID = ID;
      }
      else {
         System.out.println("Must at least deposit 200 DKr.");
      }     
   }
   
   public void buyWash() {
      //TODO
   }
   
   public void rechargeWashcard() {
      
      System.out.println("Please select the amount you want to recharge your washcard with...");
      
      Scanner scanner = new Scanner(System.in);
      double amount = scanner.nextDouble();
      
      if(amount>=200) {
         this.cardBalance += amount;
         System.out.println(cardBalance);
      }
      else {
         System.out.println("Must at least deposit 200 DKr.");
      }
   }
   
   public void getBalance() {
      
      System.out.println("Your card balance is: " + cardBalance + " DKr");
   }
   
   public int getRun(){
      return run;
   }
   
   public void returnExit(){
   
      System.out.println("Do you want to RETURN or EXIT?");
      Scanner scanner = new Scanner(System.in);
      String Continue.toLowerCase() = scanner.nextLine();
      
      if(Continue.equals("exit")){
         
         this.run = 0;
         
      } else if(Continue.equals("return")) {
      
         this.run = 1;
      
      } else {
         
         System.out.println("Not a valid option!");
         
      }
   
   }
   
<<<<<<< HEAD
   public void mainMenu(){
   
      System.out.println("MAIN MENU: Please select one of the following options...");
      System.out.println("Recharge Washcard | Get balance | Buy wash | Show statistics");
      Scanner scanner = new Scanner(System.in);
      String action = scanner.nextLine();
=======
   public double checkBalance() {
>>>>>>> 36e55c7c1399e7dd3cd0df49ab4e263ff4eb2839
      
      switch(action.toLowerCase()) {
         case "recharge":
            rechargeWashcard();
            returnExit();
            break;
         case "balance":
            getBalance();
            returnExit();
            break;
         case "buywash":
            //Buy wash
            returnExit();
            break;
         case "statistic":
            //Show statistics
            returnExit();
            break;
         case "exit":
            this.run = 0;
            break;
         default: 
            System.out.println("Not a valid option... Please try again.");
      }
   
   }
}