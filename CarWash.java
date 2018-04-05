import java.util.*;
import java.io.*;
import java.lang.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class CarWash {
   public static void main(String[] args) {
      int i = 0;
      Customer customer[] = new Customer[100];
      Washtypes washes[] = new Washtypes[100];
      Washstats stats[] = new Washstats[1000000];
      Files file = new Files();
      file.createFile();

      file.openFile("Customers.txt");
      file.readFile("Customers", customer, washes);
      file.openFile("Washtypes.txt");
      file.readFile("Washes", customer, washes);
      file.openFile("Washstats.txt");
      
      int match = customer[0].login(customer);
      while(match==20000) {
         System.out.println("login Error");
         match = customer[0].login(customer);
      }
      while(customer[match].getRun()==1) {
            customer[match].mainMenu(washes);
      }
      i=0;
      file.closeFile();
      file.clearFile("Customers");
      file.clearFile("Washtypes");
      
      while(customer[i]!=null){
         file.addToFile("Customers",customer[i].getID(),"","",0,customer[i].getCardBalance(),customer[i].getPin());
         i++;
      }
      
      i=0;
      while(washes[i]!=null) {
         file.addToFile("Washtypes", 0,washes[i].getName(), washes[i].getFeatures(), washes[i].getPrice(),0,0);
         i++;
      }
      
   }
}