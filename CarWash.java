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
      file.readFile("Customers", customer, washes, stats);
      file.openFile("Washtypes.txt");
      file.readFile("Washes", customer, washes, stats);
      file.openFile("Washstats.txt");
      file.readFile("Washstats", customer, washes, stats);
      
      //customer[0].startMenu(customer, stats);
      int userID = customer[0].getID();
      
      System.out.println("WELCOME TO F27 CARWASH: Please select one of the following options...");
      System.out.println("\t1. Existing costumer\n\t2. Buy washcard");
      Scanner scanner = new Scanner(System.in);
      String action = scanner.next();
      int match = 20000;
      
      switch(action) {
         case "1":
            match = customer[0].login(customer, stats);
            while(match==20000) {
               System.out.println("login Error\n");
               match = customer[0].login(customer, stats);
               //System.out.println("TEST "+match);
            }
            while(customer[match].getRun()==1) {
                  customer[match].mainMenu(washes, stats);
            }
            //returnExit();
            break;
         case "2":
            customer[0].buyWashCard(customer);
            file.clearFile("Customers");
            while(customer[i]!=null){
               file.addToFile("Customers",customer[i].getID(),"","",0,customer[i].getCardBalance(),customer[i].getPin(),"",0);
               i++;
            }
            match = customer[0].login(customer, stats);
            while(match==20000) {
               System.out.println("login Error\n");
               match = customer[0].login(customer, stats);
               //System.out.println("TEST "+match);
            }
            while(customer[match].getRun()==1) {
                  customer[match].mainMenu(washes, stats);
            }
            break;
         case "3":
            customer[0].adminLogin(stats);
            //returnExit();
            //return 0;
            break;
         default: 
            System.out.println("Not a valid option... Please try again.");
            //return 0;
            break;
      }
      /*int match = 
      while(match==20000) {
         System.out.println("login Error");
         match = customer[0].startMenu(customer, stats);
      }*/
      file.clearFile("Customers");
      file.clearFile("Washtypes");
      file.clearFile("Washstats");      
      i = 0;
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