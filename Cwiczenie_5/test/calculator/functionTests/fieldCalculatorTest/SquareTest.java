package calculator.functionTests.fieldCalculatorTest;

import calculator.BasicCalculator;
import calculator.FieldCalcuklator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SquareTest {

    private double expectedRes;
    private double firstNum;
    private double secNum;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    public SquareTest(double expectedRes,double firstNum, double secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{36,6,-2},{16,4,0},{81,9,-1}};
        return Arrays.asList(data);
    }
    @Test
    public void testSquare(){
        Assert.assertEquals(expectedRes, FieldCalcuklator.calculateSquare(firstNum),0.00000001);
    }
    @Test
    public  void exceptionTestSquare()
    {
        exception.expect(IllegalArgumentException.class);
        FieldCalcuklator.calculateSquare(secNum);
    }
}
