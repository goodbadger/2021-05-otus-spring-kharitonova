package ru.otus.students.testing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестовые задания")
public class TestIssueTest {

    @DisplayName("должны иметь корректный конструктор")
    @Test
    void shouldHaveCorrectConstructor() {
        TestIssue testIssue = new TestIssue(0,
                "To be or Not to be?",
                List.of("Yes", "No"),
                "Yes");

        assertEquals(testIssue.getNumber(), 0);
        assertEquals(testIssue.getQuestion(), "To be or Not to be?");
        assertEquals(testIssue.getAnswers(), List.of("Yes", "No"));
        assertEquals(testIssue.getRightAnswer(), "Yes");
    }
}
