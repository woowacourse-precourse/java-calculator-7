package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private String input;

    public StringCalculator(String input) {
        this.input = input;
    }

    public void calculate() {
        String separator = findSeperator();
        List<Integer> seperatedNums = separateMachine(separator);
        int totalNum = addAllNums(seperatedNums);
    }

    private String findSeperator() {
        // 1차적으로 문자열 맨 앞에 "//" 가 있고, "\n"으로 닫혀있는지 확인하여 어떤 커스텀 구분자를 사용하는지 검출
        if (input.startsWith("//")) {
            return whichCustomSperator(input.substring(2));
        }
        return "defaultSeparator";
    }

    private String whichCustomSperator(String subInput) {
        int newlineIndex = subInput.indexOf("\\n");

        if (newlineIndex == -1) {
            // exception 구현 예정
            throw new IllegalArgumentException("\\n으로 끝나지 않았다는 exception 구현 예정");
        }
        // "\n" 이전까지의 문자열을 커스텀 구분자로 사용
        String customSperator = subInput.substring(0, newlineIndex);

        if (customSperator.isEmpty()) {
            // exception 구현 예정
            throw new IllegalArgumentException("// \\n 사이 구분자가 존재하지 않는다는 exception 구현 예정");
        }

        if (customSperator.length() != 1) {
            // exception 구현 예정
            throw new IllegalArgumentException("// \\n 사이 구분자가 문자가 아닌 문자열이라는 exception 구현 예정");
        }
        return customSperator;
    }

    // 문자를 seperator를 통해 다 나누는 기능
    private List<Integer> separateMachine(String separator) {
        if (separator.equals("defaultSeparator")) {
            return defaultSeperateMachine();
        } else {
            return customSeperateMachine(separator);
        }
    }

    private List<Integer> defaultSeperateMachine() {
        String[] inputSplit = input.split("");
        List<Integer> splitedNums = new ArrayList<>();
        String splitedNum = "";

        // 아무 입력이 없을 경우
        if (input.length() == 0) {
            splitedNums.add(0);
            return splitedNums;
        }
        for (int i = 0; i != input.length(); i++) {
            char charInput = inputSplit[i].charAt(0);
            // 구분자일 경우
            if (charInput == ',' || charInput == ':') {
                // 구분자가 나왔지만 앞에 숫자가 없었을 경우
                if (splitedNum == "") {
                    splitedNums.add(0);
                    continue;
                }
                splitedNums.add(Integer.parseInt(splitedNum));
                splitedNum = "";
                continue;
            }
            // 숫자일 경우
            if (Character.isDigit(charInput)) {
                splitedNum = splitedNum + charInput;
                // 배열의 마지막 번째에 숫자가 나왔을 경우
                if (i == input.length() - 1) {
                    splitedNums.add(Integer.parseInt(splitedNum));
                }
            }
            // 숫자나 기본 구분자가 아닐경우 에러 발생
            else {
                throw new IllegalArgumentException("기본 구분자, 숫자가 아닌 문자가 들어왔다는 에러 구현 예정");
            }
        }
        return splitedNums;
    }

    // 구현 예정
    private List<Integer> customSeperateMachine(String seperator) {
        List<Integer> splitedNums = new ArrayList<>();
        Character seperatorToChar = seperator.charAt(0);
        String splitedNum = "";
        String seperatorRemovedInput = input.substring(5);
        String[] seperatorRemovedInputSplit = seperatorRemovedInput.split("");

        for (int i = 0; i != seperatorRemovedInput.length(); i++) {
            char charInput = seperatorRemovedInputSplit[i].charAt(0);
            // 구분자일 경우
            if (charInput == seperatorToChar) {
                // 구분자가 나왔지만 앞에 숫자가 없었을 경우
                if (splitedNum == "") {
                    splitedNums.add(0);
                    continue;
                }
                splitedNums.add(Integer.parseInt(splitedNum));
                splitedNum = "";
                continue;
            }
            // 숫자일 경우
            if (Character.isDigit(charInput)) {
                splitedNum = splitedNum + charInput;
                // 배열의 마지막 번째에 숫자가 나왔을 경우
                if (i == seperatorRemovedInput.length() - 1) {
                    splitedNums.add(Integer.parseInt(splitedNum));
                }
            }
            // 숫자나 커스텀 구분자가 아닐경우 에러 발생
            else {
                throw new IllegalArgumentException("커스텀 구분자, 숫자가 아닌 문자가 들어왔다는 에러 구현 예정");
            }
        }
        return splitedNums;
    }

    private int addAllNums(List<Integer> seperatedNums) {
        int totalNum = 0;
        for (int i = 0; i != seperatedNums.size(); i++) {
            totalNum += seperatedNums.get(i);
        }
        return totalNum;
    }

}
