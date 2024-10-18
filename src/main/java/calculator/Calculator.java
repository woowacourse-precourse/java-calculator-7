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
            addResult(customNumberSeparator);
        }else{
            int[] basicNumberSeparator = getBasicSeparatorNumbers(userInput);
            addResult(basicNumberSeparator);
        }
    }

    private void addResult(int[] numberSeparator) {
        for (int i : numberSeparator) {
            result += i;
        }
    }

    private static int[] getBasicSeparatorNumbers(String input) {
        String[] basicSeparator = input.split(",|:");

//        int[] basicNumberSeparator = new int[basicSeparator.length];
//        for (int i = 0; i < basicSeparator.length; i++) {
//            basicNumberSeparator[i] = Integer.parseInt(basicSeparator[i]);
//            isPositiveNumber(basicNumberSeparator,i);
//        }
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
        int[] numberSeparator = new int[separator.length];
        for (int i = 0; i < separator.length; i++) {
            isCorrectInput(separator, numberSeparator, i);
            isPositiveNumber(numberSeparator, i);
        }
        return numberSeparator;
    }

    private static void isCorrectInput(String[] separator, int[] numberSeparator, int i) {
        try {
            numberSeparator[i] = Integer.parseInt(separator[i]);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 구분자를 입력해주세요.");
        }
    }

    private static void isPositiveNumber(int[] numberSeparator, int i) {
        if (numberSeparator[i] < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }


}
