import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString


public class Employee {
    private String firstName;
    private String lastName;
    private int age;

    private List<String>skills;

    public String showHelloAndFirstName(){
        return "Hello "+firstName;
    }

    public void showListSkills(){
        System.out.println(firstName+" "+skills);
    }
}
