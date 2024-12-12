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
        Coachs coachs = createCoachs();
        for (Coach coach : coachs.getCoachs()) {
            createInedible(coach);
        }
        Categories categories = new Categories();
        recommendation = new Recommendation(coachs, categories);
        recommendationService = new RecommendationService(recommendation);
        recommendationService.recommendationMenu();
        outputView.printResult(recommendation.getCategories().getCategories(),
                recommendation.getCoachs().getCoachs());
    }

    private void createCoach(String coach, List<Coach> coaches) {
        InedibleMenu inedibleMenu = new InedibleMenu();
        RecommendMenu recommendMenu = new RecommendMenu();
        coaches.add(new Coach(coach, inedibleMenu, recommendMenu));
    }

    private Coachs createCoachs() {
        try {
            List<Coach> coaches = new ArrayList<>();
            List<String> inputCoachs = inputView.readCoachs();
            for (String coach : inputCoachs) {
                createCoach(coach, coaches);
            }
            Coachs coachs = new Coachs(coaches);
            return coachs;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCoachs();
        }
    }

    private void createInedible(Coach coach) {
        try {
            coach.getInedibleMenu().setEdibleMenu(inputView.readInedibles(coach.getName()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createInedible(coach);
        }
    }
}
