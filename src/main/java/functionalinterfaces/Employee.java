package functionalinterfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;

    private String gender;

    private int id;

    private int salary;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }
}
