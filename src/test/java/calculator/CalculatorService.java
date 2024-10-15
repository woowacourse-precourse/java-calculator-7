package calculator;

public class CalculatorService {
    public int returnAnswer(String answer){
        if (answer == ""){
            return 0;
        }
        return -1;
    }

    public int [] splitByDefaultDelimiter(String answer){
        String [] stringArrays = answer.split(",|:");
        int [] intArrays = new int[stringArrays.length];
        for (int i = 0; i < intArrays.length; i++){
            intArrays[i] = Integer.parseInt(stringArrays[i]);
        }
        return intArrays;
    }
}
