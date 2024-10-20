package calculator.service;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class CalculatorService {

    //TODO: 입력에 대한 문자열 처리, 계산 등을 진행하는 클래스

    private final String SPECIAL_PREFIX = "//";
    private final String SPECIAL_SUFFIX = "\\n";
    private final String SEPARATOR_COMMA = ",";
    private final String SEPARATOR_COLON = ":";

    public ArrayDeque<String> detectSeparator(String input) {

        ArrayDeque<String> separatorStack = new ArrayDeque<>();

        if (input.contains(SEPARATOR_COLON)) {
            separatorStack.addLast(SEPARATOR_COLON);
        }

        if (input.contains(SEPARATOR_COMMA)) {
            separatorStack.addLast(SEPARATOR_COMMA);
        }

        if (input.contains(SPECIAL_PREFIX) && input.contains(SPECIAL_SUFFIX)) {
            String specialSub = getSpecialSubstr(input);
            separatorStack.addLast(findSpecialSepBySubStr(specialSub));
        }

        System.out.println("separatorStack = " + separatorStack.toString());

        return separatorStack;
    }


    private String getSpecialSubstr(String input) {

        int prefixLen = SPECIAL_PREFIX.length();
        int suffixLen = SPECIAL_SUFFIX.length();
        String prefixSub = input.substring(0, prefixLen);
        String suffixSub = input.substring(prefixLen+1, prefixLen + suffixLen + 1);

        if(!prefixSub.equals(SPECIAL_PREFIX) || !suffixSub.equals(SPECIAL_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 설정 형식이 잘못되었습니다");
        }

        return input.substring(0, prefixLen + suffixLen + 1);
    }

    private String findSpecialSepBySubStr(String specialSubstr) {

        String specialSep = String.valueOf(specialSubstr.charAt(SPECIAL_PREFIX.length()));

        if (specialSep.equals(SEPARATOR_COLON) || specialSep.equals(SEPARATOR_COMMA)) {
            throw new IllegalArgumentException("일반 구분자 (쉼표,콜론) 는 특수 구분자로 사용할 수 없습니다.");
        }

        return specialSep;
    }

    public BigInteger calcInput(String input) {

        BigInteger result = BigInteger.ZERO;

        result = result.add(parseBigInteger(input));

        return result;
    }

    private BigInteger parseBigInteger(String input) {

        try {
            return new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지정된 구분자 이외의 문자가 발견되었습니다.");
        }
    }
}
