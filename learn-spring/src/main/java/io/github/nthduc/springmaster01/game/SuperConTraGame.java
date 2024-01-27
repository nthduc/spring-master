package io.github.nthduc.learnspring.game;

public class SuperConTraGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("Up");
    }
    @Override
    public void down() {
        System.out.println("Shit down <-> Ngồi");
    }
    @Override
    public void left() {
        System.out.println("Go back");
    }
    @Override
    public void right() {
        System.out.println("Shot a bullet <-> Bắn viên đạn");
    }
}
