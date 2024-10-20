package calculator;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void run() {
		String inputData = view.getUserInput();
		int answer = model.RunCalculator(inputData);
		
		view.displayResult(answer);
		}
}