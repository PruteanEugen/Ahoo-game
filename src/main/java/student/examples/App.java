package student.examples;


import com.github.javafaker.Faker;
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
    public static void main( String[] args ) {
        //1. Folosind Faker de umplut o lista cu 10 utilizatori
        //2. De copiat toti utilizatori care se incep cu litera A si de afisat ambele.

        Faker faker = new Faker();
        List<User> users = new ArrayList<User>();
        List<User> usersWithA = new ArrayList<User>();


            while (users.size() < 10) {
                users.add(new User (faker.name().username()));
            }

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUsarname().startsWith("a")) {
                        usersWithA.add(users.get(i));
                    }
            }
        System.out.println("Original Users List:");
        users.forEach(System.out::println);

        // Display filtered list
        System.out.println("\nUsers Whose Names Start with 'A':");
        usersWithA.forEach(System.out::println);

        }
}





