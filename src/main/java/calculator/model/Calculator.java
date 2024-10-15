package calculator.model;


public class Calculator {

    /**
     * 수식을 입력받아 덧셈을 진행합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 덧셈 결과
     */
    public Integer add(String input){
        if (isEmpty(input)) return 0;


        if (checkCustomSeparator(input)){
            String customSeparator = getCustomSeparator(input);
            String newCalculation = processCustomSeparator(input, customSeparator);
            return calculate(parseCustomSeparator(newCalculation));
        }
        return calculate(parseCustomSeparator(input));
    }


    /**
     * 입력 받은 수식이 커스텀 구분자를 포함하고 있는지 확인합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 커스텀 구분자를 포함하면 true, 아니면 false
     */
    private boolean checkCustomSeparator(String input){
        return input.startsWith("//");
    }

    /**
     * 커스텀 구분자 입력 시, 수식과 커스텀 구분자를 2개의 부분으로 분리합니다.
     * @param input 입력 받은 기존 상태의 수식
     * @return 분리된 수식
     */
    private String[] getParts(String input) {
        return input.split("\n");
    }

    /**
     * 커스텀 구분자를 가져옵니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 커스텀 구분자
     */
    private String getCustomSeparator(String input){
        String[] parts = getParts(input);
        return parts[0].substring(2);
    }

    /**
     * 커스텀 구분자를 정규 구분자인 ","로 변환합니다.
     * @param input 입력 받은 기존 상태의 수식
     * @return 변환된 수식
     */
    private String processCustomSeparator(String input, String customSeparator){
        String[] parts = getParts(input);
        return parts[1].replace(customSeparator, ",");
    }

    /**
     * 정규 구분자만 포함되어 있는 식을 정규 구분자를 기준으로 숫자만 파싱합니다.
     * @param input 정규 구분자만 포함된 수식
     * @return 수식에 포함된 숫자
     */
    private String[] parseCustomSeparator(String input){
        return input.split(",|;");
    }

    /**
     * 파싱이 된 수식을 통해 덧셈을 계산합니다.
     * @param numbers 파싱된 문자열 타입의 숫자들
     * @return 수들의 합
     */
    private Integer calculate(String[] numbers){
        int result = 0;
        for (String num : numbers){
            result += Integer.parseInt(num);
        }
        return result;
    }

    /*---------------------- 검증 로직 ----------------------*/

    /**
     * 입력값이 비어있는지 확인합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 입력값이 비어있으면 true, 아니면 false
     * @throws IllegalArgumentException 입력값이 비어있는 경우 예외 발생
     */
    private boolean isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        return false; // 비어있지 않으면 false 반환
    }

    /**
     * 입력값에 음수가 존재하는지 확인합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 입력값이 음수이면 true
     * @throws IllegalArgumentException 음수가 존재할 경우 예외 발생
     */
    private boolean isNegative(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return false; // 음수가 없으면 false 반환
    }

    /**
     * 입력값에 숫자가 아닌 문자가 존재하는지 확인합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 입력값에 숫자가 아닌 문자가 존재하면 true
     * @throws IllegalArgumentException 숫자 이외의 문자가 존재할 경우 예외 발생
     */
    private boolean isNotNumber(String input) {
        if (input.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("숫자 이외의 문자는 입력할 수 없습니다.");
        }
        return false; // 숫자만 존재하면 false 반환
    }

    /**
     * 커스텀 구분자가 정확히 입력되었는지 확인합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 커스텀 구분자가 정확히 입력되었으면 true
     * @throws IllegalArgumentException 커스텀 구분자가 정확히 입력되지 않았을 경우 예외 발생
     */
    private boolean isValidCustomDelimiterFormat(String input) {
        if (!input.matches("//.\n.*")) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        return true; // 형식이 올바르면 true 반환
    }

    /**
     * 지정된 구분자 외의 문자가 포함되었는지 확인합니다.
     * @param input 사용자에게 입력 받은 수식
     * @return 지정된 구분자 외의 문자가 포함되지 않은 경우 false
     * @throws IllegalArgumentException 지정된 구분자 외의 문자가 포함되었을 경우 예외 발생
     */
    private boolean isInvalidDelimiter(String input) {
        if (input.matches(".*[^0-9,;].*")) {
            throw new IllegalArgumentException("지정된 구분자 외의 문자는 입력할 수 없습니다.");
        }
        return false; // 지정된 구분자만 있으면 false 반환
    }

}
