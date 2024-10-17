package calculator.dto;

import java.util.ArrayList;

public class OperandDTO {
    private ArrayList<Integer> operandList = new ArrayList<>();

    public OperandDTO(ArrayList<Integer> operandList) {
        this.operandList = operandList;
    }

    public ArrayList<Integer> getOperandList() {
        return operandList;
    }

    public void setOperandList(ArrayList<Integer> operandList) {
        this.operandList = operandList;
    }
}
