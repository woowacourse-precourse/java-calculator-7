package calculator.controller;

import calculator.model.Numbers;
import calculator.model.Separator;
import calculator.service.Service;
import calculator.validation.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Service service = new Service();
    Numbers numbers;

    public void start(){
        setNumbersSepartorProcess();
        plusProcess();
    }

    private void setNumbersSepartorProcess(){
        String input = inputView.getString();
        Validator.validateNull(input);

        Separator separator = service.setSeparator(",:");

        if(input.startsWith("//")){
            int end = input.indexOf("\\n");
            String newSeparator = input.substring(2, end);
            Validator.validateSeparator(newSeparator);
            service.addSeparator(separator, newSeparator);
            input = input.substring(end+2);
        }

        String[] nums = input.split(separator.getSeparators());
        ArrayList<Integer> numsInt = new ArrayList<>();
        for (String i : nums){
            try{
                Validator.validateNull(i);
            }
            catch (IllegalArgumentException e){
                continue;
            }
            Validator.validateDigit(i);

            int n = Integer.parseInt(i);
            numsInt.add(n);
        }
        numbers = service.setNumbers(numsInt);
    }
    private void plusProcess(){
        int sum = 0;
        for (int i : numbers.getNumbers()) {
            sum += i;
        }
        outputView.printResult(sum);
    }
}
