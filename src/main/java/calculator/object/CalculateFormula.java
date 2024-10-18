package calculator.object;

public class CalculateFormula {

    private final Numbers numbers;

    private CalculateFormula(Numbers numbers) {
        this.numbers = numbers;
    }

    public static CalculateFormula from(String inputFormula) {
        Separators separators = new Separators(inputFormula);
        String formulaPart = getFormulaPart(inputFormula, separators);
        Numbers numbers = new Numbers(formulaPart, separators);
        return new CalculateFormula(numbers);
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
