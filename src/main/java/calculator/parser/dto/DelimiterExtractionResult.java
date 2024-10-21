package calculator.parser.dto;

import java.util.ArrayList;
import java.util.List;

public class DelimiterExtractionResult {
    public String input;
    public List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public DelimiterExtractionResult(String input, List<String> delimiters) {
        this.input = input;
        this.delimiters.addAll(delimiters);
    }
}
