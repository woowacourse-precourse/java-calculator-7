package calculator;

public class MyCalculator {

    // IllegatArgumentException을 발생시키는 잘못된 입력값을 정의한다.
    private static boolean isIllegal(String str) {
        if (str.matches("^([1-9][0-9]*(,|:))*[1-9][0-9]*$")) {
            return false;
        } else if (str.matches("^//([\\D]+)\\\\n([1-9][0-9]*((\\1|,|:)[1-9][0-9]*)*)$")) {
            return false;
        } else {
            return true;
        }
    }

    // 커스텀구분자를 입력한 문자열을 인식해서 앞부분을 잘라내는 메서드
    private static String customDelimiter(String str) {
        String newStr = "";

        // "//(커스텀구분자)\n(문자열)" 형태면 "//(커스텀구분자)\n" 부분을 잘라내고 뒷 문자열만 반환한다.
        // 일반적인 "숫자/구분자/숫자" 형태로 입력됐을 경우 그대로 반환한다.
        if (str.matches("^//[\\D]*\\\\n.*$")) {
            newStr += str.substring(str.indexOf("n") + 1);
        }
        return newStr.isEmpty() ? str : newStr;
    }

    // 문자열을 배열로 분리시키는 메서드
    private static String[] splitString(String str) {
        // customDelimiter() 메서드를 통해 문자열 형태를 "숫자/구분자/숫자"로 통일시킨다. -> ex) "1;2;3", "1,2,3"
        String newStr = customDelimiter(str);

        // 구분자를 기준으로 분리해서 배열에 담는다. 그리고 배열을 반환한다.
        String[] splitNumber = newStr.split("[^0-9]+");

        return splitNumber;
    }

    public static int getSum(String str) {
        // 합계를 담을 int형 변수 sum을 선언 및 초기화 한다.
        int sum = 0;

        // 잘못된 입력값은 IllegalArgumentException을 발생시킨다.
        if (isIllegal(str)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // 빈 문자열의 경우에는 합계로서 0을 반환한다.
        if (str.isEmpty()) {
            return sum;
        }

        // 나머지 입력값들은 구분자를 기준으로 분리해서 배열로 만든다.
        String newStr = customDelimiter(str);
        String[] strArray = splitString(newStr);

        // 배열의 원소들을 int형으로 형변환 후 합계에 더해서 결과로 반환한다.
        for (String s : strArray) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
