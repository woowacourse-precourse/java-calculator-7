package menu;

import menu.controller.RecommendationController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RecommendationController recommendationController = new RecommendationController(inputView, outputView);

        recommendationController.run();
    }
}
