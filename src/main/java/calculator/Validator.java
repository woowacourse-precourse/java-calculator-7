package calculator;

public class Validator {

    public static void validateFormula(String formula, Separator separator){
        validateCharacters(formula, separator);
        validateConsecutiveSeparators(formula, separator);
        validateBoundaries(formula, separator);
    }

    private static void validateCharacters(String formula, Separator separator){
        for(int i=0;i<formula.length();i++){
            if(isDigit(formula.charAt(i)) || separator.isSeparator(formula.charAt(i))) continue;
            throw new IllegalArgumentException();
        }
    }

    private static void validateConsecutiveSeparators(String formula, Separator separator) {
        boolean previousWasSeparator = false;
        for(Character c : formula.toCharArray()){
            if(separator.isSeparator(c)){
                if(previousWasSeparator) throw new IllegalArgumentException();
                previousWasSeparator = true;
            }
            else{
                previousWasSeparator = false;
            }
        }
    }

    private static void validateBoundaries(String formula, Separator separator) {
        if(formula.isEmpty() || separator.isSeparator(formula.charAt(0)) ||
                separator.isSeparator(formula.charAt(formula.length()-1))){
            throw new IllegalArgumentException();
        }
    }


    public static boolean isDigit(Character c){
        return ('0'<=c && c<='9');
    }
}
