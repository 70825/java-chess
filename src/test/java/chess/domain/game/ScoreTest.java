package chess.domain.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @Test
    @DisplayName("숫자로 점수를 생성할 수 있다")
    void createScoreByNumber() {
        // given
        final int value = 10;

        // then
        Assertions.assertThatNoException().isThrownBy(() -> Score.from(value));
    }

    @Test
    @DisplayName("점수와 점수는 더할 수 있다")
    void addScore() {
        // given
        final Score score1 = Score.from(10);
        final Score score2 = Score.from(20);
        final Score expected = Score.from(30);

        // when
        final Score actual = score1.add(score2);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
