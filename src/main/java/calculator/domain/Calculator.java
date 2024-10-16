package calculator.domain;

public class Calculator {

    private static Integer CUSTOM_SEPARATOR_END_INDEX = 3;
    private static Integer CUSTOM_SEPARATOR_START_INDEX = 2;


    public String[] extractNumber(String text) {
        String arr[] = text.split("[,|:]");
        return arr;
    }

    public String[] extractNumber(String customSeparator, String text) {
        String arr[] = text.split(customSeparator);
        return arr;
    }

    public String findCustomSeparator(String inputText) {
        return inputText.substring(CUSTOM_SEPARATOR_START_INDEX, CUSTOM_SEPARATOR_END_INDEX);
    }

    public String removeCustomReserveWord(String inputText) {
        return inputText.substring(5);
    }


    public void sum(String[] arr) {
        int sum = 0;
        try {
            for (String str : arr) {
                sum += validateNumber(Integer.parseInt(str));
            }
        } catch (NumberFormatException e) {
        }
        System.out.println("결과 : " + sum);
    }

    public static int validateNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException();
        }
        return positiveNumber;
    }
}
