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
      //  Scanner scanner = new Scanner(System.in);





//        Wrapper <Integer> wi = new Wrapper<>(1000);
//        Wrapper <String> ws = new Wrapper<>("abc");
//        System.out.println(ws.getValue().toUpperCase());
//        System.out.println(wi.getValue());


        // CRUD - CREATE / READ / UPDATE/ DELETE    BREAD - BROWS /READ / EDIT / ADD / DELETE
        //Generics
        //    v
        List<User> users = new ArrayList<>(); //SO[L]I[D]

        while (users.size() != 5) {
            users.add(new User(String.format("User %d" , users.size()+1)));

            }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsarname().equals("User 3")) {
                users.remove(i);
            }
        }
        //users.remove(new User("User 1"));


        users.forEach(System.out::println);

    }
}



