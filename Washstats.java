import java.util.*;

public class Washstats {
      private String type, date;
      private int price, customerID;      
      
      public Washstats(String date, String type, int price, int customerID) {
        
         Files file = new Files();
         file.openFile("Washstats.txt");
         file.closeFile();
         
         this.date = date;
         this.type = type;
         this.price = price;    
         this.customerID = customerID; 
         
      }
      
      public String getDate() {
         return date;
      }
      
      public String getType() {
         return type;
      }
      
      public int getPrice() {
         return price;
      }
      
      public int getCustomerID() {
         return customerID;
      }   
}