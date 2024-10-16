package calculator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    protected Validator() {
    }

    public static Validator of() {
        return new Validator();
    }

    public Boolean validDelimiters(String inputData) {
        return inputData.contains("//");
    }

    public void isNullDelimiters(List<String> splitSlash) {
        if(splitSlash.size() != 4 || splitSlash.get(2).isEmpty()) {
            throw new IllegalStateException("입력이 잘못되었습니다. 다시 입력해주세요.\n");
        }
    }

    public List<Integer> tryParseInteger(List<String> stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        stringNumbers.forEach(oneNumber -> {
            try {
                numbers.add(Integer.parseInt(oneNumber));
            } catch(NumberFormatException e) {
                throw new IllegalStateException("숫자만 입력해주세요.");
            }
        });
        return numbers;
    }
}
