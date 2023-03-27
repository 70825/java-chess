package chess.controller.command.factory;

import chess.controller.command.strategy.EndCommand;
import chess.controller.command.strategy.StrategyCommand;

import java.util.List;

public class EndCommandFactory implements ActionCommandFactory {

    @Override
    public StrategyCommand createCommand(final List<String> inputs) {
        return EndCommand.create();
    }
}
