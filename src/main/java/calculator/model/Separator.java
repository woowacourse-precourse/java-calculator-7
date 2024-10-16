package calculator.model;

public class Separator {
    private String separators;

    public Separator(String separators){
        this.separators = separators;
    }

    public void addSeparator(String separators){
        this.separators += separators;
    }

    public String getSeparators(){
        return separators;
    }
}
