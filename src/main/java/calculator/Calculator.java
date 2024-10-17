package calculator;

public class Calculator {

    private int result = 0;
    public void calculate(){
        User user = new User();
        String userInput = user.inputString();

        if(!userInput.startsWith("//") || userInput.contains("\n")) {
            int[] basicNumberSeparator = getBasicSeparatorNumbers(userInput);
            for (int i : basicNumberSeparator) {
                result += i;
            }
        }else{
            int[] customNumberSeparator = getCustomSeparatorNumbers(userInput);
            for (int i : customNumberSeparator) {
                result += i;
            }
        }
        System.out.println("결과 : " + result);
    }


    private static int[] getBasicSeparatorNumbers(String input) {
        String[] basicSeparator = input.split(",|:");

        int[] basicNumberSeparator = new int[basicSeparator.length];
        for (int i = 0; i < basicSeparator.length; i++) {
            basicNumberSeparator[i] = Integer.parseInt(basicSeparator[i]);
            isPositiveNumber(basicNumberSeparator, i);
        }
        return basicNumberSeparator;
    }

    private static int[] getCustomSeparatorNumbers(String input){
        input = input.replace("//","").replace("\\n","");
        String separator = input.substring(0, 1);
        input = input.substring(1);
        String[] customSeparator = input.split(separator);

        int[] customNumberSeparator = new int[customSeparator.length];
        for (int i = 0; i < customSeparator.length; i++) {
            customNumberSeparator[i] = Integer.parseInt(customSeparator[i]);
            isPositiveNumber(customNumberSeparator, i);
        }
        return customNumberSeparator;
    }

    private static void isPositiveNumber(int[] numberSeparator, int i) {
        if (numberSeparator[i] <0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
