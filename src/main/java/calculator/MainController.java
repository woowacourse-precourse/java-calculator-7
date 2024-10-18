package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    public static void run() {
        String inputString = readString();
        int sumResult = getSplittedValuesSum(inputString);
        printResult(sumResult);
    }

    private static void printResult(int sumResult) {
         System.out.printf("결과 : %d", sumResult);
    }

    private static int getSplittedValuesSum(String inputString) {
        List<String> splittedValues;
        int sumResult = 0 ;

        if(checkDefaultDelimterFormat(inputString)){
            splittedValues = SplitbyDefaultDelimiter(inputString);
            return getSumResult(splittedValues);
        }

        if (checkCustomDelimiterFormat(inputString)){
            splittedValues = SplitbyCustomDelimiter(inputString);
            sumResult = getSumResult(splittedValues);
        }
        return sumResult;
    }

    private static String readString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        if (!checkDefaultDelimterFormat(inputString) && !checkCustomDelimiterFormat(inputString)){
            throw new IllegalArgumentException("(기본 구분자를 활용한 입력 포맷) 또는 (커스텀 구분자 지정 포맷)이 잘못되었습니다.");
        }

        return inputString;
    }
    private static int getSumResult(List<String> splittedValues) {
        int sumResult = 0;
        for (String part : splittedValues) {
            checkNagativeInt(Integer.parseInt(part));
            sumResult += Integer.parseInt(part);
        }
        return sumResult;
    }

    private static boolean checkDefaultDelimterFormat(String inputString) {
        String rex = "^[0-9]+([,:]\\d*)*$";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(inputString);

        return matcher.find();
    }

    private static boolean checkCustomDelimiterFormat(String inputString) {
        String rex =  "^//[\\D ]\\\\n.*$";
        Pattern p = Pattern.compile(rex);
        Matcher matcher = p.matcher(inputString);

        return matcher.find();
    }

    private static void checkNagativeInt(int part) {
        if (part < 0) {
            throw new IllegalArgumentException("음수값은 덧셈 할 수 없습니다.");
        }
    }

    private static List<String> SplitbyDefaultDelimiter(String inputString) {
        List<String> defaultSplitValues = Arrays.asList(inputString.split(",|:"));
        return defaultSplitValues;
    }

    private static List<String> SplitbyCustomDelimiter(String inputString) {
        String customDelimiter = String.valueOf(inputString.charAt(2));
        String remainingInput = inputString.substring(5);

        if (checkRemainStringFormat(remainingInput, customDelimiter)) {
            List<String> customSplitValues = Arrays.asList(remainingInput.split(customDelimiter));
            return customSplitValues;
        }
        throw new IllegalArgumentException("커스텀 구분자 지정형식 뒤의 계산할 문자열 형식을 확인해주세요");
    }

    private static Boolean checkRemainStringFormat(String remainingInput, String customDelimiter) {
        String rex = "^[0-9]+([" + customDelimiter + "]\\d*)*$";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(remainingInput);

        return matcher.find();
    }

}
