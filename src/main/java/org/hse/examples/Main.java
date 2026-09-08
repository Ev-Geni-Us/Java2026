package org.hse.examples;

//Усынин Е.В. задание 3                                                                                                         //Created By EvGeniUs
//Имитация электронного пропуска по ID

public class Main {

    //Конструкторы добавил что бы сделать тест с Mock
    private EmployeeRepo repo;
    private InputHandler input;
    private OutputHandler output;

    public  Main() {
        this.repo = new EmployeeRepo();
        this.input = new InputHandler();
        this.output = new OutputHandler();
    }

    public Main(EmployeeRepo repo, InputHandler input, OutputHandler output) {
        this.repo = repo;
        this.input = input;
        this.output = output;
    }

    public void run() {
        input.readInputId().ifPresentOrElse(
                id -> {
                    repo.findEmployeeById(id).ifPresentOrElse(
                            output::printAnswer,
                            () -> output.printError("Сотрудник не найден")
                    );
                },
                () -> System.out.println("Выход из программы")
        );
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
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
