package calculator;

public class StringSplitter {
    public String[] DefaultSplitter(String input) {
        String[] result = input.split("[,:]");
        return result;
    }

    public String[] CustomSplitter(String input) {
        String delimiter = " "; //구분자 문자열 생성
        int index = input.indexOf("\\n");
        // "//"와 "\n" 사이의 구분자 추출
        delimiter = input.substring(2, index);
        String numbers = input.substring(index + 1);
        return numbers.split(delimiter);
    }


}
