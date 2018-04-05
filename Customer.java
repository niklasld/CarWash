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
   
   public void showStats(Washstats[] stats) {
      int i = 0;
      System.out.println("\nPurchase history:");
      while(stats[i]!=null) {
         if(stats[i].getCustomerID()==ID) {  
            System.out.printf("Date:\t\t\t"+stats[i].getDate().toString().replace("_"," ")+"\nWashname:\t"+stats[i].getType().toString().replace("_"," ")+"\nPrice:\t\t"+stats[i].getPrice()+"\n\n");
         }
      i++;
      }
   }
   public void buyWash(Washtypes[] washes, Washstats[] stats) {
      int i = 0;
      int count = 0;
      while(washes[i]!=null) {
         System.out.println(i+". "+washes[i].getName().replace("_", " ")+" ("+washes[i].getPrice()+ " DKr)");
         System.out.println(washes[i].getFeatures().replace("_", " ")+"\n");
         i++;
      }
      
      
      System.out.println("Please select the kind of wash you want to buy...");
      System.out.println("Your current balance is "+cardBalance);
      Scanner scanner = new Scanner(System.in);
      int washType = 999999;
      try {
         washType = scanner.nextInt();
         System.out.println("You have chosen wash: "+washes[washType].getName().replace("_", " "));
         System.out.println("Price is "+washes[washType].getPrice()+" DKr\n");
         
         System.out.println("Continue?");
         System.out.println("1. yes \n2. no");
         
         String confirmWash = scanner.next();
         if(confirmWash.equals("1")) {
            if(this.cardBalance-washes[washType].getPrice() < 0) {
               System.out.println("Your current balance is "+this.cardBalance+" and the balance is not high enough to buy this wash");
            }
            else {
               Date newDate = new Date();
               this.cardBalance -= washes[washType].getPrice();
               System.out.println(washes[washType].getPrice()+" Have been drawed from your card balance\nNew balance: "+cardBalance);  
               //Files file = new Files();
               //file.openFile("Washstats.txt");
               //file.addStat("Washstats", ID, washes[washType].getName(), washes[washType].getPrice());
               int y = 0;
               while(stats[y]!=null) {
                  y++;
               }
               if(stats[y]==null) {
                  Date getDate = new Date();
                  stats[y] = new Washstats(getDate.toString().replace(" ","_"), washes[washType].getName(),washes[washType].getPrice(), ID);
               }
               System.out.println("\nPuchase complete\n\nReceipt:");
               System.out.println("Wash purchased:\t"+washes[washType].getName().replace("_"," ")+"\nPrice:\t\t\t\t"+washes[washType].getPrice()+"\nDate:\t\t\t\t\t"+newDate+"\n");
            }
         } 
         else if(confirmWash.equals("2")){
            System.out.println("Okay, wash cancelled");
         }
         else {
            System.out.println("Error in input\n");
         }
      }
      catch(Exception e) {
         System.out.println("Error in input\n");
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
   
   public static void adminLogin(Washstats[] stats) {
      System.out.println("Admin logon, type in name: ");

      Scanner scanner = new Scanner(System.in);
      String name = scanner.next();
      
      System.out.println("Type in password: ");
      String pass = scanner.next();
      
      if(name.equals("admin") && pass.equals("admin")) {
         int i = 0;
         System.out.println("Printing wash statistics");
         while(stats[i]!=null) {
            System.out.println("Date: "+stats[i].getDate().toString().replace("_"," ")+"Name: "+stats[i].getType().toString().replace("_"," ")+"Customer ID: "+stats[i].getCustomerID());
            i++;
         }
         
      }
      else {
         System.out.println("Wrong username or password");
      }
   }
   public static int login(Customer[] customer, Washstats[] stats) {
      System.out.println("Login: Please type in ID: ");
      System.out.println("To log in as Admin set id to -1");
      Scanner scanner = new Scanner(System.in);
      int ID = scanner.nextInt();
      int match = 20000;
      
      System.out.println("Password: Please type in your pincode: ");
      int pincode = scanner.nextInt();
      if(ID == -1) {
         adminLogin(stats);
      }   
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
   
   public void startMenu(Customer[] customer, Washstats[] stats){
      
      System.out.println("WELCOME TO F27 CARWASH: Please select one of the following options...");
      System.out.println("\t1. Existing costumer\n\t2. Buy washcard");
      Scanner scanner = new Scanner(System.in);
      String action = scanner.next();
      //int match = 20000;
      
      switch(action) {
         case "1":
            login(customer, stats);
            while(ID==0) {
               System.out.println("login Error");
               this.ID = login(customer, stats);
               //return match;
            }
            //returnExit();
            break;
         case "2":
            //buyWashcard
            //returnExit();
            //return 0;
            break;
         case "3":
            adminLogin(stats);
            //returnExit();
            //return 0;
            break;
         default: 
            System.out.println("Not a valid option... Please try again.");
            //return 0;
            break;
      }
      //return match;
      
   }
   
   public void mainMenu(Washtypes[] washes, Washstats[] stats){
   
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
            buyWash(washes, stats);
            //returnExit();
            break;
         case "4":
            showStats(stats);
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