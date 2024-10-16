package calculator;

public class InputParser {

    public void getCustomParser(InputString inputString) {
        String separator = null;
        String input = inputString.getInput();
        if (input.startsWith("//")) {
            int indexOfNewline = input.indexOf("\n");
            separator = input.substring(2, indexOfNewline);
        }
        inputString.setSeparator(separator);
    }

    public void getIntegerList(InputString inputString){
        String input = inputString.getInput();
        if (input.startsWith("//")) {
            input = input.substring(2);
        }
        String[] parsedOperand = input.split(inputString.getSeparator());
        try{
            for(String s : parsedOperand){
                inputString.addOperand((Integer.parseInt(s)));
            }
        }catch (NumberFormatException e){
            CheckForm.throwException();
        }
    }

}
