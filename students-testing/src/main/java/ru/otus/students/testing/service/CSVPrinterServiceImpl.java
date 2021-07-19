package ru.otus.students.testing.service;

import ru.otus.students.testing.dao.TestIssueDao;
import ru.otus.students.testing.domain.TestIssue;

import java.util.List;

public class CSVPrinterServiceImpl implements PrintService {
    private final TestIssueDao testIssueDao;

    public CSVPrinterServiceImpl(TestIssueDao testIssueDao) {
        this.testIssueDao = testIssueDao;
    }

    @Override
    public void print() {
        List<TestIssue> testIssues = testIssueDao.getAll();
        testIssues.forEach(testIssue -> {
            System.out.println();
            System.out.print("Question № ");
            System.out.println(testIssue.getNumber());
            System.out.println(testIssue.getQuestion());
            System.out.println("Answer options:");
            testIssue.getAnswers().forEach(System.out::println);
        });
    }
}
