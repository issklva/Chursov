package lesson2HomeWork;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParametrizedUnitTests {

    // Параметризованный тест для расчета стоимости доставки
    @ParameterizedTest
    @MethodSource("deliveryCostProvider")
    void testCalculateDeliveryCost(int distance, String size, boolean isFragile, String workload, int expectedCost) {
        int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(distance, size, isFragile, workload);
        assertEquals(expectedCost, cost);
    }

    // Параметризованный тест для проверки исключения
    @ParameterizedTest
    @MethodSource("fragileGoodsExceptionProvider")
    void testCalculateDeliveryCost_FragileGoodsLongDistance(int distance, String size, boolean isFragile, String workload, String expectedMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Hw.DeliveryCostCalculator.calculateDeliveryCost(distance, size, isFragile, workload);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    // Источник данных для тестов расчета стоимости доставки
    private static Stream<Arguments> deliveryCostProvider() {
        return Stream.of(
                Arguments.of(35, "маленькие", false, "обычная", 500), // Расстояние > 30 км
                Arguments.of(25, "маленькие", false, "обычная", 300), // Расстояние до 30 км
                Arguments.of(8, "маленькие", false, "обычная", 200),  // Расстояние до 10 км
                Arguments.of(1, "маленькие", false, "обычная", 400),  // Расстояние до 2 км (минимальная стоимость)
                Arguments.of(5, "большие", false, "обычная", 300),    // Большой размер
                Arguments.of(15, "маленькие", true, "обычная", 600),  // Хрупкий груз
                Arguments.of(25, "маленькие", false, "высокая", 420), // Высокая загруженность
                Arguments.of(25, "маленькие", false, "очень высокая", 480) // Очень высокая загруженность
        );
    }

    // Источник данных для тестов с исключением
    private static Stream<Arguments> fragileGoodsExceptionProvider() {
        return Stream.of(
                Arguments.of(35, "маленькие", true, "обычная", "Хрупкие грузы нельзя возить на расстояние более 30 км")
        );
    }
}
