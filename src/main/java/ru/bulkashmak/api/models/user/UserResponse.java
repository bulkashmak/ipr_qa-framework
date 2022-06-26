package ru.bulkashmak.api.models.user;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String firstName;
    private String secondName;
    private Integer age;
    private Sex sex;
    private BigDecimal money;

    @Getter
    public enum Sex {
        MALE,
        FEMALE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse response = (UserResponse) o;
        return id.equals(response.id) && Objects.equals(firstName, response.firstName) && Objects.equals(secondName, response.secondName) && Objects.equals(age, response.age) && sex == response.sex && money.compareTo(response.money)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, age, sex, money);
    }
}
