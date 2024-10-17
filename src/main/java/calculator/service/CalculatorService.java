package calculator.service;

public class CalculatorService {
    private String s;
    private String plusSeparator;

    public int sum(String s){
        this.s = s;
        boolean hasPlusSeparator = checkPlusSeparator();
        String[] separatedString = separate(hasPlusSeparator);
        hasNaN(separatedString);
        return sumSeparatedStringArr(separatedString);
    }

    private boolean checkPlusSeparator() {
        if (s.length() >= 5 && s.startsWith("//") && s.startsWith("\\n", 3)) {
            plusSeparator = String.valueOf(s.charAt(2));
            s = s.substring(5);
            return true;
        }
        return false;
    }

    private String[] separate(boolean hasPlusSeparator){
        if(!hasPlusSeparator){
            return s.split("[:,]");
        }else{
            if(plusSeparator.equals("\\"))
                return s.split("[:,"+plusSeparator.repeat(2)+"]");
            return s.split("[:,"+plusSeparator+"]");
        }
    }

    private void hasNaN(String[] separatedStringArr){
        for(String s:separatedStringArr){
            for(char c:s.toCharArray()){
                if(c < 48 || c > 57)
                    throw new IllegalArgumentException();
            }
        }
    }
    private int sumSeparatedStringArr(String[] separatedStringArr){
        int sum = 0;
        for(String separatedString:separatedStringArr){
            sum += Integer.parseInt(separatedString);
        }
        return sum;
    }
}
