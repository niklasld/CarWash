import java.util.*;
import java.io.*;
import java.lang.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class Files {
   Scanner scanFile;
   
   //method for creating new files
   public void createFile() {
      //creates 2 formatter objects, these are final(cannot be changed)
      final Formatter washStats, users, washTypes;
      File StatsFile = new File("Washstats.txt");
      File usersFile = new File("Customers.txt");
      File washTypeFile = new File("Washtypes.txt");

      //checks if the Washstats.txt file exists, it it doesnt it will try and create the file
      if(!StatsFile.exists()) {
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
      if(!StatsFile.exists()) {
         try {
            washTypes = new Formatter("Washtypes.txt");
         }
         catch(Exception e) {
            System.out.println("Error creating file Washtypes.txt");
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
   public void readFile(String type, Customer[] customer, Washtypes[] washes, Washstats[] stats) {
      switch(type) {
         case "Customers" :
            int i = 0;
            //System.out.println("Customers: ");
            while(scanFile.hasNext()) {
               int ID = scanFile.nextInt();
               int balance = scanFile.nextInt();
               int pin = scanFile.nextInt();
               customer[i] = new Customer(balance, ID, pin);
               i++;
               //System.out.printf("ID: %s Balance: %s Pin: %s \n",ID, balance, pin);
            }
            break;
      
         case "Washstats" :
            //System.out.println("Washstats: ");
            int countstats=0;
            while(scanFile.hasNext()) {
            
               
               String date = scanFile.next();
               int customerID = scanFile.nextInt();
               String statType = scanFile.next();
               int price = scanFile.nextInt();
               
               stats[countstats] = new Washstats(date,statType,price,customerID);
               countstats++;
               //System.out.printf(date+" "+statType+" "+price);
            }      
            break;
         
         case "Washes":
            //System.out.println("Washes: ");
            int count = 0;
            while(scanFile.hasNext()) {
               String name = scanFile.next();
               int price = scanFile.nextInt();
               String features = scanFile.next();
               washes[count] = new Washtypes(name, price, features);
               count++;
               //System.out.println("Name:\t"+name.replace("_", " "));
               //System.out.println("Price:\t"+price);
               //System.out.println("Features:\t"+features.replace("_", " "));
               //System.out.println("");
            }                   
            break;
         
         default:
            System.out.println("Error something with readFile");
            break;
      }
   }
   public void closeFile() {
      scanFile.close();
   }
   
   public void addToFile(String type, int ID, String washName, String features, int price, int balance, int pin, String date, int custID) {
      if(type == "Washstats") {
         try {
            FileWriter fileW = new FileWriter(type+".txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(date+" "+custID+" "+washName+" "+price+"\n");
            buffW.close();
            //System.out.println("Wrote to file "+type+".txt");
         }
         catch (Exception e) {
            e.printStackTrace();
         }
      }
      else if(type == "Customers") {
         try {
            FileWriter fileW = new FileWriter(type+".txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(ID+" "+balance+" "+pin+"\n");
            buffW.close();
            //System.out.println("Wrote to file "+type+".txt");
         }
         catch (Exception e) {
            e.printStackTrace();
         }     
      }
      else if(type == "Washtypes") {
         try {
            FileWriter fileW = new FileWriter(type+".txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(washName+" "+price+" "+features+"\n");
            buffW.close();
            //System.out.println("Wrote to file "+type+".txt");
         }
         catch (Exception e) {
            e.printStackTrace();
         }     
      }
   }
   
   public void addStat(String type, int ID, String  washName, int price) {
      try {
         Date getDate = new Date();
         String date = getDate.toString(); 
         FileWriter fileW = new FileWriter(type+".txt",true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(date.replace(" ", "_")+" "+ID+" "+washName+" "+price+"\n");
         buffW.close();
         //System.out.println("Wrote to file "+type+".txt");
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public void clearFile(String fileName) {
      try {
         FileWriter fileW = new FileWriter(fileName+".txt");
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write("");
         buffW.close();
         //System.out.println("Wrote to file "+type+".txt");
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
}