package functionalinterfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfaceDemo {

    Function<String,String> capitalizeFunction = name -> name.toUpperCase();

    Function<String,String> capitalizeFunctionMethodReference = String::toUpperCase;

    Function<String,String> substringFunction = name -> name.substring(2);

    BiFunction<String, String, String> concat = (name,gender) -> String.format("%s %s", name,gender);

    public void toUpperCase() {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().name("John").id(100).gender("Male").salary(25000).build());
        employees.add(Employee.builder().name("Alex").id(101).gender("Male").salary(24000).build());
        employees.add(Employee.builder().name("Merry").id(102).gender("Female").salary(23000).build());
        employees.add(Employee.builder().name("Sam").id(103).gender("Male").salary(26000).build());
        employees.add(Employee.builder().name("Angela").id(104).gender("Female").salary(27000).build());

        employees.stream()
                .map(Employee::getName)
                .forEach(name -> System.out.println(capitalizeFunction.apply(name)));
    }

    public void composeTwoFunctions() {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().name("John").id(100).gender("Male").salary(25000).build());
        employees.add(Employee.builder().name("Alex").id(101).gender("Male").salary(24000).build());
        employees.add(Employee.builder().name("Merry").id(102).gender("Female").salary(23000).build());
        employees.add(Employee.builder().name("Sam").id(103).gender("Male").salary(26000).build());
        employees.add(Employee.builder().name("Angela").id(104).gender("Female").salary(27000).build());

        Function<String,String> capitalizeFunction = String::toUpperCase;
        Function<String,String> substringFunction = name -> name.substring(2);

        Function<String,String> composedResult = substringFunction.compose(capitalizeFunction);
        employees.forEach(employee -> System.out.println(composedResult.apply(employee.getName())));
    }
}

@Builder
@AllArgsConstructor
@NoArgsConstructor
class Employee {

    private String name;

    private String gender;

    private int id;

    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

