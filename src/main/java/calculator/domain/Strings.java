package calculator.domain;

public class Strings {

    public String[] input;
    private final String original;
    public String distinguish =  ",|:";

    public Strings(String input) {
        this.input = input.split("");
        this.original = input;
    }

    public boolean isCustomExist() {
        if (input[0].equals("/") && input[1].equals("/")) {
            int delimiterEndIndex = original.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자");
            }
            return true;
        }
        return false;
    }

    public String[] distinguisher() {
        if(isCustomExist()) {
            String temp = input[2];
            String substring = original.substring(5);
            return substring.split(temp);
        }
        return original.split(distinguish);
    }

}
