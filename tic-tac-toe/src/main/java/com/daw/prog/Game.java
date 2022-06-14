package com.daw.prog;

import java.util.*;

public class Game {

    private static Player player1;

    private static Player player2;

    private Board board;

    private static Player currentPlayer;

    private final static Scanner keyboard = new Scanner(System.in);

    private Game(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player2;

    }

    public void playGame() {

        int currentTurn = 0;
        int maxTurns = 6;

        while (!board.isWinner(currentPlayer)){
            changePlayer();

            currentTurn++;

            insertToken(currentPlayer);

            if (currentTurn == maxTurns && !board.isWinner(currentPlayer)) {
                board.printBoard();
                System.out.println("HABEIS EMPATADO");
                for (Player player: getPlayersGame()) {
                    player.setScore(Ranking.TIE_SCORE);
                }
                board.cleanBoard();
                currentTurn = 0;
            } else if (board.isWinner(currentPlayer)) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " HAS GANADO!");
                currentTurn = 0;
                currentPlayer.setScore(Ranking.WIN_SCORE);
            }
        }

    }

    private void changePlayer() {

        if (getCurrentPlayer() == player1) {
            this.currentPlayer = player2;
        } else {
            this.currentPlayer = player1;
        }

    }

    public static Game getNewGame() {

        Player player1 = getNewPlayer();
        Player player2 = getNewPlayer();

        Game game = new Game(player1, player2);

        return game;

    }

    private static Player getNewPlayer() {

        System.out.print("\nIntroduce el nombre del jugador: ");
        String name = keyboard.next();

        System.out.print("\n" + name + " elige un token: ");
        char token = keyboard.next().charAt(0);

        Player player = new Player(name, token);

        return player;

    }


    private void insertToken(Player player) {

        board.printBoard();

        System.out.println(player.getName() + " inserta el toquen en una posición\n");
        int position = keyboard.nextInt();

        while (!board.checkPosition(position)) {
            board.printBoard();
            System.out.println("POSICIÓN INVALIDA, INSERTELA DE NUEVO.");
            position = keyboard.nextInt();
        }

        board.insertToken(player, position);

    }


    private Player getCurrentPlayer() {

        return currentPlayer;

    }

    public Player[] getPlayersGame() {

        Player[] totalPlayers = new Player[]{player1,player2};

        return totalPlayers;

    }

}