import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests {

    @DataProvider
    public Object[][] dataPos() {
        return new Object[][]{
                {5.1, 2.0, 7.1, '+'},
                {2, 2, 4, '*'},
                {5, 3, 2, '-'},
                {4, 2, 2, '/'},
                {0, 0, 0, '+'},
                {0, 0, 0, '*'},
                {0, 0, 0, '-'},
                {0, 1, 0, '/'},
                {0.1, 0, 0.1, '+'},
                {-1, 1, 0, '+'},
                {-1, -1, -2, '+'},
                {2, 2, 0, '-'},
                {-1, -1, 1, '*'},
                {1, 1, 1, '/'},
                {100, 0, 0, '*'},
                {-100, 100, -200, '-'},
                {5, 10, 0.5, '/'}
        };
    }

    @DataProvider
    public Object[][] dataNegative() {
        return new Object[][]{
                {"qq", 2, '+'},
                {4, "2q", '/'},
                {2, "qq", '*'},
                {'*', '*', '*'},
                {4, 2, "qq"},
                {Double.MAX_VALUE, 40, '+'},
                {Double.MIN_VALUE, 40, '-'}
        };
    }

    @Test(dataProvider = "dataPos")
    public void testPos(double a, double b, double c, char action) {
        Assert.assertEquals(c, new Calc().doAction(a, b, action), "Не верно");
    }


    @Test(dataProvider = "dataNegative", expectedExceptions = ClassCastException.class)
    public void testNegative(Object a, Object b, Object action) {
        Assert.assertFalse((Boolean) new Calc().doAction(action, a, b));
    }
}