package ru.bulkashmak.api.models.user;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String firstName;
    private String secondName;
    private Integer age;
    private UserResponse.Sex sex;
    private BigDecimal money;

    @Getter
    enum Sex {
        MALE,
        FEMALE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequest that = (UserRequest) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(age, that.age) && sex == that.sex && money.compareTo(that.money)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, sex, money);
    }
}
