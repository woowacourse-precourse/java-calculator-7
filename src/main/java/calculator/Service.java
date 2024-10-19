package calculator;

import java.util.Arrays;
import java.util.List;

public class Service {
    private static final int INITIAL_NUMBER = 0;
    private static final int STRING_LAST_INDEX = 2;
    private static final String BLANK_STRING = "";
    private static final String START_CUSTOM_SEPARATE = "//";
    private static final String END_CUSTOM_SEPARATE = "\\n";
    private static final String CUSTOM_SEPARATE_ADD = "|";
    private static String REGEX = ",|:";


    public Integer calc(String input){
        List<Integer> intList = parseToIntList(input);
        return intList.isEmpty() ? INITIAL_NUMBER : getIntListSum(intList);
    }


    /*
        parseToIntList : 커스텀 분리자를 정제한 문자열 input을 List<Integer> 형태로 변환합니다.
     */
    private List<Integer> parseToIntList(String input){
        if(input == BLANK_STRING) {
            return List.of();
        }

        return Arrays.stream(input.split(REGEX))
                .map(number -> {
                    try {
                        Integer num = Integer.parseInt(number);
                        if(num<=INITIAL_NUMBER)
                            throw new IllegalArgumentException();
                    } catch (IllegalArgumentException e){
                        throw new IllegalArgumentException(e);
                    }
                    return Integer.parseInt(number);
                })
                .toList();
    }

    /*
        getIntListSum : List<Integer> 인자를 받아서 Sum을 반환합니다.
     */
    private Integer getIntListSum(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(number -> number.intValue()).sum();
    }

    /*
        checkCustomSeparator : 커스텀 분리자를 검사해서 REGEX에 등록하고, 나머지 문자열만 반환합니다.
     */
    public String checkCustomSeparator(String input){
        if(input.startsWith(START_CUSTOM_SEPARATE) && input.contains(END_CUSTOM_SEPARATE)) {
            try {
                int begin = input.indexOf(START_CUSTOM_SEPARATE);
                int end = input.lastIndexOf(END_CUSTOM_SEPARATE);

                String customSeparator = input.substring(begin + STRING_LAST_INDEX, end);
                REGEX = REGEX + CUSTOM_SEPARATE_ADD + customSeparator;

                input = input.substring(end + STRING_LAST_INDEX);
            }
            catch(IllegalArgumentException e){
                throw new IllegalArgumentException(e);
            }
        }

        return input;
    }
}
