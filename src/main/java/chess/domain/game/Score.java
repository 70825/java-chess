package chess.domain.game;

import java.util.Objects;

public class Score {

    private final double value;

    private Score(final double value) {
        this.value = value;
    }

    public static Score from(final double value) {
        return new Score(value);
    }

    public Score add(final Score score) {
        return Score.from(value + score.value());
    }

    public double value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
