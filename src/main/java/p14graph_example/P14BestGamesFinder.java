package p14graph_example;

import p14graph_example.p14annotations.P14Annotations.*;
import p14graph_example.p14databases.P14Database;

import java.util.*;

public class P14BestGamesFinder {
    private P14Database database = new P14Database();

    @Operation("All-Games")
    public Set<String> getAllGames() {
        return database.readAllGames();
    }

    @Operation("Game-To-Price")
    public Map<String, Float> getGameToPrice(@DependsOn("All-Games") Set<String> allGames) {
        return database.readGameToPrice(allGames);
    }

    @Operation("Game-To-Rating")
    public Map<String, Float> getGameToRating(@DependsOn("All-Games") Set<String> allGames) {
        return database.readGameToRatings(allGames);
    }

    @Operation("Score-To-Game")
    public SortedMap<Double, String> scoreGames(@DependsOn("Game-To-Price") Map<String, Float> gameToPrice,
                                                @DependsOn("Game-To-Rating") Map<String, Float> gameToRating) {
        SortedMap<Double, String> gameToScore = new TreeMap<>(Collections.reverseOrder());
        for (String gameName : gameToPrice.keySet()) {
            double score = (double) gameToRating.get(gameName) / gameToPrice.get(gameName);
            gameToScore.put(score, gameName);
        }

        return gameToScore;
    }


    @FinalResult
    public List<String> getTopGames(@DependsOn("Score-To-Game") SortedMap<Double, String> gameToScore) {
        return new ArrayList<>(gameToScore.values());
    }

}
