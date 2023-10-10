
package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class GameTest {

        Game game = new Game();

        Player player1 = new Player(1, "Саша", 5);
        Player player2 = new Player(2, "Света", 2);
        Player player3 = new Player(3, "Максим", 3);
        Player player4 = new Player(4, "Женя", 5);
        Player player5 = new Player(5, "Влад", 4);

        @Test
        public void registerTest() {

            game.register(player1);
            game.register(player2);
            game.register(player4);
            game.register(player5);

            String[] expected = {"Саша", "Света", "Женя", "Влад"};

            Assertions.assertArrayEquals(expected, game.registered.toArray());

        }

        @Test
        public void StrengthPlayerOneMoreStrengthPlayerTwo() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            game.register(player1);
            game.register(player2);

            int expected = 1;
            int actual = game.round("Саша", "Света");

            Assertions.assertEquals(expected, actual);

        }

        @Test
        public void StrengthPlayerOneLessStrengthPlayerTwo() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            game.register(player1);
            game.register(player2);

            int expected = 2;
            int actual = game.round("Света", "Саша");

            Assertions.assertEquals(expected, actual);

        }

        @Test
        public void StrengthPlayerOneEqualStrengthPlayerTwo() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            game.register(player1);
            game.register(player4);

            int expected = 0;
            int actual = game.round("Саша", "Женя");

            Assertions.assertEquals(expected, actual);

        }

        @Test
        public void NotRegisteredPlayerOne() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            game.register(player2);
            game.register(player4);
            game.register(player5);


            Assertions.assertThrows(NotRegisteredException.class, () -> {
                game.round("Саша", "Света");
            });

        }

        @Test
        public void NotRegisteredPlayerTwo() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            game.register(player1);
            game.register(player4);
            game.register(player5);


            Assertions.assertThrows(NotRegisteredException.class, () -> {
                game.round("Саша", "Света");
            });

        }

        @Test
        public void NotRegisteredTwoPlayers() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            game.register(player3);
            game.register(player4);
            game.register(player5);


            Assertions.assertThrows(NotRegisteredException.class, () -> {
                game.round("Саша", "Света");
            });
        }

        @Test
        public void strengthPlayerInGame() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            int expected = 5;
            int actual = game.strength("Женя");

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void strengthPlayerNotInGame() {

            game.add(player1);
            game.add(player2);
            game.add(player3);
            game.add(player4);
            game.add(player5);

            int expected = 0;
            int actual = game.strength("Павел");

            Assertions.assertEquals(expected, actual);
        }

    }

