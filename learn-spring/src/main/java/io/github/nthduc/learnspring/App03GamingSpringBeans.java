package io.github.nthduc.learnspring;

import io.github.nthduc.learnspring.config.GamingConfiguration;
import io.github.nthduc.learnspring.game.GameRunner;
import io.github.nthduc.learnspring.game.GamingConsole;
import io.github.nthduc.learnspring.game.MarioGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}





//        // 1. Object Creation
//        var marioGame = new MarioGame();
//        //var superConTraGame = new SuperConTraGame();
//        //var pacmaGame = new PacmaGame();
//
//        // 2. Object Creation + Wiring of Dependencies
//        // Game is Dependency of GameRunner
//        var gameRunner = new GameRunner(marioGame);
//        gameRunner.run();
