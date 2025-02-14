package lesson2HomeWork;

public class Hw {
    public class DeliveryCostCalculator {

        // Константы для минимальной стоимости доставки
        private static final int MIN_DELIVERY_COST = 400;

        // Метод для расчёта стоимости доставки
        public static int calculateDeliveryCost(int distance, String size, boolean isFragile, String workload) {
            int cost = 0;

            // Расчёт стоимости в зависимости от расстояния
            if (distance > 30) {
                cost += 300;
            } else if (distance > 10) {
                cost += 200;
            } else if (distance > 2) {
                cost += 100;
            } else {
                cost += 50;
            }

            // Расчёт стоимости в зависимости от габаритов
            if (size.equalsIgnoreCase("большие")) {
                cost += 200;
            } else if (size.equalsIgnoreCase("маленькие")) {
                cost += 100;
            }

            // Расчёт стоимости в зависимости от хрупкости
            if (isFragile) {
                if (distance > 30) {
                    throw new IllegalArgumentException("Хрупкие грузы нельзя возить на расстояние более 30 км");
                }
                cost += 300;
            }

            // Применение коэффициента загруженности
            double workloadCoefficient = getWorkloadCoefficient(workload);
            cost = (int) (cost * workloadCoefficient);

            // Проверка на минимальную стоимость доставки
            if (cost < MIN_DELIVERY_COST) {
                cost = MIN_DELIVERY_COST;
            }

            return cost;
        }

        // Метод для получения коэффициента загруженности
        private static double getWorkloadCoefficient(String workload) {
            switch (workload.toLowerCase()) {
                case "очень высокая":
                    return 1.6;
                case "высокая":
                    return 1.4;
                case "повышенная":
                    return 1.2;
                default:
                    return 1.0;
            }
        }


    }
}
