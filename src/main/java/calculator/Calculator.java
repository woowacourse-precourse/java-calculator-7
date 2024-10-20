package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String inputString;
    private final List<String> delimiter = new ArrayList<>();
    private final List<Long> numbers = new ArrayList<>();

    public Calculator() {
        this.delimiter.addAll(List.of(":", "."));
        this.inputString = input();
        addCustomDelimiter();
        tokenization();
    }

    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void addCustomDelimiter(){
        String regex =  "//(?<delimiter>.)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.inputString);

        while(matcher.find()) {
            String customDelimiter = matcher.group("delimiter");
            if (!delimiter.contains(customDelimiter)) {
                this.delimiter.add(customDelimiter);
            }
            this.inputString = this.inputString.replace(matcher.group(), "");
        }
    }

    public void tokenization() {
        String[] split = inputString.split(String.valueOf(delimiter));
        for (String s : split) {
            try {
                numbers.add(Long.parseLong(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
        }

        for (Long i : numbers) {
            if (i < 0) {
                throw new IllegalArgumentException("음수는 입력하실 수 없습니다.");
            }
        }
    }

    public long sum(){
        return numbers.stream().mapToLong(i -> i).sum();
    }
}
