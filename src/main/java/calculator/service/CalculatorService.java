package calculator.service;

public class CalculatorService {
	SeparatorService separatorService;
    SumService sumService;

    private CalculatorService() {
    	separatorService = SeparatorService.getInstance();
        sumService = SumService.getInstance();
    }
    
    private static class SingletonHelper {
    	private static final CalculatorService INSTANCE = new CalculatorService(); 
    }

    static public CalculatorService getInstance() {
        return SingletonHelper.INSTANCE;
    }

    
    public String findSeparator(String text) {
        return separatorService.findSeparator(text);
	}

	public int calculate(String targetText) throws IllegalArgumentException {
		return sumService.calculate(targetText);
    }

	
}
