package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputCode {
    private static final int CODE_SIZE = 3;

    private final List<Integer> inputCode;

    public InputCode(String stringCode) {
        validateSize(stringCode);
        List<Integer> codeNumbers = validateIntegerAndConvert(stringCode);
        validateDuplicate(codeNumbers);
        this.inputCode = codeNumbers;
    }

    public void validateSize(String stringCode) {
        if(stringCode.length() != CODE_SIZE) {
            throw new IllegalArgumentException("length of numbers must be "+CODE_SIZE);
        }
    }

    public List<Integer> validateIntegerAndConvert(String stringCode) {
        int digit;
        List<Integer> codeNumbers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            digit = Character.getNumericValue(stringCode.charAt(i));
            if(digit == -1 || digit == 0) {
                throw new IllegalArgumentException("not a valid input format. please enter an integer from 1 to 9.");
            }
            codeNumbers.add(digit);
        }
        return codeNumbers;
    }

    public void validateDuplicate(List<Integer> codeNumbers) {
        Set<Integer> numberSet = new HashSet<>(codeNumbers);
        if(numberSet.size() != codeNumbers.size()) {
            throw new IllegalArgumentException("you must enter three different numbers.");
        }
    }

    public List<Integer> getInputCode() {
        return inputCode;
    }
}
