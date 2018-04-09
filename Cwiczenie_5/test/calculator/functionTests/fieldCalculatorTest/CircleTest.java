package calculator.functionTests.fieldCalculatorTest;

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
public class CircleTest {
    private double expectedRes;
    private double firstNum;
    private double secNum;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    public CircleTest(double expectedRes,double firstNum, double secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{Math.PI*36,6,-20},{Math.PI*16,4,0},{Math.PI*81,9,-1}};
        return Arrays.asList(data);
    }
    @Test
    public void testCircle(){
        Assert.assertEquals(expectedRes, FieldCalcuklator.calculateCircle(firstNum),0.00000001);
    }
    @Test
    public  void exceptionTestCircle()
    {
        exception.expect(IllegalArgumentException.class);
        FieldCalcuklator.calculateCircle(secNum);
    }
}
