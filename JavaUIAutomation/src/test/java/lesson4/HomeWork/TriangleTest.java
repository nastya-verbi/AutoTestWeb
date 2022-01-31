package lesson4.HomeWork;

import lesson4.HomeWork.HomeWork.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    Logger logger = LoggerFactory.getLogger("TriangleTest");
    @Nested
    @DisplayName("Позитивные тесты")
    class PositiveTests {

        @ParameterizedTest
        @CsvSource({"3, 4.6, 5, 6.8", "5.5, 8, 7, 18.9", "6, 9, 5.7, 16.8"})
        void checkValidData(double a, double b, double c, double actualResult) {
            assertEquals(Triangle.areaOfATriangle(a, b, c), actualResult);
            logger.info("log data");
        }
    }

    @Nested
    @DisplayName("Негативные тесты")
    class NegativeTests {

        @ParameterizedTest
        @CsvSource({"10, 3, 4, 0.0", "5.5, 18, 7, 0.0", "6, 9, 25, 0.0"})
        void checkOneSideMoreSemiPerimeter(double a, double b, double c, double actualResult) {
            assertEquals(Triangle.areaOfATriangle(a, b, c), actualResult);
            logger.info("log data");
        }

        @ParameterizedTest
        @CsvSource({"0, 3, 4, 0.0", "5.5, 0, 7, 0.0", "6, 9, 0, 0.0"})
        void checkOneSideZero(double a, double b, double c, double actualResult) {
            assertEquals(Triangle.areaOfATriangle(a, b, c), actualResult);
            logger.info("log data");
        }

        @ParameterizedTest
        @CsvSource({"-3, 3, 4, 0.0", "5.5, -7, 7, 0.0", "6, 9, 2, 0.0"})
        void checkOneSideNegative(double a, double b, double c, double actualResult) {
            assertEquals(Triangle.areaOfATriangle(a, b, c), actualResult);
            logger.info("log data");
        }
    }
}
