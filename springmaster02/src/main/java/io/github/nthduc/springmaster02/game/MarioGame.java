package io.github.nthduc.springmaster02.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("Jump <-> Nhảy");
    }

    @Override
    public void down() {
        System.out.println("Go into a hole <-> Đi vào 1 cái hố");
    }

    @Override
    public void left() {
        System.out.println("Go Left <-> Quẹo trái");
    }

    @Override
    public void right() {
        System.out.println("Accelerate <-> Chạy nhanh Thúc giục");
    }
}
