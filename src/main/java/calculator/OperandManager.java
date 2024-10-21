package calculator;

import static calculator.Constants.*;

import java.util.LinkedList;
import java.util.List;

public class OperandManager {
    private final List<Integer> operands;
    private final SeparatorManager separatorManager;

    public OperandManager(SeparatorManager separatorManager) {
        operands = new LinkedList<>();
        this.separatorManager = separatorManager;
    }

    private void validate(String operandCandidate) {
        if(operandCandidate.isEmpty()) {
            return;
        }
        if (operandCandidate.equals("0") || !operandCandidate.matches(VALID_OPERAND_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_OPERAND);
        }
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public void save(String operandCandidates) {
        String[] splitOperandCandidates = split(operandCandidates);
        for (String operandCandidate : splitOperandCandidates) {
            validate(operandCandidate);
            if(operandCandidate.isEmpty()) {
                continue;
            }
            try {
                operands.add(Integer.parseInt(operandCandidate));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(EXCEEDS_LIMIT_MESSAGE);
            }
        }
    }

    private String[] split(String operandCandidates) {
        for (String separator : separatorManager.getSeparators()) {
            operandCandidates = operandCandidates.replace(separator, " ");
        }
        return operandCandidates.trim().split(WHITESPACE_REGEX);
    }
}
