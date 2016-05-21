package utility;
import java.util.Scanner;
import java.util.Stack;

class CalculatorApp {
    public static void main(String[] args) {

      // create new calculator
      Calculator calc = new Calculator();

      System.out.println("Enter expressions or values (type Ctrl + c to finish):");

      // get user input
      Scanner in = new Scanner(System.in);
      while(in.hasNext()) {
        calc.enter(parse(in.nextLine()));
        Stack<Integer> result = calc.getResult();
        System.out.println(result.toString().substring(1, result.toString().length() -1 ));
      }
    }

  public static String[] parse(String expr) {
    String[] values = expr.split("\\s+");

    // check whether values are valid
    for (int i = 0; i < values.length; i++) {
      if (!values[i].matches("[*+-/%pd]") && !values[i].matches("clear"))
        try {
          Integer.parseInt(values[i]);
        } catch (NumberFormatException e) {
          System.out.format("Error: '%s' is not an integer or valid operator\n", values[i]);
          return new String[0];
        }
    }

    return values;
  }
}
