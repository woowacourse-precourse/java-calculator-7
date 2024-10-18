package calculator;

import camp.nextstep.edu.missionutils.Console;
import inspector.ContentInspector;
import inspector.InspectorSelector;
import java.math.BigInteger;
import parser.ContentParser;

public class MainCalculator {
    private BigInteger calculationResult = BigInteger.ZERO;
    private String inputContent;
    private String convertedContent;
    private String parsingSeparator;
    private String[] parsedContent;

    public void startCalculator() {
        setInputContent();
        ContentInspector contentInspector = InspectorSelector.selection(inputContent);
        parsingSeparator = contentInspector.getParsingSeparator();
        convertedContent = contentInspector.getConvertedContent();
        ContentParser contentParser = new ContentParser(parsingSeparator, convertedContent);
        parsedContent = contentParser.getParsedContent();
        calculation();
        getCalculateResult();
    }

    private void setInputContent() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputContent = Console.readLine();
        if (inputContent.isEmpty()) {
            getCalculateResult();
        }
    }

    private void getCalculateResult() {
        System.out.println("결과 : " + calculationResult);
    }

    private void calculation() {
        for (String content : parsedContent) {
            BigInteger addedBigInteger = convertStringToBigInteger(content);
            detectNegativeValueException(addedBigInteger);
            calculationResult = calculationResult.add(addedBigInteger);
        }
    }

    private BigInteger convertStringToBigInteger(String content) {
        if (content.isEmpty()) {
            return BigInteger.ZERO;
        } else {
            return new BigInteger(content);
        }
    }

    private void detectNegativeValueException(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
    }
}
