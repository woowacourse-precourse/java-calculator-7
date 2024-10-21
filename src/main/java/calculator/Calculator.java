package calculator;

public class Calculator {
    public int add() {
        return 0;  // 인자가 없는 경우 0 반환
    }
    // Split numbers using the default delimiters and calculate
    public int add (String input){
        String delimiter = ",|:";
        //공백 문자 처리
        if(input.isEmpty()){
            return 0;
        }
        // 커스텀 구분자 처리
        if(input.startsWith("//")){
            input = input.replace("\\n","\n");
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 1);
            }else{
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
        }

        String[] numbers = input.split(delimiter);

        return calculate(numbers);
    }


    private int calculate(String[] numbers){
        int sum =0;
        for(String number : numbers){
            int num = validateAndParse(number);
            sum +=num;
        }
        return sum;
    }

    // 유효성 검사 및 숫자 변환
    private int validateAndParse(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다");
        }
    }
}
