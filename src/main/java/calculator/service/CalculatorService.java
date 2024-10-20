package calculator.service;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CalculatorService {

    //TODO: 입력에 대한 문자열 처리, 계산 등을 진행하는 클래스

    private final String SPECIAL_PREFIX = "//";
    private final String SPECIAL_SUFFIX = "\\n";
    private final String SEPARATOR_COMMA = ",";
    private final String SEPARATOR_COLON = ":";

    public ArrayDeque<String> detectNormalSeparator(String input) {

        ArrayDeque<String> separatorStack = new ArrayDeque<>();

        if (input.contains(SEPARATOR_COLON)) {
            separatorStack.addLast(SEPARATOR_COLON);
        }

        if (input.contains(SEPARATOR_COMMA)) {
            separatorStack.addLast(SEPARATOR_COMMA);
        }

        return separatorStack;
    }

    public Map<String, String> specialSepProcessing(String input) {

        Map<String, String> specialProcessingResult = new HashMap<>();

        String specialSub = getSpecialSubstr(input);

        specialProcessingResult.put("sep", findSpecialSepBySubStr(specialSub));
        specialProcessingResult.put("input", modifyInputBySpecialSub(input, specialSub));

        return specialProcessingResult;
    }

    private String modifyInputBySpecialSub(String input, String specialSub) {
        return input.substring(specialSub.length() - 1);
    }

    public boolean hasSpecialSeparator(String input) {

        return input.contains(SPECIAL_PREFIX) && input.contains(SPECIAL_SUFFIX);
    }

    private String getSpecialSubstr(String input) {

        int prefixLen = SPECIAL_PREFIX.length();
        int suffixLen = SPECIAL_SUFFIX.length();
        String prefixSub = input.substring(0, prefixLen);
        String suffixSub = input.substring(prefixLen + 1, prefixLen + suffixLen + 1);

        if (!prefixSub.equals(SPECIAL_PREFIX) || !suffixSub.equals(SPECIAL_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 설정 형식이 잘못되었습니다");
        }

        return input.substring(0, prefixLen + suffixLen + 2);
    }

    private String findSpecialSepBySubStr(String specialSubstr) {

        String specialSep = String.valueOf(specialSubstr.charAt(SPECIAL_PREFIX.length()));

        if (specialSep.equals(SEPARATOR_COLON) || specialSep.equals(SEPARATOR_COMMA)) {
            throw new IllegalArgumentException("일반 구분자 (쉼표,콜론) 는 특수 구분자로 사용할 수 없습니다.");
        }

        return specialSep;
    }

    public ArrayList<String> processingInputBySepStack(String input, ArrayDeque<String> sepStack) {

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(input);

        while (!sepStack.isEmpty()) {
            String sep = sepStack.removeLast();
            resultList = splitStrListBySep(resultList, sep);
        }

        return resultList;
    }

    static ArrayList<String> splitStrListBySep(ArrayList<String> strList, String separator) {

        ArrayList<String> tempList = new ArrayList<>();

        for (String str : strList) {
            if (str.contains(separator)) {
                String[] split = str.split(Pattern.quote(separator));
                for (String s : split) {
                    if (!s.isEmpty()) {
                        tempList.add(s);
                    }
                }
            } else {
                if (!str.isEmpty()) {
                    tempList.add(str);
                }
            }
        }

        return tempList;
    }

    public BigInteger calcSplitResult(ArrayList<String> splitResult) {

        BigInteger result = BigInteger.ZERO;

        for (String part : splitResult) {
            result = result.add(parseBigInteger(part));
        }

        return result;
    }

    private BigInteger parseBigInteger(String part) {

        checkPartValid(part);

        try {
            return new BigInteger(part);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지정된 구분자 이외의 문자가 발견되었습니다.");
        }
    }

    private void checkPartValid(String part) {

        if (part.contains("-")) {
            throw new IllegalArgumentException("음수는 연산에 사용될 수 없습니다.");
        }

        if (part.contains("+")) {
            throw new IllegalArgumentException("+ 기호는 연산에 사용될 수 없습니다.");
        }

    }
}