package calculator;

public class NumberSplitter {
    private String[] separatedNumbers;

    public void setSeparatedNumbers(String str, String splitter) {
        this.separatedNumbers = str.split(splitter);
    }

    public String[] getSeparatedNumbers(){
        return this.separatedNumbers;
    }
}
