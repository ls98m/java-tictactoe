package com.daw.prog;

import static com.daw.prog.Game.getNewGame;

public class Main {

    public static void main(String[] args) {

        Ranking ranking = new Ranking();

        int option = Menu.chooseOption();

        while (option != Menu.EXIT_GAME) {
            if (option == Menu.PLAY_GAME) {
                Game game = getNewGame();
                game.playGame();
                for (Player player: game.getPlayersGame()) {
                    if (player.getScore() != 0) {
                        ranking.inputPlayer(player);
                    }
                }
                option = Menu.chooseOption();
            } else if (option == Menu.SHOW_RANKING) {
                ranking.printRanking();
                option = Menu.chooseOption();
            }
        }

    }

}