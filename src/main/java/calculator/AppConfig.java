package calculator;

import detector.CustomSeparatorDetector;
import detector.CustomSeparatorDetectorImpl;
import separator.Separator;
import separator.SeparatorImpl;

public class AppConfig {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";

    private static Separator separator;
    private static CustomSeparatorDetector customSeparatorDetector;

    public AppConfig() {
        separator = new SeparatorImpl();
        customSeparatorDetector = new CustomSeparatorDetectorImpl();
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
}
