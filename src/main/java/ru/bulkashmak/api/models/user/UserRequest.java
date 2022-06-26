package ru.bulkashmak.api.models.user;

import lombok.*;

import java.math.BigDecimal;

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
}
