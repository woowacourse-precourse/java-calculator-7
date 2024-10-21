package calculator.object;

public final class CalculationFormula {

    private final Numbers numbers;

    private CalculationFormula(Numbers numbers) {
        this.numbers = numbers;
    }

    public static CalculationFormula from(String inputFormula) {
        throwIfInputFormulaIsNull(inputFormula);

        Separators separators = new Separators(inputFormula);
        String formulaPart = getFormulaPart(inputFormula, separators);
        Numbers numbers = new Numbers(formulaPart, separators);

        return new CalculationFormula(numbers);
    }

    private static void throwIfInputFormulaIsNull(String inputFormula) {
        if (inputFormula == null) {
            throw new IllegalArgumentException("입력되는 수식은 null일 수 없습니다.");
        }
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
