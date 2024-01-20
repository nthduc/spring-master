package io.github.nthduc.learnspring.game;

public class GameRunner {
    private final GamingConsole game;
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game:" + game);
        game.up();
        game.down();
        game.left();
        game.down();
    }
}
