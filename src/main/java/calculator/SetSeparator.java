package calculator;

public class SetSeparator {
    public static String setSeparator(String input) {

        input = input.replace("\\n","\n");

        if ((input.trim().startsWith("//")) && input.trim().contains("\n")) {
            Application.separator = input.trim().substring(2, input.indexOf("\n"));
        } else {
            Application.separator = Application.defaultSeparator;
            return input;
        }

        if (Application.separator == null || Application.separator.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자 지정이 안되었습니다.");
        } else {
            StringBuilder regexPattern = new StringBuilder();

            for (int i = 0; i < Application.separator.length(); i++) {

                char c = Application.separator.charAt(i);

                if (regexPattern.indexOf(String.valueOf(c)) == -1) {

                    if (!regexPattern.isEmpty()) {
                        regexPattern.append("|");
                    }
                    regexPattern.append(c).append("+");
                }
            }
            Application.separator = regexPattern.toString();
        }
        String result = input.trim().substring(input.indexOf("\n") + 1); // \n 이후의 숫자만 남김
        return result;

    }
}