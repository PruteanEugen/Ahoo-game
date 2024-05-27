package student.examples;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Wrapper <Integer> wi = new Wrapper<>(1000);
        Wrapper <String> ws = new Wrapper<>("abc");
        System.out.println(ws.getValue().toUpperCase());



        System.out.println(wi.getValue());
    }
}
