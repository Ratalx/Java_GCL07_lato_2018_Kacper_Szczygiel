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
public class DifferenceTest {

    private double expectedRes;
    private double firstNum;
    private double secNum;

    public DifferenceTest(int expectedRes,int firstNum, int secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{10,12,2},{1,4,3},{-4,2,6}};
        return Arrays.asList(data);
    }
    @Test
    public void testDiff(){
        Assert.assertEquals(expectedRes, BasicCalculator.caclulateDifference(firstNum,secNum),0.00000001);
    }
}
