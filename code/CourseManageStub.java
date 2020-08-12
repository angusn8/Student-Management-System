/*
This work is mine unless otherwise cited - Nate Angus
*/

import java.util.Scanner;

public class CourseManageStub {

  // Declare variables for the class
  public static int semester = 1;

  /* The main method for the course
  management program. This method will mostly
  call other methods in order to execute
  the program */
  public static void main(String[] args) {

    // Create objects of the other classes
    Print print = new Print();
    CourseManage course = new CourseManage();

    // Print welcome message
    print.printWelcome();

    // Give the user their initial options
    print.printOptions();

    // Declare Scanner
    Scanner scan = new Scanner(System.in);

    // Take in the first option selected
    int option = scan.nextInt();

    // While loop to run program until user does not wish to continue
    while(true) {

      // Conditional tree for what the user picks as an option
      if (option == 1) {

        // Ask and take in number of courses to add
        System.out.println("How many courses were in this semester?");
        int numCourses = scan.nextInt();

        // For loop that goes until all course for semester have been entered
        for(int i = 1; i <= numCourses; i++) {

          // Declare seperate Scanner
          Scanner scan2 = new Scanner(System.in);

          // Ask and take in name of course
          System.out.println("What was the name of course " + i + " ?");
          String name = scan2.nextLine();

          // Ask and take in number of credits
          System.out.println("How many credits was this course worth?");
          Double credits = Double.parseDouble(scan2.nextLine());

          // Ask and take in grade in course
          System.out.println("What was your letter grade in this course? (capital letters, inlcude + and -)");
          String letterGrade = scan2.nextLine();

          // Call add course method to add this course
          course.addCourse(name, credits, letterGrade, semester);

        }

        // Increase semester so next time user presses option 1 it is the next semester
        semester = semester + 1;

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();

        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {

          // Reprint options for the user
          print.printOptions();

          // Have them select next option
          option = scan.nextInt();

          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");

        } else {

          // Print the thank you message
          print.printThank();

          // End the while loop thus ending the program
          break;

        }

      }
      else if (option == 2) {

        // Ask and take in which semester should be deleted
        System.out.println("Which semester of courses would you like to delete?");
        int semesterDelete = scan.nextInt();

        // Call method to delete the specified semester
        course.deleteSemester(semesterDelete);

        // Decrement semester since there is one lessn now 
        semester = semester - 1;

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();

        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {

          // Reprint options for the user
          print.printOptions();

          // Have them select next option
          option = scan.nextInt();

          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");

        } else {

          // Print the thank you message
          print.printThank();

          // End the while loop thus ending the program
          break;

        }

      }
      else if (option == 3) {

        // Declare new scanner to avoid skipping
        Scanner scan3 = new Scanner(System.in);

        // Ask and take in name of course
        System.out.println("What was the name of this course?");
        String name = scan3.nextLine();
        
        // Ask and take in number of credits
        System.out.println("How many credits was this course worth?");
        Double credits = Double.parseDouble(scan3.nextLine());
        
        // Ask and take in grade in course
        System.out.println("What was your letter grade in this course? (capital letters, inlcude + and -)");
        String letterGrade = scan3.nextLine();
        
        // Call add course method to add this course
        course.addCourse(name, credits, letterGrade, 0);

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();
        
        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {
        
          // Reprint options for the user
          print.printOptions();
        
          // Have them select next option
          option = scan.nextInt();
        
          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");
        
          } else {
        
            // Print the thank you message
            print.printThank();
        
            // End the while loop thus ending the program
            break;
        
          }

      }
      else if (option == 4) {

        // Declare new scanner to avoid skipping
        Scanner scan4 = new Scanner(System.in);

        // Ask user and take in which course they want to delete 
        System.out.println("Which individual course would you like to delete? (enter a number 1 or greater)");
        int courseSelected = scan4.nextInt();

        // Remove the course 
        course.deleteClass(courseSelected);

        // Tell user it has been deleted 
        System.out.println("The course has been deleted successfully");

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();
                
        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {
                
          // Reprint options for the user
          print.printOptions();
                
          // Have them select next option
          option = scan.nextInt();
                
          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");
                
        } else {
                
          // Print the thank you message
          print.printThank();
                
          // End the while loop thus ending the program
          break;
                
        }

      }
      else if(option == 5) {

        // Declare new scanner to avoid skipping 
        Scanner scan5 = new Scanner(System.in);

        // Ask and take in semester user wants gpa for 
        System.out.println("Which semester would you like to calculate GPA for?");
        int semester = scan5.nextInt();

        // Display that semesters gpa for user
        System.out.println("Your GPA for semester " + semester + ": " + course.semesterGPA(semester));

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();
                
        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {
                
          // Reprint options for the user
          print.printOptions();
                
          // Have them select next option
          option = scan.nextInt();
                
          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");
                
        } else {
                
          // Print the thank you message
          print.printThank();
                
          // End the while loop thus ending the program
          break;
                
        }

      }
      else if(option == 6) {

        // Print the user's career GPA
        System.out.println("Your career GPA: " + course.careerGpa());
        System.out.println("-----------------------------------------------------");

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();
        
        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {
        
          // Reprint options for the user
          print.printOptions();
        
          // Have them select next option
          option = scan.nextInt();
        
          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");
        
        } else {
        
          // Print the thank you message
          print.printThank();
        
          // End the while loop thus ending the program
          break;
        
        }

      }
      else if(option == 7) {

        // Call method to print list of courses
        course.listCourses();
        System.out.println("");

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();

        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {

          // Reprint options for the user
          print.printOptions();

          // Have them select next option
          option = scan.nextInt();

          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");

        } else {

          // Print the thank you message
          print.printThank();

          // End the while loop thus ending the program
          break;

        }

      }
      else if(option == 8) {

        // Call method to display number of letter grades 
        course.listLetterGrades();

        // Ask user and take in if they wish to continue
        System.out.println("Would you like to continue (y/n)?");
        String choice = scan.next();
                  
        // Conditional logic for which they selected
        if (choice.equalsIgnoreCase("y")) {
        
          // Reprint options for the user
          print.printOptions();
        
          // Have them select next option
          option = scan.nextInt();
        
          // Print dashes for stylistic reasons
          System.out.println("-----------------------------------------------------");
        
        } else {
        
          // Print the thank you message
          print.printThank();
        
          // End the while loop thus ending the program
          break;
        
        }

      }
      else if(option == 9) {

        // Call method to exit the program 
        course.exit();

      }

    }

  }

}
