package io.github.nthduc.springmaster02;

import io.github.nthduc.springmaster02.game.GameRunner;
import io.github.nthduc.springmaster02.game.GamingConsole;
import io.github.nthduc.springmaster02.game.PacmaGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("io.github.nthduc.springmaster02.game")
public class GamingAppLaucherApplication {

    @Bean
    public GamingConsole game(){
        var game  = new PacmaGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        System.out.println("Parameter:" + game);
        var gameRunner  = new GameRunner(game);
        return gameRunner;
    }

    /**
     *  @Primary - A Bean should be given preference when multiple candidatés are qualified
     *  @Qualifier - A specific bean should be auto-wired (name of the bean can be used as qualifier)
     *  @Qualifier has higher priority then @Primary
     * **/

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingAppLaucherApplication.class)){
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
