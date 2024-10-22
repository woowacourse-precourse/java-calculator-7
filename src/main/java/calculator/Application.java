package calculator;

import calculator.CustomExtractor.ExtractedCharAndString;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {

        String msg = ConsoleIO.getInput();

        List<Character> delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(':');

        CustomExtractor extractor = new CustomExtractor("//", "\\n");

        Optional<ExtractedCharAndString> result = extractor.extractCustomDelimiter(msg);
        if (result.isPresent()) {
            ExtractedCharAndString extractedCharAndString = result.get();
            delimiters.add(extractedCharAndString.customDelimiter());
            msg = extractedCharAndString.extracted();
        }

        Calculator calculator = new Calculator(delimiters, msg);
        ConsoleIO.putOutput(calculator.CalculateSum());
    }
}
