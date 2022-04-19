public class Question {

    private String phrase;
    private boolean answer;
    private int difficulty;

    public Question(String phrase, boolean answer, int difficulty) {
        this.phrase = phrase;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public boolean checkAnswer(boolean guess) {
        return guess == this.answer;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

}
