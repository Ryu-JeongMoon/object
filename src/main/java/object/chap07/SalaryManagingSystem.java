package object.chap07;

import java.util.Map;
import java.util.Scanner;

public class SalaryManagingSystem {

    private static final Map<String, Integer> employeesPays = Map.of("emA", 400, "emB", 300, "emC", 250);
    private static final String NAME = "emA";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(calculate(NAME));
        System.out.println("sumOfBasePays() = " + sumOfBasePays());

    }

    private static String calculate(String name) {
        Double taxRate = getTaxRate();
        Double pay = calculatePayFor(name, taxRate);
        return printPretty(NAME, pay);
    }

    private static Integer sumOfBasePays() {
        return employeesPays.values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static String printPretty(String name, Double pay) {
        return String.format("NAME -> {%s}, SALARY -> {%.2f}", name, pay);
    }

    private static Double calculatePayFor(String name, Double taxRate) {
        Integer basePay = employeesPays.get(name);
        return basePay * (1 - taxRate);
    }

    private static Double getTaxRate() {
        System.out.print("세율을 입력하세요 : ");
        return Double.parseDouble(scanner.nextLine());
    }
}
