package calculator.domain;

public class Separator {

    private static final String FIXED_SEPARATORS = "[,:]";
    private static final String PIPE = "|";

    private String separators;

    public Separator(){
        this.separators = FIXED_SEPARATORS;
    }

    public Separator(String customSeparator){
        this.separators = FIXED_SEPARATORS + PIPE + customSeparator;
    }

    public String getSeparators(){
        return this.separators;
    }
}
