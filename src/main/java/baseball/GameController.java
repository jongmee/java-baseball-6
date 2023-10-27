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
        return gameService.determineRestarting(commandInput);
    }

    public void initializeSetting(final Long computerCodeId) {
        gameService.removeComputerCode(computerCodeId);
    }

}
