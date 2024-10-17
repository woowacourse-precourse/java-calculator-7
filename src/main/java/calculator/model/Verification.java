package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Verification {

    private final List<String> parsedList;
    private final List<Integer> numList = new ArrayList<>();

    public Verification(List<String> parsedList){
        this.parsedList = parsedList;
    }

    public void verifyAndParseNums() {
        parsedList.stream().forEach(num -> {
            try {
                int parsedNum = Integer.parseInt(num);
                if (parsedNum <= 0) {
                    throw new IllegalArgumentException("숫자는 양수여야 합니다!");
                }
                numList.add(parsedNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 들어가있습니다!");
            }
        });
    }
}
