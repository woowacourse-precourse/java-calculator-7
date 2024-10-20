package calculator.util;

import java.util.ArrayList;
import java.util.List;
import static calculator.constant.ExceptionMessage.*;

public class NumberExtractor {
    public static List<Integer> extractNums(String inputStr, String delimiter) {
        String[] str_nums = inputStr.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        for(String str_num : str_nums){
            try{
                int int_num = Integer.parseInt(str_num.trim());
                if (int_num < 0) {
                    throw new IllegalArgumentException(UNDER_ZERO_NOT_ALLOW);
                }
                numbers.add(int_num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
            }
        }
        return numbers;
    }
}
