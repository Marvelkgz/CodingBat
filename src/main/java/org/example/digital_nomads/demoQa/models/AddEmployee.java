package org.example.digital_nomads.demoQa.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddEmployee {
    String firstName;
    String lastName;
    String email;
    int age;
    int salary;
    String department;
}
