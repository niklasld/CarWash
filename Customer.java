import java.util.*;

public class Customer {
   private double cardBalance = 0;
   private int ID = 0;
   
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
      //TODO
   }
   
   public double checkBalance() {
      
      return cardBalance;
   }
}