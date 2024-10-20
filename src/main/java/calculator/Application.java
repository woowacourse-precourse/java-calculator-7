package calculator;

public class Application{
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		
		controller.run();
	}
}