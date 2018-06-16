package calculator.functionTests.basicCalculatorTest;

import calculator.BasicCalculator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class SqlrTest {

    private double expectedRes;
    private double firstNum;
    private double secNum;

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    public SqlrTest(double expectedRes,double firstNum, double secNum) {
        this.expectedRes=expectedRes;
        this.firstNum=firstNum;
        this.secNum=secNum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] data = new Object[][]{{5,25,-15},{6,36,-2},{10,100,-1.0/2.0}};
        return Arrays.asList(data);
    }
    @Test
    public void testSqlr(){
        Assert.assertEquals(expectedRes, BasicCalculator.calculateSqlr(firstNum),0.00000001);
    }
    @Test
    public  void exceptionTestSqlr()
    {
        exception.expect(IllegalArgumentException.class);
        BasicCalculator.calculateSqlr(secNum);
    }
}
