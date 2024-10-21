package calculator;

public class Splitter {
    private String inputString;
    private String[] resultArray;
    private int resultValue = 0;
    private char customSeparator;

    // 생성자
    public Splitter(String inputString){
        this.inputString = inputString;
    }

    // 결과 값 출력
    public void printResult() {
        System.out.println("결과 : " + resultValue);
    }

    public void calculate() {
        if(isNum(inputString.charAt(0))) { // 문자열 시작 : 숫자
            resultArray = inputString.split(":|,");
        } else { // 문자열 시작 : 문자
            // 커스텀 구분자 있으면 추가
            generateCustomSeparator();

            // 기본 + 커스텀 구분자를 이용한 Split
            if(customSeparator >= 65 && customSeparator <= 90 || customSeparator >= 97 && customSeparator <= 122) {
                resultArray = inputString.split(":|,|" + customSeparator);
            } else {
                resultArray = inputString.split(":|,|\\" + customSeparator);
            }
        }

        // 생성된 resultArray 의 값이 유효하면 합계 계산, 유효하지 않으면 에러 발생 후 프로그램 종료
        if(inspectionValue(resultArray)) {
            sum(resultArray);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNum(int num) {
        return num > 47 && num < 58;
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
        for(String iter : result) {
            for(int i = 0; i < iter.length(); i++) {
                if(iter.charAt(i) < 48 || iter.charAt(i) > 57) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sum(String[] result) {
        for(String iter : result) {
            resultValue += Integer.parseInt(iter);
        }
    }

}
