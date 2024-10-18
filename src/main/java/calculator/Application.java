package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        final String inputSequence = Console.readLine();
        return inputSequence;
    }

    private static String[] parseInput(String inputSequence) {
        String divider = "default";

        if (isCustomDivider(inputSequence)) {
            divider = parseDivider(inputSequence);
            inputSequence = normalizeInput(inputSequence);
        }

        return divideInput(inputSequence, divider);
    }

    private static boolean isCustomDivider(String inputSequence) {
        boolean containsCustom = inputSequence.contains("//") && inputSequence.contains("\\n");
        return containsCustom;
    }

    private static String parseDivider(String inputSequence) {
        int beginIndex = inputSequence.indexOf("//") + 2;
        int endIndex = inputSequence.indexOf("\\n");
        String divider = inputSequence.substring(beginIndex, endIndex);
        return divider;
    }

    private static String normalizeInput(String inputSequence) {
        int dividerIndex = inputSequence.indexOf("\\n") + 2;
        String normalizedInput = inputSequence.substring(dividerIndex, inputSequence.length());
        return normalizedInput;
    }

    private static String[] divideInput(String inputSequence, String divider) {
        if (divider == "default") {
            String[] dividedInput = inputSequence.split(",|:");
            return dividedInput;
        } else {
            String[] dividedInput = inputSequence.split(divider);
            return dividedInput;
        }
    }

    private static int[] convertStringToInt(String[] parsedInput) {
        int arrayLength = parsedInput.length;
        int[] convertedInput = new int[arrayLength];

        if (arrayLength == 0) {
            return convertedInput;
        }

        for (int i = 0; i < arrayLength; i++) {
            try {
                int element = Integer.parseInt(parsedInput[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("파싱할 수 없습니다");
            }

            int element = Integer.parseInt(parsedInput[i]);
            if (element <= 0) {
                throw new IllegalArgumentException("양수가 아닙니다");
            }
            convertedInput[i] = element;
        }
        return convertedInput;
    }

    private static int calculateNumber(int[] convertedInput) {
        int answer = 0;
        for (int element : convertedInput) {
            answer += element;
        }
        return answer;
    }

    private static void showOutput(int answer) {
        System.out.println("결과 : " + answer);
    }

    public static void main(String[] args) {
        String inputSequence = readInput();
        String[] parsedInput = parseInput(inputSequence);
        int[] convertedInput = convertStringToInt(parsedInput);
        final int answer = calculateNumber(convertedInput);
        showOutput(answer);
    }
}
