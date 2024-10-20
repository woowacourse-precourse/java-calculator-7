package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        List<String> number = new ArrayList<>();
        List<BigInteger> sumList;
        BigInteger total = BigInteger.ZERO;

        for (int i = 0; i < 10; i++) {
            number.add(String.valueOf(i));
        }

        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        String[] splitStr = str.split("");

        // 구분자 확인
        if (splitStr[0].equals("/")) {
            String delimiter = findDelimiter(splitStr);
            sumList = digitsToNumber(str, splitStr, 5, number, delimiter);
        } else {
            sumList = digitsToNumber(str, splitStr, 0, number, null);
        }

        // 출력
        for (int i = 0; i < sumList.size(); i++) {
            total = total.add(sumList.get(i));
        }

        System.out.println("결과 : " + total);
    }

    public static String findDelimiter (String[] splitStr) {
        if (splitStr[1].equals("/") && splitStr[3].equals("\\") && splitStr[4].equals("n")) {
            String delimiter = splitStr[2];
            return delimiter;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // 문자열 구분 -> 덧셈리스트 추가
    public static List<BigInteger> digitsToNumber (String str, String[] splitStr, int start, List<String> number, String delimiter) {
        List<BigInteger> sumNumbers = new ArrayList<>();
        int index = start;
        BigInteger num;

        for (int i = start; i < splitStr.length; i++) {
            if (splitStr[i].equals(",") || splitStr[i].equals(":") || splitStr[i].equals(delimiter)) {
                if (i == 0 || splitStr[i - 1].equals(",") || splitStr[i - 1].equals(":") || splitStr[i - 1].equals(delimiter)) {
                    index = i + 1;
                    continue;
                }
                if (index != i) {
                    num = new BigInteger(str.substring(index, i));
                } else {
                    num = new BigInteger(str.substring(index));
                }
                sumNumbers.add(num);
                index = i + 1;
            } else if (!number.contains(splitStr[i])) {
                throw new IllegalArgumentException();
            }
        }

        num = new BigInteger(str.substring(index));
        sumNumbers.add(num);

        return sumNumbers;
    }

}
