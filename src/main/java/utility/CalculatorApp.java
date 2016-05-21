package utility;

import java.util.Scanner;

class CalculatorApp {
    public static void main(String[] args) {

      // create new calculator
      Calculator calc = new Calculator();

      System.out.println("Enter expressions or values (type Ctrl + c to finish):");

      // get user input
      Scanner in = new Scanner(System.in);
      while(in.hasNext()) {
        calc.enter(in.nextLine());
      }
    }
}
