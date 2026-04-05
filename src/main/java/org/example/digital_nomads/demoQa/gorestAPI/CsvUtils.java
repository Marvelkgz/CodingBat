package org.example.digital_nomads.demoQa.gorestAPI;




import org.example.digital_nomads.demoQa.gorestAPI.models.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvUtils {

    private static final String DEFAULT_PATH = "src/test/resources/users.csv";
    private static final String HEADERS = "id,name,email,gender,status";

    public static void writeUsers(List<User> users) {
        writeUsers(users, DEFAULT_PATH);
    }

    public static void writeUsers(List<User> users, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(HEADERS);
            for (User user : users) {
                writer.println(formatUser(user));
            }
            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write CSV file: " + filePath, e);
        }
    }

    public static void appendUser(User user) {
        appendUser(user, DEFAULT_PATH);
    }

    public static void appendUser(User user, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(formatUser(user));
        } catch (IOException e) {
            throw new RuntimeException("Failed to append user to CSV file: " + filePath, e);
        }
    }

    private static String formatUser(User user) {
        return String.format("%s,%s,%s,%s,%s",
                nullSafe(user.getId()),
                nullSafe(user.getName()),
                nullSafe(user.getEmail()),
                nullSafe(user.getGender()),
                nullSafe(user.getStatus()));
    }

    private static String nullSafe(Object value) {
        return value != null ? value.toString() : "";
    }
}
