import java.util.*;

public class Customer {
   private double cardBalance = 0;
   private int ID = 0;
   private int pin;
   private int run = 1;
   private int access = 0;
   
   public Customer(double cardBalance, int ID) {
      if(cardBalance>=200) {
         this.cardBalance = cardBalance;
         this.ID = ID;
         
         Random generator = new Random();
         this.pin = generator.nextInt(10000);
         //System.out.println("New pin: "+pin);
         
      }
      else {
         System.out.println("Must at least deposit 200 DKr.");
      }     
   }
   
   public void buyWash() {
      //TODO
   }
   
   public void showPin(){
         
      if(NumberDigits(pin) == 4){
         System.out.println(pin);
      } else if(NumberDigits(pin) == 3){
         System.out.println("0"+pin);
      } else if(NumberDigits(pin) == 2){
         System.out.println("00"+pin);
      } else if(NumberDigits(pin) == 1){
         System.out.println("000"+pin);
      }
   
   }
   
   public void getAccess(){
      System.out.println("Please type your pin");
      
      Scanner scanner = new Scanner(System.in);
      int Continue = scanner.nextInt();
      
      if (Continue == this.pin && NumberDigits(pin) == 4){
         this.access = 1;
      } else {
         System.out.println("Invalid pin!");
         this.run = 0;
      }
      
   }
   
   public int NumberDigits(int num){
      int count = 0;

      for(; num != 0; num/=10, ++count) {   
      }
      
      return count;
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
            //Exit
            this.run = 0;
            this.access = 0;
            break;
         default: 
            System.out.println("Not a valid option... Please try again.");
      }
   
   }
}