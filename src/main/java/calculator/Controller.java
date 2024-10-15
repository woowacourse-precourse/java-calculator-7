package calculator;


import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private static final int INITIAL_NUMBER = 0;
    private static final int STRING_LAST_INDEX = 2;
    private static final String START_CUSTOM_SEPARATE = "//";
    private static final String END_CUSTOM_SEPARATE = "\\n";
    private static final String CUSTOM_SEPARATE_ADD = "|";
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";
    private static final String BLANK_STRING = "";

    private static String REGEX = ",|:";


    public void run(){
        String input = input();
        Integer sum = calc(input);
        output(sum);
    }


    private String input(){
        System.out.println(INPUT_MESSAGE);
        String inputField = readLine();
        return checkCustomSeparator(inputField);
    }

    private Integer calc(String input){
        List<Integer> intList = parseToIntList(input);
        return intList.isEmpty() ? INITIAL_NUMBER : null; //todo. TESTCODE
    }

    private void output(Integer result){
        System.out.print(OUTPUT_MESSAGE + result);
    }

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

    private String checkCustomSeparator(String input){
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
