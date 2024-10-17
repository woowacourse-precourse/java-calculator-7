package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        System.out.println("입력된 문자열 : " + inputString);

        String customDelimiter = getCustomDelimiter(inputString);
        System.out.println("커스텀 구분자 : " + (customDelimiter == null ? "없음" : customDelimiter));

        String[] splitStrings;
        if (customDelimiter == null) {
            splitStrings = inputString.split("[,:]");
            System.out.println("기본 구분자로 분리한 결과 : ");
            for (String str : splitStrings) {
                System.out.println(str);
            }
        } else {
            inputString = inputString.substring(5);
            splitStrings = inputString.split("[,:" + customDelimiter + "]");
            System.out.println("기본 구분자 + 커스텀 구분자로 분리한 결과 : ");
            for (String str : splitStrings) {
                System.out.println(str);
            }
        }

        List<String> stringList = new ArrayList<>(Arrays.asList(splitStrings));
        stringList.removeIf(String::isEmpty);
        List<Integer> integerList = convertStringsToIntegers(stringList);
        if (integerList != null) {
            System.out.println("빈 문자열을 제외한 모든 문자열이 숫자입니다.");
            for (int i : integerList) {
                System.out.println(i);
            }
            int sum = 0;
            for (int i : integerList) {
                sum += i;
            }
            System.out.println("결과 : " + sum);
        } else {
            System.out.println("숫자가 아닌 문자열이 존재합니다.");
        }
    }

    private static String getCustomDelimiter(String string) {
        String customDelimiterOpener = "//";
        String customDelimiterCloser = "\\n";

        if (string.length() < 5) {
            return null;
        }
        if (!string.substring(0, 2).equals(customDelimiterOpener) || !string.substring(3, 5).equals(customDelimiterCloser)) {
            return null;
        }
        return string.substring(2, 3);
    }

    private static List<Integer> convertStringsToIntegers(List<String> stringList) {
        boolean isAllDigits = true;
        List<Integer> integerList = new ArrayList<>();

        for (String str : stringList) {
            if (str.length() != 1 || !Character.isDigit(str.charAt(0))) {
                isAllDigits = false;
                break;
            }
            integerList.add(Integer.parseInt(str));
        }

        if (isAllDigits) {
            return integerList;
        }
        return null;
    }
}
