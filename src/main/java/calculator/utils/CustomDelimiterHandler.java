package calculator.utils;

import calculator.CustomDelimiterDefinitionRemover;
import calculator.CustomDelimiterExtractor;
import calculator.CustomDelimiterPresenceChecker;

public class CustomDelimiterHandler {

    private final CustomDelimiterPresenceChecker verifier = new CustomDelimiterPresenceChecker();
    private final CustomDelimiterDefinitionRemover remover = new CustomDelimiterDefinitionRemover();
    private final CustomDelimiterExtractor extractor = new CustomDelimiterExtractor();

    public boolean isCustomDelimiterExists(String inputNumber) {
        return verifier.existsCustomDelimiter(inputNumber);
    }

    public int getCustomDelimiterPosition(String inputNumber) {
        return verifier.getCustomDelimiterPos(inputNumber);
    }

    public String eraseCustomDelimiterDefinition(String inputNUmber) {
        return remover.eraseCustomDelimiterDefinition(inputNUmber);
    }

    public char extractCustomDelimiter(String inputNumber, int customDelimiterPos) {
        return extractor.extractCustomDelimiter(inputNumber, customDelimiterPos);
    }


}
