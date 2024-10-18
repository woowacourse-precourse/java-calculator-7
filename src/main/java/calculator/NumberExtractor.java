package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    public static List<Integer> extractNums(String inputStr, String delimiter) {
        String[] str_nums = inputStr.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        for(String str_num : str_nums){
            try{
                int int_num = Integer.parseInt(str_num.trim());
                if (int_num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형태입니다.");
            }
        }
        return numbers;
    }
}
