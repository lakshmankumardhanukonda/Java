package functionalinterfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceDemo {

    public static List<Employee> employees;

    static {
        employees = new ArrayList<>();
        employees.add(Employee.builder().name("John").id(100).gender("Male").salary(25000).build());
        employees.add(Employee.builder().name("Alex").id(101).gender("Male").salary(24000).build());
        employees.add(Employee.builder().name("Merry").id(102).gender("Female").salary(23000).build());
        employees.add(Employee.builder().name("Sam").id(103).gender("Male").salary(26000).build());
        employees.add(Employee.builder().name("Angela").id(104).gender("Female").salary(27000).build());
    }

    Predicate<Employee> salGt25000Predicate = (employee) -> employee.getSalary() > 25000;

    Predicate<Employee> salLt25000Predicate = (employee) -> employee.getSalary() < 25000;

    Predicate<Employee> isMalePredicate = (employee) -> "Male".equalsIgnoreCase(employee.getGender());

    Predicate<Employee> isFemalePredicate = (employee) -> "Female".equalsIgnoreCase(employee.getGender());

    Predicate<Employee> namesStartsWithA = (employee) -> employee.getName().startsWith("A");

    Function<Integer, Integer> squareOfNumber = (number) -> number * number;

    Function<Integer, Integer> doubleTheNumber = (number) -> number + number;

    Consumer<Employee> printEmployeeName = (employee) -> System.out.println(employee.getName());

    Consumer<Employee> printEmployeeId = (employee) -> System.out.println(employee.getId());

    Consumer<Employee> printEmployeeGender = (employee) -> System.out.println(employee.getGender());

    Consumer<String> printString = (str) -> System.out.println(str);

    Supplier<Date> getCurrentDate = () -> new Date();

    BiPredicate<Double, Double> isSumOfSquaresEqProduct = (number1, number2) -> (number1 * number1 + number2 * number2) == number1 * number2;

    BiFunction<Double,Double, Double> calculateDiscountAmount = (totalAmount, discountPercentage) -> (totalAmount * discountPercentage)/100;

    BiFunction<Double, Double, Double> calculateTotalBill = (totalAmount, discountAmount) -> totalAmount - discountAmount;

    BiConsumer<String, String> printAsCommaSeparated = (str1, str2) -> System.out.println(str1 + ", " + str2);

    Function<Double, Double> roundOff = (amount) -> Math.ceil(amount);

    public void printEmployeeNamesWhoseSalaryGreaterThan25000AndAreMale() {
        Predicate<Employee> salGt25000AndMalePredicate = salGt25000Predicate.and(isMalePredicate);
        employees.stream().filter(salGt25000AndMalePredicate).forEach(printEmployeeName);
    }

    public void printEmployeeNamesWhoseSalaryGreaterThan25000AndAreFemale() {
        Predicate<Employee> salGt25000AndFemalePredicate = salGt25000Predicate.and(isFemalePredicate);
        employees.stream().filter(salGt25000AndFemalePredicate).forEach(printEmployeeName);
    }

    public void printEmployeeNamesWhoseSalaryLessThan25000OrGenderFemale() {
        Predicate<Employee> salLt25000OrGenderFemale = salLt25000Predicate.or(isFemalePredicate);
        employees.stream().filter(salLt25000OrGenderFemale).forEach(printEmployeeName);
    }

    public void printEmployeeNamesStartsWithA() {
        employees.stream().filter(namesStartsWithA).forEach(printEmployeeName);
    }

    public void printEmployeeNamesDoesNotStartsWithA() {
        employees.stream().filter(namesStartsWithA.negate()).forEach(printEmployeeName);
    }

    public void squareAndThenDouble() {
        Integer squareAndDouble = squareOfNumber.andThen(doubleTheNumber).apply(3);
        System.out.println(squareAndDouble);
    }

    public void doubleAndThenSquare() {
        Integer doubleAndThenSquare = doubleTheNumber.andThen(squareOfNumber).apply(3);
        System.out.println(doubleAndThenSquare);
    }

    public void composeTwoFunction() {
        Integer composeResult = squareOfNumber.compose(doubleTheNumber).apply(3);
        System.out.println(composeResult);
    }

    public void printEmployeeIds() {
        employees.stream().forEach(printEmployeeId);
    }

    public void printEmployeeDetails() {
        Consumer<Employee> printDetails = printEmployeeId.andThen(printEmployeeName).andThen(printEmployeeGender);
        employees.stream().forEach(printDetails);
    }

    public void printTodayDate() {
        printString.accept(getCurrentDate.get().toString());
    }

    public void calculateSumOfSquaresEqToProduct() {
        System.out.println(isSumOfSquaresEqProduct.test(3D, 4D));
    }

    public void printBillAmount() {
        Double amount = 5500D;
        Double discountPercentage = 15D;
        Double totalDiscount = calculateDiscountAmount.apply(amount, discountPercentage);
        Double totalBill = calculateTotalBill.andThen(roundOff).apply(amount, totalDiscount);
        System.out.println(totalBill);
    }

    public void printHobbies() {
        printAsCommaSeparated.accept("cricket", "football");
    }
}



