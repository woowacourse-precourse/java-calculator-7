package calculator;

public class NumberParser {
    public String[] replaceNumber(String[] inputArr){
        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = inputArr[i].replaceAll("[^0-9]","");
        }
        return inputArr;
    }
}
