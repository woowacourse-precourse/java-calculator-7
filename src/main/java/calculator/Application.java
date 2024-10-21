package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    static int result = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        문자열 입력을 받는다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();
//        //,\n가 문자열의 앞부분에 있는지 확인한다.
        String delimiter = "//(.)\\\\n(.*)";
        if(inputStr.matches(delimiter)){
            // 커스텀 구분자
            Matcher customMatcher = Pattern.compile(delimiter).matcher(inputStr);
            if (customMatcher.find()) {
                String customDelimiter = customMatcher.group(1);
                String customInputStr = customMatcher.group(2);
                result = getResult(customDelimiter,customInputStr);
            }
        }else{
            // 일반 구분자
            result = getResult("",inputStr);
        }
        // 결과 출력
        System.out.println("결과 : " + result);

    }
    // 결과 구하는 메소드
    static int getResult(String custom, String inputStr){
        int sum = 0;
        String delimiter = ",|:";
        // 커스텀일 경우 구분자 추가
        if(!custom.isEmpty()){
            delimiter = delimiter + "|" + custom;
        }
        // 구분자를 이용하여 문자 분리
        Pattern pattern = Pattern.compile(delimiter);
        Matcher matcher = pattern.matcher(inputStr);

        String[] numsStrArr = inputStr.split(delimiter);
        // - 지정 구분자로 분리
        if (matcher.find()) {
            isVaildNumbers(numsStrArr);
                int[] numsArr = Arrays.stream(numsStrArr).mapToInt(Integer::parseInt).toArray();
                // 모든 숫자의 합을 구함
                for (int i : numsArr) {
                    sum += i;
                }
        }else if(isVaildNumbers(numsStrArr)){
            // 구분자 없이 숫자만 존재하는 경우
            sum = Integer.parseInt(numsStrArr[0]);
        }
        return sum;
    }

    // 숫자만 있는지 확인
    static boolean isVaildNumbers(String[] strArr) {
            Pattern pattern = Pattern.compile("^[0-9]+$");

            for (String str : strArr) {
                if (!pattern.matcher(str).matches()) {
                    // 숫자 이외의 문자 포함
                    throw new IllegalArgumentException();
                    }
        }
            return true;
    }
}
