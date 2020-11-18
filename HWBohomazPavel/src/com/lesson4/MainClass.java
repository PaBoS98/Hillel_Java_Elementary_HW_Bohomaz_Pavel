package com.lesson4;

public class MainClass {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        float totalSpendMoney = 0;
        float totalFill = 0;

        System.out.println("Маршрут Одесса-Киев состовляет " + ANSI_RED + "473,4 км" + ANSI_RESET + ", 1 обязательная дозаправка, через " + ANSI_RED + "178 км." + ANSI_RESET + " (Кривое Озеро) \n" +
                "2 дозаправка, через " + ANSI_RED + "153 км." + ANSI_RESET + " (Жашков). Бензин будет " + ANSI_RED + "92" + ANSI_RESET + ", стоимостью " + ANSI_RED + "27 грн." + ANSI_RESET + "\n");
        float km = 473.4f;
        float priceFuel = 27.0f;

        Car car = new Car(66, 0, 7.7f);
        System.out.println("В машине объем бака будет состовлять " + ANSI_RED + "66 л." + ANSI_RESET + ", с расходом " + ANSI_RED + "7.7 л./100км." + ANSI_RESET + ", по умолчанию бак будет " + ANSI_RED + "пустой.");

        totalSpendMoney += (car.fillTankFull() * priceFuel); // заправляем полный бак

        System.out.println("\n" + "Выдвигаемся в путь, следующая дозаправка в Кривом Озере, через 178км.");
        km -= 178;
        System.out.println("В баке останется - " + ANSI_RED + car.forecastFuelRemaining(178) + " л." + ANSI_RESET);
        System.out.println("Стоимость заправки - " + ANSI_RED + (car.forecastRefueling(178) * priceFuel) + " грн." + ANSI_RESET + "\n");
        totalSpendMoney += car.forecastRefueling(178) * priceFuel; //прогноз заправки через 178км.

        System.out.println("Следуюущая остановка в Жашкова, через 153км.");
        km -= 153;
        System.out.println("В баке останется - " + ANSI_RED + car.forecastFuelRemaining(153) + " л." + ANSI_RESET);
        System.out.println("Стоимость заправки - " + ANSI_RED + (car.forecastRefueling(153) * priceFuel) + " грн." + ANSI_RESET + "\n");
        totalSpendMoney += car.forecastRefueling(153) * priceFuel; //прогноз заправки через 153км.

        System.out.println("Направляемся к конечной точке, остается - " + km + "км.");
        System.out.println("В баке останется - " + ANSI_RED + car.forecastFuelRemaining(km) + " л." + ANSI_RESET);
        System.out.println("Всего денег ушло на заправку - " + ANSI_RED + (totalSpendMoney += car.forecastRefueling(km) * priceFuel) + " грн." + ANSI_RESET);


    }
}
