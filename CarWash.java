import java.util.*;
import java.io.*;
import java.lang.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class CarWash {
   public static void main(String[] args) {
      int i = 0;
      Customer customer[] = new Customer[100];
      Files file = new Files();
      file.createFile();

      file.openFile("Customers.txt");
      file.readFile("Customers", customer);
      
      int match = customer[0].login(customer);
      if(match==20000) {
         System.out.println("login Error");
      }
      else {
         while(customer[match].getRun()==1) {
            customer[match].mainMenu();
         }
      }

      /*while(customer[0].getRun() == 1) {
         //System.out.println(customer[0].getRun());
         customer[0].mainMenu();
      }*/
      
      //customer[0].login(customer);
      
      //System.out.println(customer[0].getPin());
      i=0;
      file.closeFile();
      file.clearFile("Customers");
      while(customer[i]!=null){
         file.addToFile("Customers",customer[i].getID(),"","","",customer[i].getCardBalance(),customer[i].getPin());
         i++;
      }
      
      

      //Johnny.rechargeWashcard();
      
     /* while(Johnny.getRun() == 1){
         
         System.out.println(Johnny.getRun());
         Johnny.mainMenu();
         
      }*/
      
   }
}