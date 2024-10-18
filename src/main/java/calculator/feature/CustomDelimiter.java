package calculator.feature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {

    String str;

    public CustomDelimiter(String str) {
        this.str = str;
    }

    public char[] getDelimiter() {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n"); // //와 \n 사이의 커스텀 구분자 가져오기
        Matcher matcher = pattern.matcher(str);

        if (matcher.find())
            return matcher.group(1).toCharArray();
        else
            return new char[]{};
    }

}
