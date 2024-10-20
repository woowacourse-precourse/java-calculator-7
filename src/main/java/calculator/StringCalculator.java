package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    String userInput;
    String noBlankInput;
    Matcher userInputForCheck;
    List<String> defaultDividerList = List.of(",", ":");
    String customDivider;
    List<String> dividerList;
    String regexString;
    List<Integer> intNumbers;
    int sum = 0;

    public void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.userInput = Console.readLine();
    }

    public void removeBlank() {
        this.noBlankInput = this.userInput.replaceAll(" ", "");
    }

    public void addCustomDivider() {
        List<String> customDividerList = new ArrayList<>();
        Set<String> duplicationFilter = new LinkedHashSet<>(defaultDividerList);

        this.userInputForCheck = Pattern.compile("//(.+)\\\\n(.*)").matcher(this.noBlankInput);
        if (userInputForCheck.find()) {
            customDivider = userInputForCheck.group(1);
            customDividerList = Arrays.asList(customDivider.split(""));
        }

        if (customDivider != null && customDivider.matches("(.*)[0-9](.*)")) {
            throw new IllegalArgumentException();
        }

        duplicationFilter.addAll(customDividerList);
        dividerList = new ArrayList<>(duplicationFilter);
    }

    public void removeDividerSettings() {
        this.noBlankInput = this.noBlankInput.replaceAll("//(.+)\\\\n", "");
    }

    public void makeStringForSplit() {
        regexString = String.join("|", dividerList);
    }

    public void extractNumbers() {
        List<String> stringNumbers = Arrays.asList(noBlankInput.split(regexString));
        Collections.replaceAll(stringNumbers, "", "0");

        intNumbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            intNumbers.add(Integer.parseInt(stringNumber));
        }
    }

    public void sum() {
        for (int number : intNumbers) {
            sum = sum + number;
        }
    }

    public void printResult() {
        System.out.println("결과 : " + sum);
    }
}