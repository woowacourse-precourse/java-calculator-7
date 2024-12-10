package menu;

import menu.controller.RecommendController;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RecommendService recommendService = new RecommendService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RecommendController recommendController = new RecommendController(recommendService, inputView, outputView);
        recommendController.run();
    }
}
