package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class commonUtils {

    public static String emailGeneration() {
        String emailID = "Naveensean" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")) + "@email.com";
        return emailID;
    }

    public static Properties userdata() {
        Properties prop = new Properties();
        String fileName = System.getProperty("user.dir") + "//src//test//resources//resource.properties";
        try {
            FileReader fileReader = new FileReader(fileName);
            prop.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;

    }
}
