import Dao.DaoEmployee;
import Employee.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
    while(true) {
        System.out.println("\n employee management");
        System.out.println("1 = Create, 2 = Read, 3 = Update, 4 = Delete ");
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        if(choice < 1 || choice >= 5) break;
        switch (choice) {
            case 1: System.out.println("id, name, email, salary");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    String email = sc.nextLine();
                    int salary = sc.nextInt();
                    Employee emp = new Employee(id, name, email, salary);
                    DaoEmployee.createEmployee(emp);

                    break;
            case 2: try {
                    List<Employee> list;
                    list = DaoEmployee.readAllEmployee();
                    for (Employee employee : list) {
                        System.out.println(employee);
                    }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            case 3: System.out.println("id & name");
                    id = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();
                    DaoEmployee.updateEmployee(id, name);
                    break;
            case 4:
                    System.out.println("id");
                    id = sc.nextInt();
                    sc.nextLine();
                    DaoEmployee.deleteEmployee(id);
                    break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
    }
}
