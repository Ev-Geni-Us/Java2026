package org.hse.examples.infrastructure;

import org.hse.examples.domain.Employee;
import org.hse.examples.domain.TemporaryAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InMemoryEmployeeRepositoryTest {

    private InMemoryEmployeeRepository repo;

    @BeforeEach
    void setUp() {
        repo = new InMemoryEmployeeRepository();
        repo.initialize();
    }

    @Test
    @DisplayName("Поиск по существующему ID")
    void shouldFindEmployeeById() {

        assertThat(repo.findById(10))
                .isPresent()
                .hasValueSatisfying(emp -> {
                    assertThat(emp.id()).isEqualTo(10);
                    assertThat(emp.name()).isEqualTo("Новиков А. М.");
                });
    }

    @Test
    @DisplayName("Поиск по несуществующему ID")
    void shouldNotFindEmployeeByInvalidId() {

        assertThat(repo.findById(-1)).isEmpty();
        assertThat(repo.findById(999_999)).isEmpty();
    }

    @Test
    @DisplayName("Попытка добавить сотрудника с дубликатом ID")
    void shouldNotAddDuplicateEmployee() {

        Employee duplicate = new Employee(1, "Усынин Е. В.", 5, true, new TemporaryAccess());
        assertThat(repo.add(duplicate)).isFalse();
    }

    @Test
    @DisplayName("Успешное добавление нового сотрудника")
    void shouldAddNewEmployee() {
        Employee newEmployee = new Employee(11, "Усынин Е. В.", 5, true, new TemporaryAccess());

        boolean added = repo.add(newEmployee);

        assertThat(added).isTrue();
        assertThat(repo.findById(11)).contains(newEmployee);
    }

}
