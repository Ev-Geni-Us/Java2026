package org.hse.examples;

//Вывод ответа в консоль (не переделал)

public class OutputHandler {

    public void printAnswer(Employee employee){
        if (employee == null) {

            // отсутствие = ошибка
            printError("Сотрудник не найден");
            return;
        }
        else {
            System.out.println(employee.name() + " Уровень доступа: " + employee.accessLevel());
            if (employee.isActive()) {
                System.out.println("Доступ активен");

                //тип доступа через кейс
                AccessType accessType = employee.getAccessType();
                String accessOut = switch (accessType) {
                    case PermanentAccess p -> "Постоянный доступ";
                    case TemporaryAccess t -> "Временный доступ";
                };
                System.out.println(accessOut);
                //System.out.println("Выход");
            }
            else {
                System.out.println("Доступ аннулирован");
            }
        }
    }
    //для тестов
    public void printError(String message) {
        System.err.println(message);
    }
}
