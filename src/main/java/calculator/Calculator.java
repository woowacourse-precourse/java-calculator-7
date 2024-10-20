package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    /**
     * 입력된 문자열에서 그 숫자들의 합을 출력합니다.
     */
    public void run() {
        String input = Console.readLine();

        int sum = calculate(input);
        System.out.println("결과 : " + sum);
    }

    /**
     * 문자열을 분리하고, 그 문자열 속 숫자들의 합을 구합니다.
     *
     * @param input 입력된 문자열
     * @return 문자열 속 수들의 합, 비었을 경우 0 반환
     */
    private int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] inputSplit = splitStr(input);
        return sumNumber(inputSplit);
    }

    /**
     * 커스텀 구분자나 기본 구분자로 문자열을 분리합니다.
     *
     * @param str 분리할 문자열
     * @return 구분자로 분리된 문자열
     * @throws IllegalArgumentException 커스텀 구분자에서 "\n"이 없는 경우
     */
    private String[] splitStr(String str) {
        String delimiter = ",|:";
        if (str.startsWith("//")) {
            int start = str.indexOf("\\n");
            if (start == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다: " + str);
            }
            str = str.substring(start + 2);
        }

        return str.split(delimiter);
    }

    /**
     * 분리된 문자열 속 수들의 합을 반환합니다.
     *
     * @param str 분리된 문자열
     * @return 문자열 속 수들의 합
     * @throws IllegalArgumentException 음수일 경우 발생
     */
    private int sumNumber(String[] str) {
        int sum = 0;
        int num = 0;

        for (String s : str) {
            if (isNumber(s)) {
                num = Integer.parseInt(s);
            }
            if (num < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다: " + num);
            }
            sum += num;
        }

        return sum;
    }

    /**
     * 문자가 숫자인지 확인합니다.
     *
     * @param str 확인하고 싶은 문자
     * @return 숫자일 경우, true
     * @throws IllegalArgumentException 숫자가 아닌 경우
     */
    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다: " + str);
        }

        return true;
    }
}