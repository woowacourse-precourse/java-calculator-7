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
}
