package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        String customDelimiter = getCustomDelimiter(inputString);

        String[] splitStrings;
        if (customDelimiter == null) {
            splitStrings = inputString.split("[,:]");
        } else {
            inputString = inputString.substring(5);
            splitStrings = inputString.split("[,:" + customDelimiter + "]");
        }

        List<String> stringList = new ArrayList<>(Arrays.asList(splitStrings));
        stringList.removeIf(String::isEmpty);
        List<Integer> integerList = convertStringsToIntegers(stringList);
        if (integerList != null) {
            int sum = 0;
            for (int i : integerList) {
                sum += i;
            }
            System.out.println("결과 : " + sum);
        }
    }

    private static String getCustomDelimiter(String string) throws IllegalArgumentException {
        String customDelimiterOpener = "//";
        String customDelimiterCloser = "\\n";

        if (string.length() < 5) {
            return null;
        }
        if (!string.substring(0, 2).equals(customDelimiterOpener) || !string.substring(3, 5).equals(customDelimiterCloser)) {
            return null;
        }
        if (string.charAt(2) == ',' || string.charAt(2) == ':') {
            throw new IllegalArgumentException();
        }
        return string.substring(2, 3);
    }

    private static List<Integer> convertStringsToIntegers(List<String> stringList) throws IllegalArgumentException{
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
        throw new IllegalArgumentException();
    }
}
