package calculator;

public class StringParsing {
    private static String[] userInputArr;

    public static String[] stringValidateCheck(String UserInput, String delimiter) {
        userInputArr = UserInput.split(delimiter);
        //System.out.println("배열 안에 값들" + Arrays.toString(UserInputArr));//디버깅코드
        return userInputArr;
    }
}
