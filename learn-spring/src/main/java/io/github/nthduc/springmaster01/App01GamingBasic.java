package io.github.nthduc.learnspring;

import io.github.nthduc.learnspring.game.GameRunner;
import io.github.nthduc.learnspring.game.MarioGame;

public class App01GamingBasic {
    public static void main(String[] args) {

        // 1. Object Creation
        var marioGame = new MarioGame();
        //var superConTraGame = new SuperConTraGame();
        //var pacmaGame = new PacmaGame();

        // 2. Object Creation + Wiring of Dependencies
        // Game is Dependency of GameRunner
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
