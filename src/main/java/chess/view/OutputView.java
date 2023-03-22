package chess.view;

import chess.domain.Board;
import chess.domain.game.ChessGame;
import chess.domain.game.Score;
import chess.domain.piece.Piece;
import chess.domain.position.File;
import chess.domain.position.Position;
import chess.domain.position.Rank;
import chess.domain.team.Team;

import java.util.Map;

public class OutputView {

    public static void printStart() {
        System.out.println("> 체스 게임을 시작합니다.");
        System.out.println("> 게임 시작 : start");
        System.out.println("> 게임 종료 : end");
        System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
        System.out.println("> 점수 확인 : status");
    }

    public static void printBoard(final Board board) {
        final Map<Position, Piece> chessBoard = board.getBoard();

        for (final Rank rank : Rank.values()) {
            printEachRank(chessBoard, rank);
        }
        System.out.println();
    }

    private static void printEachRank(final Map<Position, Piece> chessBoard, final Rank rank) {
        for (final File file : File.values()) {
            final Position position = Position.of(file, rank);
            final Piece piece = chessBoard.get(position);
            System.out.printf(PieceName.findNameByPiece(piece));
        }
        System.out.println();
    }

    public static void printStatus(final Score white, final Score black) {
        System.out.printf("[현재 점수]\nWhite 팀: %.1f점\nBlack 팀: %.1f점\n", white.value(), black.value());

    }

    public static void printScoreWinning(final Score white, final Score black) {
        if (white.value() > black.value()) {
            System.out.println("결과: White 팀 승리");
            return;
        }
        if (white.value() < black.value()) {
            System.out.println("결과: Black 팀 승리");
            return;
        }
        System.out.println("결과: 무승부");
    }

    public static void printResultWinning(final Team team) {
        if (team == Team.WHITE) {
            System.out.println("White 팀 승리");
        }
        if (team == Team.BLACK) {
            System.out.println("Black 팀 승리");
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
