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

}
