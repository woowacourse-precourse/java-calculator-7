package calculator;

import static exceptHandler.ExceptHandler.detectNegativeValueException;

import camp.nextstep.edu.missionutils.Console;
import inspector.ContentInspector;
import inspector.InspectorSelector;
import java.math.BigInteger;
import parser.ContentParser;

public class Calculator {
    private BigInteger result = BigInteger.ZERO; //결과를 저장할 변수
    private String originalContent; //처음 입력받은 문자열
    private String[] parsedContentGroup; //배열로 나뉘어진 문자열

    public void start() {
        inputContent();
        ContentInspector contentInspector = InspectorSelector.selection(originalContent); //문자열을 분석하는 메서드
        String separator = contentInspector.getSeparator(); //분석하는 메서드를 통해 구분자를 반환받는다.
        String convertedContent = contentInspector.getConvertedContent(); //검사가 완료된 문자열을 반환한다
        ContentParser contentParser = new ContentParser(separator); //문자열을 나누는 메서드
        parsedContentGroup = contentParser.parse(convertedContent); //파서 메서드로 나뉘어진 메서드
        calculation(); //계산
        printResult(); //결과를 출력하는 메서드
    }

    private void inputContent() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        originalContent = Console.readLine();
        detectContentEmpty();
    }

    //문자열이 비었는지 확인하는 메서드. 만약에 비었으면 이후의 과정을 진행하지 않고 결과를 반환하는 메서드 printResult로 이동한다.
    private void detectContentEmpty() {
        if (originalContent.isEmpty()) {
            printResult();
        }
    }

    //결과를 계산하는 메서드.
    private void calculation() {
        for (String content : parsedContentGroup) {
            BigInteger addendsBigInteger = convertStringToBigInteger(content);
            detectNegativeValueException(addendsBigInteger);
            result = result.add(addendsBigInteger);
        }
    }

    /**
     * 배열의 문자열을 BigInteger type으로 변환하는 메서드. 객체 content가 빈 문자열일 경우 0을 반환하고, 아니면 문자열의 수를 변환한다.
     *
     * @param content 배열 parsedContentGroup에 있는 원소 content
     * @return BigInteger
     */
    private BigInteger convertStringToBigInteger(String content) {
        if (content.isEmpty()) {
            return BigInteger.ZERO;
        } else {
            return new BigInteger(content);
        }
    }

    //결과를 출력하는 메서드
    private void printResult() {
        System.out.println("결과 : " + result);
    }
}
