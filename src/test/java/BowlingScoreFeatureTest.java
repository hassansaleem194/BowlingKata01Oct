import org.codurance.BowlingScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BowlingScoreFeatureTest {


    private final BowlingScoreCalculator underTest = new BowlingScoreCalculator();

    @ParameterizedTest
    @MethodSource("singlePointScoreCards")
    public void should_return_a_completed_game_with_point_on_first_bowl(String scoreCard, int finalScore) {
        assertEquals(finalScore, underTest.score(scoreCard));
    }

    @Test
    public void should_return_a_completed_game_with_two_scores_in_the_first_frame() {
        assertEquals(9, underTest.score("36|--|--|--|--|--|--|--|--|--||"));
    }

    @Test
    public void should_return_a_completed_game_with_multiple_scores_in_the_whole_game() {
        assertEquals(42, underTest.score("36|--|4-|6-|-6|--|3-|6-|8-|--||"));

    }

    @Test
    public void should_return_10_when_you_score_a_strike() {
        assertEquals(10, underTest.score("X|--|--|--|--|--|--|--|--|--||"));
    }

    @Test
    public void should_return_correct_score_when_you_score_a_strike_and_non_strikes() {
        assertEquals(17, underTest.score("X|--|3-|4-|--|--|--|--|--|--||"));
    }

    @Test
    public void should_return_correct_score_when_you_score_two_strikes_and_non_strike_consecutively() {
        assertEquals(33, underTest.score("X|X|1-|--|--|--|--|--|--|--||"));
    }

    @Test
    public void should_return_correct_score_when_you_score_a_strike_and_non_strike_consecutively() {
        assertEquals(20, underTest.score("X|23|--|--|--|--|--|--|--|--||"));
    }



    private static Stream<Arguments> singlePointScoreCards() {
        return Stream.of(
                arguments("--|--|--|--|--|--|--|--|--|--||", 0),
                arguments("1-|--|--|--|--|--|--|--|--|--||", 1),
                arguments("2-|--|--|--|--|--|--|--|--|--||", 2),
                arguments("3-|--|--|--|--|--|--|--|--|--||", 3),
                arguments("4-|--|--|--|--|--|--|--|--|--||", 4),
                arguments("5-|--|--|--|--|--|--|--|--|--||", 5),
                arguments("6-|--|--|--|--|--|--|--|--|--||", 6),
                arguments("7-|--|--|--|--|--|--|--|--|--||", 7),
                arguments("8-|--|--|--|--|--|--|--|--|--||", 8),
                arguments("9-|--|--|--|--|--|--|--|--|--||", 9)
        );
    }

}
