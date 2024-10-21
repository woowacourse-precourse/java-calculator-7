package calculator;


public class Calculator {

    Validator validator = new Validator();
    Identifier identifier = new Identifier();

    public int calculate(String str) {
        int result = 0;

        if (str.isEmpty()) {
            return result;
        }

        str = identifier.customIdentifierProcess(str); // 커스텀 구분자 처리
        return extractNumbers(str); // 계산된 값을 반환
    }


    public int extractNumbers(String str) {
        return getResult(str.split(Identifier.identifier));
    }

    public int getResult(String[] numbers) {
        int result = 0;
        for (String s : numbers) {
            int num = Integer.parseInt(s);
            validator.negativeCheck(num);
            result += num;
        }
        return result;
    }
}
