package baseball.controller;

import baseball.model.NumberComparator;
import baseball.model.ProgramNumber;
import baseball.model.ResetGameNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final NumberComparator numberComparator = new NumberComparator();
    private ProgramNumber programNumber;
    private UserNumber userNumber;

    private static final String RESET_COMMAND = "1";
    private static final int NUMBER_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public void run() {
        OutputView.printStart();
        do {
            playGame();
        } while (isResetRequested());
    }

    private void playGame() {
        programNumber = new ProgramNumber(NUMBER_SIZE, START_NUMBER, END_NUMBER);
        do {
            userNumber = new UserNumber(InputView.inputUserNumber());
            int[] result = getResultList();
            OutputView.printScoreMessage(result[0], result[1]);
        } while (!isAnswer());
    }

    private boolean isAnswer() {
        if (numberComparator.isAllStrike(NUMBER_SIZE)) {
            OutputView.printEnd();
            return true;
        }
        return false;
    }

    private int[] getResultList() {
        return numberComparator.getStrikeBall(userNumber.getUserNumber(), programNumber.getProgramNumber());
    }

    private boolean isResetRequested() {
        ResetGameNumber resetGameNumber = new ResetGameNumber(InputView.resetNumber());
        return resetGameNumber.getResetNumber().equals(RESET_COMMAND);
    }
}
