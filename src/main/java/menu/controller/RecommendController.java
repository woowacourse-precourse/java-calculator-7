package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Recommend;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {
    private RecommendService recommendService;
    private InputView inputView;
    private OutputView outputView;
    private Recommend recommend;

    public RecommendController(RecommendService recommendService,
                               InputView inputView,
                               OutputView outputView) {
        this.recommendService = recommendService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        List<String> coachs = inputView.readCoach();
        Map<String, List<String>> inedibles = new HashMap<>();
        for (String coach : coachs) {
            List<String> inedible = inputView.readInedible(coach);
            inedibles.put(coach, inedible);
        }
        recommend = new Recommend(coachs, inedibles);
        while (recommend.recommendAmount() < 5) {
            recommendService.recommendMenu(recommend);
        }
        outputView.printResult(recommend);
    }
}
