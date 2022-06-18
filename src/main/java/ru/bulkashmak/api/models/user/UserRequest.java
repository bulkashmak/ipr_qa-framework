package ru.bulkashmak.api.models.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String firstName;
    private String secondName;
    private Integer age;
    private UserResponse.Sex sex;
    private Double money;

    @Getter
    enum Sex {
        MALE,
        FEMALE
    }
}
