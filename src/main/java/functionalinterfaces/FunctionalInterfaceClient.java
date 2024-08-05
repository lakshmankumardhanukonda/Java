package functionalinterfaces;

public class FunctionalInterfaceClient {

    public void execute() {
        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeNamesWhoseSalaryGreaterThan25000AndAreMale();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeNamesWhoseSalaryGreaterThan25000AndAreFemale();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeNamesWhoseSalaryLessThan25000OrGenderFemale();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeNamesStartsWithA();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeNamesDoesNotStartsWithA();
        System.out.println("==================================================================");
        functionalInterfaceDemo.squareAndThenDouble();
        System.out.println("==================================================================");
        functionalInterfaceDemo.doubleAndThenSquare();
        System.out.println("==================================================================");
        functionalInterfaceDemo.composeTwoFunction();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeIds();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printEmployeeDetails();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printTodayDate();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printBillAmount();
        System.out.println("==================================================================");
        functionalInterfaceDemo.calculateSumOfSquaresEqToProduct();
        System.out.println("==================================================================");
        functionalInterfaceDemo.printHobbies();
    }
}
