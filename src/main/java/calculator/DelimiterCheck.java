package calculator;

import java.util.StringTokenizer;

public class DelimiterCheck {

    // Application에서 사용자가 입력한 수식에 대해서 구분자만 제외하고 숫자만 추출
    // 잘못 입력된 예외처리 항목에 대해서 해소
    // 커스텀 구분자를 저장, 관리
    private String inputString = "";
    private String delimiter = ",|:";
    private String[] splitFormulaArray;
    private int[] intNumArray;
    private double[] doubleNumArray;

    public DelimiterCheck(String inputString) {
        this.inputString = inputString;
        getCustomDelimiter();
    }

    //커스텀 구분자 커맨드 입력여부 검증 로직
    private void getCustomDelimiter() {
        if (inputString.startsWith("//") && (inputString.indexOf("\\n",3)!= -1)) {
            String customDelimiter = Character.toString(inputString.charAt(2));
            // 커스텀 문자열로 사용할 수 없는 문자들 예외처리
//            if (customDelimiter.equals(" ") || customDelimiter.equals(".") || customDelimiter.equals("-")) {
//                throw new IllegalAccessException();
//            }
            delimiter = ",|:|" + customDelimiter;
            // 커맨드 입력 이후의 문자열만 inputString 지정
            inputString = inputString.substring(inputString.indexOf("\\n")+2);
        }
        getSplitFormula();
    }

    // String 계산식에서 구분자로 숫자들을 분리
    private void getSplitFormula() {
        // 분리된 문자열을 splitFormula[] 배열로 저장, 추가) trim()으로 공백문자 지워줌
        inputString = inputString.replaceAll(" ", "");

        // 구분자 없이 하나만 입력되었을 때 하나의 배열로만 입력
        splitFormulaArray = inputString.trim().split("\\s*"+delimiter+"\\s*");

        for (int i = 0; i < splitFormulaArray.length; i++) {
            if (splitFormulaArray[i].isBlank()) {
                splitFormulaArray[i] = "0";
            }
//            String afterTrimBlank = splitFormulaArray[i].trim().replace("\r\n","");
//            splitFormulaArray[i] = afterTrimBlank;
        }
        checkFloatingPointNum();
    }


    // 입력된 수들 중에서 실수가 포함되어있는지 점검 후 각 메서드로 보냄
    private void checkFloatingPointNum() {
        if (inputString.contains(".")) {
            convertToDoubleArray();
        } else {
            convertToIntArray();
        }
    }

    // String으로 저장되어있는 배열을 int 배열로 변환
    private void convertToIntArray() {
        // 기존 null으로 저장된 배열의 길이를 지정하고, for문 반복으로 배열 저장
        intNumArray = new int[splitFormulaArray.length];
        for (int i = 0; i < splitFormulaArray.length; i++) {
            String beforeConvert = splitFormulaArray[i];
            intNumArray[i] = Integer.parseInt(beforeConvert);
        }

    }

    // String으로 저장되어있는 배열을 Double 배열로 변환
    private void convertToDoubleArray() {
        // 기존 null으로 저장된 배열의 길이를 지정하고, for문 반복으로 배열 저장
        doubleNumArray = new double[splitFormulaArray.length];
        for (int i = 0; i < splitFormulaArray.length; i++) {
            String beforeConvert = splitFormulaArray[i];
            doubleNumArray[i] = Double.parseDouble(beforeConvert);
        }
    }

    // 저장된 배열을 계산기에서 메서드로 호출
    public double[] getDoubleNumArray() {
        return doubleNumArray;
    }

    public int[] getIntNumArray() {
        return intNumArray;
    }
}


