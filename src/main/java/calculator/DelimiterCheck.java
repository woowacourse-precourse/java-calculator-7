package calculator;

public class DelimiterCheck {

    // Application에서 사용자가 입력한 수식에 대해서 구분자만 제외하고 숫자만 추출
    // 잘못 입력된 예외처리 항목에 대해서 해소
    // 커스텀 구분자를 저장, 관리
    String formula = "";
    String delimiter = ",|:";

    public DelimiterCheck(String formula) {
        this.formula = formula;
        getCustomDelimiter();
    }

    public void getCustomDelimiter() {
        //커스텀 구분자 커맨드 입력여부 검증 로직
        if (formula.startsWith("//") && (formula.charAt(3)=='\\') && (formula.charAt(4)=='n')) {
            System.out.println("커스텀으로 넘길때");
            String customDelimiter = Character.toString(formula.charAt(2));
            delimiter = ",|:|" + customDelimiter;
            System.out.println("커스텀 구분자가 " + customDelimiter + " 로 설정되었습니다.");
            // 커맨드 입력 이후의 문자열만 formula로 지정
            formula = formula.substring(5);
            getSplitFormula();
        } else {
            System.out.println("조건 불충족");
            getSplitFormula();
        }
    }

    // String 계산식에서 구분자로 숫자들을 분리
    public String getSplitFormula() {
        System.out.println("입력된 문자열: " + formula); // 중간테스트 (이후 삭제)

        // 분리된 문자열을 splitFormula[] 배열로 저장
        String [] splitFormulaArray = formula.split(delimiter);
        for (int i = 0; i < splitFormulaArray.length; i++) {
            System.out.println(splitFormulaArray[i]); // 제대로 분리되는지 출력하여 테스트
        }
        return "";
    }

}


