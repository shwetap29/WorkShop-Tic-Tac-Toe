package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {
    //Constants
    private static final int USER=1;
    private static final int COMPUTER=2;
    private static final int EMPTY=0;

    //  method to print board and passing parameters for player and computer moves
    public static void print_board(int[][] board, String userChoice, String computerChoice){
        System.out.print(printChar(board[0][0], userChoice, computerChoice));
        System.out.print("|");
        System.out.print(printChar(board[0][1], userChoice, computerChoice));
        System.out.print("|");
        System.out.println(printChar(board[0][2], userChoice, computerChoice));
        System.out.println("-----");
        System.out.print(printChar(board[1][0], userChoice, computerChoice));
        System.out.print("|");
        System.out.print(printChar(board[1][1], userChoice, computerChoice));
        System.out.print("|");
        System.out.println(printChar(board[1][2], userChoice, computerChoice));
        System.out.println("-----");
        System.out.print(printChar(board[2][0], userChoice, computerChoice));
        System.out.print("|");
        System.out.print(printChar(board[2][1], userChoice, computerChoice));
        System.out.print("|");
        System.out.println(printChar(board[2][2], userChoice, computerChoice));
    }

    public static String printChar(int b,String charChoice, String computerChoice) {
        switch (b){
            case EMPTY:
                return " ";
            case USER:
                return charChoice;
            case COMPUTER:
                return computerChoice;
        }
        return  " ";
    }

//player to select X OR O
    public static String moveChoice() {
        String computerChoice;
        String userChoice;
        System.out.println("Choose 1.for X and 2.for O");
        Scanner sc = new Scanner(System.in);
        int userChoiceNumber = sc.nextInt();
        if (userChoiceNumber == 1) {
            userChoice = "X";
        } else
            userChoice = "O";
        System.out.println("You have choosen: " + userChoice);

        return userChoice;
    }

    //method to get computers move by random
    public static int computerMove(int[][] board) {
        int move = (int) (Math.random() * 9);

        //using while loop  to insure its index free
        while(board[move/3][move%3] != EMPTY) {
            move = (int)(Math.random()*9);
        }
        int displayMove = move + 1;
        System.out.println("Computer Move : "+ displayMove);
        return move;
    }

    //method to get user move
    public static int userMove() {
        System.out.println("Please enter your move between 1 to 9");
        //taking user input for user move
        Scanner ac = new Scanner(System.in);
        int move = ac.nextInt();
        return move;
    }

    public static void main(String[] args) {

        //declaring constants
        int turn;
        int move;
        String choice = " ";
        String computerChoice;

        //creating multidimentional aray
        int[][] board = new int[3][3];
        String empty = " ";
        String emptyUser = " ";
        print_board(board, empty, emptyUser);
        String userChoice = moveChoice();
        if (userChoice == "X") {
            computerChoice = "O";
            turn = COMPUTER;
        }
        else {
            computerChoice = "X";
            turn = USER;
        }
        System.out.println("You have chose: " + userChoice + " so computer gets: " + computerChoice);
        System.out.println(USER+" "+ COMPUTER);
        while(true) {
            if (turn == USER) {
                move = -1;
                while (move<0 || move>8 || board[move/3][move%3] != EMPTY) {
                    move = userMove();
                    move = move-1;

                }
            }
            else
            {
                move = computerMove(board);
                board[(int)(move/3)][move%3] = turn;

            }
            board[(int)(move/3)][move%3] = turn;

            //printing board after move
            print_board(board, userChoice, computerChoice);

            if (turn == USER) {
                turn = COMPUTER;
            }
            else {
                turn = USER;
            }
        }
    }
    }

