package org.hse.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Optional;

class EmployeeRepoTest {

    private EmployeeRepo repo;
    private Employee testEmployee;

    @BeforeEach
    void setUp() {
        repo = new EmployeeRepo();
    }

    @Test
    @DisplayName("Поиск по существующему ID")
    void shouldFindEmployeeById() {

        Optional<Employee> employee = repo.findEmployeeById(10);
        assertThat(employee).isPresent();
        assertThat(employee.get().id()).isEqualTo(10);
        assertThat(employee.get().name()).isEqualTo("Новиков А. М.");
    }

    @Test
    @DisplayName("Поиск по несуществующему ID")
    void shouldNotFindEmployeeByInvalidId() {

        Optional<Employee> employee = repo.findEmployeeById(11);
        assertThat(employee).isEmpty();
    }

    @Test
    @DisplayName("Попытка добавить сотрудника с существующим ID")
    void shouldNotAddDuplicateEmployee() {

        Employee duplicateEmployee = new Employee(1, "Усынин Е. В.", 5, true, 2);
        boolean added = repo.addEmployee(duplicateEmployee);

        assertThat(added).isFalse();
    }

}
