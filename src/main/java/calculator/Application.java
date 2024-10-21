package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    // `//` 와 `\n` 사이의 하나 이상의 모든 문자들을 찾되, 최소한의 문장만 매칭하는 정규표현식
    static Pattern pattern = Pattern.compile("\\/\\/(.+?)\\\\n");

    public static void main(String[] args) {
        System.out.println("계산을 수행할 문자열을 입력해주세요.");
        String input = Console.readLine();
        // 입력한 문자열에 \n이 포함된 경우, 즉 커스텀 구분자가 존재하는 경우
        int index = input.indexOf("\\n");
        // 커스텀 구분자 이후 구간으로 문자열 범위 좁힘 ( 커스텀 구분자 없는 경우 그대로 사용 )
        String refinedInput = index >= 0 ? input.substring(index + 2) : input;
        // 구문자 문자열을 입력값으로 부터 추출해, 이스케이핑 시킨다
        String newDelimiter = escapeAllSpecials(extractDelimiter(input));
        // 커스텀 구분자를 구분자들(,와:)에 추가시킨다
        String delimiter = ",|:" + (newDelimiter.equals("") ?  "" : "|" + newDelimiter);
        int[] arr;
        try{
            // 구분자들을 기준으로 문자열을 나눈 뒤 각각 int 값으로 변환해 배열에 담는다 
            arr = splitWithDelimiter(refinedInput, delimiter);
        } catch (NumberFormatException e) {
            // 만약 사용자가 잘못된 값을 입력해 String -> int 변환 과정에 문제가 생긴 경우
            // IllegalArgumentException을 발생시킨다
            throw new IllegalArgumentException();
        }
        // int 배열에 담긴 모든 값을 합산한다
        int result = sumAllIntegers(arr);
        System.out.printf("결과 : %d\n", result);
    }
    public static String extractDelimiter(String str) {
        // 정규표현식에 인자로 주어진 str를 적용한다.
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            // 만약 해당 //와 \n이 존재하며, 해당 문자 사이에 문자열이 존재할 경우
            // 해당 문자열을 반환한다.
            return matcher.group(1);
        }
        return "";
    }
    public static int[] splitWithDelimiter(String input, String delimiters) {
        // 인자로 받은 구분자들을 기준으로 input을 나눈다
        String[] splitString = input.split(delimiters);
        int[] result = new int[splitString.length];
        for(int i=0; i<splitString.length; i++) {
            // 나눠진 input의 각 문자들을 int형으로 변환하고, result 배열에 담는다
            result[i] = Integer.parseInt(splitString[i]);
            // 입력 값은 구분자와 양수로 구성된 문자열이므로
            // 문자가 만약 음수, 즉 -를 포함하고 있는 경우 올바르지 않은 값이라 IllegalArgumentException 발생시킴
            if(result[i] < 0) throw new IllegalArgumentException();
        }
        return result;
    }
    public static String escapeAllSpecials(String delimiters) {
        // delimiters에 포함된  [ * + ? { . ( ) ^ $ | \ 와 같은 특수문자들을 모두 이스케이프 시킨다
        return delimiters.replace("\\", "\\\\")
                .replace("[", "\\[")
                .replace("*", "\\*")
                .replace("+", "\\+")
                .replace("?", "\\?")
                .replace("{", "\\{")
                .replace(".", "\\.")
                .replace("(", "\\(")
                .replace(")", "\\)")
                .replace("^", "\\^")
                .replace("$", "\\$")
                .replace("|", "\\|");
    }
    public static int sumAllIntegers(int[] arr) {
        int result = 0;
        for(int i : arr) {
            result += i;
        }
        return result;
    }
}
