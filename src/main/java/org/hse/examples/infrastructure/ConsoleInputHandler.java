package org.hse.examples.infrastructure;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleInputHandler {
    private final Scanner scanner;

    public ConsoleInputHandler() {
        this(System.in);
    }

    public ConsoleInputHandler(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public Optional<Integer> readInputId() {
        while (true) {
            System.out.print("Введите ID сотрудника (или 0 для выхода): ");

            String inputId;
            try {
                inputId = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                return Optional.empty();
            }

            if (inputId.isEmpty() || inputId.equals("0")) {
                return Optional.empty();
            }

            try {
                int intId = Integer.parseInt(inputId);
                if (intId < 0) {
                    System.out.println("Отрицательный ID");
                    continue;
                }
                return Optional.of(intId);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }
}
