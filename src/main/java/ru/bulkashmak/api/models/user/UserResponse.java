package ru.bulkashmak.api.models.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String firstName;
    private String secondName;
    private Integer age;
    private Sex sex;
    private Double money;

    @Getter
    public enum Sex {
        MALE,
        FEMALE
    }
}
