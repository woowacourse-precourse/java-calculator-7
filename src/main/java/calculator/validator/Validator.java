package calculator.validator;

public class Validator {


    public static void validate(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException("[NumberError] 양수를 입력해주세요");
        }

    }


    public static boolean isHaveNextToken(String input) {

        if (input.split("\\\\n").length == 1) {
            throw new IllegalArgumentException("[FORMAT_ERROR] NextToken의 입력값이 없습니다");
        }

        return true;

    }


}
