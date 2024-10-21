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
     * @return
     */
    public Integer calcFromString(String userInput) {
        if (userInput.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(userInput);
    }


}
