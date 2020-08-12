/*
This work is mine unless otherwise cited - Nate Angus
*/

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;

public class CourseManage {

  // Declare class variables
  ArrayList<String> nameArr = new ArrayList<String>();
  ArrayList<Double> creditArr = new ArrayList<Double>();
  ArrayList<String> gradeLetterArr = new ArrayList<String>();
  ArrayList<Double> gradeGpaArr = new ArrayList<Double>();
  ArrayList<Integer> semesterArr = new ArrayList<Integer>();

  /* This is the constructor method for
  the CourseManage class and will initilize
  any variables needed throughout the entire
  class */
  public CourseManage() {



  }

  /* Add course method will allow the user
  to add an entire semester or single course
  worth of courses. Which one will be determined
  in the main method. The user can pick how many
  courses they took and enter them all */
  public void addCourse(String name, double credits, String grade, int semester) {

    // Add name, subject, credits, semester, and letter grade to their respective ArrayLists
    nameArr.add(name);
    gradeLetterArr.add(grade);
    creditArr.add(credits);
    semesterArr.add(semester);

    // Conditional logic to set grade equal to gpa equivilant
    switch(grade) {

      // Different letter grades and their equivilant gpa
      case "A":
        // add value to ArrayList
        gradeGpaArr.add(4.0);
        break;
      case "A-":
        // add value to ArrayList
        gradeGpaArr.add(3.7);
        break;
      case "B+":
        // add value to ArrayList
        gradeGpaArr.add(3.3);
        break;
      case "B":
        // add value to ArrayList
        gradeGpaArr.add(3.0);
        break;
      case "B-":
        // add value to ArrayList
        gradeGpaArr.add(2.7);
        break;
      case "C+":
        // add value to ArrayList
        gradeGpaArr.add(2.3);
        break;
      case "C":
        // add value to ArrayList
        gradeGpaArr.add(2.0);
        break;
      case "C-":
        // add value to ArrayList
        gradeGpaArr.add(1.7);
        break;
      case "D+":
        // add value to ArrayList
        gradeGpaArr.add(1.3);
        break;
      case "D":
        // add value to ArrayList
        gradeGpaArr.add(1.0);
        break;
      default:
        gradeGpaArr.add(0.0);
        break;

    }

   // for(int i = 0; i < gradeGpaArr.size(); i++) {
     // System.out.println(gradeGpaArr.get(i));
    //}

  }

  /* The deleteSemester method will delete an
  entire semester worth of courses. The user
  can choose which semester will be deleted */
  public void deleteSemester(int semester) {

    // Declare res variable for which index semester starts at
    int resStart = 0;

    // Declare res variable for number of indexs mathching semester to be deleted
    int resNumIndexes = 0;

    // Iterate through semesterArr to find where selected semester starts
    // For loop for every index of semesterArr
    for (int i = 0; i < semesterArr.size(); i++) {

      // Declare variable that increments each index as for loop increments
      int currentSemester = semesterArr.get(i);

      // Conditional to check if index matches selected semester
      if (currentSemester == semester && resStart != 0) {

        // Set res equal to current index to signify starting index of semester
        resStart = i;

      }

    }

    // Iterate through semesterArr to find how many indexes are in this semester
    // For loop for every index of semesterArr
    for (int i = 0; i < semesterArr.size(); i++) {

      // Declare variable that increments each index as for loop increments
      int currentSemester = semesterArr.get(i);

      // Conditional to check if index matches selected semester to be deleted
      if (currentSemester == semester)
        resNumIndexes++; //increment res to signify that they match

    }

    // Declare loop counter variable 
    int loopCounter = resStart;
    int loopCounterTwo = resNumIndexes;

    // Iterate through semesterArr to delete indexes in semester
    // While loop for however many indexes are in semester to be deleted
    while(loopCounter < resNumIndexes) {

      // Conditional to see if entire semester has been removed yet
      if(loopCounter == resStart && loopCounterTwo != 0) {

        // Remove all elements at current index 
        nameArr.remove(loopCounter);
        creditArr.remove(loopCounter);
        gradeLetterArr.remove(loopCounter);
        gradeGpaArr.remove(loopCounter);
        semesterArr.remove(loopCounter);

        // Decrement loopcountertwo
        loopCounterTwo = loopCounterTwo - 1;

      }
      else {

        loopCounter++;

      }

    }

    // Iterate through to change semester value for still existing semesters to account for now missing semester
    for(int i = 0; i < semesterArr.size(); i++) {

      // Conditional to make sure its not in first semester or an individual course 
      if(semesterArr.get(i) != 1 && semesterArr.get(i) != 0) {

        // Set semesterArr to its new title
        semesterArr.set(i, semesterArr.get(i) - 1);

      } 

    }


  }

  /* The deleteClass method will delete an 
  individually added course that the user 
  selects */
  public void deleteClass(int course) {

    // Declare variable for which individually added course the loop is on
    int courseIndex = 0;

    // Iterate through all the individually added courses to find the one to delete 
    // For loop from start to end of the semester ArrayList
    for(int i = 0; i < semesterArr.size(); i++) {

      // Conditional for whethether of not this is the selected class
      if(semesterArr.get(i) == 0 && courseIndex != course - 1) {
      
        // Incremement courseIndex 
        courseIndex = courseIndex + 1;
        
      }
      else if(semesterArr.get(i) == 0 && courseIndex == course - 1) {

        // Delete the course as per user request
        nameArr.remove(i);
        creditArr.remove(i);
        gradeLetterArr.remove(i);
        gradeGpaArr.remove(i);
        semesterArr.remove(i);

      }

    }

  }

  /* The semesterGPA method will calculate 
  and display the users GPA for the semester 
  that they have selected */
  public double semesterGPA(int semester) {

    // Declare variables for calculating GPA
    double totalGradePoints = 0;
    double totalCreditHours = 0;
    double gpa = 0.0;

    // Declare variables for determining semester 
    int resStart = 0;
    int resNumIndexes = 0;

    // Iterate through semester array to find where selected semester starts
    // For loop for entire semester Arraylist
    for(int i = 0; i < semesterArr.size(); i++) {

      // Declare variable that increments each index as for loop increments
      int currentSemester = semesterArr.get(i);

      // Conditional to check if index matches selected semester
      if (currentSemester == semester && resStart != 0) {

        // Set res equal to current index to signify starting index of semester
        resStart = i;
      
      }

    }

    // Iterate through semesterArr to find how many indexes are in this semester
    // For loop for every index of semesterArr
    for (int i = 0; i < semesterArr.size(); i++) {

      // Declare variable that increments each index as for loop increments
      int currentSemester = semesterArr.get(i);

      // Conditional to check if index matches selected semester to be deleted
      if (currentSemester == semester)
      resNumIndexes++; //increment res to signify that they match

    }

    // Iterate through user's selected semester and calculate its gpa 
    // For loop for selected semester 
    for(int i = resStart; i <= resNumIndexes; i++) {

      // Declare variable for credit indexes 
      int loopCounter = resStart;

      // Iterate to find total credit hours
      // While loop for credits within semester selected 
      while(loopCounter < resNumIndexes) {

        // Get credits and gpa for current index and find grade points for current course
        double currentCredits = creditArr.get(loopCounter);
        double currentGradeGpa = gradeGpaArr.get(loopCounter);
        double currentGradePoint = currentCredits * currentGradeGpa;

        // Add currents and totals for grade points and credits
        totalCreditHours = totalCreditHours + currentCredits;
        totalGradePoints = totalGradePoints + currentGradePoint;

        // Increment loop counter 
        loopCounter++;

      }
      
    }

    // Calculate total GPA using grade points and credits 
    gpa = totalGradePoints / totalCreditHours;

    // Return user's gpa
    return gpa;

  }

  /* The careerGpa method will calculate and 
  display the users GPA when taking all classes 
  into consideration */
  public double careerGpa() {

    // Declare method variables
    double totalGradePoints = 0;
    double totalCreditHours = 0;
    double gpa = 0.0;

    // Iterate through entire Arraylist to find total credit hours
    // For loop from start of credit array to end 
    for(int i = 0; i < creditArr.size(); i++) {

      // Get current index
      double currentCredits = creditArr.get(i);

      // add current credits to total credits;
      totalCreditHours = totalCreditHours + currentCredits;

    }

    // Iterate thorugh entire Arraylist to find total grade points
    // For loop from start of gradeGpa array to end
    for(int i = 0; i < gradeGpaArr.size(); i++) {

      // Get current index for both credits and gradeGpa 
      double currentCredits = creditArr.get(i);
      double currentGradeGpa = gradeGpaArr.get(i);

      // Calculate total grade points for the current index
      double currentGradePoint = currentCredits * currentGradeGpa;

      // Add current total grade points to the total grade points overall
      totalGradePoints = totalGradePoints + currentGradePoint;

    }

    // Calculate total GPA using grade points and credits 
    gpa = totalGradePoints / totalCreditHours;

    // Return user's gpa
    return gpa;

  }

  /* The listLetterGrades method will display
  how many of each letter grade the user has 
  received for all courses entered */
  public void listLetterGrades() {

    // Declare array to store number of each letter grade 
    int[] numLetterGrades = new int[11];

    // Iterate through entire letter grade array and add to array accordingly 
    // For loop from start to end of letterGrade arraylist 
    for(int i = 0; i < gradeLetterArr.size(); i++) {

      // Get current grade letter for current index
      String currentGradeLetter = gradeLetterArr.get(i);

      // Conditional to add to array 
      switch(currentGradeLetter) {

        // Different letter grades and adding to array 
        case "A":
          // add 1 to 'A' index in array
          numLetterGrades[0] = numLetterGrades[0] + 1;
        case "A-":
          // add 1 to 'A-' index in array
          numLetterGrades[1] = numLetterGrades[1] + 1;
        case "B+":
          // add 1 to 'B+' index in array
          numLetterGrades[2] = numLetterGrades[2] + 1;
        case "B":
          // add 1 to 'B' index in array
          numLetterGrades[3] = numLetterGrades[3] + 1;
        case "B-":
          // add 1 to 'B-' index in array
          numLetterGrades[4] = numLetterGrades[4] + 1;
        case "C+":
          // add 1 to 'C+' index in array
          numLetterGrades[5] = numLetterGrades[5] + 1;
        case "C":
          // add 1 to 'C' index in array
          numLetterGrades[6] = numLetterGrades[6] + 1;
        case "C-":
          // add 1 to 'C-' index in array
          numLetterGrades[7] = numLetterGrades[7] + 1;
        case "D+":
          // add 1 to 'D+' index in array
          numLetterGrades[8] = numLetterGrades[8] + 1;
        case "D":
          // add 1 to 'D' index in array
          numLetterGrades[9] = numLetterGrades[9] + 1;
        default:
          // add 1 to 'F' index in array
          numLetterGrades[10] = numLetterGrades[10] + 1;

      }

    }

      // Print the various letter grades and how many of each the user has received
      System.out.println("Here is a list of how many of each grade you have earned");
      System.out.println("A: " + numLetterGrades[0]);
      System.out.println("A-: " + numLetterGrades[1]);
      System.out.println("B+: " + numLetterGrades[2]);
      System.out.println("B: " + numLetterGrades[3]);
      System.out.println("B-: " + numLetterGrades[4]);
      System.out.println("C+: " + numLetterGrades[5]);
      System.out.println("C: " + numLetterGrades[6]);
      System.out.println("C-: " + numLetterGrades[7]);
      System.out.println("D+: " + numLetterGrades[8]);
      System.out.println("D: " + numLetterGrades[9]);
      System.out.println("F: " + numLetterGrades[10]);

  }

  /* The listCourses method will display all
  the courses the user has entered and their
  details in order of oldest to most recent */
  public void listCourses() {

    // Print to tell user the courses are being listed
    System.out.println("Here is a list of all your completed courses:");
    System.out.println("");

    // Iterate through all ArrayList indexes and print values
    // For loop for every course
    for(int i = 0; i < nameArr.size(); i++) {

      // Print semester 1 header if start of list and not an individual course
      if(i == 0 && semesterArr.get(i) != 0) {

        // Print statements
        System.out.println("Semester 1:");
        System.out.println("-------------------------");

      }

      // Print semester header if not the same as previous index and not an individual course
      if(i != 0 && semesterArr.get(i) != semesterArr.get(i - 1) && semesterArr.get(i) != 0) {

        // Print statements
        System.out.println("");
        System.out.println("Semester " + semesterArr.get(i) + " :");
        System.out.println("-------------------------");

      }

      // Print an individual course header if the index is tagged as such
      if(semesterArr.get(i) == 0) {

        // Print statements
        System.out.println("");
        System.out.println("Individual Course:");
        System.out.println("-------------------------");

      }

      // Print the ArrayList elements
      System.out.println("Course Name:" + nameArr.get(i));
      System.out.println("Grade: " + gradeLetterArr.get(i));
      System.out.println(creditArr.get(i) + " credits");

    }

  }

  /* The exit method will allow the user
  to exit the program even after they have 
  already selected to continue */
  public void exit() {

    // Create an object of print 
    Print print = new Print();
    
    // Print the thank you message 
    print.printThank();

    // Exit the program 
    System.exit(0);

  }

}
