package ru.otus.students.testing.domain;

import java.util.List;

public class TestIssue {
    private final int number;
    private final String question;
    private final List<String> answers;
    private final String rightAnswer;

    public TestIssue(int number, String question, List<String> answers, String rightAnswer) {
        this.number = number;
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public int getNumber() {
        return number;
    }
}
