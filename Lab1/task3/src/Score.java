public class Score {
    private static int score = 0;
    private static ScoreListener listener = null;
    public static int getScore(){
        return score;
    }

    public static void addListener(ScoreListener listener){
        Score.listener = listener;
    }

    public static void increment(){
        Score.score++;

        listener.action();
    }


}
