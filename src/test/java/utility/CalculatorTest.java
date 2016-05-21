package utility;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testEnter() {
    Calculator calc = new Calculator();

    assertArrayEquals(calc.enter(new String[]{"4", "7", "+"}).toArray(), new Integer[]{11});
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"52", "7", "-"}).toArray(), new Integer[]{45});
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"-12", "8", "*"}).toArray(), new Integer[]{-96});
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"100", "10", "/"}).toArray(), new Integer[]{10});
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"234", "5", "%"}).toArray(), new Integer[]{4});
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"5123", "2", "p"}).toArray(), new Integer[]{5123});
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"5", "-3", "d"}).toArray(), new Integer[]{5, -3, -3});
    calc.enter(new String[]{"clear"});
    assertNull(calc.enter(new String[]{"32", "p", "d", "17", "*"}));
    calc.enter(new String[]{"clear"});
    assertArrayEquals(calc.enter(new String[]{"12", "-12", "43", "p", "d", "d", "16", "/", "+", "*", "-"}).toArray(), new Integer[]{-132});
  }

  @Test
  // checks whether there is more than one value in stack
  public void testStackEmpty() {
    Calculator calc = new Calculator();
    assertTrue(calc.stackEmpty());  

    calc.enter(new String[]{"90"});
    assertFalse(calc.stackEmpty());

    calc.enter(new String[]{"952"});
    assertFalse(calc.stackEmpty());

    // remove top of stack
    calc.enter(new String[]{"p"});
    assertFalse(calc.stackEmpty());

    // duplicate top of stack
    calc.enter(new String[]{"p"});
    assertNull(calc.enter(new String[]{"d"}));

    calc.enter(new String[]{"6"});
    assertNull(calc.enter(new String[]{"-"}));
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
     assertFalse(calc.isOperator("2.5"));
  }
}
