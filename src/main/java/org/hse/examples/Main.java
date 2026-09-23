package org.hse.examples;

//Усынин Е.В. задание 5                                                                                                         //Created By EvGeniUs
//Имитация электронного пропуска по ID

public class Main {

    private final AppContext context;

    public Main(AppContext context) {
        this.context = context;
    }

    public Main() {
        this(new AppContext());
    }

    public void run() {
        var id = context.input().readInputId();
        if (id.isEmpty()) {
            System.out.println("Выход из программы");
            return;
        }
        processEmployee(id.get());
    }

    private void processEmployee(int id) {
        context.repo().findEmployeeById(id).ifPresentOrElse(
                context.output()::printAnswer,
                () -> context.output().printError("Сотрудник не найден")
        );
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
