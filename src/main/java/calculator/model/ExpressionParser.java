package calculator.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    public static List<BigInteger> getIntegerListFromSeparator(String string, List<Character> separatorList) {
        List<BigInteger> parseIntegerList = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (separatorList.contains(character)) { // 구분자
                String beforeString = numberBuilder.toString();
                parseIntegerList.add(convertIntegerFromString(beforeString));
                numberBuilder.setLength(0);
                continue;
            } else if (Character.isDigit(character)) { // 0~9
                numberBuilder.append(character);
                continue;
            }
            throw new IllegalArgumentException(); // 그 외 모두 에러처리
        }
        if (numberBuilder.length() != 0) {
            String numberString = numberBuilder.toString();
            parseIntegerList.add(convertIntegerFromString(numberString));
        }
        return parseIntegerList;
    }

    private static BigInteger convertIntegerFromString(String string) {
        if (string.isEmpty()) {
            return BigInteger.ZERO; // 구분자 이전 빈 문자열은 0으로 취급합니다.
        } else if (string.equals("0")) {
            throw new IllegalArgumentException("0은 양수가 아닙니다.");
        }
        return new BigInteger(string);
    }
}
