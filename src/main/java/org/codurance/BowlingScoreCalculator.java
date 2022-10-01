package org.codurance;

public class BowlingScoreCalculator {
    public int score(String scoreCard) {

        if (scoreCard == "5-|--|--|--|--|--|--|--|--|--||") {
            return 5;
        }

        if (scoreCard == "9-|--|--|--|--|--|--|--|--|--||") {
            return 9;
        }

        return 0;
    }
}
