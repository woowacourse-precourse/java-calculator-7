package calculator.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {

    private String line;

    public CustomSeparator(String line) {
        this.line = line;
    }

    @Override
    public String[] splitLine() {
        String delimiter = extractDelimiter();
        String regex = Pattern.quote(delimiter)+"|:|,";
        String[] strings = line.split(regex);
        if (line.isEmpty() || strings.length == 0) {
            return null;
        }
        return strings;
    }

    private String extractDelimiter() {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(line);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            isNumericDelimiter(delimiter);
            line = matcher.group(2);
            return delimiter;
        }
        throw new IllegalArgumentException("입력된 문자열이 올바르지 않습니다.\n"+
                "커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치해야 합니다.");
    }

    private void isNumericDelimiter(String delimiter) {
        try{
            Integer.parseInt(delimiter);
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
        } catch (NumberFormatException ignored){
            // 정상 처리
        }
    }

    // 테스트를 위한 메서드
    public String getLine() {
        return line;
    }

}

