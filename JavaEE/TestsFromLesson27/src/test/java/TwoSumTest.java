import org.example.TwoSums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TwoSumTest {
    private final TwoSums twoSums = new TwoSums();

    @Test
    public void testCalculatedMethodIfArrayNotNull() {
        TwoSums twoSums = new TwoSums();
        int[] array = {10, 20, 30, 40, 50, 60};
        int desiredResult = 30;
        int[] expectedArray = {0, 1};
        int[] answer = twoSums.calculate(array, desiredResult);
        Assertions.assertArrayEquals(expectedArray, answer);
    }

    @Test
    public void testCalculatedMethodIfArrayNull() {
        TwoSums twoSums = new TwoSums();
        int[] array = null;
        int desiredResult = 30;
        Assertions.assertNull(twoSums.calculate(array, desiredResult));
    }

    @Test
    public void testCalculatedMethodIfNoSolution() {
        TwoSums twoSums = new TwoSums();
        int[] array = {30, 40, 50, 60};
        int desiredResult = 30;
        Assertions.assertNull(twoSums.calculate(array, desiredResult));
    }

}
