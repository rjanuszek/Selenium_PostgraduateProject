package Model;

import lombok.Data;

@Data
public class DataForLogin {

    public String firstName;
    public String lastName;
    public String password;
    public String dayOfBirth;
    public String monthOfBirth;
    public String yearOfBirth;
}