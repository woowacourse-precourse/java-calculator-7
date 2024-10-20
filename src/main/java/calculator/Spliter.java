package calculator;

public class Spliter {
    private String inputString;
    private char customSeparator1;
    private int resultValue = 0;

    public Spliter(String inputString){
        this.inputString = inputString;
    }

    public int getResultValue() {
        return resultValue;
    }

    public void calculate() {
        String[] result;

        // 커스텀 구분자 있으면 추가
        if(isNum(inputString.charAt(0))) { // 문자열 시작이 숫자이면
            result = inputString.split(":|,");
        } else { // 문자열 시작이 문자이면
            // 커스텀 구분자를 추출하여 문자열 Split

        }

    }

    public boolean isNum(int num) {
        if(num > 47 && num < 58) {
            return true;
        } else {
            return false;
        }
    }
}
