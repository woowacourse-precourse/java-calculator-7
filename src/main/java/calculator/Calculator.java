package calculator;

public class Calculator {

    private int result = 0;

    public void calculate(){
        User user = new User();
        String userInput = user.inputString();

        int[] basicNumberSeparator = getCustomSeparatorNumbers(userInput);

        for (int i : basicNumberSeparator) {
            result += i;
        }

        System.out.println("결과 : " + result);
    }

    private static int[] getBasicSeparatorNumbers(String input) {
        String[] basicSeparator = input.split(",|:");

        int[] basicNumberSeparator = new int[basicSeparator.length];
        for (int i = 0; i < basicSeparator.length; i++) {
            basicNumberSeparator[i] = Integer.valueOf(basicSeparator[i]);
        }
        return basicNumberSeparator;
    }

    private static int[] getCustomSeparatorNumbers(String input){
        char custom = input.charAt(2);
        String customString = input.substring(5);
        String[] customSeparator = customString.split(String.valueOf(custom));

        int[] customNumberSeparator = new int[customSeparator.length];
        for (int i = 0; i < customSeparator.length; i++) { // 숫자는 양수!! 예외 처리
            customNumberSeparator[i] = Integer.valueOf(customSeparator[i]);
        }
        return customNumberSeparator;
    }
}
