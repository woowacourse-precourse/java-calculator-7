package calculator.dto;

import calculator.domain.Delimiter;
import java.util.List;

public record ParsedComponents(List<Delimiter> delimiters, String operationalExpression) {
}