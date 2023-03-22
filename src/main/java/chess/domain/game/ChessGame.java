package chess.domain.game;

import chess.domain.Board;
import chess.domain.piece.Piece;
import chess.domain.position.File;
import chess.domain.position.Position;
import chess.domain.position.Rank;
import chess.domain.team.Team;

import java.util.HashMap;

public class ChessGame {

    private static final int INITIAL_SCORE = 0;
    private final Board board;
    private Team turn;

    private ChessGame() {
        this.board = Board.create(new HashMap<>());
        this.turn = Team.WHITE;
    }

    public static ChessGame create() {
        return new ChessGame();
    }

    public void move(final Position source, final Position target) {
        board.move(source, target, turn);
        turn = turn.reverse();
    }

    public Score calculateScore() {
        Score score = Score.from(INITIAL_SCORE);

        for (final File file : File.values()) {
            score = score.add(calculateScoreEachFile(file));
        }

        return score;
    }

    private Score calculateScoreEachFile(final File file) {
        Score score = Score.from(INITIAL_SCORE);

        for (final Rank rank : Rank.values()) {
            score = score.add(calculateScoreEachPosition(Position.of(file, rank)));
        }

        return score;
    }

    private Score calculateScoreEachPosition(final Position position) {
        final Score score = Score.from(INITIAL_SCORE);
        final Piece piece = board.getPiece(position);

        return score.add(PieceScore.findByPiece(piece, turn));
    }

    public Board getBoard() {
        return board;
    }
}
