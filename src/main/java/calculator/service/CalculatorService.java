package calculator.service;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorService {

    private final String SPECIAL_PREFIX = "//";
    private final String SPECIAL_SUFFIX = "\\n";
    private final ArrayList<String> NORMAL_SEPARATORS = new ArrayList<>(Arrays.asList(",", ":"));
    private ArrayDeque<String> separatorQueue = new ArrayDeque<>();

    public String detectSeparators(String input) {

        if (hasSpecialSeparator(input)) {
            String specialSeparator = extractSpecialSeparator(input);
            separatorQueue.addLast(specialSeparator);
            input = modifyInputBySpecialSeparator(input, specialSeparator);
        }

        detectNormalSeparators(input);

        return input;
    }

    private void detectNormalSeparators(String input) {

        for(String separator : NORMAL_SEPARATORS) {
            if (input.contains(separator)) {
                separatorQueue.addLast(separator);
            }
        }
    }

    private String modifyInputBySpecialSeparator(String input, String specialSeparator) {
        return input.substring(input.indexOf(SPECIAL_SUFFIX) + SPECIAL_SUFFIX.length());
    }

    public boolean hasSpecialSeparator(String input) {
        return input.contains(SPECIAL_PREFIX) && input.contains(SPECIAL_SUFFIX);
    }

//    private String getSpecialSubstr(String input) {
//
//        int prefixLen = SPECIAL_PREFIX.length();
//        int suffixLen = SPECIAL_SUFFIX.length();
//        String prefixSub = input.substring(0, prefixLen);
//        String suffixSub = input.substring(prefixLen + 1, prefixLen + suffixLen + 1);
//
//        if (!prefixSub.equals(SPECIAL_PREFIX) || !suffixSub.equals(SPECIAL_SUFFIX)) {
//            throw new IllegalArgumentException("커스텀 구분자 설정 형식이 잘못되었습니다");
//        }
//
//        return input.substring(0, prefixLen + suffixLen + 2);
//    }

    private String extractSpecialSeparator(String input) {

        int startIndex = SPECIAL_PREFIX.length();
        int endIndex = input.indexOf(SPECIAL_SUFFIX);
        String specialSeparator = input.substring(startIndex, endIndex);


        for(String separator : NORMAL_SEPARATORS) {
            if(specialSeparator.equals(separator)) {
                throw new IllegalArgumentException("일반 구분자 (쉼표,콜론) 는 특수 구분자로 사용할 수 없습니다.");
            }
        }

        return specialSeparator;
    }

    public ArrayList<String> processingInput(String input) {

        ArrayList<String> resultList = new ArrayList<>();

        if (!input.isEmpty()) {
            resultList.add(input);
        }

        while (!separatorQueue.isEmpty() && !input.isEmpty()) {
            String sep = separatorQueue.removeFirst();
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