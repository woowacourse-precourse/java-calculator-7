package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInputStr = Console.readLine();

        if (userInputStr == "") {
            System.out.print("결과 : " + 0);
            return;
        }

        String[] splitNumberArr;

        if (userInputStr.indexOf("//") == 0) {
            String delimiter = userInputStr.substring(2, userInputStr.indexOf("\\n"));

            String userString = userInputStr.substring(userInputStr.indexOf("\\n") + 2);

            splitNumberArr = userString.split(",|:|delimiter");

        } else {
            splitNumberArr = userInputStr.split(",|:");
        }

        int result = 0;

        for (String splitNumber : splitNumberArr) {
            if (splitNumber.equals("")) {
                throw new IllegalArgumentException("구분자는 연속적으로 사용할 수 없습니다.");

            } else if (splitNumber.matches("[^0-9]")) {
                throw new IllegalArgumentException("숫자 외의 문자는 입력할 수 없습니다.");

            } else if (Integer.valueOf(splitNumber) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            result += Integer.valueOf(splitNumber);
        }

        System.out.println("결과 : " + result);
    }
}