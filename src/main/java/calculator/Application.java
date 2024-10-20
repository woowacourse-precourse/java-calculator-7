package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
            sumList = checkStr(splitStr, 5, number, delimiter);
        } else {
            sumList = checkStr(splitStr, 0, number, null);
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

    public static List<BigInteger> checkStr (String[] splitStr, int start, List<String> number, String delimiter) {
        Stack<String> digits = new Stack<>();
        List<BigInteger> sumNumbers = new ArrayList<>();

        for (int i = start; i < splitStr.length; i++) {
            if (splitStr[i].equals(",") || splitStr[i].equals(":") || splitStr[i].equals(delimiter)) {
                digitsToNumber(digits, sumNumbers);
            } else if (number.contains(splitStr[i])) {
                digits.add(splitStr[i]);
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (!digits.isEmpty()) {
            digitsToNumber(digits, sumNumbers);
        }

        return sumNumbers;
    }

    public static void digitsToNumber (Stack<String> digits, List<BigInteger> sumNumbers) {
        if (digits.size() == 1) {
            sumNumbers.add(new BigInteger(digits.pop()));
        } else {
            BigInteger sum = BigInteger.ZERO;
            while (!digits.empty()) {
                int count = digits.size();
                BigInteger a = new BigInteger(digits.pop());

                for (int i = 0; i < count - 1; i++) {
                    a = a.multiply(BigInteger.TEN);
                }
                sum = sum.add(a);
            }
            sumNumbers.add(sum);
        }
    }
}
