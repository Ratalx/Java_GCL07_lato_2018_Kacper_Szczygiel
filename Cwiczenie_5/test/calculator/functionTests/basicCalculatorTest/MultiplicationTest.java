package calculator.functionTests.basicCalculatorTest;
import calculator.BasicCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)

public class MultiplicationTest {


    private double expectedRes;
    private double firstNum;
    private double secNum;

    public MultiplicationTest(double expectedRes,double firstNum, double secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{10,2,5},{36,6,6},{-6,-1,6}};
        return Arrays.asList(data);
    }
    @Test
    public void testMulti(){
        Assert.assertEquals(expectedRes, BasicCalculator.calculateMultiplication(firstNum,secNum),0.00000001);
    }
}
