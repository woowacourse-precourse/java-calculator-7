package calculator;

import java.util.Arrays;

public class InputValidate {
    private static String delimiter = ",|:";
    private static final String customStart = "//";
    private static String[] UserInputArr;

    //커스텀 구분자 먼저 예외처리
    public static void CheckCustom(String UserInput) {
        // "//"와 "\n"으로 감싸져있으면 구분자 반환 후 아래 에러처리
        if (!(UserInput.startsWith(customStart) && UserInput.indexOf("\\n", 2) == 3)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        CustomValidateCheck(UserInput.charAt(2));
    }

    public static void CustomValidateCheck(char CustomVal) {
        if (Character.isDigit(CustomVal)) {
            throw new IllegalArgumentException("구분자가 숫자가 될 수 없습니다.");
        }
        addDelimiter(CustomVal);
    }

    public static void addDelimiter(char addDelimiter) {
        delimiter += "|" + addDelimiter;
    }

    //커스텀 구분자가 있으며 그 안에 숫자가 들어있을 경우
    //커스텀 구분자가 있으며 커스텀 구분자로 안감싸져있는 경우 x
    //커스텀 구분자가 있으며 커스텀 구분자 안에 문자가 두개 이상일때
    //커스텀 구분자가 있으며 커스텀 구분자가 두개 이상일때 x
    public static void StringValidateCheck(String UserInput, String delimiter) {
        //구분자를 기준으로 숫자 분리 후 배열 혹은 리스트에 삽입
        //숫자가 맞는지 확인
        UserInputArr = UserInput.split(delimiter);
        System.out.println("배열 안에 값들" + Arrays.toString(UserInputArr));//디버깅코드
    }

    public static int calculateSum(String UserInput) {
        // 입력값이 커스텀 구분자를 포함하는지 먼저 체크
        if (UserInput.startsWith(customStart)) {
            CheckCustom(UserInput);
            // 커스텀 구분자가 포함된 경우, 입력값에서 실제 숫자 부분만 추출
            UserInput = UserInput.substring(UserInput.indexOf("\\n") + 2);
        }
        // 문자열을 구분자를 기준으로 나누고 숫자 합산
        StringValidateCheck(UserInput, delimiter);
        return UserInputArrIsNum(UserInputArr);
    }

    public static int UserInputArrIsNum(String[] UserInputArr) {
        int sum = 0;

        for (String s : UserInputArr) {
            try {
                int num = Integer.parseInt(s);
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
            }
        }
        return sum;
    }
}