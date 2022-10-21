import org.example.TwoSums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TwoSumTest {
    private final TwoSums twoSums = new TwoSums();

    @ParameterizedTest
    @CsvSource({
            "30",
            "40",
            "50",
            "60"
    })
    public void shouldConvertCorrectly(int desiredResult) {
        int[] answer = twoSums.calculate(new int[]{10, 20, 30, 40, 50, 60}, desiredResult);

        Assertions.assertNotNull(answer);
    }
}
