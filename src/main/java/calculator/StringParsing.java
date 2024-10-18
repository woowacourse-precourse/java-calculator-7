package calculator;

public class StringParsing {
    private static String[] UserInputArr;

    public static String[] StringValidateCheck(String UserInput, String delimiter) {
        UserInputArr = UserInput.split(delimiter);
        //System.out.println("배열 안에 값들" + Arrays.toString(UserInputArr));//디버깅코드
        return UserInputArr;
    }
}
