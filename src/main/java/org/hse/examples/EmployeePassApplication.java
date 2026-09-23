package org.hse.examples;

import org.hse.examples.application.EmployeeService;
import org.hse.examples.infrastructure.ConsoleInputHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePassApplication implements CommandLineRunner {

    private final ConsoleInputHandler input;
    private final EmployeeService employeeService;

    public EmployeePassApplication(ConsoleInputHandler input, EmployeeService employeeService) {
        this.input = input;
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeePassApplication.class, args);
    }

    @Override
    public void run(String... args) {
        input.readInputId().ifPresentOrElse(
                employeeService::processEmployee,
                () -> System.out.println("Выход из программы")
        );
    }
}