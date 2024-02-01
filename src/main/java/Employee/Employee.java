package Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_salary")
    private int salary;

    // Default constructor is required by Hibernate
    public Employee() {
    }

    public Employee(int id, String name, String email, int salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getter methods

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    // Setter methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // toString method

    @Override
    public String toString() {
        return "Employee [id:" + id + " name:" + name +
                " email: " + email + " salary:" + salary + "]";
    }
}
