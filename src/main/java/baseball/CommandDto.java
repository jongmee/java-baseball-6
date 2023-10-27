package baseball;

public class CommandDto {
    private final Integer command;

    public CommandDto(String stringCommand) {
        this.command = validateAndConvertCommand(stringCommand);
    }

    Integer validateAndConvertCommand(String stringCommand) {
        if(stringCommand.length() != 1) {
            throw new IllegalArgumentException("length of command must be 1.");
        }

        Integer digit = Character.getNumericValue(stringCommand.charAt(0));
        if(digit != 1 && digit != 2) {
            throw new IllegalArgumentException("not a valid input format. please enter 1 or 2.");
        }

        return digit;
    }

    public Integer getCommand() {
        return command;
    }
}
