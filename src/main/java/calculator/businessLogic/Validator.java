package calculator.businessLogic;

import calculator.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static calculator.message.Message.구분자시작;
import static calculator.message.Message.구분자인덱스;
import static calculator.message.Message.구분자크기;
import static calculator.message.Message.음수확인;

public class Validator {

    protected Validator() {
    }

    public static Validator of() {
        return new Validator();
    }

    public Boolean validDelimiters(String inputData) {
        return inputData.contains(구분자시작);
    }

    public void isNullDelimiters(List<String> splitSlash) {
        if(splitSlash.size() != 구분자크기 || splitSlash.get(구분자인덱스).isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.구분자입력에러메시지.getMessage());
        }
    }

    public List<Integer> tryParseInteger(List<String> stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        stringNumbers.forEach(oneNumber -> {
            try {
                numbers.add(isPositiveInt(oneNumber));
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.숫자입력에러메시지.getMessage());
            }
        });
        return numbers;
    }

    private Integer isPositiveInt(String oneNumber) {
        int num = Integer.parseInt(oneNumber);
        if(num < 음수확인) {
            throw new IllegalArgumentException(ErrorMessage.음수입력에러메시지.getMessage());
        }
        return num;
    }
}
