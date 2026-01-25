package calculator;

import org.example.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    void sumTest(){
        calculator.sum(2,2);
        Assertions.assertEquals(4,calculator.sum(2,2));
    }
    @Test
    void divideTest(){
        Assertions.assertEquals(1,calculator.divide(2,2));
        Assertions.assertEquals(1,calculator.divide(4,0));
    }
    @Test
    void nameTest(){
        String name = "John";
        Assertions.assertEquals(4,name.length());
    }

    @Test
    void demo(){
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
    }
}
