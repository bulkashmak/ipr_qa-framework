package ru.bulkashmak.api.models.user;

import lombok.*;

import java.math.BigDecimal;

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
}
