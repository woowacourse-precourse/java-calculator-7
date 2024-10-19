package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartSlash {
    public ArrayList<Integer> readSlashInput (String input) {
        String custom = "";
        String exp = "";
        if (input.startsWith("//")) {
            int changeIndex = input.indexOf("\\n");
            if (changeIndex != -1) {
                custom = input.substring(2, changeIndex);
                exp = input.substring(changeIndex + 2);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }

        // 숫자 -문자 - 숫자- ... 형식 맞는지 확인
        String regex = "^[0-9]+(" + Pattern.quote(custom) + "[0-9]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(exp);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        String[] temps = exp.split(custom);
        for (String temp : temps) {
            numbers.add(Integer.parseInt(temp));
        }

        return numbers;
    }
}
