package lesson2HomeWork;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UnitTests {

        @Test
        void testCalculateDeliveryCost_DistanceMoreThan30() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(35, "маленькие", false, "обычная");
            assertEquals(500, cost); // 300 (distance) + 100 (size) = 400, но минимальная стоимость 400
        }

        @Test
        void testCalculateDeliveryCost_DistanceUpTo30() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(25, "маленькие", false, "обычная");
            assertEquals(300, cost); // 200 (distance) + 100 (size) = 300, но минимальная стоимость 400
        }

        @Test
        void testCalculateDeliveryCost_DistanceUpTo10() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(8, "маленькие", false, "обычная");
            assertEquals(200, cost); // 100 (distance) + 100 (size) = 200, но минимальная стоимость 400
        }

        @Test
        void testCalculateDeliveryCost_DistanceUpTo2() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(1, "маленькие", false, "обычная");
            assertEquals(150, cost); // 50 (distance) + 100 (size) = 150, но минимальная стоимость 400
        }

        @Test
        void testCalculateDeliveryCost_LargeSize() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(5, "большие", false, "обычная");
            assertEquals(300, cost); // 100 (distance) + 200 (size) = 300, но минимальная стоимость 400
        }

        @Test
        void testCalculateDeliveryCost_FragileGoods() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(15, "маленькие", true, "обычная");
            assertEquals(600, cost); // 200 (distance) + 100 (size) + 300 (fragile) = 600
        }

        @Test
        void testCalculateDeliveryCost_FragileGoodsLongDistance() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                Hw.DeliveryCostCalculator.calculateDeliveryCost(35, "маленькие", true, "обычная");
            });
            assertEquals("Хрупкие грузы нельзя возить на расстояние более 30 км", exception.getMessage());
        }

        @Test
        void testCalculateDeliveryCost_HighWorkload() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(25, "маленькие", false, "высокая");
            assertEquals(420, cost); // (200 (distance) + 100 (size)) * 1.4 = 420
        }

        @Test
        void testCalculateDeliveryCost_VeryHighWorkload() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(25, "маленькие", false, "очень высокая");
            assertEquals(480, cost); // (200 (distance) + 100 (size)) * 1.6 = 480
        }

        @Test
        void testCalculateDeliveryCost_DefaultWorkload() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(25, "маленькие", false, "обычная");
            assertEquals(300, cost); // (200 (distance) + 100 (size)) * 1.0 = 300, но минимальная стоимость 400
        }

        @Test
        void testCalculateDeliveryCost_MinimumCost() {
            int cost = Hw.DeliveryCostCalculator.calculateDeliveryCost(1, "маленькие", false, "обычная");
            assertEquals(400, cost); // 50 (distance) + 100 (size) = 150, но минимальная стоимость 400
        }
    }

