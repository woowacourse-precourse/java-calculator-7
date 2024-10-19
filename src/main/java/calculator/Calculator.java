package calculator;

import camp.nextstep.edu.missionutils.Console;
import inspector.ContentInspector;
import inspector.InspectorSelector;
import java.math.BigInteger;
import parser.ContentParser;

public class Calculator {
    private BigInteger Result = BigInteger.ZERO;
    private String inputContent;
    private String convertedContent;
    private String parsingSeparator;
    private String[] parsedContent;

    public void start() {
        setInputContent();
        ContentInspector contentInspector = InspectorSelector.selection(inputContent);
        parsingSeparator = contentInspector.getParsingSeparator();
        convertedContent = contentInspector.getConvertedContent();
        ContentParser contentParser = new ContentParser(parsingSeparator, convertedContent);
        parsedContent = contentParser.getParsedContent();
        calculation();
        getResult();
    }

    private void calculation() {
        for (String content : parsedContent) {
            BigInteger addedBigInteger = convertStringToBigInteger(content);
            detectNegativeValueException(addedBigInteger);
            Result = Result.add(addedBigInteger);
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
            throw new IllegalArgumentException("음수가 입력되었음");
        }
    }


    private void setInputContent() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputContent = Console.readLine();
        if (inputContent.isEmpty()) {
            getResult();
        }
    }

    private void getResult() {
        System.out.println("결과 : " + Result);
    }
}
