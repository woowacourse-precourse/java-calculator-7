package calculator;

import java.util.regex.Pattern;

public class Delimiter {
    private String input;
    public static String delimiter = "[,|:]"; // TODO
    private static String[] stringNumbers;

    public Delimiter(String input) {
        this.input = input;
    }

    public String separateCustomDelimiter() {
//        if (input.substring(0, 2).equals("//") && input.contains("\\n")) {
        if (input.startsWith("//") && input.contains("\\n")) {
            extractDelimiter();
            input = input.substring(input.indexOf("\\n") + 2);
        }
        return input;
    }

    public void extractDelimiter() {
//        String newDelimiter = input.split("//")[1].split("|\n|")[0];
        String newDelimiter = input.substring(2, input.indexOf("\\n"));
//        delimiter += "|" + newDelimiter; // TODO 정규표현식 그룹으로 묶기
        delimiter += Pattern.quote(newDelimiter);
//        System.out.println("newDelimiter = " + newDelimiter);
//        System.out.println("delimiter = " + delimiter);
    }

    public String[] splitInput() {
        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        return input.split(delimiter);
    }
}
