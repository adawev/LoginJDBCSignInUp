package diyor.adashev;

import java.sql.*;
import java.util.Scanner;

public class MyDatabase {
    Scanner scannerString = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);

    String url = "jdbc:postgresql://localhost:5432/sinf11a24";
    String username = "postgres";
    String password1 = "root";

    public void createUser(Users users){
        try {
            Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();
            String query = "insert into users(id, name, surname, email, password) values ("+users.getId()+",'"+users.getName()+"','"+users.getSurname()+"','"+users.getEmail()+"','"+users.getPassword()+"')";

            statement.execute(query);
            System.out.println("User created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void checkUser(String email, String password){
        try {
            Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();
            String query = "select * from users where email='"+email+"' and password='"+password+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                System.out.println("User found");
                Main main = new Main();
                main.singUpMenu();
            }else{
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createBook(Book book){
        try {
            Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();

            String query = "insert into book(id, name, description, price) values("+book.getId()+",'"+book.getName()+"','"+book.getDescription()+"','"+book.getPrice()+"')";
            statement.execute(query);
            System.out.println("Book created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void readBook(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();
            String query = "select * from book";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String price = resultSet.getString(4);

                Book book = new Book(anInt, name, description, price);
                System.out.println(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void readUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();
            String query = "select * from users";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String email = resultSet.getString(4);
                String password = resultSet.getString(5);

                Users users = new Users(anInt, name, surname, email, password);
                System.out.println(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
