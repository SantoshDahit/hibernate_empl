package database;


import Employee.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    static Connection conn = null;
//    public static Connection connect() {
//    try {
//        String url = "jdbc:mysql://localhost:3308/employee";
//        String userName = "root";
//        String password = "1234";
//
//        conn = DriverManager.getConnection(url, userName, password);
//    } catch( Exception e) {
//        e.printStackTrace();
//        }
//        return conn;
//    }

        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {
                Configuration configuration = new Configuration();


                configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3308/employee");
                configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "1234");


                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");


                configuration.setProperty("hibernate.show_sql", "true");


                configuration.setProperty("hibernate.hbm2ddl.auto", "update");

                // Add annotated class
                configuration.addAnnotatedClass(Employee.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());

                return configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                throw new RuntimeException("Error building the SessionFactory: " + e.getMessage(), e);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }


