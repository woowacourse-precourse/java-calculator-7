package calculator.controller;


import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Process {

    private final InputView inputView = new InputView();
    private String userInput;
    private List<Character> basicSeparator = new ArrayList<>(Arrays.asList(':', ','));
    OutputView outputView = new OutputView();

    public void run() {

        userInput = inputView.getInput();
        if (isSeparator()) {
            String newSeparator = findSeparator();
            addStringToCharList(newSeparator);
        }
        String number = splitString();
        outputView.printResult(calculateSum(number));
    }

    public boolean isSeparator() {
        return userInput.startsWith("//") && userInput.contains("\\n");
    }

    public String findSeparator() {
        int startIndex = 2;
        int endIndex = userInput.lastIndexOf("\\n");
        return userInput.substring(startIndex, endIndex);
    }

    public void addStringToCharList(String separator) {
        for (int i = 0; i < separator.length(); i++) {
            basicSeparator.add(separator.charAt(i));
        }
    }

    public String splitString() {
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            int index = userInput.lastIndexOf("\\n");
            return userInput.substring(index + 2);
        }
        return userInput;
    }

    public int calculateSum(String number) {
        String result = "";
        int num = 0;
        boolean lastCharFlag = false;
        for (char ch : number.toCharArray()) {
            if (Character.isDigit(ch)) {
                result += ch;
                lastCharFlag = false;
            } else if (lastCharFlag) {
                throw new IllegalArgumentException("구분자가 연속으로 존재합니다.");

            } else if (basicSeparator.contains(ch)) {
                if (!result.isEmpty()) {
                    num += Integer.parseInt(result);
                    result = "";

                    lastCharFlag = true;
                }
            } else if (!basicSeparator.contains(ch)) {
                throw new IllegalArgumentException("잘못된 구분자가 포함되어 있습니다.");
            }
        }

        if (!result.isEmpty()) {
            num += Integer.parseInt(result);
        }

        return num;
    }
}
