import java.util.*;

public class Customer {
   private int cardBalance = 0;
   private int ID = 0;
   private int pin;
   private int run = 1;
   
   public Customer(int cardBalance, String ID) {
      if(cardBalance>=200) {
         Files file = new Files();
         file.openFile("Customers.txt");
         //this.cardBalance = cardBalance;
         //this.ID = ID;
         Random generator = new Random();
         this.pin = generator.nextInt(10000);
         System.out.println(pin);
         String balance = Integer.toString(cardBalance);
         file.addToFile("Customers",ID,"","","",balance,this.pin);
         file.closeFile();     
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
   
      System.out.println("Do you want to EXIT?");
      System.out.println("\t1. yes\n\t2. no");
      Scanner scanner = new Scanner(System.in);
      int Continue = scanner.nextInt();
      
      if(Continue == 2){
         
         this.run = 0;
         
      } else if(Continue == 1) {
      
         this.run = 1;
      
      } else {
         
         System.out.println("Not a valid option!");
         
      }
   
   }
   
   public void mainMenu(){
   
      System.out.println("MAIN MENU: Please select one of the following options...");
      System.out.println("\t1. Recharge Washcard\n\t2. Get balance\n\t3. Buy wash\n\t4. Show statistics\n\t5. Exit");
      Scanner scanner = new Scanner(System.in);
      int action = scanner.nextInt();
      
      switch(action) {
         case 1:
            rechargeWashcard();
            //returnExit();
            break;
         case 2:
            getBalance();
            //returnExit();
            break;
         case 3:
            //Buy wash
            //returnExit();
            break;
         case 4:
            //Show statistics
            //returnExit();
            break;
         case 5:
            this.run = 0;
            break;
         default: 
            System.out.println("Not a valid option... Please try again.");
      }
   
   }
}