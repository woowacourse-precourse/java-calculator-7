package calculator;

public class SetSeparator {
    public static void setSeparator(String input){

        if ((input.trim().startsWith("//")) && (input.trim().indexOf("\n") != 2)) {
            Application.separator = input.trim().substring(2, input.indexOf("\n"));
        }

        if (Application.separator.isEmpty()) {
            Application.separator = Application.defaultSeparator;
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
    }
}
