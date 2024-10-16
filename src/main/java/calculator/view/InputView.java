package calculator.view;


import calculator.domain.Seperator;
import calculator.exception.ManyGroupException;

import calculator.validation.MinusValidator;
import calculator.validation.NumberValidator;
import calculator.validation.validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputView {


    public static void enterInput(){
        String input= Console.readLine();
        validator.validateUserInput(input);
    }








}
