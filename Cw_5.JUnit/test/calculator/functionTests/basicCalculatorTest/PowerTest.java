package calculator.functionTests.basicCalculatorTest;

import calculator.BasicCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PowerTest {

    private double expectedRes;
    private double firstNum;
    private double secNum;

    public PowerTest(double expectedRes,double firstNum, double secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{36,6,2},{4,16,1.0/2.0},{81,-3,4}};
        return Arrays.asList(data);
    }
    @Test
    public void testPower(){
        Assert.assertEquals(expectedRes, BasicCalculator.calculatePow(firstNum,secNum),0.00000001);
    }
}
