import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);

    private LinkedList<Question> questions;
    private String playerName;
    private int score = 0;
    private int correct = 0;

    public void start() {
        System.out.println(". : TRIVIAL : .");
        System.out.println("Nom: ");
        this.playerName = sc.nextLine();
        this.questions = this.generateQuestions();
        Collections.shuffle(this.questions);

        for(Question q : questions) {
            this.showQuestion(q);
        }

        System.out.println();
        this.showStats();
        System.out.println("Gracias por jugar!");
    }

    private LinkedList<Question> generateQuestions() {
        LinkedList<Question> res = new LinkedList<Question>();

        res.add(new Question("El Ziad es de galicia?", false, 1));
        res.add(new Question("El Real Madrid va a ganar la champions?", false, 1));
        res.add(new Question("El ramadan empezo el dia 2 de abril?", true, 4));
        res.add(new Question("La sagrada familia esta acabada?", false, 2));
        res.add(new Question("Aprobaremos la carrera?", false, 1));
        res.add(new Question("Es Belmopan la capital de Belice?", true, 5));
        res.add(new Question("Era Adolf Hitler aleman?", false, 3));
        res.add(new Question("Fumar perjudica seriamente la salud?", true, 1));
        res.add(new Question("El hombre piso la luna en 1969?", true, 2));
        res.add(new Question("La guerra de los cien años duro? 116 años?", true, 3));

        return res;
    }

    private void showQuestion(Question q) {
        System.out.println();
        System.out.println(q.getPhrase() + " (c/f)");
        System.out.println("Respuesta: ");
        boolean guess = sc.nextLine().equals("c");
        if(q.checkAnswer(guess)) {
            this.score += q.getDifficulty();
            this.correct++;
            System.out.println("Respuesta correcta! Has ganado " + q.getDifficulty() + " puntos (TOTAL: " + this.score + ")");
        } else {
            System.out.println("Respuesta incorrecta!");
        }
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();
        sc = new Scanner(System.in);
    }

    private void showStats() {
        System.out.println("Total respostes correctes: " + this.correct);
        System.out.println("Puntuacio total: " + this.score);
        System.out.println("% de respostes correctes: " + (this.correct * 100 / this.questions.size()) + "%");
    }

    public static void main(String args[]) {
        new Game().start();
    }

}
