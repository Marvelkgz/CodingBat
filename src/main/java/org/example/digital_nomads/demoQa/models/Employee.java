package org.example.digital_nomads.demoQa.models;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.digital_nomads.demoQa.pages.BasePage;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Employee {
    String firstName;
    String lastName;
    int age;
    String email;
    int salary;
    String department;

}
