package baseball.view;

public class OutputView {

    public static void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrike(){
        System.out.println("스트라이크");
    }

    public static void printBall(){
        System.out.println("볼");
    }

    /**
     * a볼 b스트라이크 -> "볼 " + "스트라이크"
     */
    public static void printBallWithStrike(){
        System.out.println("볼 ");
    }

    public static void printNothing(){
        System.out.println("낫싱");
    }

    public static void printEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}