package org.hse.examples.infrastructure;

//Вывод ответа в консоль (не переделал)

import org.hse.examples.application.OutputPort;
import org.hse.examples.domain.Employee;
import org.hse.examples.domain.PermanentAccess;
import org.hse.examples.domain.TemporaryAccess;
import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputHandler implements OutputPort {

    @Override
    public void printAnswer(Employee employee) {
        System.out.println(employee.name() + " Уровень доступа: " + employee.accessLevel());

        if (employee.isActive()) {
            System.out.println("Доступ активен");

            String accessOut = switch (employee.accessType()) {
                case PermanentAccess ignored -> "Постоянный доступ";
                case TemporaryAccess ignored -> "Временный доступ";
            };
            System.out.println(accessOut);
        } else {
            System.out.println("Доступ аннулирован");
        }
    }
    @Override
    public void printError(String message) {
        System.err.println(message);
    }
}
