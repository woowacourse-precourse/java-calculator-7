package calculator.util;

public class MyCalculator {
    
    public int calculate(String expression) {
        if(expression == null || expression.trim().isEmpty()) {
            return 0;
        }
        
        int result = 0;
        
        String replaceExpression = expression.replace(":", ",");
        
        String[] numbers = replaceExpression.split(",");
        
        for(String n : numbers) {
            int num = Integer.parseInt(n);
            
            result += num;
        }
        return result;
    }
}
