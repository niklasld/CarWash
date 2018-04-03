import java.util.*;

public class CarWash {
   public static void main(String[] args) {
      Customer customer[];
      Files file = new Files();
      file.createFile();
      file.openFile("Customers.txt");
      //while(file.scanFile.hasNext()) {
         //String ID = file.scanfile.next();
         //int balance = file.scanfile.nextInt();
         //int pin = file.scanFile.nextInt();
         
      //}
      file.readFile("Customers");
      file.closeFile();
      
      
      
      //System.out.println("Your balance is: "+Johnny.getBalance()+" DKr.");
      
      //Johnny.rechargeWashcard();
      
     /* while(Johnny.getRun() == 1){
         
         System.out.println(Johnny.getRun());
         Johnny.mainMenu();
         
      }*/
      
   }
}