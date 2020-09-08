import java.util.Scanner;


public class Program {

    //Main program start:
    public static void main (String [] args)
{

    //Initialize common variables:
    Scanner s = new Scanner(System.in);
    boolean runProgram = true;
    int projectCounter = 0;

    //Initialize common classes (Different, yet common, persons):
    Person architect = new Person("", "", "Architect", "", "", "", "", "");
    Person contractor = new Person("", "", "Contractor", "", "", "", "", "");
    Person customer = new Person("", "", "Customer", "", "", "", "", "");

    //Initializing a default project class:
    Project currentProject = new Project(0, "", "", "", "", "", 0, 0, 0, "", architect, contractor, customer,"No");
    
    //System start:
    System.out.println("\nPoised Project Management System:\n");
    while(runProgram != false){

        //System Menu:
        System.out.println("Main Menu:\n");
        System.out.println("Please choose one of the following options (Type in the appropriate number): \n1. Add a new Project\n2. Update an existing project\n3. Finalise a project\n00. Exit Program\nEnter your choice here: ");
        int option = s.nextInt();
        s.nextLine();

        //Add a new project on user decision input of 1:
        if(option == 1){

            //Project class add function:
            currentProject = Project.add(projectCounter);

            //print the newly added project:
            System.out.println("\nNew Project:\n" + currentProject);
        }

        //update a newly created project on user decision of 2:
        else if(option == 2 ){

            //validator of current project != null:
            if(!currentProject.name.isBlank()){
            currentProject = Project.update(currentProject);
            }

            //Print issue if current project == null:
            else{
                System.out.println("\nNo current Project available to update.\nPlease create a new project.\n");
            }
        }

        //Finalise current project on user decision of 3:
        else if(option == 3){

            //Finalise criteria will be met here:
            String result = Project.finalise(currentProject);  
            System.out.println(result);          
        }

        //Exit program function to disregard user current interaction:
        else if(option == 00){
            s.close();
            runProgram = false;
        }
}

}
}