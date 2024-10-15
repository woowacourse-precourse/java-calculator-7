package calculator.view;

import calculator.model.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.Constant.INPUT_NUMBER_MESSAGE;

public class InputView {
    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public String[] inputCalculateNumber() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        String inputNumber = trimInputNumber(Console.readLine());

        if (inputNumber.isEmpty()) {
            return new String[]{"0"};
        }
        String[] splitNumber = splitInputNumber(inputNumber);

        validator.validateInputNumber(splitNumber);

        return splitNumber;
    }

    private String trimInputNumber(String inputNumber) {
        return inputNumber.trim();
    }

    private String[] splitInputNumber(String input) {
        String divisionNumber = ",|:";
        String numbersPart = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.matches()) {
                divisionNumber = Pattern.quote(matcher.group(1));
                numbersPart = matcher.group(2);
            }
        }
        return numbersPart.split(divisionNumber);
    }


}
