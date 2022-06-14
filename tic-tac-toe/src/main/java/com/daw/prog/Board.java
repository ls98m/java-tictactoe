package com.daw.prog;

public class Board {

    private char[][] position;

    Board() {

        this.position = new char[3][3];
        cleanBoard();

    }


    public void printBoard() {

        for (int i = 0;i < getPosition().length;i++) {
            if (i == 1 || i == 2){
                System.out.println(addHorizontalLine());
            }

            for (int j = 0;j < getPosition()[i].length;j++) {
                if (j == 1 || j == 2) {
                    System.out.print(addVerticalLine());
                }

                System.out.print(getPosition()[i][j]);

                if (j == 2 || j == 5) {
                    System.out.println();
                }
            }

            if (i == getPosition().length - 1) {
                System.out.println();
            }
        }

    }

    public void cleanBoard() {

        for (int i = 0;i < getPosition().length;i++) {
            for (int j = 0;j < getPosition()[i].length;j++) {
                getPosition()[i][j] = ' ';
            }

        }

    }

    public void insertToken(Player player,int numberImput) {

        if (numberImput == 1) {
            position[2][0] = player.getToken();
        } else if (numberImput == 2) {
            position[2][1] = player.getToken();
        } else if (numberImput == 3) {
            position[2][2] = player.getToken();
        } else if (numberImput == 4) {
            position[1][0] = player.getToken();
        } else if (numberImput == 5) {
            position[1][1] = player.getToken();
        } else if (numberImput == 6) {
            position[1][2] = player.getToken();
        } else if (numberImput == 7) {
            position[0][0] = player.getToken();
        } else if (numberImput == 8) {
            position[0][1] = player.getToken();
        } else if (numberImput == 9) {
            position[0][2] = player.getToken();
        }

    }

    public boolean isWinner(Player player) {

        String token = String.valueOf(player.getToken() + player.getToken() + player.getToken());

        int totalWinningCombinations = getWinningCombinations().length;

        for (int i = 0;i < totalWinningCombinations; i++) {
            if (token.equals(getWinningCombinations()[i])) {
                return true;
            }
        }

        return false;

    }

    public boolean checkPosition(int numberImput) {

        if (!isValidRangePosition(numberImput) || !isEmpty(numberImput)) {
            return false;
        }

        return true;

    }

    private char getConversionPosition(int numberImput) {

        if (numberImput == 1) {
            return position[2][0];
        } else if (numberImput == 2) {
            return position[2][1];
        } else if (numberImput == 3) {
            return position[2][2];
        } else if (numberImput == 4) {
            return position[1][0];
        } else if (numberImput == 5) {
            return position[1][1];
        } else if (numberImput == 6) {
            return position[1][2];
        } else if (numberImput == 7) {
            return position[0][0];
        } else if (numberImput == 8) {
            return position[0][1];
        } else if (numberImput == 9) {
            return position[0][2];
        }

        return 0;

    }

    private String[] getWinningCombinations() {

        String[] winningCombination = new String[7];
        winningCombination[0] = String.valueOf(getPosition()[0][0] + getPosition()[1][0] + getPosition()[2][0]);
        winningCombination[1] = String.valueOf(getPosition()[0][0] + getPosition()[0][1] + getPosition()[0][2]);
        winningCombination[2] = String.valueOf(getPosition()[0][2] + getPosition()[1][2] + getPosition()[2][2]);
        winningCombination[3] = String.valueOf(getPosition()[2][0] + getPosition()[2][1] + getPosition()[2][2]);
        winningCombination[4] = String.valueOf(getPosition()[0][0] + getPosition()[1][1] + getPosition()[2][2]);
        winningCombination[5] = String.valueOf(getPosition()[0][1] + getPosition()[1][1] + getPosition()[2][1]);
        winningCombination[6] = String.valueOf(getPosition()[1][0] + getPosition()[1][1] + getPosition()[1][2]);

        return winningCombination;

    }

    private boolean isValidRangePosition(int numberImput) {

        if (numberImput > 9 || numberImput < 1) {
            return false;
        }

        return true;

    }

    private boolean isEmpty(int numImput) {

        char empty = ' ';

        if (getConversionPosition(numImput) == empty) {
            return true;
        }

        return false;

    }


    private String addVerticalLine() {

        String line = "\033[32m | \u001B[0m";

        return line;

    }

    private String addHorizontalLine() {

        String line = "\033[32m---------\u001B[0m";

        return line;

    }

    private char[][] getPosition() {

        return position;

    }

}