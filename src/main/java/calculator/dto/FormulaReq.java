package calculator.dto;

public record FormulaReq (String formula) {
	public static FormulaReq from (String formula) {
		return new FormulaReq(formula);
	}
}
