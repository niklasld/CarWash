import java.util.*;
import java.io.*;
import java.lang.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class Files {
   private Scanner scanFile;
   
   //method for creating new files
   public void createFile() {
      //creates 2 formatter objects, these are final(cannot be changed)
      final Formatter washStats, users;
      File wStatsFile = new File("Washstats.txt");
      File usersFile = new File("Customers.txt");

      //checks if the Washstats.txt file exists, it it doesnt it will try and create the file
      if(!wStatsFile.exists()) {
         try {
            washStats = new Formatter("Washstats.txt");
         }
         catch(Exception e) {
            System.out.println("Error creating file Washstats.txt");
         }
      }
      //checks if the Customers.txt file exists, it it doesnt it will try and create the file
      if(!usersFile.exists()) {
         try {
            users = new Formatter("Customers.txt");
         }
         catch(Exception e) {
            System.out.println("Error creating file Customers.txt");
         }
      }
   }
   
   //Creates the method openfile, used for opening file, input is the name of the file to open
   public void openFile(String fileName) {
      try {
         scanFile = new Scanner(new File(fileName));
      }
      catch(Exception e) {
         System.out.println("Could not find file with the filename "+fileName);
      }
   }
   
   //creates the method readFile takes the input(type) to use in the switch case so that it knows what file its working with
   public void readFile(String type) {
      switch(type) {
         case "Costumers" :
            System.out.println("Costumers: ");
            while(scanFile.hasNext()) {
            
               String ID = scanFile.next();
               int balance = scanFile.nextInt();
               
               System.out.printf("ID: %s Balance: %s \n", ID, balance);
            }
            break;
      
         case "Washstats" :
            System.out.println("Washstats: ");
            while(scanFile.hasNext()) {
            
               String ID = scanFile.next();
               String firstName = scanFile.next();
               String lastName = scanFile.next();
               String sex = scanFile.next();
               String age = scanFile.next();
               
               System.out.printf("%s %s %s %s %s\n", ID, firstName, lastName, sex, age);
            }      
            break;
         
         case "Washtypes":
            System.out.println("Washes: ");
            while(scanFile.hasNext()) {
            
               String ID = scanFile.next();
               String firstName = scanFile.next();
               String lastName = scanFile.next();
               String sex = scanFile.next();
               String age = scanFile.next();
               
               System.out.printf("%s %s %s %s %s\n", ID, firstName, lastName, sex, age);
            }         
            break;
         
         default:
            System.out.println("Error");
            break;
      }
   }
   public void closeFile() {
      scanFile.close();
   }
   
   public void addToFile(String type, String ID, String washType, String features, String price, String balance) {
      if(type == "Washstats") {
         try {
            FileWriter fileW = new FileWriter(type+".txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(ID+" "+washType+" "+price+"\n");
            buffW.close();
            System.out.println("Wrote to file "+type+".txt");
         }
         catch (Exception e) {
            e.printStackTrace();
         }
      }
      else if(type == "Customer") {
         try {
            FileWriter fileW = new FileWriter(type+".txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(ID+" "+balance+"\n");
            buffW.close();
            System.out.println("Wrote to file "+type+".txt");
         }
         catch (Exception e) {
            e.printStackTrace();
         }     
      }
      else if(type == "Washes") {
         try {
            FileWriter fileW = new FileWriter(type+".txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(ID+" "+washType+" "+features+" "+price+"\n");
            buffW.close();
            System.out.println("Wrote to file "+type+".txt");
         }
         catch (Exception e) {
            e.printStackTrace();
         }     
      }
   }
}