package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputMessage = "결과 : ";

    public void run() {
        //1. 문자열 입력받기
        String str = getString();

        //구분자 문자열
        String separator = "";

        if (Custom(str)) { //2. 커스텀 구분자
            //3. 커스텀 구분자 중 [,\,] 세가지인 경우 구분자 조정
            String a = ConvertSeparator(String.valueOf(str.charAt(2)));
            //구분자를 separator에 추가
            separator = "[,:".concat(a).concat("]");
            //계산에 필요한 문자열만 잘라줌
            str = str.substring(5);
        } else { //커스텀 구분자가 아닌 문자열들
            separator = "[,:]"; //구분자 아니면 구분자[,:]로!
        }

        //4. 합 구해서 출력
        System.out.println(outputMessage + getSum(str, separator));

    }

    //1. 사용자의 입력을 받는 메서드
    private static String getString() {
        System.out.println(inputMessage);
        return Console.readLine();
    }

    //2. 커스텀 문자열 확인
    private boolean Custom(String str) {
        //문자열 길이가 1보다 작은 경우 false를 반환하는 조건이 있는 이유는 substring(0,2)에서 오류가 발생하기 때문에 미리 처리
        if (str.length() <= 1) {
            return false;
        }
        return str.startsWith("//") && str.startsWith("\\n", 3);
    }

    // 3. 구분자가 [, \, ] 인 경우 구분자 조정
    private static String ConvertSeparator(String a) {
        switch (a) {
            case "\\" -> a = "\\\\";
            case "[" -> a = "\\[";
            case "]" -> a = "\\]";
        }
        return a;
    }

    //4. 합 구하기 + 예외 처리
    private static int getSum(String str, String separator) {
        //빈 문자열은 0출력
        if (str.isEmpty()) {
            return 0;
        }

        int totalSum = 0;
        // 입력받은 문자열을 구분자 기준으로 split
        String[] splitArray = str.split(separator);
        // 정상 문자열인 경우 split한 문자열의 문자들은 모두 숫자이다.
        // 문자인 경우 모두 예외 던짐
        int splitedNumber;
        for (String s : splitArray) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < 48 || c > 57) { //0-9 숫자 아닌 문자열은 예외처리
                    throw new IllegalArgumentException();
                }
            }

            try {
                splitedNumber = Integer.parseInt(s);
            } catch (NumberFormatException e) { // ":,:::,"와 같은 문자열은 split하면 splitedNumber = 0
                splitedNumber = 0;
            }

            if (splitedNumber < 0) { //음수인 경우 예외처리
                throw new IllegalArgumentException();
            }
            totalSum += splitedNumber;
        }
        return totalSum;
    }




}
