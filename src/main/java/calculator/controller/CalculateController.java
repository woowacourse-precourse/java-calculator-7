package calculator.controller;

import calculator.constant.ValidConstants;
import calculator.model.Numbers;
import calculator.model.Separator;
import calculator.service.CalculateService;
import calculator.service.SplitService;
import calculator.validator.InputValid;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculateController {
    private Separator sep;
    private Numbers num;
    private CalculateService calculateService;
    private SplitService splitService;

    public CalculateController() {
        this.sep = new Separator();
        this.num = new Numbers();
        this.calculateService = new CalculateService();
        this.splitService = new SplitService();
    }

    public String process(String input){
        InputValid.checkStringLength(input);

        String numbers = input;

        if(InputValid.isValidCustomSeparatorFormat(input)){
            String[] splitStr = splitService.extractCustomSeparatorAndNumbers(input);
            numbers = splitStr[1];
            String separator = splitStr[0];
            sep.registerSeparator(separator);
        }

        List<String> numbersList = splitService.splitNumber(sep, numbers);
        InputValid.checkNumberCount(numbersList.size());
        numbersList.forEach(num::addNumber);

        return calculateService.calculate(num.getNumbers());
    }




}
