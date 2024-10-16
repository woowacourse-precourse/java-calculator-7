package calculator;

public class Calculator {

    private int result = 0;

    public void calculate(){
        User user = new User();
        String userInput = user.inputString();

        int[] basicNumberSeparator = getBasicSeparatorNumbers(userInput);

        for (int i : basicNumberSeparator) {
            result += i;
        }

        System.out.println("결과 : " + result);
    }

    private static int[] getBasicSeparatorNumbers(String userInput) {
        String[] basicSeparator = userInput.split(",|:");

        int[] basicNumberSeparator = new int[basicSeparator.length];
        for (int i = 0; i < basicSeparator.length; i++) {
            basicNumberSeparator[i] = Integer.valueOf(basicSeparator[i]);
        }
        return basicNumberSeparator;
    }
}
