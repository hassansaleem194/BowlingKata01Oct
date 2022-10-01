import org.codurance.BowlingScoreCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BowlingScoreFeatureTest {


    @ParameterizedTest
    @MethodSource("scoreCards")
    public void should_return_a_completed_game_with_0_points(String scoreCard, int finalScore) {
        assertEquals(finalScore, new BowlingScoreCalculator().score(scoreCard));
    }

    private static Stream<Arguments> scoreCards(){
        return Stream.of(
                arguments("0-|--|--|--|--|--|--|--|--|--||", 0),
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
