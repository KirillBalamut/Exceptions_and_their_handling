package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();

        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();

        System.out.println("Введите отчество:");
        String middleName = scanner.nextLine();

        System.out.println("Введите дату рождения в формате dd.mm.yyyy:");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Введите пол (f - женский, m - мужской):");
        String gender = scanner.nextLine();

        try {
            validateData(dateOfBirth, phoneNumber, gender);

            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender);
            writer.newLine();
            writer.close();

            System.out.println("Данные успешно записаны в файл.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    private static void validateData(String dateOfBirth, String phoneNumber, String gender) {
        // Проверка формата даты рождения
        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        // Проверка формата номера телефона
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }

        // Проверка значения пола
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new IllegalArgumentException("Неверное значение пола");
        }
    }
}