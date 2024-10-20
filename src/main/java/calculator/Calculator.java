package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Calculator {
    final static int identifierLength = 2;
    final static int customDelimiterInputLength = 5;

    StringBuilder delimiter;
    String inputLine;
    BigInteger res;

    Calculator() {
        delimiter = new StringBuilder(",:");
        inputLine = "";
        res = BigInteger.ZERO;
    }

    void on() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputLine = Console.readLine();

        preProcessing();

        calculate();
    }

    private void preProcessing() {
        findCustomDelimiter();

        inputLine = inputLine.replaceAll("[" +delimiter.toString() + "]", " ");
        if (!inputLine.matches("[0-9\\s]*"))
            throw new IllegalArgumentException("구분자와 양수 이외의 입력");
    }

    private void findCustomDelimiter() {
        boolean flag = inputLine.substring(0, identifierLength).equals("//");
        int i = 0;

        while(flag && inputLine.length() >= i+customDelimiterInputLength) {
            if (inputLine.indexOf("\\n", i) != identifierLength+1+i)
                throw new IllegalArgumentException("커스텀 구분자로 2자 이상의 문자 입력");
            if (Character.isDigit(inputLine.charAt(i+identifierLength)))
                throw new IllegalArgumentException("커스텀 구분자로 0~9 입력");

            char str = inputLine.charAt(i+identifierLength);

            for (int j = 0; j < delimiter.length(); j++) {
                if (delimiter.charAt(j) == str)
                    throw new IllegalArgumentException("이미 존재하는 구분자");
            }
            delimiter.append(str);
            flag = false;
            i += customDelimiterInputLength;
            if (inputLine.length() >= i+identifierLength)
                flag = inputLine.substring(i, i+identifierLength).equals("//");
        }
        int invalidCustomDelimterIndex = inputLine.indexOf("//", i);
        if (invalidCustomDelimterIndex != -1)
            if (inputLine.indexOf("\\n", invalidCustomDelimterIndex) != -1)
                throw new IllegalArgumentException("잘못된 커스텀 구분자 입력");

        inputLine = inputLine.substring(i);
    }

    private void calculate() {
        StringTokenizer st = new StringTokenizer(inputLine, " ");

        while (st.hasMoreTokens())
            res = res.add(new BigInteger(st.nextToken()));

        System.out.println("결과 : " + res);
    }
}
