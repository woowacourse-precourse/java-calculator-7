package input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputString;

    private String[] separators = new String[]{",", ":"};
    private String customSeparator = null;

    private Vector<Integer> extractedNumbers = new Vector<>();


    public void setInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.inputString = Console.readLine();
    }

    public void ensureCustomSeparator() {
        String regExp = "^//(.*?)\\n";
        Pattern pattern = Pattern.compile(regExp);

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String capturedText = matcher.group(1);
            customSeparator = capturedText;
        }

    }


    public void extractNumbers() {
        String target = inputString;
        String regExp = "[" + customSeparator + ",:]+";

        // 커스텀 구분자 추가 하는 부분 제거.
        if (customSeparator != null) {
            String targetToDelete = "^//" + customSeparator + "\\n";
            target = target.replaceFirst(targetToDelete, "");
        }

        String[] extractedStrings = target.split(regExp);

        for (String ext : extractedStrings) {
            try {
                int extractedNumber = Integer.parseInt(ext);
                extractedNumbers.add(extractedNumber);

            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }


    }


}
