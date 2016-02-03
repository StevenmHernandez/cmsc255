//*****************************************************
//
// Steven Hernandez.
// Introduction to Programming CMSC 255-002 Spring 2016
// Selection.java
// Project: 2
// Circle Maths
//
//*****************************************************

import java.util.Scanner;

class Selection {
  /*
   * 
   * Use this portion of code for all project in this course
   * Replace these variables per project
   * 
   */
  public static String project_file_name = "Selection.java";
  public static int project_number = 2;
  public static String project_description = "Circle Maths";

  private static void printHeading() {
    // Print out the Heading (reuse for each project)
    System.out.println("Steven Hernandez.");
    System.out.println("Introduction to Programming CMSC 255-002 Spring 2016");
    System.out.println(project_file_name);
    System.out.println("Project: " + project_number);
    System.out.println(project_description);
    System.out.println();
  }
 
 
  /*
   * 
   * Actual Project Code
   * 
   */
  public static void main (String[] args) {
    System.out.println("Let's do some Circle calculations.");
    
    Scanner scan = new Scanner(System.in);
    
    //Ask user for floating point radius of circle
    float radius = requestRadius(scan);
    
    //Ask user what they want calculated
    String type = requestCalculationType(scan);
    
    //instantiate calculation variables
    String calculationTypeName = "";
    double answer = 0;
    
    //calculate answer based on input from user
    if (type.equals("D")) {
      calculationTypeName = "diameter";
      answer = radius * 2;
    } else if (type.equals("C")) {
      calculationTypeName = "circumference";
      answer = 2 * Math.PI * radius;
    } else if (type.equals("A")) {
      calculationTypeName = "area";
      answer = Math.PI * Math.pow(radius, 2);
    }
    
    //print "The X of a circle with radius X is X."
    System.out.printf("\nThe %s of the circle with radius %.2f is %.2f", calculationTypeName, radius, answer);
  }
  
  /*
   * 
   * Request Radius from the user
   * 
   */
  public static float requestRadius(Scanner scan) {
    System.out.println("Please enter a radius (including decimal points)");
    
    if(scan.hasNextFloat()) {
      float radius = scan.nextFloat();
      return radius;
    } else {
      String non_floating_radius = scan.next();
      System.out.printf("Sorry, \"%s\" doesn't seem to be a number we can use for the calculation.\n", non_floating_radius);
      return requestRadius(scan);
    }
  }
  
  /*
   * 
   * Request Calculation type from the user
   * 
   */
  public static String requestCalculationType(Scanner scan) {
    System.out.println("What would you like to calculate?");
    System.out.println("To calculate Diameter, Circumference, or Area, enter D, C, or A.");

    String type = scan.next();
    
    //Validate the incoming string
    if(type.equals("D") || type.equals("C") || type.equals("A")) {
      //if the input string is an allowed option, return the string
      return type;
    } else {
      //otherwise, re-ask the user for an allowed option
      System.out.printf("Sorry, \"%s\" is not a calculation option.\n", type);
      return requestCalculationType(scan);
    }
  }
  
}