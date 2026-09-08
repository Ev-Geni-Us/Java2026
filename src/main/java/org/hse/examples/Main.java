package org.hse.examples;

//Усынин Е.В. задание 3                                                                                                         //Created By EvGeniUs
//Имитация электронного пропуска по ID


public class Main {
    public static void main(String[] args) {
        EmployeeRepo repo = new EmployeeRepo();
        InputHandler input = new InputHandler();
        OutputHandler output = new OutputHandler();

        // ввод
        input.readInputId().ifPresentOrElse(
                id -> {
                    repo.findEmployeeById(id).ifPresentOrElse(
                            output::printAnswer,
                            () -> System.out.println("Сотрудник не найден")
                    );
                },
                () -> System.out.println("Выход")
        );
        input.scannerClose();
    }
}

/*
        int intId = inputHandler.readInputId();
        inputHandler.scannerClose();

        // поиск сотрудника
        Employee employee = employeeRepo.findEmployeeById(intId);

        //вывод
        outputHandler.printAnswer(employee);

 */
