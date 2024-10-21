package calculator.stringSplitter;

public class StringContoller {
    private final StringParser stringParser;
    public StringContoller(){
        SeparatorManager separatorManager = new SeparatorManager();
        InputValidator inputValidator = new InputValidator();
        this.stringParser = new StringParser(separatorManager,inputValidator);
    }

    public String[] splitsString(String input){
        return stringParser.parse(input);
    }
}
