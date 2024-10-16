package calculator;

public class  Calculator {
    private String defaultDelimiter = "[,:]";

    public int calculate(String input){

        //입력값에 따른 분기 처리
        switch (input.length()){

            //입력값이 없을 경우
            case 0: return 0;
            //입력값이 한개일 경우
            case 1: return Integer.parseInt(input);
            //입력값이 하나 이상인 경우

            default:
                //입력값에 기본 구분자가 있을 경우
                if (isDefaultDelimiter(input)) {
                    String[] splitedString = input.split(defaultDelimiter);
                    validateNegativeNumber(splitedString);
                    int sum = 0;
                    for (String numberStr : splitedString) {
                        if (!numberStr.trim().isEmpty()) {
                            sum += Integer.parseInt(numberStr.trim());
                        }
                    }
                    return sum;
                }
                //입력값의 구분자가 커스텀 구분자일 경우
                if (!isDefaultDelimiter(input)) {
                    String replaceInput = input.replace("//", "").replace("\\n", "").trim();
                    String customDelimiter = replaceInput.substring(0, 1);
                    String[] numbers = replaceInput.substring(1).split(customDelimiter);
                    int sum = 0;

                    for (String numberStr : numbers) {
                        sum += Integer.parseInt(numberStr.trim());
                    }
                    return sum;
                }
        }
        return 0;
    }

    private boolean isDefaultDelimiter(String input) {
        String[] splitedString = input.split(defaultDelimiter);
        try {
            Integer.parseInt(splitedString[0]);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    private static void validateNegativeNumber(String[] splitedString) {
        for (String numberStr : splitedString) {
            if (Integer.parseInt(numberStr.trim()) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
