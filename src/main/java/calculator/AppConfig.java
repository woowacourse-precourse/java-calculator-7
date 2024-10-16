package calculator;

import binaryOperator.BinaryOperator;
import detector.CustomSeparatorDetector;
import detector.CustomSeparatorDetectorImpl;
import binaryOperator.PlusOperator;
import separator.Separator;
import separator.SeparatorImpl;
import separator.SeparatorParser;
import separator.SeparatorParserImpl;

public class AppConfig {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";

    private final Separator separator;
    private final CustomSeparatorDetector customSeparatorDetector;
    private final SeparatorParser separatorParser;
    private final BinaryOperator operator;

    public AppConfig() {
        separator = new SeparatorImpl();
        customSeparatorDetector = new CustomSeparatorDetectorImpl();
        separatorParser = new SeparatorParserImpl();
        operator = new PlusOperator();
    }

    public Separator separator() {
        return separator;
    }

    public CustomSeparatorDetector customSeparatorDetector() {
        return customSeparatorDetector;
    }

    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    public SeparatorParser separatorParser() {
        return separatorParser;
    }

    public BinaryOperator operator() {
        return operator;
    }
}
