package chess.controller.command.strategy;

import chess.controller.ChessState;
import chess.domain.game.ChessGame;
import chess.view.OutputView;

public class StatusCommand implements StrategyCommand {

    private StatusCommand() {}

    public static StatusCommand create() {
        return new StatusCommand();
    }

    @Override
    public ChessState execute(final ChessState state, final ChessGame chessGame) {
        if (state == ChessState.START || state == ChessState.PROGRESS) {
            OutputView.printScore(chessGame.calculateScore());
            OutputView.printBoard(chessGame.getBoard());
            return ChessState.PROGRESS;
        }

        throw new IllegalArgumentException("게임이 시작되기 전에 점수를 확인할 수 없습니다");
    }
}
