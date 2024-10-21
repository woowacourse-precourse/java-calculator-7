package calculator;

public class Application {

    public static String defaultSeparator = ",+|:+";
    public static String separator = null;

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을  입력해 주세요.");
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        String processedInput = "";

        try {
            processedInput = SetSeparator.setSeparator(userInput);
            StringValidator.nullValidate(processedInput);
            StringValidator.emptyValidate(processedInput);
            StringValidator.numValidate(processedInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }

        System.out.println("결과 : " + Calculate.sumString(processedInput));
    }
}



