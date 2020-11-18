package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    private String employee_id;
    String name;
    String surname;
    int salary;

    public Employee(String name,
                    String surname,
                    int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.employee_id = UUID.randomUUID().toString();
    }

    public Employee() {

    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary(){ return salary;}

}

}