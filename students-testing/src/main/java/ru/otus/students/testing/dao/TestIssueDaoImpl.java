package ru.otus.students.testing.dao;

import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;
import net.sf.flatpack.Record;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.students.testing.domain.TestIssue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestIssueDaoImpl implements TestIssueDao {
    private final Resource resource;
    private final InputStream inputStream;
    private final Parser csvParser;

    public TestIssueDaoImpl(String resourcePath) throws IOException {
        this.resource = new ClassPathResource(resourcePath);
        this.inputStream = resource.getInputStream();
        csvParser = DefaultParserFactory.getInstance().newDelimitedParser(new InputStreamReader(inputStream), ';', '"');
    }

    private static TestIssue apply(Record row) {
        return new TestIssue(
                row.getInt("number"),
                row.getString("question"),
                Arrays.stream(row.getString("answers").split(";"))
                        .collect(Collectors.toList()),
                row.getString("right_answer")
        );
    }

    @Override
    public List<TestIssue> getAll() {
        return csvParser.parseAsStream().stream()
                .map(TestIssueDaoImpl::apply)
                .collect(Collectors.toList());
    }
}
