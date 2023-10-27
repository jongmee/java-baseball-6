package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameController {

    private final GameService gameService;

    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    public Long gameStart() {
        return gameService.createComputerCode();
    }

    public Map<Grade, Integer> guessCode(final String inputCode, final Long computerCodeId) {
        return gameService.guessCode(inputCode, computerCodeId);
    }

    public boolean determineGameStatus(final Map<Grade, Integer> resultMap) {
        return gameService.determinePass(resultMap);
    }

    public boolean determineRestarting(final String commandInput) {
        final Integer command = validateCommand(commandInput);
        return gameService.determineRestarting(command);
    }

    public void initializeSetting(final Long computerCodeId) {
        gameService.removeComputerCode(computerCodeId);
    }

    private Integer validateCommand(final String command) {
        if(command.length() != 1) {
            throw new IllegalArgumentException("length of command must be 1.");
        }

        Integer digit = Character.getNumericValue(command.charAt(0));
        if(digit != 1 && digit != 2) {
            throw new IllegalArgumentException("not a valid input format. please enter 1 or 2.");
        }

        return digit;
    }

}
