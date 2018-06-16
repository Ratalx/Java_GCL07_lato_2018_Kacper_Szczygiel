package calculator.functionTests;

import calculator.functionTests.fieldCalculatorTest.CircleTest;
import calculator.functionTests.fieldCalculatorTest.RectangleTest;
import calculator.functionTests.fieldCalculatorTest.SquareTest;
import calculator.functionTests.fieldCalculatorTest.TriangleTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Parameterized.*;
@RunWith(Suite.class)
@SuiteClasses({CircleTest.class, RectangleTest.class, SquareTest.class, TriangleTest.class})
public class FieldCalcuklatorTest {

}