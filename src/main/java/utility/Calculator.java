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
      if (isOperator(values[i]))
        if (stackEmpty()) {
          System.out.format("Error: insufficient input for operator '%s'\n", values[i]);
          return null;
        }
        else if (values[i].matches("p"))
          System.out.println(mem.pop());
        else if (values[i].matches("d"))
          mem.push(mem.peek());
        else {
          // remove top of stack
          int temp = mem.pop();

          // operator cannot be applied to single value
          if (stackEmpty()) {
            System.out.format("Error: insufficient input for operator '%s'\n", values[i]);
            mem.push(temp);
            return null;
          }
          else if (values[i].matches("\\+"))
            mem.push(mem.pop() + temp);
          else if (values[i].matches("-"))
            mem.push(mem.pop() - temp);
          else if (values[i].matches("\\*"))
            mem.push(mem.pop() * temp);
          else if (values[i].matches("/"))
            mem.push(mem.pop() / temp);
          else if (values[i].matches("%"))
            mem.push(mem.pop() % temp);
        }
      else if (values[i].matches("clear"))
        // erase memory
        mem = new Stack<Integer>();
      else // push integer to stack
        mem.push(Integer.parseInt(values[i]));
    }

    return mem;
  }

  public boolean stackEmpty() {
    try {
      mem.peek();
    } catch (EmptyStackException e) {
      return true;
    }
  
  return false;
  }

  public boolean isOperator(String value) {
    if (value.matches("[*+-/%pd]"))
      return true;
    else
      return false;
  }
}
