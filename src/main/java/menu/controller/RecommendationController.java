package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coachs;
import menu.domain.InedibleMenu;
import menu.domain.RecommendMenu;
import menu.domain.Recommendation;
import menu.service.RecommendationService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendationController {
    private final InputView inputView;
    private final OutputView outputView;
    private RecommendationService recommendationService;
    private Recommendation recommendation;

    public RecommendationController(InputView inputView,
                                    OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        List<Coach> coaches = new ArrayList<>();
        List<String> inputCoachs = inputView.readCoachs();
        for (String coach : inputCoachs) {
            List<String> indeibles = inputView.readInedibles(coach);
            InedibleMenu inedibleMenu = new InedibleMenu(indeibles);
            RecommendMenu recommendMenu = new RecommendMenu();
            coaches.add(new Coach(coach, inedibleMenu, recommendMenu));
        }
        Coachs coachs = new Coachs(coaches);
        Categories categories = new Categories();
        recommendation = new Recommendation(coachs, categories);
        recommendationService = new RecommendationService(recommendation);
        recommendationService.recommendationMenu();
        outputView.printResult(recommendation.getCategories().getCategories(),
                recommendation.getCoachs().getCoachs());
    }
}
