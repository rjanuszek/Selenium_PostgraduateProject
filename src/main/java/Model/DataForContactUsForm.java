package Model;

import lombok.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Data
public class DataForContactUsForm {

    public String subjectHeading;
    public String emailAddress;
    public String orderReference;
    public String textMessage;

    public static DataForContactUsForm getDefaultMessage() throws FileNotFoundException {
        DataForContactUsForm message = new DataForContactUsForm();
        File file = new File("DataForContactUsForm.txt");
        Scanner scanner = new Scanner(file);

        message.setSubjectHeading(scanner.nextLine());
        message.setEmailAddress(scanner.nextLine());
        message.setOrderReference(scanner.nextLine());
        message.setTextMessage(scanner.nextLine());

        return message;
    }
}