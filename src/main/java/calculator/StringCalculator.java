package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.userInput = Console.readLine();
        System.out.println("사용자 입력값 : " + this.userInput); //메서드 기능 점검용 코드 - 추후 삭제
    }

    public void removeBlank() {
        this.noBlankInput = this.userInput.replaceAll(" ", "");
        System.out.println("공백 제거된 사용자 입력값: " + this.noBlankInput); //메서드 기능 점검용 코드
    }

    public void addCustomDivider() {
        List<String> customDividerList = new ArrayList<>();
        Set<String> duplicationFilter = new LinkedHashSet<>(defaultDividerList);

        this.userInputForCheck = Pattern.compile("//(.+)\\\\n(.*)").matcher(this.noBlankInput);

        if (userInputForCheck.find()) {
            customDivider = userInputForCheck.group(1);
            customDividerList = Arrays.asList(customDivider.split(""));
        }
        System.out.println("커스텀 구분자 리스트: " + customDividerList); //메서드 기능 점검용 코드

        duplicationFilter.addAll(customDividerList);
        dividerList = new ArrayList<>(duplicationFilter);

        System.out.println("최종 구분자 리스트: " + dividerList); //메서드 기능 점검용 코드
    }

    public void removeDividerSettings() {
        this.noBlankInput = this.noBlankInput.replaceAll("//(.+)\\\\n", "");
        System.out.println("구분자 지정 문구 제거된 문자열 : " + noBlankInput); //메서드 기능 점검용 코드
    }

    public void makeStringForSplit() {
        regexString = String.join("|", dividerList);
        System.out.println("구분자 정규식 문자열 : " + regexString); //메서드 기능 점검용 코드
    }
}