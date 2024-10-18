package calculator;

import camp.nextstep.edu.missionutils.Console;
import inspector.ContentInspector;
import inspector.InspectorSelector;
import java.math.BigInteger;
import parser.ContentParser;

public class CalculatorMain {
    private BigInteger calculateResult = BigInteger.ZERO;
    private String inputContent;
    private String convertedContent;
    private String parsingDelimiter;
    private String[] parsedContent;

    public void startCalculator() {
        setInputContent();
        ContentInspector contentInspector = InspectorSelector.selection(inputContent);
        parsingDelimiter = contentInspector.getParsingDelimiter();
        convertedContent = contentInspector.getContent();
        ContentParser contentParser = new ContentParser(parsingDelimiter, convertedContent);
        parsedContent = contentParser.getParsedContent();
        calculation();
        getCalculateResult();
    }

    private void setInputContent() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputContent = Console.readLine();
        if (inputContent.isBlank()) {
            getCalculateResult();
        }
    }

    private void getCalculateResult() {
        System.out.println("결과 : " + calculateResult);
    }

    private void calculation() {
        for (String content : parsedContent) {
            BigInteger addedBigInteger = convertToBigInteger(content);
            makeNegativeException(addedBigInteger);
            calculateResult = calculateResult.add(addedBigInteger);
        }
    }

    private BigInteger convertToBigInteger(String content) {
        if (content.isEmpty()) {
            return BigInteger.ZERO;
        } else {
            return new BigInteger(content);
        }
    }

    private void makeNegativeException(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
    }
}
