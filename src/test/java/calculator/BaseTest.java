package calculator;

import org.example.calculator.Calculator;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

  public static  Calculator calculator;
    @BeforeAll
    public static void setCalculator(){
        calculator = new Calculator();
    }
}
