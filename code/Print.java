/*
This work is mine unless otherwise cited
*/

public class Print {

  /* This method is the constructor
  for the Print class and will initilize
  any variables needed throghout the entire
  class */
  public Print() {



  }

  /* The print welcome method will print
  the welcome message used at the beginning
  of the program */
  public void printWelcome() {

    // Print the Welcome Message
    System.out.println("-----------------------------------------------------");
    System.out.println("WELCOME TO THE COURSE MANAGEMENT SOFTWARE");

  }

  /* The print options method will print
  a list of the users options and will be
  used at the beginning and every time the
  user continues the program */
  public void printOptions() {

    // Print the list of options
    System.out.println("-----------------------------------------------------");
    System.out.println("Please Select An Option From The List Below");
    System.out.println("1: Add a Semester of Courses");
    System.out.println("2: Delete a Semester of Courses");
    System.out.println("3: Add an Individual Course");
    System.out.println("4: Delete an Individual Course");
    System.out.println("5: Find GPA by Semester");
    System.out.println("6: Find career GPA");
    System.out.println("7: List Courses Taken");
    System.out.println("8: List Number of Each Letter Grade Received");
    System.out.println("9: Exit the Program");
    System.out.println("Choose an option from above:");
    System.out.println("-----------------------------------------------------");

  }

  /* The printThank method will thank the
  user for using the program and will be
  used whenever the program ends */
  public void printThank() {

    // Print thank you message
    System.out.println("-----------------------------------------------------");
    System.out.println("THANK YOU FOR USING THE COURSE MANAGEMENT SOFTWARE");

  }

}
