package processor;

import display.ConsoleDisplay;
//import static display.ConsoleDisplay.input;


public class NumberProcess implements Processor {
    private String numberString;
    private String[] numberArray;

    DelimiterProcess delimiterProcess = new DelimiterProcess();
    ConsoleDisplay display = new ConsoleDisplay();
    String original;

    public NumberProcess() {
        original = display.getInput();
    }

    public String getNumberString() {
        return numberString;
    }

    public void setNumberString(String numberString) {
        this.numberString = numberString;
    }

    public String[] getNumberArray() {
        return numberArray;
    }

    public void setNumberArray(String[] numberArray) {
        this.numberArray = numberArray;
    }


    public void setNumberStr(){
        DelimiterProcess delim = new DelimiterProcess();
       if (delim.hasCustomDelimiter()) {
            int startIdx = delimiterProcess.getStartIdx();
            int endIdx = delimiterProcess.getEndIdx();
            String str1 = original.substring(0, startIdx).trim();
            String str2 = original.substring(endIdx+2).trim();
            setNumberString(str1+str2);
        }else{
           setNumberString(original.trim());
       }
    }

    public void setNumberArray(){
        setNumberArray(getNumberString().replace(" ", "").split(delimiterProcess.getDelimiterRegex()));
    }

    @Override
    public void calculate(){
        setNumberStr();
        setNumberArray();

    }
}
