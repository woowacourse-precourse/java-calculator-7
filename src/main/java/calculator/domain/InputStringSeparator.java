package calculator.domain;

public class InputStringSeparator {
    private String inputString;
    private String finalSeparator;
    private String customSeparator = null;
    private String[] inputNumber; // int vs integear ??

    public InputStringSeparator(String inputString) {
        this.inputString = inputString;
        setCustomSeparator(this.inputString);
    }

    private void validateInputString(String inputString){

    }

    private void setCustomSeparator(String inputString){
        int startIndex = 0 ;
        int lastIndex = 0;
        if(isDefaultSeparatorContained()){ //this.inputString 으로 판단하는게 좋은가?
            startIndex = inputString.indexOf("//");
            lastIndex = inputString.indexOf("\n");
            this.customSeparator = inputString.substring(startIndex+2, lastIndex); //커스텀 구분자는 그럼 한 개만인가?
        }
    }

    private boolean isDefaultSeparatorContained(){
        return inputString.contains("//") && inputString.contains("\n");
    }

    private void setFinalSeparator(){
        if(this.customSeparator.isEmpty()){
            this.finalSeparator = "[" + "//" + "\n" + "]";
            return;
        }
        this.finalSeparator = "[" + "//" + "\n" + customSeparator + "]";
    }

    private void setInputNumber(String inputString){
       this.inputNumber =  inputString.split(this.finalSeparator);
    }
}
