package calculator.domain.machine;

import java.util.Arrays;
import java.util.List;

public class LineSplitter {

    private static final String DEFAULT_DELIMITER = ",|:";

    private final DelimiterExtractor delimiterExtractor;

    public LineSplitter(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public List<Long> getOperands(String line) {

        if (delimiterExtractor.isCustomDelimiter(line)) {

            String customDelimiter = delimiterExtractor.getCustomDelimiter(line);
            String operandLine = delimiterExtractor.getOperandLine(line);

            return split(operandLine, customDelimiter);
        }

        return split(line);
    }

    private List<Long> split(String line) {
        return split(line, DEFAULT_DELIMITER);
    }

    private List<Long> split(String line, String delimiter) {
        String[] splitLine = line.split(delimiter);

        return Arrays.stream(splitLine).map(Long::parseLong).toList();
    }
}
