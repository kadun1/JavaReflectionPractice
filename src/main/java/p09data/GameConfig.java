package p09data;

import java.util.Arrays;
import java.util.Random;

public class GameConfig {
    private final int releaseYear;
    private String gameName;
    private float price;
    private String [] characterNames;

    public GameConfig() {
        Random random = new Random();
        this.releaseYear = random.nextInt(2000);
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGameName() {
        return gameName;
    }

    public float getPrice() {
        return price;
    }

    public String[] getCharacterNames() {
        return characterNames;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "releaseYear=" + releaseYear +
                ", gameName='" + gameName + '\'' +
                ", price=" + price +
                ", characterName=" + Arrays.toString(characterNames) +
                '}';
    }
}
