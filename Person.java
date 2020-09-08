import java.util.Scanner;

public class Person {

   // Attributes
   String name;
   String surname;
   String role;
   String contactNumber;
   String email;
   String address;
   String city;
   String postalCode;
	
	// Methods
   public Person(String name, String surname, String role,String contactNumber,String email,String address,String city, String postalCode) {
      this.name = name;
      this.surname = surname;
      this.role = role;
      this.contactNumber = contactNumber;
      this.email = email;
      this.address = address;
      this.city = city;
      this.postalCode = postalCode;
   }

   //Acquire Person full name from user first and surname input:
   public String fullName(){
      String output = name + " " + surname;
      return output;
   }

   //update the project person current details:
   public static Person update(Person person){

      //Declare common variables:
      Scanner s = new Scanner(System.in);
      System.out.println("The current " + person.role + " Details are:\n" + person +"\nChange the " + person.role + " Details below:\n");
      System.out.println("Choose one of the below to change:\n1. Email Address\n2. Contact Number\n3. Physical Address\n00. Go Back ");
      int editOption = s.nextInt();
      s.nextLine();

      //User input option while edit option != 00:
      while(editOption != 00){

         //edit Person email address if user option equals 1:
         if(editOption == 1){
            System.out.println("The current Email Address is: " + person.email +"\nThe new Email Address will be: ");
            person.email = s.nextLine();
            System.out.println("Email Address was changed to: " + person.email);
            editOption = 10;
         }

         //edit Person Contact Number if user option equals 2:
         else if(editOption == 2){
            System.out.println("The current Contact Number is: " + person.contactNumber +"\nThe new Contact Number will be: ");
            person.contactNumber = s.nextLine();
            System.out.println("Contact Number was changed to: " + person.contactNumber);
            editOption = 10;
         }

         //edit Person Physical address if user option equals 3:
         else if(editOption == 3){
            System.out.println("The current Physical Address is: " + person.fullAddress() +"\nThe new Physical Address will be: ");
            System.out.println(person.role + " Address:");
            person.address = s.nextLine();
            System.out.println("City: ");
            person.city = s.next();
            System.out.println("Postal Code: ");
            person.postalCode = s.next();
            System.out.println("\n");                  
            System.out.println("Physical Address was changed to: " + person.fullAddress());
            editOption = 10;
         }

         //User option to disregard changes and go back to previous menu:
         else{
            System.out.println("The current " + person.role + " Details are:\n" + person +"\nChange the " + person.role + " Details below:\n");
            System.out.println("Choose one of the below to change:\n1. Email Address\n2. Contact Number\n3. Physical Address\n00. Go Back ");
            editOption = s.nextInt();
            s.nextLine();
         }
      }
      return person;
   }


   //Acquire the string representation of the Person class:
   public String toString(){
      String output = name + " " + surname;
      output += "\nEmail: " + email;
      output += "\nContact Number: " + contactNumber;
      output += "\nAddress: " + fullAddress() + "\n";

      return output;
   }


   //Generate the full address from user inputs of Person:
   public String fullAddress() {
      String result;
      if(address.isBlank()||city.isBlank()||postalCode.isBlank()){
         result = "No Current Address set for " + fullName();
      }else{
      result = address + " ," +  city + ", " + postalCode;
      }
      return result;
 }
	
   

}