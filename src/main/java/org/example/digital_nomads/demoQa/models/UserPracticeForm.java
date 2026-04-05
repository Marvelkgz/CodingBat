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
public class UserPracticeForm {
     String firstName;
     String lastName;
     String email;
     String mobileNumber;
     String subject;
     String currentAddress;
}

