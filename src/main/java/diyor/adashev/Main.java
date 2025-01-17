package diyor.adashev;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scannerString = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    1.SingIn
                    2.SignUp
                    """);
            int tanlash = scannerInt.nextInt();
            switch (tanlash) {
                case 1 -> {
                    System.out.println("Enter your email:");
                    String email = scannerString.nextLine();

                    System.out.println("Enter your password:");
                    String password = scannerString.nextLine();
                    MyDatabase myDatabase = new MyDatabase();
                    myDatabase.checkUser(email, password);
                }
                case 2 -> {
                    System.out.println("Enter your id:");
                    int id = scannerInt.nextInt();
                    System.out.println("Enter your name:");
                    String name = scannerString.nextLine();
                    System.out.println("Enter your surname:");
                    String surname = scannerString.nextLine();
                    System.out.println("Enter your email:");
                    String email = scannerString.nextLine();
                    System.out.println("Enter your password:");
                    String password = scannerString.nextLine();

                    Users users = new Users(id, name, surname, email, password);
                    MyDatabase myDatabase = new MyDatabase();
                    myDatabase.createUser(users);


                }
            }
        }


    }
    public void singUpMenu(){
        System.out.println("""
                1.Book
                2.AllUsers
                3.Exit
                """);
        int tanl = scannerInt.nextInt();

        switch (tanl){
            case 1->{
                System.out.println("""
                        1.Create
                        2.Read
                        3.Update
                        4.Delete
                        """);
                int tanlash = scannerInt.nextInt();
                switch (tanlash){
                    case 1->{
                        System.out.println("Enter id:");
                        int id = scannerInt.nextInt();
                        System.out.println("Enter name:");
                        String name = scannerString.nextLine();
                        System.out.println("Enter description:");
                        String description = scannerString.nextLine();
                        System.out.println("Enter price:");
                        String price = scannerString.nextLine();

                        Book book = new Book(id, name, description, price);
                        MyDatabase myDatabase = new MyDatabase();
                        myDatabase.createBook(book);

                    }
                    case 2->{

                        MyDatabase myDatabase = new MyDatabase();
                        myDatabase.readBook();
                    }
                }
            }
            case 2->{
                MyDatabase myDatabase = new MyDatabase();
                myDatabase.readUser();
            }
        }

    }
}