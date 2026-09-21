package org.hse.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -10})
    @DisplayName("Создание сотрудника с отрицательным ID")
    void shouldThrowExceptionForNegativeIds(int negativeId) {
        assertThatThrownBy(() ->
                new Employee(negativeId, "Усынин Е. В.", 1, true, 1)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Отрицательный ID");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t"})
    @DisplayName("Создание сотрудника с пустым именем")
    void shouldThrowExceptionForEmptyName(String emptyName) {
        assertThatThrownBy(() ->
                new Employee(1, emptyName, 1, true, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пустое поле имени");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    @DisplayName("Создание сотрудника с недопустимым граничным уровнем доступа")
    void shouldThrowExceptionForInvalidAccessLevel(int badLevel) {
        assertThatThrownBy(() ->
                new Employee(1, "Усынин Е. В.", badLevel, true, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Не допустимый уровень доступа");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("Создание сотрудника с допустимым граничным уровнем доступа")
    void shouldCreateEmployeeWithValidAccessLevel(int validLevel) {
        Employee employee = new Employee(1, "Усынин Е. В.", validLevel, true, 1);

        assertThat(employee.accessLevel()).isEqualTo(validLevel);
    }
}
