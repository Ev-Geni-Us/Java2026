package org.hse.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

    @ExtendWith(MockitoExtension.class)
    class AppContextTest {

        @Mock private EmployeeRepo mockRepo;
        @Mock private InputHandler mockInput;
        @Mock private OutputHandler mockOutput;

        @Test
        @DisplayName("Создание зависимостей")
        void shouldCreateDefaultDependencies() {
            AppContext context = new AppContext();

            assertThat(context.repo()).isNotNull();
            assertThat(context.input()).isNotNull();
            assertThat(context.output()).isNotNull();
        }

        @Test
        @DisplayName("Возврат переданных зависимостей")
        void shouldReturnInjectedDependencies() {
            AppContext context = new AppContext(mockRepo, mockInput, mockOutput);

            assertThat(context.repo()).isSameAs(mockRepo);
            assertThat(context.input()).isSameAs(mockInput);
            assertThat(context.output()).isSameAs(mockOutput);
        }
    }
