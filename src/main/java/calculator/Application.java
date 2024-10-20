package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력 받기
        String inputStr = getInput();

        // 입력한 문자열에서 기본 구분자, 커스텀 구분자 찾아내기
        String customSeparator = findCustomSeparator(inputStr);

        // 기본 구분자 리스트에 커스텀 구분자 추가하기
        String basicSeparatorList = "[,:]";
        String customSeparatorList = addSeparatorList(customSeparator, basicSeparatorList);

        // 입력한 문자열에서 구분자를 기준으로 숫자 문자열 분리시키기
        String[] inputStrList = separateStr(inputStr, customSeparator, basicSeparatorList, customSeparatorList);

        // 문자열 숫자가 아닌 경우 예외 처리
        boolean isStringNumber = true;
        isStrNum(isStringNumber, inputStrList);

        // 분리된 문자열 숫자로 변환하기
        int[] strToIntList = new int[inputStrList.length];
        boolean isMinus = false;
        strToInt(strToIntList, inputStrList, isMinus);

        // 음수인 경우 예외 처리
        checkMinusNum(isMinus);

        // 변환된 숫자를 더하기
        int sum = sumNumList(strToIntList);

        // 덧셈 결과 출력하기
        System.out.println("결과 : " + sum);
    }

    // 문자열 입력 받기
    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 입력한 문자열에서 기본 구분자, 커스텀 구분자 찾아내기
    private static String findCustomSeparator(String inputStr) {
        String customSeparatorPattern = "//[^\\w\\s]";
        String customSeparator = "";

        Pattern pattern = Pattern.compile(customSeparatorPattern);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.find() && inputStr.substring(3, 5).equals("\\n")) {
            customSeparator = inputStr.substring(2, 3);
        }

        return customSeparator;
    }

    // 기본 구분자 리스트에 커스텀 구분자 추가하기
    private static String addSeparatorList(String customSeparator, String basicSeparatorList) {
        String customSeparatorList = "";
        if (customSeparator.length() > 0) {
            customSeparatorList = basicSeparatorList.substring(0, basicSeparatorList.length() - 1) + customSeparator + "]";
        }
        return customSeparatorList;
    }

    // 입력한 문자열에서 구분자를 기준으로 숫자 문자열 분리시키기
    private static String[] separateStr(String inputStr, String customSeparator,
                                        String basicSeparatorList, String customSeparatorList) {
        String[] inputStrList;
        if (customSeparator.length() == 1) {
            inputStrList = inputStr.substring(5).split(customSeparatorList);
        } else {
            inputStrList = inputStr.split(basicSeparatorList);
        }
        return inputStrList;
    }

    // 예외처리 -1: 문자열 숫자가 아닌 경우
    private static void isStrNum(boolean isStringNumber, String[] inputStrList) {
        for (String s : inputStrList) {
            if (!s.matches("\\d+")) {
                isStringNumber = false;
            }
        }
        if (!isStringNumber) {
            throw new IllegalArgumentException("숫자 제외 입력 금지");
        }
    }

    // 분리된 문자열 숫자로 변환하기
    private static void strToInt(int[] strToIntList, String[] inputStrList, boolean isMinus) {
        int index = 0;
        for (String str : inputStrList) {
            strToIntList[index] = Integer.parseInt(str);
            if (strToIntList[index] < 0) {
                isMinus = true;
            }
            index++;
        }
    }

    // 예외 처리 -2 : 음수인 경우
    private static void checkMinusNum(boolean isMinus) {
        if (isMinus) {
            throw new IllegalArgumentException("음수 입력 불가");
        }
    }

    // 변환된 숫자를 더하기
    private static int sumNumList(int[] strToIntList) {
        int sum = 0;
        for (int number : strToIntList) {
            sum += number;
        }
        return sum;
    }
}
