package org.hse.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Список сотрудников
public class EmployeeRepo {

    private final List<Employee> employees;

    public EmployeeRepo() {
        this.employees = new ArrayList<>();
        initializeEmployees();
    }
    // Выделил инициализацию списка
    private void initializeEmployees() {
        employees.add(new Employee(1, "Иванов И. Г.", 2, true, 2));
        employees.add(new Employee(2, "Петрова А. Е.", 4, true, 1));
        employees.add(new Employee(3, "Сидоров С. В.", 5, true, 1));
        employees.add(new Employee(4, "Козлова Е. В.", 3, true, 1));
        employees.add(new Employee(5, "Морозов А. И.", 2, true, 2));
        employees.add(new Employee(6, "Смирнов Д. М.", 2, false, 1));
        employees.add(new Employee(7, "Волкова М. К.", 4, false, 1));
        employees.add(new Employee(8, "Зайцев П. Е.", 1, true, 2));
        employees.add(new Employee(9, "Соколова О. Д.", 4, true, 1));
        employees.add(new Employee(10, "Новиков А. М.", 5, true, 1));
    }
    //добавил Optional
    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.id() == id)
                .findFirst();
        //.orElse(null);
    }

    //Добавление нового сотрудника для теста
    public boolean addEmployee(Employee employee) {
        // Проверка на null
        if (employee == null) {
            return false;
        }

        if (findEmployeeById(employee.id()).isPresent()) {
            return false;
        }

        employees.add(employee);
        return true;
    }
}