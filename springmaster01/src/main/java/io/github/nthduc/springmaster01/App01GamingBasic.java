package io.github.nthduc.springmaster01;

import io.github.nthduc.springmaster01.game.GameRunner;
import io.github.nthduc.springmaster01.game.MarioGame;

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
