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
public class TriangleTest {
    private double expectedRes;
    private double firstNum;
    private double secNum;
    private double firstNumEx;
    private double secNumEx;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    public TriangleTest(double expectedRes,double firstNum, double secNum,double firstNumEx, double secNumEx) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
        this.firstNumEx=firstNumEx;
        this.secNumEx=secNumEx;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{4,6,2,0,6},{8.0/3.0,4,2,-4,-7},{9,9,3,9,-4}};
        return Arrays.asList(data);
    }
    @Test
    public void testTriangle(){
        Assert.assertEquals(expectedRes, FieldCalcuklator.calculateTriangle(firstNum,secNum),0.00000001);
    }
    @Test
    public  void exceptionTestTriangle()
    {
        exception.expect(IllegalArgumentException.class);
        FieldCalcuklator.calculateTriangle(firstNumEx,secNumEx);
    }
}
