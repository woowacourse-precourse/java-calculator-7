package calculator.validation;

import calculator.domain.Seperator;
import calculator.exception.ManyGroupException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validator {

    public static void validateUserInput(String input){

        checkCustomAtFirst(input);



    }
    // // \n이 가장 처음에 하나만 존재한다
    private static void checkCustomAtFirst(String input) {
        Pattern pattern= Pattern.compile("^//(.)\\\\n{1}");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find() || matcher.groupCount()>=2){ // // \n이 존재하지 않거나 존재하지만 조건을 만족하지 않는다
            checkPatternExist(input);
        }
        else{
            String customSperator=matcher.group(1);
            checkCustomSeperator(customSperator);


        }

    }

    //중간에 구분자가 존재하면 exception 발생
    private static void checkPatternExist(String input) {
        Pattern pattern= Pattern.compile("^//(.*)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()){
            throw new ManyGroupException("구분자가 제일 앞에 들어가지 않았습니다");
        }

    }

    // 커스텀 표식이 있는 경우, 구분자에 - 을 입력한 경우 | 구분자에 숫자를 입력한 경우를 확인한다 |  // \n이 제일 앞에 있지 않는 경우
    private static void checkCustomSeperator(String customSeperator) {

        Pattern pattern= Pattern.compile("//(.*)\\\\n");

        //마이너스 입력한경우 예외를 던진다

        MinusValidator.isMinusSeperator(customSeperator);
        //숫자 입력한 경우 예외를 던진다
        NumberValidator.isNumberSeperator(customSeperator);

        //구분자를 추가한다
        Seperator.addSeperator(customSeperator);

    }
}
