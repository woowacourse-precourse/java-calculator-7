package calculator;

import java.util.Arrays;

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
            generateCustomSeparator();

            if(customSeparator1 >= 65 && customSeparator1 <= 90 || customSeparator1 >= 97 && customSeparator1 <= 122) {
                result = inputString.split(":|,|" + customSeparator1);
            } else {
                result = inputString.split(":|,|" + "\\" + customSeparator1);
            }
        }

        System.out.println(Arrays.toString(result));

        if(inspectionValue(result) == true) {
            sum(result);
        } else {
            System.out.println("[result문자열]잘못된 값을 입력하였습니다.");
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

    // 작성 필요
    //*\n1:2,3*4*-4
    public void generateCustomSeparator() {
        if(inputString.length() >= 5) {
            char[] inputArray = inputString.toCharArray();

            // 커스텀 구분자 등록 후 문자열 시작위치 변경
            if(inputArray[0] == '/' && inputArray[1] == '/' && inputArray[3] == '\\' && inputArray[4] == 'n') {
                customSeparator1 = inputArray[2];
            } else {
                System.out.println("[커스텀 구분자 생성]잘못된 값을 입력하였습니다!");
                throw new IllegalArgumentException();
            }
            this.inputString = inputString.substring(5);
        }
    }

    // 작성 필요
    public boolean inspectionValue(String[] result) {
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[i].length(); j++) {
                if(result[i].charAt(j) < 48 || result[i].charAt(j) > 57) {
                    System.out.println("result[" + i + "][" + j + "] = " + result[i].charAt(j));
                    return false;
                }
            }
        }
        return true;
    }

    public void sum(String[] result) {
        System.out.println("커스텀 구분자 = " + customSeparator1 + ", result = " + Arrays.toString(result));
        for(int i=0; i<result.length; i++) {
            this.resultValue += Integer.parseInt(result[i]);
        }
    }

}
