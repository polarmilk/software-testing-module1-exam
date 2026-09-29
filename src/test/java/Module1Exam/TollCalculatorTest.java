package Module1Exam;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TollCalculatorTest {

    private final TollCalculator calculator = new TollCalculator();

    @ParameterizedTest(name = "{0}: weight={1}, isEV={2}, isCarpool={3} -> expected={4}")
    @CsvSource({
            // Equivalence Partitions
            "TC1,  -10,  false, false, EXCEPTION",
            "TC2,  500,  true,  false, 0.0",
            "TC3,  2500, false, true,  0.10",
            "TC4,  5000, true,  true,  0.25",

            // Boundary Value Analysis
            "TC5,  0,    false, false, EXCEPTION",
            "TC6,  1,    false, false, 0.0",
            "TC7,  1200, false, false, 0.0",
            "TC8,  1201, false, false, 0.0",
            "TC9,  3500, false, false, 0.0",
            "TC10, 3501, false, false, 0.05",

            // Decision Table
            "TC11, 500,  true,  true,  0.0",
            "TC12, 2500, true,  true,  0.15",
            "TC13, 2500, true,  false, 0.10",
            "TC14, 5000, true,  false, 0.05",
            "TC15, 500,  false, true,  0.0",
            "TC16, 5000, false, true,  0.05",
            "TC17, 500,  false, false, 0.0",
            "TC18, 2500, false, false, 0.0",
            "TC19, 5000, false, false, 0.05"
    })
    void testCalculateDiscount(
            String testCase,
            double weight,
            boolean isEV,
            boolean isCarpool,
            String expected) {

        if (expected.equals("EXCEPTION")) {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> calculator.calculateDiscount(weight, isEV, isCarpool)
            );
        } else {
            assertEquals(
                    Double.parseDouble(expected),
                    calculator.calculateDiscount(weight, isEV, isCarpool)
            );
        }
    }
}