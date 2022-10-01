package org.codurance;

import java.util.Objects;

public class BowlingScoreCalculator {

    public static final String STRIKE = "X";
    public static final int STRIKE_POINTS = 10;

    public int score(String scoreCard) {
        String[] scoreArray = scoreCard.split("\\|");
        return calculateScore(scoreArray);
    }

    private int calculateScore(String[] scoreArray) {
        int score = 0;
        for (int i = 0; i < scoreArray.length; i++) {
            String frame = scoreArray[i];
            String[] frameArray = frame.split("");
            score += parseScore(frameArray[0]);

            if (!isAStrike(frameArray)) {
                score += addSecondBowlOfFrame(frameArray);

            } else if (isNextFrameAStrike(scoreArray, i)) {
                score += STRIKE_POINTS;
                String scoredTwoStrikesConsecutively = scoreArray[i + 2].split("")[0];
                score += parseScore(scoredTwoStrikesConsecutively);

            } else {
                String[] nextFrame = scoreArray[i + 1].split("");
                score += parseScore(nextFrame[0]);
                score += parseScore(nextFrame[1]);
            }
        }
        return score;
    }

    private boolean isNextFrameAStrike(String[] scoreArray, int i) {
        return scoreArray[i + 1].equals(STRIKE);
    }

    private int addSecondBowlOfFrame(String[] frameArray) {
        return parseScore(frameArray[1]);
    }

    private boolean isAStrike(String[] frameArray) {
        return frameArray[0].equals(STRIKE);
    }

    private int parseScore(String attempt) {
        if (Objects.equals(attempt, STRIKE)) {
            return STRIKE_POINTS;
        }

        if (!Objects.equals(attempt, "-")) {
            return Integer.parseInt(attempt);
        }
        return 0;
    }
}

