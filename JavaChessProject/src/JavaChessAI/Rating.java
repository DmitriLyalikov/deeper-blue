package JavaChessAI;

import java.util.ArrayList;

public class Rating extends ABchess {
	 // Define the static arrays that hold the "board" scores for different pieces
    // The scores are based on the position of the pieces on the board
    // The board is represented as an 8x8 grid with rows numbered from 0 to 7 and columns numbered from 0 to 7
    static int pawnBoard[][]={//attribute to http://chessprogramming.wikispaces.com/Simplified+evaluation+function
        { 0,  0,  0,  0,  0,  0,  0,  0},
        {50, 50, 50, 50, 50, 50, 50, 50},
        {10, 10, 20, 30, 30, 20, 10, 10},
        { 5,  5, 10, 25, 25, 10,  5,  5},
        { 0,  0,  0, 20, 20,  0,  0,  0},
        { 5, -5,-10,  0,  0,-10, -5,  5},
        { 5, 10, 10,-20,-20, 10, 10,  5},
        { 0,  0,  0,  0,  0,  0,  0,  0}};
    static int rookBoard[][]={
        { 0,  0,  0,  0,  0,  0,  0,  0},
        { 5, 10, 10, 10, 10, 10, 10,  5},
        {-5,  0,  0,  0,  0,  0,  0, -5},
        {-5,  0,  0,  0,  0,  0,  0, -5},
        {-5,  0,  0,  0,  0,  0,  0, -5},
        {-5,  0,  0,  0,  0,  0,  0, -5},
        {-5,  0,  0,  0,  0,  0,  0, -5},
        { 0,  0,  0,  5,  5,  0,  0,  0}};
    static int knightBoard[][]={
        {-50,-40,-30,-30,-30,-30,-40,-50},
        {-40,-20,  0,  0,  0,  0,-20,-40},
        {-30,  0, 10, 15, 15, 10,  0,-30},
        {-30,  5, 15, 20, 20, 15,  5,-30},
        {-30,  0, 15, 20, 20, 15,  0,-30},
        {-30,  5, 10, 15, 15, 10,  5,-30},
        {-40,-20,  0,  5,  5,  0,-20,-40},
        {-50,-40,-30,-30,-30,-30,-40,-50}};
    static int bishopBoard[][]={
        {-20,-10,-10,-10,-10,-10,-10,-20},
        {-10,  0,  0,  0,  0,  0,  0,-10},
        {-10,  0,  5, 10, 10,  5,  0,-10},
        {-10,  5,  5, 10, 10,  5,  5,-10},
        {-10,  0, 10, 10, 10, 10,  0,-10},
        {-10, 10, 10, 10, 10, 10, 10,-10},
        {-10,  5,  0,  0,  0,  0,  5,-10},
        {-20,-10,-10,-10,-10,-10,-10,-20}};
    static int queenBoard[][]={
        {-20,-10,-10, -5, -5,-10,-10,-20},
        {-10,  0,  0,  0,  0,  0,  0,-10},
        {-10,  0,  5,  5,  5,  5,  0,-10},
        { -5,  0,  5,  5,  5,  5,  0, -5},
        {  0,  0,  5,  5,  5,  5,  0, -5},
        {-10,  5,  5,  5,  5,  5,  0,-10},
        {-10,  0,  5,  0,  0,  0,  0,-10},
        {-20,-10,-10, -5, -5,-10,-10,-20}};
    static int kingMidBoard[][]={
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-20,-30,-30,-40,-40,-30,-30,-20},
        {-10,-20,-20,-20,-20,-20,-20,-10},
        { 20, 20,  0,  0,  0,  0, 20, 20},
        { 20, 30, 10,  0,  0, 10, 30, 20}};
    static int kingEndBoard[][]={
        {-50,-40,-30,-20,-20,-30,-40,-50},
        {-30,-20,-10,  0,  0,-10,-20,-30},
        {-30,-10, 20, 30, 30, 20,-10,-30},
        {-30,-10, 30, 40, 40, 30,-10,-30},
        {-30,-10, 30, 40, 40, 30,-10,-30},
        {-30,-10, 20, 30, 30, 20,-10,-30},
        {-30,-30,  0,  0,  0,  0,-30,-30},
        {-50,-30,-30,-30,-30,-30,-30,-50}};
    static int kingCheckmateBoardAdjustedLateGame[][]={
            {-30,-20,-10,  0,  0,-10,-20,-30},
            {-20,-10,  0, 10, 10,  0,-10,-20},
            {-10,  0, 20, 30, 30, 20,  0,-10},
            {  0, 10, 30, 40, 40, 30, 10,  0},
            {  0, 10, 30, 40, 40, 30, 10,  0},
            {-10,  0, 20, 30, 30, 20,  0,-10},
            {-20,-10,  0, 10, 10,  0,-10,-20},
            {-30,-20,-10,  0,  0,-10,-20,-30}};
 // The rating function that determines the quality of a given chess move
    public static int rating(int list, int depth) {
    	// Initialize the counter to 0 and calculate the material score
        int counter=0, material=rateMaterial();
     // Add the scores from attack, material, movability, and positional factors
        counter+=rateAttack();
        counter+=material;
        counter+=rateMoveablitly(list, depth, material);
        counter+=ratePositional(material);
        // Flip the board, recalculate the material score, and subtract the scores from attack, material, 
        // movability, and positional factors from the counter
        ABchess.flipBoard();
        material=rateMaterial();
        counter-=rateAttack();
        counter-=material;
        counter-=rateMoveablitly(list, depth, material);
        counter-=ratePositional(material);
     // Flip the board back and return the negative counter plus the depth multiplied by 50
        ABchess.flipBoard();
        return -(counter+depth*50);
    }
 // The attack factor of the rating function, which determines the risk of a given move
    public static int rateAttack() {
        int counter=0;
        int tempPositionC=ABchess.kingPositionC;
     // Iterate through the board and add scores for each attacking piece
        for (int i=0;i<64;i++) {
            switch (ABchess.chessBoard[i/8][i%8]) {
                case "P": {ABchess.kingPositionC=i; if (!ABchess.kingSafe()) {counter-=64;}}
                    break;
                case "R": {ABchess.kingPositionC=i; if (!ABchess.kingSafe()) {counter-=500;}}
                    break;
                case "K": {ABchess.kingPositionC=i; if (!ABchess.kingSafe()) {counter-=300;}}
                    break;
                case "B": {ABchess.kingPositionC=i; if (!ABchess.kingSafe()) {counter-=300;}}
                    break;
                case "Q": {ABchess.kingPositionC=i; if (!ABchess.kingSafe()) {counter-=900;}}
                    break;
            }
        }
     // Reset the position of the king and subtract 200 if the king is not safe
        ABchess.kingPositionC=tempPositionC;
        if (!ABchess.kingSafe()) {counter-=200;}
        return counter/2; // Divide the counter by 2 for balance
    }
 // The material factor of the rating function, which adds up the scores for all pieces on the board
    public static int rateMaterial() {
        int counter=0, bishopCounter=0;
     // Iterate through the board and add scores for each piece type
        for (int i=0;i<64;i++) {
            switch (ABchess.chessBoard[i/8][i%8]) {
                case "P": counter+=200;
                    break;
                case "R": counter+=1000;
                    break;
                case "K": counter+=600;
                    break;
                case "B": bishopCounter+=1;
                    break;
                case "Q": counter+=1800;
                    break;
            }
        }
        if (bishopCounter>=2) {
            counter+=300*bishopCounter;
        } else {
            if (bishopCounter==1) {counter+=250;}
        }
        return counter;
    }
    public static int rateMoveablitly(int listLength, int depth, int material) {
        int counter=0;
        counter+=listLength;//5 pointer per valid move
        if (listLength==0) {//current side is in checkmate or stalemate
            if (!ABchess.kingSafe()) {//if checkmate
                counter+=-200000*depth;
            } else {//if stalemate
                counter+=-150000*depth;
            }
        }
        return counter;
    }
    public static int ratePositional(int material) {
        int counter=0;
        for (int i=0;i<64;i++) {
            switch (ABchess.chessBoard[i/8][i%8]) {
                case "P": counter+=pawnBoard[i/8][i%8];
                    break;
                case "R": counter+=rookBoard[i/8][i%8];
                    break;
                case "K": counter+=knightBoard[i/8][i%8];
                    break;
                case "B": counter+=bishopBoard[i/8][i%8];
                    break;
                case "Q": counter+=queenBoard[i/8][i%8];
                    break;
                case "A": if (material>=3500) {counter+=kingMidBoard[i/8][i%8]; counter+=ABchess.posibleA(ABchess.kingPositionC).length()*10;} else
                {counter+=kingEndBoard[i/8][i%8]; counter+=ABchess.posibleA(ABchess.kingPositionC).length()*10;}
                    break;
            }
        }
        return counter;
    }
    
}