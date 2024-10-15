package calculator.model;


public class Calculator {

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
}
