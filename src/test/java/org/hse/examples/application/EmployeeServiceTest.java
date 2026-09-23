package org.hse.examples.application;

import org.hse.examples.domain.Employee;
import org.hse.examples.domain.EmployeeRepository;
import org.hse.examples.domain.PermanentAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock private EmployeeRepository repository;
    @Mock private OutputPort output;

    private EmployeeService service;

    @BeforeEach
    void setUp() {
        service = new EmployeeService(repository, output);
    }

    @Test
    @DisplayName("Найден сотрудник — печатается ответ")
    void shouldPrintAnswerWhenEmployeeFound() {
        Employee employee = new Employee(1, "Иванов И. Г.", 3, true, new PermanentAccess());
        when(repository.findById(1)).thenReturn(Optional.of(employee));

        service.processEmployee(1);

        verify(output).printAnswer(employee);
        verify(output, never()).printError(anyString());
    }

    @Test
    @DisplayName("Сотрудник не найден — печатается ошибка")
    void shouldPrintErrorWhenEmployeeNotFound() {
        when(repository.findById(999)).thenReturn(Optional.empty());

        service.processEmployee(999);

        verify(output).printError("Сотрудник не найден");
        verify(output, never()).printAnswer(any());
    }
}
