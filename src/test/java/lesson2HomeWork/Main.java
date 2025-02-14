package lesson2HomeWork;

import static lesson2HomeWork.Hw.DeliveryCostCalculator.calculateDeliveryCost;

public class Main {
    // Пример использования
    public static void main(String[] args) {
        int distance = 41; // Расстояние в км
        String size = "маленькие"; // Габариты груза
        boolean isFragile = false; // Хрупкость груза
        String workload = "низкая"; // Загруженность службы доставки

        try {
            int deliveryCost = calculateDeliveryCost(distance, size, isFragile, workload);
            System.out.println("Стоимость доставки: " + deliveryCost + " рублей");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
