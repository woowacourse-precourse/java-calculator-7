package calculator.controller;

import calculator.domain.DelimiterSet;
import calculator.domain.OriginalString;
import calculator.io.InputManager;
import calculator.service.DelimiterExtractor;
import java.util.List;

public class Controller {

    private final DelimiterExtractor delimiterExtractor;

    public Controller(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public void run() {
        OriginalString originalString = InputManager.readInput();

        DelimiterSet delimiterSet = new DelimiterSet();
        List<String> delimiters = delimiterExtractor.extractDelimiter(originalString.value());
        delimiterSet.addAll(delimiters);
    }

}
