package input;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputString;

    private String[] separators = new String[]{",", ":"};
    private String customSeparator = null;


    public void setInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
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

    private void addCustomSeparator() {
    }


}
