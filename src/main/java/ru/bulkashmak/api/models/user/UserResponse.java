package ru.bulkashmak.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String firstName;
    private String secondName;
    private Integer age;
    private Sex sex;
    private Integer money;

    @Getter
    enum Sex {
        MALE,
        FEMALE
    }
}
