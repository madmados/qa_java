import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class felineGetKittensTest {
    private int kittensCount;
    private int expected;
    private int actual;

    public felineGetKittensTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "kittensCount: {0}, return {1}")
    public static Object[][] kittenNumbers() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {-1, -1},
                {999, 999},
                {-999, -999},
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, Integer.MIN_VALUE},
        };
    }

    @Test
    public void felineGetKittens() {
        Feline feline = new Feline();
        actual = feline.getKittens(kittensCount);
        assertEquals(expected, actual);
    }
}
