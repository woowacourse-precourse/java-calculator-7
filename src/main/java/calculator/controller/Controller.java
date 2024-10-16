package calculator.controller;

import calculator.domain.DelimiterSet;
import calculator.domain.OriginalString;
import calculator.io.InputManager;
import calculator.service.DelimiterExtractor;

public class Controller {

    private final DelimiterExtractor delimiterExtractor;

    public Controller(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public void run() {
        OriginalString originalString = InputManager.readInput();
        DelimiterSet delimiterSet = delimiterExtractor.extractDelimiter(originalString.value());

    }

}
