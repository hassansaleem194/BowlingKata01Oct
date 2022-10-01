package org.codurance;

import java.util.Objects;

public class BowlingScoreCalculator {
    public int score(String scoreCard) {


//        split("|")
//        will return array
//            array function first last
//                if first = "-" add 0
//            else convert string to integer
//                atomicinteger create running total / return score


        String[] scoreArray = scoreCard.split("\\|");

        int score = 0;

        for (int i = 0; i < scoreArray.length; i++) {
            String[] frame = scoreArray[i].split("");

            score += parseScore(frame[0]);
            score += parseScore(frame[1]);

        }
            return score;
    }

    private int parseScore(String attempt) {
        if (!Objects.equals(attempt, "-")) {
            return Integer.parseInt(attempt);
        }
        return 0;
    }
}
