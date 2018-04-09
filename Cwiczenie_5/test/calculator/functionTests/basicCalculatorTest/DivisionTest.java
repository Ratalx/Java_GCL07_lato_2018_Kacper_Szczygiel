package calculator.functionTests.basicCalculatorTest;

import calculator.BasicCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class DivisionTest {

    private double expectedRes;
    private double firstNum;
    private double secNum;
    private double fristExeptionNum;
    private double secExceptionNum;
    public DivisionTest(double expectedRes,double firstNum, double secNum,double fristExeptionNum,double secExceptionNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
        this.fristExeptionNum=fristExeptionNum;
        this.secExceptionNum=secExceptionNum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{5,10,2,20,0},{-10,20,-2,10,0},{2,2,1,-15,0}};
        return Arrays.asList(data);
    }
    @Test
    public void testDiv(){
        Assert.assertEquals(expectedRes, BasicCalculator.calculateDivision(firstNum,secNum),0.00000001);
    }
    @Test(expected = Exception.class)
    public void  testDivExp(){
        Assert.assertEquals(null,BasicCalculator.calculateDivision(10,0));

    }
}
