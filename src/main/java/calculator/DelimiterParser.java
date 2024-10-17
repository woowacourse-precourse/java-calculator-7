package calculator;

public class DelimiterParser {
    public String[] parse(String input) {
        String delimiter = ",|:";
        input=input.replace(" ","");

        if ((input.startsWith("//"))&&(input.contains("\n"))) {
            int newLineIndex = input.indexOf("\n");
            delimiter=input.substring(2,newLineIndex);
            input=input.substring(newLineIndex+1);
        }
        else{
            throw new IllegalArgumentException("커스텀 구분자가 올바르지 않은 형식인 경우입니다.");
        }
        return input.split(delimiter);
    }
}
