package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        CalculatorInput calculationInput = readCalculatorInputByKeyboard();
        int calculatorResult = addAll(calculationInput.getOperands());
        printCalculatorOutput(calculatorResult);
    }

    private static CalculatorInput readCalculatorInputByKeyboard() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        return new CalculatorInput(inputString);
    }

    private static int addAll(List<Integer> operands) {
        return operands.stream().mapToInt(operand -> operand).sum();
    }

    private static void printCalculatorOutput(int calculatorResult) {
        System.out.println("결과 : " + calculatorResult);
    }

    private static class CalculatorInput {

        private final String BASE_OPERANDS_SEPARATOR = "[,:]";

        private List<Integer> operands;

        public CalculatorInput(String inputString) {
            Optional<Character> customSeparatorOptional = findCustomSeparator(inputString);
            if (customSeparatorOptional.isPresent()) {
                String operandString = inputString.substring(5);
                char customSeparator = customSeparatorOptional.get();
                this.operands = findOperands(operandString, customSeparator);
            } else {
                this.operands = findOperands(inputString);
            }
        }

        private Optional<Character> findCustomSeparator(String inputString) {
            if (inputString.length() < 6) {
                return Optional.empty();
            }
            String header = inputString.substring(0, 5);
            if (header.startsWith("//") && header.endsWith("\\n")) {
                return Optional.of(inputString.substring(2, 3).charAt(0));
            } else {
                return Optional.empty();
            }
        }

        private List<Integer> findOperands(String operandString) {
            try {
                List<String> operands = List.of(operandString.split(BASE_OPERANDS_SEPARATOR));
                return operands.stream().map(this::makeStringToOperand).toList();
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("숫자가 아닌 데이터나 너무 큰 값이 피연산자로 입력되었습니다.");
            }
        }

        private List<Integer> findOperands(String operandString, char customSeparator) {
            try {
                List<String> operands = List.of(operandString.split(BASE_OPERANDS_SEPARATOR + "|" + customSeparator));
                return operands.stream().map(this::makeStringToOperand).toList();
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("숫자가 아닌 데이터나 너무 큰 값이 피연산자로 입력되었습니다.");
            }
        }

        private int makeStringToOperand(String target) {
            if (target.startsWith("-")) {
                throw new NumberFormatException();
            }
            return Integer.parseInt(target);
        }

        public List<Integer> getOperands() {
            return this.operands;
        }

    }
}