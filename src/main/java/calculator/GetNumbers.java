package calculator;

import java.util.ArrayList;
import java.util.List;

public class GetNumbers {
    // 2. 기본 구분자(, :)를 기준으로 숫자 추출
    public List<Integer> extractNumbers(String input) {
        String[] tokens = input.split("[,:]");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            // 숫자로 변환 후 리스트에 추가
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }
}
