package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {
    //Constants
    private static final int USER=1;
    private static final int COMPUTER=2;
    private static final int EMPTY=0;
    private static int stalemate=0;
    //private static int none = 0;

    //method to create board
    public static void print_board(int[][] board, String userChoice, String computerChoice) {
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

    //method for printing user choice or cumputer choice on board
    public static String printChar(int b, String userChoice, String computerChoice) {

        switch(b) {
            case EMPTY:
                return " ";
            case USER:
                return userChoice;
            case COMPUTER:
                return computerChoice;
        }
        return  " ";
    }

    //method tp decide move choice that is who gets X and who gets O
    public static String moveChoice() {
        String computerChoice;
        String userChoice;
        System.out.println("Choose 1 for X and 2 for O");
        Scanner sc = new Scanner(System.in);
        int userChoiceNumber = sc.nextInt();
        if (userChoiceNumber == 1) {
            userChoice = "X";
        }
        else
            userChoice = "O";

        System.out.println("You Have choose: " + userChoice);

        return userChoice;
    }

    //methode to decide computer move using random
    public static int computerMove(int[][] board) {
        int move = (int)(Math.random()*9);

        //using while loop and condition to get position on board of multidimentional array
        while(board[move/3][move%3] != EMPTY) {
            move = (int)(Math.random()*9);
        }
        int displayMove = move + 1;
        System.out.println("Computer Move : "+ displayMove);
        return move;
    }

    //method  for user to select its move
    public static int userMove() {
        System.out.println("Please Enter Your Move Between 1 To 9");
        Scanner ac = new Scanner(System.in);
        int move = ac.nextInt();
        return move;
    }

    //method to check winning combinations
    public static int checkWinner(int[][] board) {


        if((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
            return board[0][0];

        if((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
            return board[1][0];

        if((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
            return board[2][0];


        if((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
            return board[0][0];

        if((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
            return board[0][1];

        if((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
            return board[0][2];


        if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
            return board[0][0];

        if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
            return board[0][2];



        return stalemate;
    }

    public static void main(String[] args) {

        //initializing variables
        int turn;
        int move, win;
        int counter = 0;
        String choice = " ";
        String computerChoice;
        int[][] board = new int[3][3];
        String empty = " ";
        String emptyUser = " ";
        print_board(board, empty, emptyUser);
        String userChoice = moveChoice();

        //toss to determine who plays first
        int toss = (int)(Math.random()*2);
        if (toss==0) {
            turn = USER;
            System.out.println("You Have Won The Toss !!");

        }
        else {
            turn = COMPUTER;
            System.out.println("Computer Has Won The Toss !!");

        }
        if (userChoice == "X") {
            computerChoice = "O";
        }
        else {
            computerChoice = "X";
        }
        System.out.println("You have chose: " + userChoice + " so computer gets: " + computerChoice);
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
            print_board(board, userChoice, computerChoice);
            win = checkWinner(board);
            counter = counter + 1;

            if ( win != stalemate ) {
                break;
            }

            if (counter == 9) {
                System.out.println("It's a Tie!!!");
                break;
            }
            if (turn == USER) {
                turn = COMPUTER;
            }
            else {
                turn = USER;
            }

        }
        switch(win) {
            case USER:
                System.out.println("You Have Won");
                break;
            case COMPUTER:
                System.out.println("Computer Won");
                break;
            default:
                break;
        }
    }
    }

