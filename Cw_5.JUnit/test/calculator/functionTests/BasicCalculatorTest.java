package calculator.functionTests;

import calculator.functionTests.basicCalculatorTest.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SumTest.class, MultiplicationTest.class, DifferenceTest.class, DivisionTest.class, PowerTest.class,SqlrTest.class})
public class BasicCalculatorTest {
}
