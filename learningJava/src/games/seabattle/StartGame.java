package games.seabattle;

public class StartGame {
    public StartGame() {
        Game game = new Game();
        game.start();
    }

    public static void main(String[] args) {
        // StartGame start= new StartGame();
        System.out.println(System.getProperties());
        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
        System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());
    }
}
