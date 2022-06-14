package com.daw.prog;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import java.util.*;

public class Ranking {

    public static final int TIE_SCORE = 50;

    public static final int WIN_SCORE = 100;

    private AsciiTable tableRanking;

    private ArrayList<Player> playerList;

    public Ranking() {

        this.playerList = new ArrayList<>();

    }

    public void printRanking() {

        tableRanking = new AsciiTable();

        tableRanking.addRule();
        tableRanking.addRow(null, null, "RANKING");
        tableRanking.addRule();
        tableRanking.addRow("POS", "NOMBRE", "PUNTUACION");
        tableRanking.addRule();

        int positionPlayer = 1;
        for (Player player: playerList) {
                tableRanking.addRow(positionPlayer, player.getName(), player.getScore());
                tableRanking.addRule();
                positionPlayer++;
        }

        tableRanking.setTextAlignment(TextAlignment.CENTER);

        System.out.println("\u001B[34m" + tableRanking.render(40) + "\u001B[0m");

    }

    public void inputPlayer(Player playerToAdd) {

        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getName().equalsIgnoreCase(playerToAdd.getName())) {
                playerToAdd.setScore(playerList.get(i).getScore());
                playerList.remove(i);
                break;
            }
        }

        int indexToAddPlayer = 0;

       for (Player player: playerList) {
           if (playerToAdd.getScore() < player.getScore()) {
               indexToAddPlayer++;
           } else {
               break;
           }
       }

        playerList.add(indexToAddPlayer,playerToAdd);

    }

}