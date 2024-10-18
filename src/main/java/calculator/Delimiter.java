package calculator;

public class Delimiter {
    public static String delimiter = ",:"; // TODO

    public static void extractDelimiter(String input) {
//        String newDelimiter = input.split("//")[1].split("|\n|")[0];
        String newDelimiter = input.substring(2, input.indexOf("\\n"));
        delimiter += newDelimiter; // TODO 정규표현식 그룹으로 묶기
    }
}
