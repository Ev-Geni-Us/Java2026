package org.hse.examples;

//Усынин Е.В. задание 5                                                                                                         //Created By EvGeniUs
//Имитация электронного пропуска по ID

public class Main {

    private final AppContext context;

    public  Main(AppContext context) {
        this.context = context;
    }

    public Main() {
        this(new AppContext());
    }

    public void run() {
        context.input().readInputId().ifPresentOrElse(
                id -> {
                    context.repo().findEmployeeById(id).ifPresentOrElse(
                            context.output()::printAnswer,
                            () -> context.output().printError("Сотрудник не найден")
                    );
                },
                () -> System.out.println("Выход из программы")
        );
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
