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
public class SumTest {

    private double expectedRes;
    private double firstNum;
    private double secNum;

    public SumTest(int expectedRes, int firstNum, int secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{6,2,4},{7,4,3},{8,2,6}};
        return Arrays.asList(data);
    }
    @Test
    public void testAdd(){
        Assert.assertEquals(expectedRes, BasicCalculator.calculateSum(firstNum,secNum),0.00000001);
    }

}
