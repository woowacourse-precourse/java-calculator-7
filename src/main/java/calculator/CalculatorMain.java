package calculator;

import camp.nextstep.edu.missionutils.Console;
import inspector.ContentInspector;
import inspector.InspectorSelector;
import java.math.BigInteger;
import parser.ContentParser;

public class CalculatorMain {
    private BigInteger calculateResult = BigInteger.ZERO;
    private String inputContent;
    private String[] parsedContent;

    public void startCalculator() {
        setInputContent();
        ContentInspector contentInspector = InspectorSelector.selection(inputContent);
        String parsingDelimiter = contentInspector.getDelimiterGroup();
        String convertedContent = contentInspector.getContent();
        ContentParser contentParser = new ContentParser(parsingDelimiter, convertedContent);
        parsedContent = contentParser.getParsedContent();
        Calculation();
        getCalculateResult();
    }

    private void setInputContent() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputContent = Console.readLine();
    }

    private void getCalculateResult() {
        System.out.println("결과 : " + calculateResult);
    }

    private void Calculation() {
        for (String content : parsedContent) {
            BigInteger contentNumber = new BigInteger(content);
            if (contentNumber.compareTo(BigInteger.ZERO) == -1) {
                throw new IllegalArgumentException();
            }
            calculateResult = calculateResult.add(new BigInteger(content));
        }
    }
}
