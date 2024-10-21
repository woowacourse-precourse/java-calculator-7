package calculator.controller;

import calculator.domain.CustomDelim;
import calculator.domain.CustomDelimVerify;
import calculator.domain.Prep;
import calculator.domain.Unify;
import calculator.domain.UserExpression;
import calculator.domain.UserExpressionDivide;
import calculator.domain.Validation;
import calculator.repository.DelimiterRepository;
import java.util.List;

public class ExpressionController {

    private UserExpression userExpression;
    private DelimiterRepository delimiterRepository;

    public List<String> init(UserExpression userExpression) {
        this.userExpression = userExpression;
        delimiterRepository = new DelimiterRepository();
        divideUserExpression();
        customDelimProcess();
        String unified = unifyAllDelim(userExpression.getEssentialExpression(),
                delimiterRepository.getDelimiters());
        return prepExpressionDiced(unified);
    }

    private void createExpression(UserExpression userExpression) {
        this.userExpression = userExpression;
        delimiterRepository = new DelimiterRepository();
    }

    private void divideUserExpression() {
        UserExpressionDivide.dividePart(userExpression);
    }

    private void customDelimProcess() {
        userExpression= UserExpressionDivide.setDivideCustomDelimDisappear();
        if(CustomDelimVerify.exist(userExpression.getCustomDelimExpressionCandidate())){
            customDelimTreatment(userExpression.getCustomDelimExpressionCandidate());
        }
    }

    private void customDelimTreatment(String customDelimCandidate) {
        delimiterRepository.addDelimiter(new CustomDelim(customDelimCandidate).getDelim());
        userExpression.setEssentialExpression(userExpression.getRawExpression()
                .replace(userExpression.getCustomDelimExpressionCandidate(), ""));
    }

    private String unifyAllDelim(String essenceExpression, List<String> delimiters) {
        return Unify.allDelimiters(essenceExpression, delimiters);
    }

    private List<String> prepExpressionDiced(String unified) {
        Validation.undefinedStrMixedInExpression(unified,delimiterRepository.getDelimiters());
        return Prep.dicedChunk(unified, delimiterRepository.getDelimiters().getFirst());
    }
}
