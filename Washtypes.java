import java.util.*;

public class Washtypes {
   private String type, features;
   private int price;
   
   public Washtypes(String type, int price, String features) {
      Files file = new Files();
      file.openFile("Washtypes.txt");
      file.closeFile();
      
      this.type = type;
      this.price = price;    
      this.features = features; 
      
   }
   
   public String getName() {
      return type;
   }
   
   public int getPrice() {
      return price;
   }
   
   public String getFeatures() {
      return features;
   }
}