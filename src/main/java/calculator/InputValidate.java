package calculator;

public class InputValidate {
    private static String delimiter = ",|:";
    private static final String customStart = "//";
    private static String[] UserInputArr;

    public static void CheckCustom(String UserInput) {
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

    public static void StringValidateCheck(String UserInput, String delimiter) {
        UserInputArr = UserInput.split(delimiter);
        //System.out.println("배열 안에 값들" + Arrays.toString(UserInputArr));//디버깅코드
    }

    public static int calculateSum(String UserInput) {
        if (UserInput.startsWith(customStart)) {
            CheckCustom(UserInput);
            UserInput = UserInput.substring(UserInput.indexOf("\\n") + 2);
        }
        StringValidateCheck(UserInput, delimiter);
        return UserInputArrIsNum(UserInputArr);
    }

    public static int UserInputArrIsNum(String[] UserInputArr) {
        int sum = 0;

        for (String s : UserInputArr) {
            if (s.isEmpty()) {
                continue;
            }
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