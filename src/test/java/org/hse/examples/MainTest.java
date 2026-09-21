
/*
-------------------------------------------------------------------
Не работает, возможно, конфликт версий, так и не разобрался
-------------------------------------------------------------------
*/

package org.hse.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class MainTest {

    private EmployeeRepo mockRepo;

    private InputHandler mockInput;

    private OutputHandler mockOutput;

    private Main main;
    private Employee testEmployee;

    @BeforeEach
    void setUp() {

        this.mockRepo = Mockito.mock(EmployeeRepo.class);
        this.mockInput = Mockito.mock(InputHandler.class);
        this.mockOutput = Mockito.mock(OutputHandler.class);

        testEmployee = new Employee(1, "Иванов И.Г.", 3, true, 1);
        main = new Main(mockRepo, mockInput, mockOutput);
    }

    @Test
    @DisplayName("Поиск существующего сотрудника")
    void shouldFindEmployeeSuccessfully() {

        when(mockInput.readInputId()).thenReturn(Optional.of(1));
        when(mockRepo.findEmployeeById(1)).thenReturn(Optional.of(testEmployee));
        main.run();
    }

    @Test
    @DisplayName("Поиск несуществующего сотрудника")
    void shouldHandleEmployeeNotFound() {

        when(mockInput.readInputId()).thenReturn(Optional.of(11));
        when(mockRepo.findEmployeeById(11)).thenReturn(Optional.empty());
        main.run();

        verify(mockInput).readInputId();
        verify(mockRepo).findEmployeeById(11);

    }
}
