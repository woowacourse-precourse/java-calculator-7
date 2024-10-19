package calculator;

import camp.nextstep.edu.missionutils.Console;
import inspector.ContentInspector;
import inspector.InspectorSelector;
import java.math.BigInteger;
import parser.ContentParser;

public class Calculator {
    private BigInteger Result = BigInteger.ZERO;
    private String originalContent;
    private String convertedContent;
    private String separator;
    private String[] parsedContent;

    public void start() {
        inputContent();
        ContentInspector contentInspector = InspectorSelector.selection(originalContent);
        separator = contentInspector.getSeparator();
        convertedContent = contentInspector.getConvertedContent();
        ContentParser contentParser = new ContentParser(separator);
        parsedContent = contentParser.parsing(convertedContent);
        calculation();
        printResult();
    }

    private void inputContent() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        originalContent = Console.readLine();
        if (originalContent.isEmpty()) {
            printResult();
        }
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
        if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("음수가 입력되었음");
        }
    }

    private void printResult() {
        System.out.println("결과 : " + Result);
    }
}
