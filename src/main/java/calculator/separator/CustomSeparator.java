package calculator.separator;

public class CustomSeparator implements Separator {

    @Override
    public String[] splitLine(String line) {
        String delimiter = validateLine(line);
        String updatedLine = line.substring(("//" + delimiter + "\\n").length());
        if (updatedLine.equals("")) {
            return null;
        }
        return updatedLine.split(delimiter + "|:|,");
    }

    private String validateLine(String line) {
        if (line.contains("//") && line.contains("\\n")) {
            return line.substring("//".length()).split("\\\\n")[0];
        }
        throw new IllegalArgumentException("입력된 문자열이 올바르지 않습니다.\n커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치해야 합니다.");
    }
}

