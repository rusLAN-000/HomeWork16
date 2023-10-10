package ru.netology.stats;

import java.util.ArrayList;

public class Game {
    private Player[] players = new Player[0];

    private Player[] addToArray(Player[] current, Player player) {
        Player[] tmp = new Player[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = player;
        return tmp;
    }

    public void add(Player player) {

        players = addToArray(players, player);
    }

    ArrayList<String> registered = new ArrayList<>();

    public void register(Player player) {

        registered.add(player.getName());

    }

    public int strength(String name) {

        Player[] tmp = new Player[players.length];

        for (Player player : players) {
            if (player.getName() == name) {
                return player.getStrength();
            }
        }
        return 0;
    }

    public int round(String playerName1, String playerName2) {

        if (!registered.contains(playerName1)) {
            throw new NotRegisteredException(
                    "Пользователь " + playerName1 + " не зарегистрирован на турнир"
            );
        }

        if (!registered.contains(playerName2)) {
            throw new NotRegisteredException(
                    "Пользователь " + playerName2 + " не зарегистрирован на турнир"
            );
        }

        int strength1 = strength(playerName1);
        int strength2 = strength(playerName2);

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else {
            return 0;
        }

    }

}
