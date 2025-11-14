import java.util.InputMismatchException;
import java.util.Scanner;

public class GPAFunction {
    //Initiate a scanner to take user input.
    static Scanner userinput = new Scanner(System.in);

    //Define the main method.
    public static void main(String[] args) {

        //Formatting.
        System.out.println("\n");

        //Prompt user for how many courses they took.
        int courses = intTry("How many courses did you take --> ");

        //Create a double array with length specified by the user.
        Double[] userGrades = new Double[courses];

        //Create an integer array with the same length.
        int[] userCredits = new int[courses];

        //This for loop will iterate through the courses.
        for (int i = 0; i < courses; i++){

            //Formatting.
            System.out.println("\n");

            //Prompt user of the grade for the current course.
            userGrades[i] = doubleTry("Enter the grade you got for course " + i + " --> ");

            //Formatting.
            System.out.println("\n");

            //Prompt the user for the number of credits of the current course.
            userCredits[i] = intTry("Enter the number of credits course " + i + " was worth --> ");

            //Formatting.
            System.out.println("\n");

        }

        //Formatting.
        System.out.println("\n");

        //Display the results with a format string, in order to round the GPA to 4 decimal places.
        System.out.format("Your GPA is: %5.4f%n", computeGPA(userGrades, userCredits));

        //Formatting.
        System.out.println("\n");

        //Tell the user the program is ending.
        System.out.println("The program is ending...");

        //Formatting.
        System.out.println("\n");

        //Close the scanner.
        userinput.close();


    }

    //This method computes the GPA.
    static Double computeGPA(Double [] grades, int [] credits){

        //Initiate variables for the numerator, denominator, and GPA.
        Double numerator = 0.00;
        int denominator = 0;
        Double GPA;

        //This for loop will iterate through the length of the arrays passed as arguments.
        for(int i = 0; (i < grades.length) && (i < credits.length); i++){

            //Calculate the numerator.
            numerator = numerator + (grades[i]*credits[i]);

            //Calculate the denominator.
            denominator += credits[i];
        }

        //Calculate the GPA.
        GPA = numerator / (double)denominator;

        //Return GPA to the method.
        return GPA;
    }

    /** I copied these two error trapping methods from ones that I wrote in the Main Menu App. */

    //This method traps errors when entering an integer.
    static int intTry(String message){
        //This variable holds the user's response.
        int response;

        //This loop will run until a value is returned to the method.
        //This is so that if the user enters an incorrect value they will just be prompted again.
        while(true){

            //Run this code and check for errors.
            try {
                System.out.print(message);
                //Get the user's response.
                response = userinput.nextInt();
                userinput.nextLine();
                //Return the response to the method. This is the way the loop will end.
                return response;
            }
            //If an error is thrown this code will run.
            catch (InputMismatchException e) {
                userinput.nextLine();
            }
        }
    }

    //This method does the same thing but, it makes sure that the user entered a double instead of an integer.
    static Double doubleTry(String message){
        Double response;

        while(true){

            try {
                System.out.print(message);
                response = userinput.nextDouble();
                userinput.nextLine();
                return response;
            }
            catch (InputMismatchException e) {
                userinput.nextLine();
            }
        }
    }
}
