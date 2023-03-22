package chess.domain.game;

import chess.domain.piece.*;
import chess.domain.team.Team;

import java.util.Map;

public class PieceScore {

    private static final Map<Class<? extends Piece>, Score> pieceScore = Map.of(
            King.class, Score.from(0),
            Queen.class, Score.from(9),
            Bishop.class, Score.from(3),
            Knight.class, Score.from(2.5),
            Rook.class, Score.from(5),
            Pawn.class, Score.from(1),
            Empty.class, Score.from(0)
    );

    public static Score findByPiece(final Piece piece, final Team team) {
        if (piece.isSameTeam(team)) {
            return pieceScore.get(piece.getClass());
        }
        return Score.from(0);
    }
}
