import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project{

    //Declaring the variables for the Project class and initializing them accordingly:
    int projectNum = 0;
    String name = "";
    String buildType = "";
    String address = "";
    String city = "";
    String postalCode = "";
    int numERF = 0;
    double feeTotal = 0;
    double amountPayed = 0;
    String dateDeadline = "";
    Person architect;
    Person contractor;
    Person customer;
    String finalised;
    
   // Constructor for the Project class:
  public Project(

      int projectNum,
      String name,
      String buildType,
      String address,
      String city,
      String postalCode,
      int numERF,
      double feeTotal,
      double amountPayed,
      String dateDeadline,
      Person architect,
      Person contractor,
      Person customer,
      String finalised) {

          this.projectNum = projectNum;
          this.name = name;
          this.buildType = buildType;
          this.address = address;
          this.city = city;
          this.postalCode = postalCode;
          this.numERF = numERF;
          this.feeTotal = feeTotal;
          this.amountPayed = amountPayed;
          this.dateDeadline = dateDeadline;
          this.architect = architect;
          this.contractor = contractor;
          this.customer = customer;
          this.finalised = finalised;

  }

  //toString Method for writing onto the console in a readable format:
   public String toString(){
      String output = "Project Number: " + projectNum;
      output += "\nName: " + name;
      output += "\nBuild Type: " + buildType;
      output += "\nAddress: " + fullAddress();
      output += "\nERF Number: " + numERF;
      output += "\nFee Total: R" + feeTotal;
      output += "\nAmount Payed: R" + amountPayed;
      output += "\nDeadline: " + dateDeadline;
      output += "\nArchitect: " + architect;
      output += "\nContractor: " + contractor;
      output += "\nCustomer: " + customer;
      output += "\nFinalised: " + finalised +"\n";

      return output;
   }

   //Taking the user input and constructing the full address string for the Address:
   public String fullAddress() {
     return address + " ,"  + city + ", " + postalCode;
  }

  //If there is no name for the project, Construct a name with the building type and customer surname:
   public String generateName() {
    return buildType + " " + customer;
 }

 //Adding a new project to the program:
   public static Project add(int counter){
      //initializing the months:
      String[] months = {"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
      
      //Setting up the console scanner:
      Scanner s = new Scanner(System.in);
      
      //Initializing variables:
      Person architect = new Person("", "", "Architect", "", "", "", "", "");
      Person contractor = new Person("", "", "Contractor", "", "", "", "", "");
      Person customer = new Person("", "", "Customer", "", "", "", "", "");
      int projectNum = counter + 1;

      //start of user inputs:
      //For every newly initialized Variable: 
      //user input equals the new variable:
      System.out.println("Project Name: ");
      String name = s.nextLine();
      System.out.println("Build Type (e.g House, Apartment etc): ");
      String buildType = s.nextLine();
      System.out.println("Project Address:");
      String address = s.nextLine();
      System.out.println("City: ");
      String city = s.next();
      System.out.println("Postal Code: ");
      String postalCode = s.next();
      System.out.println("\n");
      System.out.println("ERF Number: ");
      int numERF = s.nextInt();
      System.out.println("Total Fee to be charged (R): ");
      double feeTotal = s.nextDouble();
      double amountPayed = 0.00;
      s.nextLine();
      System.out.println("\nDeadline for the Project: ");
      System.out.println("Day (DD):");
      int day = s.nextInt();
      System.out.println("Month (MM):");
      int monthInt = s.nextInt();
      String month = months[monthInt -1];
      System.out.println("Year (YYYY):");
      int year = s.nextInt();
      s.nextLine();
      String dateDeadline = day + " " + month + " " + year;
      System.out.println("\nAssigned Architect: ");
      System.out.println("First Name: ");
      architect.name = s.nextLine();
      System.out.println("Surname: ");
      architect.surname = s.nextLine();
      System.out.println("\nAssigned Contractor: ");
      System.out.println("First Name: ");
      contractor.name = s.nextLine();
      System.out.println("Surname: ");
      contractor.surname = s.nextLine();      
      System.out.println("\nCustomer Name: ");
      System.out.println("First Name: ");
      customer.name = s.nextLine();
      System.out.println("Surname: ");
      customer.surname = s.nextLine();
      //End of User input for new Project

      //Project name constructor:
      if(name.isBlank()){
          name = buildType + " " + customer.surname;
      }

      //returning the newly created Project with user inputs:
      return new Project(projectNum, name, buildType, address, city, postalCode, numERF, feeTotal, amountPayed, dateDeadline, architect, contractor, customer,"No");
   }


   public static Project update(Project project) {
      //Initializing the months and other common variables:
      String[] months = {"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
      Scanner s = new Scanner(System.in);

      //user menu for update:
      System.out.println("Please choose what you would like to update Below:\n1. Change the Due Date\n2. Change the Fee paid\n3. Change Contractor Details\n4. Change the Architect Details\n5. Change the Customer Details\n00. Go Back");
      int editOption = s.nextInt();
      s.nextLine();
      while(editOption != 00){

         //editing the specific (User selected) project objects:
         //Due Date project edit:
         if(editOption == 1){
            System.out.println("The current Due Date is : " + project.dateDeadline +"\nThe new Date will be: ");
            System.out.println("Day (DD):");
            int day = s.nextInt();
            System.out.println("Month (MM):");
            int monthInt = s.nextInt();
            String month = months[monthInt -1];
            System.out.println("Year (YYYY):");
            int year = s.nextInt();
            s.nextLine();
            project.dateDeadline = day + " " + month + " " + year;
            System.out.println("Due Date changed to: " + project.dateDeadline);
            editOption = 10;

         }
         //Fee paid project edit:
         else if(editOption == 2){
            System.out.println("The current Fee Paid is : R" + project.amountPayed +"\nThe new Fee Paid is (R): ");
            project.amountPayed = s.nextDouble();
            System.out.println("Fee Paid changed to: R" + project.amountPayed);
            editOption = 10;
         }

         //Project contractor update:
         else if(editOption == 3){
            Person editContractor = Person.update(project.contractor);
            int contractorOption = 10;
            if(editContractor != null){
               contractorOption = 00;
            }
            if (contractorOption == 00){
               editOption = 10;
            }
         }

         //Project Architect update:
         else if(editOption == 4){
            Person editArchitect = Person.update(project.architect);
            int architectOption = 10;
            if(editArchitect != null){
               architectOption = 00;
            }
            if (architectOption == 00){
               editOption = 10;
            }
         }

         //Project Customer update:
         else if(editOption == 5){
            Person editCustomer = Person.update(project.customer);
            int customerOption = 10;
            if(editCustomer != null){
               customerOption = 00;
            }
            if (customerOption == 00){
               editOption = 10;
            }
         }

         //Repeat the menu until user inputs 00:
         else{
            System.out.println("Please choose what you would like to update Below:\n1. Change the Due Date\n2. Change the Fee paid\n3. Change Contractor Details\n4. Change the Architect Details\n5. Change the Customer Details\n00. Go Back");
            editOption = s.nextInt();
         }
         
      }
      return project;
   }
 
   public static String finalise(Project project) {

      //Initialise common variables:
      Scanner s = new Scanner(System.in);
      String result;

      //Check to see if project is available for finalisation: 
      if(project.customer.name.isBlank()){
         result = "Please create a Project first.\n";
      }

      //Check for Customer details input:
      else{
         Person customer = project.customer;
      while(customer.email.isBlank() && customer.contactNumber.isBlank()){
         System.out.println("The Customer Contact Details have not been added.\nAdd the Customers contact for " + customer.name + "  below:\n");
         customer = Person.update(customer);
      }
      //Completed and payed project showing finalised result:
      if(project.amountPayed == project.feeTotal){
         DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
         Date date = new Date();
         project.finalised = "Yes\nCompleted on: " + dateFormat.format(date);
         result = "\nThe Finalised Project looks as follows:\n"+ project;
      }

      //Customer invoice generation if Fee Total > Fee Payed:
      else if(project.amountPayed <= project.feeTotal) {
         result = "-----------------------------------------";
         result += "\nCUSTOMER INVOICE: ";
         result += "\nName: " + project.name;
         result += "\n\nCustomer Details:";
         result += "\nEmail Address: " + project.customer.email;
         result += "\nContact Number: " + project.customer.contactNumber;
         result += "\n\nAmount Owed: R" + (project.feeTotal - project.amountPayed);
         result += "\n-----------------------------------------";

      }
      else{
         result = "Customer Owed: R" + project.feeTotal + "\nCustomer Payed: R" + project.amountPayed + "\nTherefore: Poised Owes Customer: R" + (project.amountPayed - project.feeTotal);
      }
   }
      return result;
 }
 

   //Potential future Function:
   public String incomplete() {
    return  " " ;
 }
 
    //Potential future Function:
   public String overdue() {
    return  " ";
 }


    //Potential future Function:
   public String search() {
    return  " ";
 }
   
  

}