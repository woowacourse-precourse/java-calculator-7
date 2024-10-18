package calculator.object;

public class CalculateFormula {

    private final Numbers numbers;

    private CalculateFormula(Numbers numbers) {
        this.numbers = numbers;
    }

    public static CalculateFormula from(String inputFormula) {
        Separators separators = new Separators(inputFormula);
        Numbers numbers = new Numbers(inputFormula, separators);
        return new CalculateFormula(numbers);
    }

    public String calculate() {
        return numbers.addAll();
    }

}
