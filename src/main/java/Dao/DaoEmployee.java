package Dao;

import Employee.Employee;
import database.DataBase;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DaoEmployee {

    public static void createEmployee(Employee employee) {
        try (Session session = DataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            System.out.println("Employee created successfully: " + employee);
        } catch (Exception e) {
            System.err.println("Error creating employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Employee> readAllEmployee() {
        List<Employee> empList = new ArrayList<>();
        try (Session session = DataBase.getSessionFactory().openSession()) {
            empList = session.createQuery("FROM Employee", Employee.class).list();
            System.out.println("Retrieved all employees from the database.");
        } catch (Exception e) {
            System.err.println("Error retrieving all employees: " + e.getMessage());
            e.printStackTrace();
        }
        return empList;
    }

    public static void updateEmployee(int id, String name) {
        try (Session session = DataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                employee.setName(name);
                session.update(employee);
                transaction.commit();
                System.out.println("Employee updated successfully: " + employee);
            }
        } catch (Exception e) {
            System.err.println("Error updating employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(int id) {
        try (Session session = DataBase.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
                System.out.println("Employee deleted successfully: " + employee);
            }
        } catch (Exception e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
