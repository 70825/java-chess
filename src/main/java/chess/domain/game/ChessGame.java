package chess.domain.game;

import chess.domain.Board;
import chess.domain.piece.King;
import chess.domain.piece.Pawn;
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
    }

    public void changeTurn() {
        turn = turn.reverse();
    }

    public Score calculateScore(final Team team) {
        Score score = Score.from(INITIAL_SCORE);

        for (final File file : File.values()) {
            score = score.add(calculateScoreEachFile(file, team));
        }

        return score;
    }

    private Score calculateScoreEachFile(final File file, final Team team) {
        Score score = Score.from(INITIAL_SCORE);

        for (final Rank rank : Rank.values()) {
            score = score.add(calculateScoreEachPosition(Position.of(file, rank), team));
        }
        score = score.minus(calculatePawnScoreByCountEachFile(file, team));

        return score;
    }

    private Score calculateScoreEachPosition(final Position position, final Team team) {
        final Score score = Score.from(INITIAL_SCORE);
        final Piece piece = board.getPiece(position);

        return score.add(PieceScore.findByPiece(piece, team));
    }

    private Score calculatePawnScoreByCountEachFile(final File file, final Team team) {
        int pawnCount = 0;

        for(final Rank rank : Rank.values()) {
            pawnCount += hasPawn(Position.of(file, rank), team);
        }

        if (pawnCount <= 1) {
            return Score.from(0);
        }
        return Score.from(0.5 * pawnCount);
    }

    private int hasPawn(final Position position, final Team team) {
        if (board.getPiece(position).equals(new Pawn(team))) {
            return 1;
        }
        return 0;
    }

    public boolean isExistOpponentKing() {
        int countOpponentKing = 0;

        for(final File file: File.values()) {
            countOpponentKing += getCountOpponentKingEachFile(file);
        }

        return countOpponentKing == 1;
    }

    private int getCountOpponentKingEachFile(final File file) {
        int countOpponentKing = 0;

        for(final Rank rank: Rank.values()) {
            countOpponentKing += getCountOpponentKingEachPosition(file, rank);
        }

        return countOpponentKing;
    }

    private int getCountOpponentKingEachPosition(final File file, final Rank rank) {
        final Piece piece = board.getPiece(Position.of(file, rank));

        if (piece.equals(new King(turn.reverse()))) {
            return 1;
        }
        return 0;
    }

    public Board getBoard() {
        return board;
    }

    public Team getTurn() {
        return turn;
    }
}
