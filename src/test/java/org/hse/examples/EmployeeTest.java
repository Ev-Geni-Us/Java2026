package org.hse.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
