package calculator.service;

public class CalculatorService {
    private String s;
    private String plusSeparator;

    /** Run all logic step by step. */
    public int sum(String s){
        this.s = s;
        boolean hasPlusSeparator = checkPlusSeparator();
        String[] separatedString = separate(hasPlusSeparator);
        hasNaN(separatedString);
        return sumSeparatedStringArr(separatedString);
    }
    /**
     * Check existence of another separator.
     * @return if exist another separator, return true. Or return false.
     */
    private boolean checkPlusSeparator() {
        if (s.length() >= 5 && s.startsWith("//") && s.startsWith("\\n", 3)) {
            plusSeparator = String.valueOf(s.charAt(2));
            s = s.substring(5);
            return true;
        }
        return false;
    }
    /**
     * Separate input string. if escape string(\) added separator, need action.
     * @param hasPlusSeparator if another separator exist, set true. Or false.
     * @return separated string.
     */
    private String[] separate(boolean hasPlusSeparator){
        if(!hasPlusSeparator){
            return s.split("[:,]");
        }else{
            if(plusSeparator.equals("\\"))
                return s.split("[:,"+plusSeparator.repeat(2)+"]");
            return s.split("[:,"+plusSeparator+"]");
        }
    }
    /**
     * Check input string array contains not a number. if it contains NaN,
     * throw IllegalArgumentException.
     * @param separatedStringArr String separated by separator.
     */
    private void hasNaN(String[] separatedStringArr){
        for(String s:separatedStringArr){
            for(char c:s.toCharArray()){
                if(c < 48 || c > 57)
                    throw new IllegalArgumentException();
            }
        }
    }
    /**
     * Sum all of them
     * @param separatedStringArr clean integer string array.
     * @return Sum
     */
    private int sumSeparatedStringArr(String[] separatedStringArr){
        int sum = 0;
        for(String separatedString:separatedStringArr){
            if(!separatedString.isEmpty())
                sum += Integer.parseInt(separatedString);
        }
        return sum;
    }
}
