package student.examples;


import student.examples.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);





//        Wrapper <Integer> wi = new Wrapper<>(1000);
//        Wrapper <String> ws = new Wrapper<>("abc");
//        System.out.println(ws.getValue().toUpperCase());
//        System.out.println(wi.getValue());


        // CRUD - CREATE / READ / UPDATE/ DELETE    BREAD - BROWS /READ / EDIT / ADD / DELETE
        //Generics
        //    v
        List<Object> users = new ArrayList<>(); //SO[L]I[D]


        while (users.size() != 5) {
            users.add(new User(String.format("User %d" , users.size()+1)));

            }
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        ((User)users.get(index)).setUsarname(username);

//        for (int i = 0; i < users.size() ; i++) {
//            System.out.println(users.get(i));
//
//
//        }
//        for (User user : users) {
//            System.out.println(user);
//        }
        ((User)users.get(2)).setUsarname("User 3 new");
        users.forEach(System.out::println);

    }
}

//        users.add(new User("User 1"));
//        users.add(new User("User 2"));
//        users.add(new User("User 3"));
//        System.out.println("Users:" + users.size());

