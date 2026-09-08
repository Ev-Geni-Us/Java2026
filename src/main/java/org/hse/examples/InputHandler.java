package org.hse.examples;

//Ввод ID и валидация

import java.util.Optional;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public Optional<Integer> readInputId(){
        // Цикл для повтора
        while (true) {
            System.out.print("Введите ID сотрудника (или 0 для выхода): ");
            String inputId = scanner.nextLine().trim();
            if (inputId.equals("0")){
                return Optional.empty();
            }

            // тут можно добавлять проверки ввода
            try {
                int intId = Integer.parseInt(inputId);
                return Optional.of(intId);
            }
            catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public void scannerClose() {
        scanner.close();
    }
}
