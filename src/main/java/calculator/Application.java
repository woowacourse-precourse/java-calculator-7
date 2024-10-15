package calculator;

import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        Optional<String> customDelimiterOptional = customDelimiterExtractor.extractCustomDelimiterFrom("//1\n");
        System.out.println(customDelimiterOptional.orElse(null));
    }
}
