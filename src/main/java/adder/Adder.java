package adder;

import java.util.ArrayList;
import java.util.Stack;
import separator.Separator;

public class Adder {

    public int add(String stringToCalculate) {

        ArrayList<String> parsedStringWithSeparators
                = parseStringWithSeparators(stringToCalculate);

        if (!isValidated(parsedStringWithSeparators)) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> numbers = parseOnlyNumbers(parsedStringWithSeparators);

        if (!isAllPositiveInteger(numbers)) {
            throw new IllegalArgumentException();
        }

        return addNumbers(numbers);
    }

    public Integer addNumbers(ArrayList<Integer> numbers) {

        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private boolean isSeparator(String e) {

        for (char separator : Separator.separators) {
            if (e.equals(String.valueOf(separator))) {
                return true;
            }
        }

        return false;
    }

    public boolean isNumber(String number) {

        try {
            Integer.parseInt(number);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isAllPositiveInteger(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> parseStringWithSeparators(String calculationFormula) {

        ArrayList<String> parsedString = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < calculationFormula.length(); i++) {

            char element = calculationFormula.charAt(i);
            String separator = String.valueOf(element);

            if (isSeparator(separator)) {
                if (!number.isEmpty()) {
                    parsedString.add(number.toString());
                    number = new StringBuilder();
                }

                parsedString.add(separator);
                continue;
            }

            number.append(element);
        }
        parsedString.add(number.toString());

        return parsedString;
    }

    public boolean isValidated(ArrayList<String> calculationFormula) {
        Stack<String> numberStack = new Stack<>();

        for (String element : calculationFormula) {
            if (isNumber(element)) {
                numberStack.push(element);

            } else if (isSeparator(element)) {
                if (numberStack.isEmpty()) {
                    return false;
                }

                numberStack.pop();

            } else {
                return false;
            }
        }

        if (numberStack.isEmpty()) {
            return false;
        }
        return true;
    }

    public ArrayList<Integer> parseOnlyNumbers(ArrayList<String> calculationFormula) {
        if (!isValidated(calculationFormula)) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String element : calculationFormula) {
            if (isNumber(element) && !isSeparator(element)) {
                int number = Integer.parseInt(element);
                numbers.add(number);
            }
        }

        return numbers;
    }


}
