package chess.controller.command.strategy;

import chess.controller.ChessState;
import chess.service.ChessService;

public class EndCommand implements StrategyCommand {

    private EndCommand() {
    }

    public static EndCommand create() {
        return new EndCommand();
    }

    @Override
    public ChessState execute(final ChessState state, final ChessService chessService) {
        if (state == ChessState.START || state == ChessState.PROGRESS) {
            return ChessState.END;
        }

        throw new IllegalArgumentException("게임을 시작하기 전에 종료할 수 없습니다");
    }
}
