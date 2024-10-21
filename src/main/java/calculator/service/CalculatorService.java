package calculator.service;

public class CalculatorService {
    // @TODO : 입력받은 문자열을 repository에 저장하기
//    private

    private CalculatorService() {
    }

    private static class InnerCalculatorService {

        private static final CalculatorService INSTANCE = new CalculatorService();
    }
    public static CalculatorService getInstance(){
        return InnerCalculatorService.INSTANCE;
    }



    /**
     * 사용자로부터 입력받은 문자열 연산
     * @param userInput
     * @return Integer
     */
    public Integer calcFromString(String userInput) {
        if (userInput.isEmpty()) {
            return 0;
        }



        return Integer.parseInt(userInput);
    }

    /**
     * 기본 구분자 쉼표(,) 또는 콜론(:)이 사용자 입력 문자열에 있는지 확인하는 메소드
     * @param userInput
     * @return Boolean
     */
    public static Boolean containsDefaultDelimiters(String userInput) {
        return userInput.contains(",") || userInput.contains(":");
    }


}
