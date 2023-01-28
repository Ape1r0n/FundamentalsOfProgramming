import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    String name;
    Integer age;
    Gender gender;
    Country country;

    public Boolean isAdult() {
        return age >= 18;
    }
}