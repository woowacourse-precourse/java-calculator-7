package calculator;

public class Calculator {

    private int result = 0;

    public void calculate(){
        User user = new User();
        String userInput = user.inputString();

        sum(userInput);
        System.out.println("결과 : " + result);
    }

    private void sum(String userInput) {
        if(userInput.startsWith("//") || userInput.contains("\n")) {
            int[] customNumberSeparator = getCustomSeparatorNumbers(userInput);
            for (int i : customNumberSeparator) {
                result += i;
            }
        }else{
            int[] basicNumberSeparator = getBasicSeparatorNumbers(userInput);
            for (int i : basicNumberSeparator) {
                result += i;
            }
        }
    }

    private static int[] getBasicSeparatorNumbers(String input) {
        String[] basicSeparator = input.split(",|:");

        int[] basicNumberSeparator = stringToInt(basicSeparator);
        return basicNumberSeparator;
    }

    private static int[] getCustomSeparatorNumbers(String input){
        input = input.replace("//","").replace("\\n","");
        String separator = input.substring(0, 1);
        input = input.substring(1);
        String[] customSeparator = input.split(separator);

        int[] customNumberSeparator = stringToInt(customSeparator);
        return customNumberSeparator;
    }

    private static int[] stringToInt(String[] separator) {
        int[] basicNumberSeparator = new int[separator.length];
        for (int i = 0; i < separator.length; i++) {
            basicNumberSeparator[i] = Integer.parseInt(separator[i]);
            isPositiveNumber(basicNumberSeparator, i);
        }
        return basicNumberSeparator;
    }

    private static void isPositiveNumber(int[] numberSeparator, int i) {
        if (numberSeparator[i] < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
