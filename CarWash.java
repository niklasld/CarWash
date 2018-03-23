import java.util.*;

public class CarWash {
   public static void main(String[] args) {
      Customer Johnny = new Customer(350.00, 01);
      
      //System.out.println("Your balance is: "+Johnny.getBalance()+" DKr.");
      
      //Johnny.rechargeWashcard();
      
      while(Johnny.getRun() == 1){
         
         //System.out.println(Johnny.getRun());
         Johnny.mainMenu();
         
      }
      
   }
}