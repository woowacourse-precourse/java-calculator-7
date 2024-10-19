package calculator.logic;

public class Validation {

    public static void execution(String str) {

    isNotNull(str);
    isContainCustom(str);

    }


    public static boolean isNotNull(String str) {

        return false;
    }

    public static boolean isContainCustom(String str) {

        return false;
    }



    // 입력 유효성 판별
    // 비어있는 문자열인가? -> 요구사항에서 "" 의 경우에는 ... 0의 값을 리턴하라고 했는데..
    // ( 커스텀 체크를 하고 ) -> 유효한 문자열로 구분되어 있는가?

}
