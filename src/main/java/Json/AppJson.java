package Json;

import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

public class AppJson {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir"))+"\\data\\message.json");

        String textContent = new String(fis.readAllBytes());
        JSONObject obj = new JSONObject(textContent);
        System.out.println(obj.getString("body"));

        // 1) In contextul server - client , clientul citeste datele din Json formeaza unui obiect de tip message,
        // 1) le searileaza si transmite serverului
        // 2) Serverul receptionand mesajul il desareazlizasa salveaza in Json
        //2)  sa folosim diferite fisiere sa nu rescriem acelasi rezultate


    }
}
