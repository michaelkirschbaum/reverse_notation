package utility;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.EmptyStackException;

public class Calculator {
  private Stack<Integer> mem;

  public Calculator() {
    // initialize memory
    mem = new Stack<Integer>();
  }

  public void enter(String input) {
    // parse user input
    String[] values = input.split("\\s+");

    // check whether values are valid
    for (int i = 0; i < values.length; i++) {
      if (!isOperator(values[i]) && !values[i].matches("clear"))
   	try {
	  Integer.parseInt(values[i]);
	} catch (NumberFormatException e) {
	  System.out.format("Error: '%s' is not an integer or valid operator\n", values[i]);
          return;
	}
    }

    // evaluate expression
    for (int i = 0; i < values.length; i++) {

      // check whether input is sufficient for operator
      int temp;
      if (isOperator(values[i])) {
        try {
          temp = mem.pop();
        } catch (EmptyStackException e) {
          System.out.format("Error: insufficient input for '%s' operator\n", values[i]);
	  return;
 	}
        try {
	  mem.peek();
	} catch (EmptyStackException e) {
	  mem.push(temp);
	  System.out.format("Error: insufficient input for '%s' operator\n", values[i]);
	  return;
	}
	mem.push(temp);
      }

      int result; 
      if (values[i].matches("\\+")) {
        temp = mem.pop();	
        result = mem.pop() + temp;
        mem.push(result);
      }
      else if (values[i].matches("-")) {
        temp = mem.pop();
        result = mem.pop() - temp;
        mem.push(result);
      }
      else if (values[i].matches("\\*")) {
        temp = mem.pop();
        result = mem.pop() * temp;
        mem.push(result);
      }
      else if (values[i].matches("/")) {
        temp = mem.pop();
        result = mem.pop() / temp;
        mem.push(result);
      }
      else if (values[i].matches("%")) {
        temp = mem.pop();
        result = mem.pop() % temp;
        mem.push(result);
      }
      else if (values[i].matches("p"))
        System.out.println(mem.pop());
      else if (values[i].matches("d"))
	mem.push(mem.peek());
      else if (values[i].matches("clear")) {
	mem = new Stack<Integer>();
	return;
      }
      else
	mem.push(Integer.parseInt(values[i]));
    }
	
    showResult();
  }

  public void showResult() {
    System.out.println(mem.toString().substring(1, mem.toString().length() - 1));
  }

  public boolean isOperator (String s) {
    if (s.matches("[*+-/%pd]"))
      return true;
    else
      return false;
  }
}
