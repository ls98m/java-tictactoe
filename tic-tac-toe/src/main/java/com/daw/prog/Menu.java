package com.daw.prog;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Scanner;

public class Menu {

    public static final int PLAY_GAME = 1;

    public static final int SHOW_RANKING = 2;

    public static final int EXIT_GAME = 3;

    private static final Scanner keyboard = new Scanner(System.in);

    public static int chooseOption() {

        int numShowMenu = 0;

        int optionChoseed;

        do {
            numShowMenu++;
            printMenu();
            if (numShowMenu >= 2) {
                System.out.println("OPCIÓN INVALIDA, INSERTE UN NUMERO ENTRE 1 Y 3 PORFAVOR");
            }
            System.out.print("OPCIÓN SELECCIONADA: ");
            optionChoseed = keyboard.nextInt();
        } while (optionChoseed > 3 || optionChoseed < 1);

        return optionChoseed;

    }

    private static void printMenu() {

        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("TIC TAC TOE");
        table.addRule();
        table.addRow(PLAY_GAME + ") JUGAR");
        table.addRule();
        table.addRow(SHOW_RANKING + ") VER RANKING");
        table.addRule();
        table.addRow(EXIT_GAME + ") SALIR DEL JUEGO");
        table.addRule();
        
        table.setTextAlignment(TextAlignment.CENTER);

        System.out.println("\u001B[35m" + table.render(30) + "\u001B[0m");

    }

}