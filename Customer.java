import java.util.*;

public class Customer {
   private int cardBalance = 0;
   private int ID = 0;
   private int pin;
   private static int run = 0;
   
   public Customer(int cardBalance, int ID, int pin) {
         Files file = new Files();
         file.openFile("Customers.txt");
         //Random generator = new Random();
         //this.pin = generator.nextInt(10000);
         String balance = Integer.toString(cardBalance);
         //file.addToFile("Customers",ID,"","","",balance,this.pin);
         file.closeFile();
         this.cardBalance = cardBalance;
         this.ID = ID;    
         this.pin = pin; 
   }     
   
   public void buyWash(Washtypes[] washes) {
      int i = 0;
      int count = 0;
      while(washes[i]!=null) {
         System.out.println(i+". "+washes[i].getName().replace("_", " ")+" ("+washes[i].getPrice()+ " DKr)");
         System.out.println(washes[i].getFeatures().replace("_", " ")+"\n");
         i++;
      }
      
      
      System.out.println("Please select the kind of wash you want to buy...");
      Scanner scanner = new Scanner(System.in);
      int washType = scanner.nextInt();
      
      System.out.println("You have chosen wash: "+washes[washType].getName().replace("_", " "));
      System.out.println("Price is "+washes[washType].getPrice()+" DKr\n");
      
      System.out.println("Continue?");
      System.out.println("1. yes \n2. no");
      
      int confirmWash = scanner.nextInt();
      if(confirmWash==1) {
         this.cardBalance -= washes[washType].getPrice();
         System.out.println(washes[washType].getPrice()+" Have been drawed from your card balance\nNew balance: "+cardBalance);
      } else {
         System.out.println("Okay, wash canceled");
      }
   }
   
   public void rechargeWashcard() {
      
      System.out.println("Please select the amount you want to recharge your washcard with...");
      
      Scanner scanner = new Scanner(System.in);
      int amount = scanner.nextInt();
      
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
   
   public int getID() {
      return ID;
   }
   public int getPin() {
      return pin;
   }
   
   public int getRun(){
      return run;
   }
   public void setRun(int input) {
      this.run = input;
   }
   public int getCardBalance() {
      return cardBalance;
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
   
   public static int login(Customer[] customer) {
      System.out.println("Login: Please type in ID: ");
      Scanner scanner = new Scanner(System.in);
      int ID = scanner.nextInt();
      int match = 20000;
      
      System.out.println("Password: Please type in your pincode: ");
      int pincode = scanner.nextInt();
      
      for(int i = 0; i<customer.length;i++) {
         //System.out.println("ID: "+customer[i].getPin());
         if(customer[i]==null) {
            i = 101;
         }
         else if(customer[i].getID() == ID && customer[i].getPin() == pincode) {
            customer[i].setRun(1);
            match = i;  
         }

         
      }
      return match;
   }
   
   public void mainMenu(Washtypes[] washes){
   
      System.out.println("MAIN MENU: Please select one of the following options...");
      System.out.println("\t1. Recharge Washcard\n\t2. Get balance\n\t3. Buy wash\n\t4. Show statistics\n\t5. Exit");
      Scanner scanner = new Scanner(System.in);
      String action = scanner.next();
      
      switch(action) {
         case "1":
            rechargeWashcard();
            //returnExit();
            break;
         case "2":
            getBalance();
            //returnExit();
            break;
         case "3":
            buyWash(washes);
            //returnExit();
            break;
         case "4":
            //Show statistics
            //returnExit();
            break;
         case "5":
            this.run = 0;
            break;
         default: 
            System.out.println("Not a valid option... Please try again.");
      }
   
   }
}