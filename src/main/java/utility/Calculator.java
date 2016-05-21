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

  public Stack<Integer> enter(String[] values) {

    // evaluate expression
    for (int i = 0; i < values.length; i++) {

      if (isOperator(values[i]) && stackEmpty()) { 
        System.out.format("Error: insufficient input for '%s' operator\n", values[i]);
        return mem; 
      }

      int temp, result; 
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
	return mem;
      }
      else
	mem.push(Integer.parseInt(values[i]));
    }

    return mem;
  }

  public boolean stackEmpty() {

    // if stack is empty or has only one value, operator cannot be applied
    int temp;
    try {
      temp = mem.pop();
    } catch (EmptyStackException e) {
      return true;
    }
    try {
      mem.peek();
    } catch (EmptyStackException e) {
      mem.push(temp);
      return true;
    }

  mem.push(temp);
  return false;
  }

  public boolean isOperator(String value) {
    if (value.matches("[*+-/%pd]"))
      return true;
    else
      return false;
  }
}
