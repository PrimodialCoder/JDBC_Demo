

import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "@TCO7b2dx";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query2 = "INSERT INTO students(name, age, marks) VALUES ('Ashu', 32, 90.5);";
            int result = statement.executeUpdate(query2);
            if(result > 0){
                System.out.println("Record inserted successfully");
            }else {
                System.out.println("Record not inserted");
            }
            String query = "SELECT * FROM students";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double marks = rs.getDouble("marks");
                System.out.println(id + ", " + name + ", " + age + ", " + marks);

            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}