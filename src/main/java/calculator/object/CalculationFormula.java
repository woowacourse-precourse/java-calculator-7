package calculator.object;

public class CalculationFormula {

    private final Numbers numbers;

    private CalculationFormula(Numbers numbers) {
        this.numbers = numbers;
    }

    public static CalculationFormula from(String inputFormula) {
        Separators separators = new Separators(inputFormula);
        String formulaPart = getFormulaPart(inputFormula, separators);
        Numbers numbers = new Numbers(formulaPart, separators);
        return new CalculationFormula(numbers);
    }

    public String calculate() {
        return numbers.addAll();
    }

    private static String getFormulaPart(String inputFormula, Separators separators) {
        String numberPartOfFormula = inputFormula;
        if (!separators.isCustomSeparatorEmpty()) {
            int separatorIndex = inputFormula.indexOf(Separators.getSeparatorFooter());
            int numbersStartIndex = separatorIndex + Separators.getSeparatorFooter().length();
            numberPartOfFormula = inputFormula.substring(numbersStartIndex);
        }
        return numberPartOfFormula;
    }

}
