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
            throw new IllegalArgumentException("입력이 잘못되었습니다. 다시 입력해주세요.\n");
        }
    }

    public List<Integer> tryParseInteger(List<String> stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        stringNumbers.forEach(oneNumber -> {
            try {
                numbers.add(isPositiveInt(oneNumber));
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        });
        return numbers;
    }

    private Integer isPositiveInt(String oneNumber) {
        int num = Integer.parseInt(oneNumber);
        if(num < 0) {
            throw new IllegalArgumentException("음수는 입력되면 안됩니다.");
        }
        return num;
    }
}
