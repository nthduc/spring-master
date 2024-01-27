package io.github.nthduc.springmaster01.config;

import io.github.nthduc.springmaster01.game.GameRunner;
import io.github.nthduc.springmaster01.game.GamingConsole;
import io.github.nthduc.springmaster01.game.PacmaGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game  = new PacmaGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner  = new GameRunner(game);
        return gameRunner;
    }
}
