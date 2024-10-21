package calculator.domain.machine;

import calculator.ExceptionInfo;

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

    private List<Long> split(String operandLine) {
        return split(operandLine, DEFAULT_DELIMITER);
    }

    private List<Long> split(String operandLine, String delimiter) {
        try {
            isCollectDelimiterPosition(operandLine);

            String[] splitLine = operandLine.split(delimiter);
            isPositive(splitLine);

            return Arrays.stream(splitLine).map(Long::parseLong).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionInfo.EXCEPTION_MESSAGE);
        }
    }

    private void isPositive(String[] splitOperands) {
        Arrays.stream(splitOperands).forEach(e -> {
            long operand = Long.parseLong(e);
            if (operand < 0) {
                throw new IllegalArgumentException(ExceptionInfo.EXCEPTION_MESSAGE);
            }
        });
    }

    private void isCollectDelimiterPosition(String operandLine) {
        if (!Character.isDigit(operandLine.charAt(operandLine.length() - 1))) {
            throw new IllegalArgumentException(ExceptionInfo.EXCEPTION_MESSAGE);
        }
    }
}
