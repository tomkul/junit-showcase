package extensions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataSet {

    private final int valueA;
    private final int valueB;
    private final int expectedResult;

    public DataSet(int valueA, int valueB, int expectedResult) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expectedResult = expectedResult;
    }

    public int getValueA() {
        return valueA;
    }

    public int getValueB() {
        return valueB;
    }

    public int getExpectedResult() {
        return expectedResult;
    }

    public static Stream<DataSet> parseRuleFile(String filePath) {
        try {
            URL resource = DataSet.class.getClassLoader().getResource(filePath);
            return Files.lines(Paths.get(resource.toURI())).map(DataSet::parse);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static DataSet parse(String rule) {
        String[] operation = rule.split("\\|");
        String[] operands = operation[0].split(",");
        Integer operandA = Integer.valueOf(operands[0].trim());
        Integer operandB = Integer.valueOf(operands[1].trim());
        Integer expectedResult = Integer.valueOf(operation[1].trim());
        return new DataSet(operandA, operandB, expectedResult);
    }

}