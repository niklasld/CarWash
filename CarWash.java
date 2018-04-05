import java.util.*;
import java.io.*;
import java.lang.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class CarWash {
   
   public static void main(String[] args) {
   
      Customer customer[] = new Customer[100];
      Washtypes washes[] = new Washtypes[100];
      Washstats stats[] = new Washstats[10000000];
      Files file = new Files();
      file.createFile();
      
      file.openFile("Customers.txt");
      file.readFile("Customers", customer, washes, stats);
      file.openFile("Washtypes.txt");
      file.readFile("Washes", customer, washes, stats);
      file.openFile("Washstats.txt");
      file.readFile("Washstats", customer, washes, stats);
      
      customer[0].startMenu(customer, stats);
      int userID = customer[0].getID();
      
      /*int match = 
      while(match==20000) {
         System.out.println("login Error");
         match = customer[0].startMenu(customer, stats);
      }*/
      while(customer[userID].getRun()==1) {
            customer[userID].mainMenu(washes, stats);
      }

      file.clearFile("Customers");
      file.clearFile("Washtypes");
      file.clearFile("Washstats");      
      int i = 0;  
      while(customer[i]!=null){
         file.addToFile("Customers",customer[i].getID(),"","",0,customer[i].getCardBalance(),customer[i].getPin(),"",0);
         i++;
      }
      
      i=0;
      while(washes[i]!=null) {
         file.addToFile("Washtypes", 0,washes[i].getName(), washes[i].getFeatures(), washes[i].getPrice(),0,0,"",0);
         i++;
      }
      
      i=0;
      while(stats[i]!=null) {
         file.addToFile("Washstats", 0, stats[i].getType(), "", stats[i].getPrice(), 0, 0, stats[i].getDate(), stats[i].getCustomerID());
         i++;
      }
      file.closeFile();
   
   }
}