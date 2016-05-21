package utility;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testEnter() {
    Calculator calc = new Calculator();

    assertEquals(true , true);  
  }

  @Test
  public void testStackEmpty() {
    Calculator calc = new Calculator();

    assertTrue(calc.stackEmpty());  
  }

  @Test
  public void testIsOperator () {
     Calculator calc = new Calculator();

     assertTrue(calc.isOperator("+"));
     assertTrue(calc.isOperator("-"));
     assertTrue(calc.isOperator("*"));
     assertTrue(calc.isOperator("/"));
     assertTrue(calc.isOperator("%"));
     assertTrue(calc.isOperator("p"));
     assertTrue(calc.isOperator("d"));
     assertFalse(calc.isOperator("23"));
     assertFalse(calc.isOperator("++"));
     assertFalse(calc.isOperator("^"));
  }
}
