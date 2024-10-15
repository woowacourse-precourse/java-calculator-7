package calculator;

public class CalculatorService {
    public int returnAnswer(String answer){
        if (answer == ""){
            return 0;
        }
        return -1;
    }

    public int [] splitByDefaultDelimiter(String answer){
        String [] stringArray = answer.split(",|:");
        int [] intArrays = new int[stringArray.length];
        for (int i = 0; i < intArrays.length; i++){
            intArrays[i] = Integer.parseInt(stringArray[i]);
        }
        return intArrays;
    }

    public int[] splitByCustomDelimiter(String answer) {
        int customIndex = answer.indexOf("\n");
        String customDelimiter = answer.substring(2, customIndex);
        String exceptDelimiter = answer.substring(customIndex+1);
        String [] stringArray = exceptDelimiter.split(customDelimiter);
        int [] intArrays = new int [stringArray.length];
        for (int i = 0; i < intArrays.length; i++){
            intArrays[i] = Integer.parseInt(stringArray[i]);
        }
        return intArrays;
    }
}
