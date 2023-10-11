
package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void winPlayer1() {
        Player jack = new Player(1, "Джек", 130);
        Player nick = new Player(2, "Ник", 110);
        Game game = new Game();

        game.register(jack);
        game.register(nick);
        int actual = game.round("Джек", "Ник");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winPlayer2() {
        Player jack = new Player(1, "Джек", 100);
        Player nick = new Player(2, "Ник", 110);
        Game game = new Game();

        game.register(jack);
        game.register(nick);
        int actual = game.round("Джек", "Ник");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void friendshipWon() {
        Player jack = new Player(1, "Джек", 110);
        Player nick = new Player(2, "Ник", 110);
        Game game = new Game();

        game.register(jack);
        game.register(nick);
        int actual = game.round("Джек", "Ник");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void Player1NotRegistered() {
        Player jack = new Player(1, "Джек", 100);
        Player nick = new Player(2,"Ник", 120);
        Game game = new Game();

        game.register(jack);
        game.register(nick);
        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Лора","Ник"));
    }
    @Test
    public void Player2NotRegistered() {
        Player jack = new Player(1, "Джек", 100);
        Player nick = new Player(2,"Ник", 120);
        Game game = new Game();

        game.register(jack);
        game.register(nick);
        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Джек","Лора"));
    }
}