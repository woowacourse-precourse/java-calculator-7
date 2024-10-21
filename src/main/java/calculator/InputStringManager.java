package calculator;

import java.util.regex.*;

public class InputStringManager {
    String inputString;
    String customDelimiter;

    private void setInputString(String inputString) {
        this.inputString = inputString;
    }

    private void setCustomDelimiter(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    private void validateString(String input){
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == 3) {
                // 커스텀 구분자 추출 (//과 \n 사이의 문자)
                String customDelimiter = input.substring(2, newlineIndex);
                setCustomDelimiter(customDelimiter);
                customDelimiter = customDelimiter.replaceAll("([\\W])", "\\\\$1");
                delimiter += "|" + customDelimiter;
                numbers = input.substring(newlineIndex + 2);
                // 숫자 부분 추출
            } else {
                throw new IllegalArgumentException("예외 처리 1");
                  // \n 또는 \\n이 없다면 예외 처리
            }
        }

        String[] tokens = stringDivider(numbers,customDelimiter);

        for (String token : tokens) {
            if (!token.matches("\\d+")) {  // 숫자가 아닌 것이 있다면 false 반환
                throw new IllegalArgumentException("예외 처리 2");
            }
        }

        // 연속된 구분자가 있는지 확인
        if (numbers.matches(".*[" + delimiter + "]{2,}.*")) {
            throw new IllegalArgumentException("예외 처리 3"); // 연속된 구분자가 있는 경우 false 반환
        }
        // 모든 조건을 만족하면 true 반환
    }

    private String stringNormalizer(String input) {
        return input.substring(5);
    }

    private String[] stringDivider(String input, String custom) {
        if (custom==null){
            return input.split("[,:]");
        }
        else{
            return input.split("[,:"+custom+"]");
        }
    }

    private int[] intListConvert (String[] stringList){
        int[] intList = new int[stringList.length];
        for (int i = 0; i < stringList.length; i++) {
            intList[i] = Integer.parseInt(stringList[i]);  // 문자열을 정수로 변환
        }
        return intList;
    }

    public int[] convert (String input){
        setInputString(input);
        validateString(input);

        if (input.isEmpty()){
            return new int[] {0};
        }
        else if (Character.isDigit(input.charAt(0))) {
            String[] stringSplitList = stringDivider(input,customDelimiter);
            return intListConvert(stringSplitList);
        }
        else if (input.charAt(0)=='/'){
            input = stringNormalizer(input);
            String[] stringSplitList = stringDivider(input,customDelimiter);
            return intListConvert(stringSplitList);
        }

        throw new IllegalArgumentException("잘못된 문자열이 입력되었습니다.");
    }
}
