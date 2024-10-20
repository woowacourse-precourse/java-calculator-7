package calculator.input;


import calculator.input.error.InputErrorController;
import calculator.input.error.InputErrorType;
import calculator.staticValue.StaticValue;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    private static final Input input = new Input();

    public static void printStartCalculatorMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static String getInputString() {
        return Console.readLine();
    }


    public boolean hasEmptyInput(String inputString) {
        return inputString.isEmpty();
    }


    public boolean hasParticularValue(String inputString, String regex) {
        return createMatcher(inputString, regex).find();
    }

    private Matcher createMatcher(String inputString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(inputString);
    }

    public Matcher findCustomizedSeparator(String inputString) {
        Matcher matcher = createMatcher(inputString, StaticValue.CUSTOM_SEPARATOR_REGEX.getValue());

        if (matcher.find()) {
            return matcher;
        } else {
            throw new InputErrorController(InputErrorType.CANT_FIND_CUSTOM_SEPARATOR);
        }
    }


    public void checkInputAvailable(String[] inputNumber) {

        for (String s : inputNumber) {
            checkInvalidCharacters(s);
        }

        checkIfContainsDash(inputNumber);

        if (!hasNumber(inputNumber)) {
            if (inputNumber.length == 0 | inputNumber[0].isEmpty()) {
                return;
            }
            throw new InputErrorController(InputErrorType.NEED_POSITIVE_NUMBER);
        }

    }


    private void checkInvalidCharacters(String inputString) {
        if (input.hasParticularValue(inputString,
                StaticValue.INVALID_CHAR_REGEX.getValue())) {
            throw new InputErrorController(InputErrorType.NEED_NUMBER_OR_SEPARATOR);
        }
    }

    private boolean hasNumber(String[] inputNumbers) {
        for (String number : inputNumbers) {

            if (!input.hasParticularValue(number, StaticValue.POSITIVE_NUMBER_REGEX.getValue())) {
                System.out.println("내가 진짜 범인: " + number);
                return false;
            }

        }
        return true;
    }

    private void checkIfContainsDash(String inputString[]) {
        for (String inputCharacter : inputString) {
            if (inputCharacter.contains("-")) {
                throw new InputErrorController(InputErrorType.NEED_POSITIVE_NUMBER);
            }
        }
    }


}
