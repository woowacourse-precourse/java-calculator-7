package calculator;

public class Spliter {
    private String inputString;
    private char customSeparator;
    private int resultValue = 0;

    // 생성자
    public Spliter(String inputString){
        this.inputString = inputString;
    }

    // 결과 값 출력
    public void printResult() {
        System.out.println("결과 : " + resultValue);
    }

    public void calculate() {
        String[] result;

        // 커스텀 구분자 있으면 추가
        if(isNum(inputString.charAt(0))) { // 문자열 시작이 숫자이면
            result = inputString.split(":|,");
        } else { // 문자열 시작이 문자이면
            generateCustomSeparator();

            if(customSeparator >= 65 && customSeparator <= 90 || customSeparator >= 97 && customSeparator <= 122) {
                result = inputString.split(":|,|" + customSeparator);
            } else {
                result = inputString.split(":|,|" + "\\" + customSeparator);
            }
        }

        if(inspectionValue(result)) {
            sum(result);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public boolean isNum(int num) {
        if(num > 47 && num < 58) {
            return true;
        } else {
            return false;
        }
    }

    public void generateCustomSeparator() {
        if(inputString.length() >= 5) {
            char[] inputArray = inputString.toCharArray();

            // 커스텀 구분자 등록 후 문자열 시작위치 변경
            if(inputArray[0] == '/' && inputArray[1] == '/' && inputArray[3] == '\\' && inputArray[4] == 'n') {
                customSeparator = inputArray[2];
            } else {
                throw new IllegalArgumentException();
            }
            this.inputString = inputString.substring(5);
        }
    }

    public boolean inspectionValue(String[] result) {
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[i].length(); j++) {
                if(result[i].charAt(j) < 48 || result[i].charAt(j) > 57) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sum(String[] result) {
        for(int i=0; i<result.length; i++) {
            this.resultValue += Integer.parseInt(result[i]);
        }
    }

}
