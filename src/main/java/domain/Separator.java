package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {
    private final List<String> separatorCollection;

    public Separator(List<String> separatorCollection) {
        this.separatorCollection = new ArrayList<>(separatorCollection);
        defaultSeparator();
    }

    private void defaultSeparator() {
        if (!separatorCollection.contains(",")) {
            separatorCollection.add(",");
        }
        if (!separatorCollection.contains(":")) {
            separatorCollection.add(":");
        }
    }

    public String findAndAddSeparator(String inputString) {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String separator = matcher.group(1);
            if (!separatorCollection.contains(separator)) {
                separatorCollection.add(separator);
            }
            return inputString.substring(matcher.end()).trim();
        }
        return inputString.trim();
    }

    public List<Integer> extractionNumbers(String inputString) {
        List<Integer> numberCollection = new ArrayList<>();

        String regex = separatorCollection.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        String[] parts = inputString.split(regex);

        for (String part : parts) {
            part = part.trim();

            if (!part.isEmpty()) {
                try {
                    int number = Integer.parseInt(part);  // 문자열을 바로 정수로 변환
                    if (number <= 0) {
                        throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
                    }
                    numberCollection.add(number);  // 예외가 발생하지 않으면 숫자 리스트에 추가
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(part + "는 유효한 숫자가 아닙니다.");  // 변환에 실패하면 예외 발생
                }
            }
        }
        return numberCollection;
    }

    public List<String> getSeparatorCollection() {
        return separatorCollection;
    }
}
