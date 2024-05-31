package student;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static java.awt.SystemColor.text;

public class App {
    public static void main(String[] args) throws Exception {

        final String cwd = System.getProperty("user.dir");
        final String pathToInput = "\\data\\bill.txt";
        final String pathToOutput = "\\data\\bill-processed.txt";
        final double rate = 20.00;

        // CWD PWD
        //System.out.println(System.getProperty("user.dir"));//current directory cwd or pwd

        File fileInput = new File(cwd+ pathToInput);
        File fileOutput = new File(cwd+ pathToOutput);
        if (fileInput.exists()) {
            // READ from source file
            InputStream is = new FileInputStream(fileInput);
            byte[] content  = is.readAllBytes();
            String textContent = new String(content);
            System.out.println(textContent);



            // Text processing
             final String pattern = "(\\d+)(EURO)";
            Pattern pattern1 = Pattern.compile(pattern);
            Matcher matcher = pattern1.matcher(textContent);

            do {
                matcher = pattern1.matcher(textContent);
                if (!matcher.find()) {
                    break;
                }
                Double amount = Double.valueOf(matcher.group(1));
                String currency = matcher.group(2);
                Double amountMDL = amount * rate;
//                System.out.println(amount);
//                System.out.println(currency);

                String replacement = String.format("%.2fMDL", amountMDL);

                textContent = matcher.replaceFirst(replacement);
                System.out.println(textContent);
                System.out.println(amountMDL);
                System.out.println(currency);
                break;
            } while (true);
            //



            //Write into destination second file
            OutputStream os = new FileOutputStream(fileOutput);
            os.write(textContent.getBytes());

            is.close();
            os.close();

        } else {
            System.out.println("File not found");
        }

    }
}
