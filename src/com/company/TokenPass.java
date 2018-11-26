package com.company;

public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++)
        {
            board[i] = 1 + (int) (10* Math.random());
        }
        currentPlayer = (int) (playerCount * Math.random());
    }

    public void distributeCurrentPlayerTokens()
    {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while (numToDistribute > 0)
        {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }

    }
    public int gameOver()
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i] == 0)
                return i+1;
        }
        return -1;
    }
    public void nextPlayer()
    {
        currentPlayer = (currentPlayer+1)%board.length;
    }
    public void printBoard()
    {
        String x = "";
        for (int i = 1; i < board.length; i++)
        {
            x = x + "Player " + i + " : " + board[i-1] + " tokens \n";
        }
        System.out.println(x);
    }
}



