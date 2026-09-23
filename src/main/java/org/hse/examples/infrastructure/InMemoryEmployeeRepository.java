package org.hse.examples.infrastructure;

import jakarta.annotation.PostConstruct;
import org.hse.examples.domain.Employee;
import org.hse.examples.domain.EmployeeRepository;
import org.hse.examples.domain.PermanentAccess;
import org.hse.examples.domain.TemporaryAccess;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
class InMemoryEmployeeRepository implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        employees.add(new Employee(1,  "Иванов И. Г.",  2, true,  new TemporaryAccess()));
        employees.add(new Employee(2,  "Петрова А. Е.", 4, true,  new PermanentAccess()));
        employees.add(new Employee(3,  "Сидоров С. В.", 5, true,  new PermanentAccess()));
        employees.add(new Employee(4,  "Козлова Е. В.", 3, true,  new PermanentAccess()));
        employees.add(new Employee(5,  "Морозов А. И.", 2, true,  new TemporaryAccess()));
        employees.add(new Employee(6,  "Смирнов Д. М.", 2, false, new PermanentAccess()));
        employees.add(new Employee(7,  "Волкова М. К.", 4, false, new PermanentAccess()));
        employees.add(new Employee(8,  "Зайцев П. Е.",  1, true,  new TemporaryAccess()));
        employees.add(new Employee(9,  "Соколова О. Д.", 4, true, new PermanentAccess()));
        employees.add(new Employee(10, "Новиков А. М.", 5, true,  new PermanentAccess()));
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employees.stream()
                .filter(emp -> emp.id() == id)
                .findFirst();
    }

    @Override
    public boolean add(Employee employee) {
        if (employee == null) {
            return false;
        }
        if (findById(employee.id()).isPresent()) {
            return false;
        }
        employees.add(employee);
        return true;
    }
}