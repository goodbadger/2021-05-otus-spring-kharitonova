package ru.otus.students.testing.dao;

import ru.otus.students.testing.domain.TestIssue;

import java.util.List;

public interface TestIssueDao {
    List<TestIssue> getAll();
}
