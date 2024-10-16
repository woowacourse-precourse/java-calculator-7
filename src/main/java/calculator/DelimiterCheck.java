package calculator;

public class DelimiterCheck {

    // Application에서 사용자가 입력한 수식에 대해서 구분자만 제외하고 숫자만 추출
    // 잘못 입력된 예외처리 항목에 대해서 해소
    // 커스텀 구분자를 저장, 관리
    private String formula = "";
    private String delimiter = ",|:";
    private String[] splitFormulaArray;
    private int[] intNumArray;
    private double[] doubleNumArray;

    public DelimiterCheck(String formula) {
        this.formula = formula;
        getCustomDelimiter();
    }

    private void getCustomDelimiter() {
        //커스텀 구분자 커맨드 입력여부 검증 로직
        if (formula.startsWith("//") && (formula.charAt(3)=='\\') && (formula.charAt(4)=='n')) {
            System.out.println("커스텀으로 넘길때"); // 이후 삭제
            String customDelimiter = Character.toString(formula.charAt(2));
            delimiter = ",|:|" + customDelimiter;
            System.out.println("커스텀 구분자가 " + customDelimiter + " 로 설정되었습니다.");
            // 커맨드 입력 이후의 문자열만 formula로 지정
            formula = formula.substring(5);
        }
            getSplitFormula();
    }

    // String 계산식에서 구분자로 숫자들을 분리
    private void getSplitFormula() {
        System.out.println("입력된 문자열: " + formula); // 중간테스트 (이후 삭제)

        // 분리된 문자열을 splitFormula[] 배열로 저장
        splitFormulaArray = formula.split(delimiter);
        for (int i = 0; i < splitFormulaArray.length; i++) {
            System.out.println(splitFormulaArray[i]); // 제대로 분리되는지 출력하여 테스트
        }
        // 다 분리된 문자열 내 실수 검증
        checkFloatingPointNum();
    }

    // 입력된 수들 중에서 실수가 포함되어있는지 점검 후 각 메서드로 보냄
    private void checkFloatingPointNum() {
        if (formula.contains(".")) {
            convertToDoubleArray();
        } else {
            convertToIntArray();
        }

    }

    // String으로 저장되어있는 배열을 int 배열로 변환
    private void convertToIntArray() {
        // 기존 null으로 저장된 배열의 길이를 지정하고, for문 반복으로 배열 저장
        intNumArray = new int[splitFormulaArray.length];
        System.out.println("정수 배열을 출력합니다"); // 검증용
        for (int i = 0; i < splitFormulaArray.length; i++) {
            String beforeConvert = splitFormulaArray[i];
            intNumArray[i] = Integer.parseInt(beforeConvert);
            System.out.println(intNumArray[i]); // 검증용
        }
    }

    // String으로 저장되어있는 배열을 Double 배열로 변환
    private void convertToDoubleArray() {
        // 기존 null으로 저장된 배열의 길이를 지정하고, for문 반복으로 배열 저장
        doubleNumArray = new double[splitFormulaArray.length];
        System.out.println("실수 배열을 출력합니다"); // 검증용
        for (int i = 0; i < splitFormulaArray.length; i++) {
            String beforeConvert = splitFormulaArray[i];
            doubleNumArray[i] = Double.parseDouble(beforeConvert);
            System.out.println(doubleNumArray[i]); // 검증용
        }
    }

}


