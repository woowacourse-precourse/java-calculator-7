package calculator;

public class StringSpliter { //TODO: 구분자를 인식하고, 구분자로 분리된 문자열 반환
    public static String[] split(String input) {
        String spliter = "[,:]";
        String[] splitedString = input.split(spliter);
        for (String s : splitedString) {
            System.out.print(s + " ");
        }
        return splitedString;
    }
}
