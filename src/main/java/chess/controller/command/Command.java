package chess.controller.command;

import chess.controller.command.factory.*;
import chess.controller.command.strategy.StrategyCommand;

import java.util.Arrays;
import java.util.List;

public enum Command {

    START("start", 1, new StartCommandFactory()),
    MOVE("move", 3, new MoveCommandFactory()),
    STATUS("status", 1, new StatusCommandFactory()),
    END("end", 1, new EndCommandFactory());

    private static final int COMMAND_INDEX = 0;

    private final String value;
    private final int size;
    private final ActionCommandFactory actionCommandFactory;

    Command(final String value, final int size, final ActionCommandFactory actionCommandFactory) {
        this.value = value;
        this.size = size;
        this.actionCommandFactory = actionCommandFactory;
    }

    public static StrategyCommand bind(final List<String> input) {
        return Arrays.stream(Command.values())
                .filter(command -> isSameCommand(input, command) && isSameSize(input, command))
                .map(command -> command.actionCommandFactory.create(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력값은 `start`, `end`, `move source target`, `status`만 가능합니다."));
    }

    private static boolean isSameCommand(final List<String> input, final Command command) {
        return command.value.equals(input.get(COMMAND_INDEX));
    }

    private static boolean isSameSize(final List<String> input, final Command command) {
        return command.size == input.size();
    }
}
