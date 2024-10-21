package calculator.domain;

public class CustomDelim {

    private final String delim;

    public CustomDelim(String input) {
        delim = CustomDelimExtract.getEssence(input);
    }

    public String getDelim() {
        return delim;
    }
}
