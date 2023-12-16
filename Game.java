import java.util.*;
import java.util.Random;
class TicTacToe{
    static char[][] board;
    public TicTacToe(){
        board=new char[3][3];
        initboard();
    }
    void initboard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }
    static void dispBoard(){

        System.out.println("------------");
        for(int i=0;i<board.length;i++){
            System.out.print("|");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("------------");
        }

    }

    static void placemark(int row,int column,char mark){
        if(row>=0 && row<=2 && column>=0 && column<=2){
            board[row][column]=mark;
        }
        else{
            System.out.println("Invalid position");
        }
       
    }
    static boolean col(){
        for(int j=0;j<=2;j++){
            if(board[0][j]!=' ' && board[0][j]==board[1][j] && 
               board[1][j]==board[2][j]){
                return true;
            }
        }
        return false;
    }
     static boolean row(){
        for(int i=0;i<=2;i++){
            if(board[i][0]!=' ' && board[i][0]==board[i][1] && 
               board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;
    }
     static boolean diagonal(){
        if(board[0][0]!=' ' && board[0][0]==board[1][1] && 
           board[1][1]==board[2][2] || board[0][2]!=' ' && 
           board[0][2]==board[1][1] && board[1][1]==board[2][0] ){
            return true;
            }
            else{
            return false;
            }
    }
    static boolean Draw(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
}
abstract class Player{
    String name;
    char mark;
    abstract void makeMove();
    boolean isValidMove(int row,int col){
        if(row>=0 && row <=2 &&
            col >=0 && col<=2){
                if(TicTacToe.board[row][col]==' '){
                    return true;
                }

            }
            return false;

    }
}
class Human extends Player{
    
    Human(String name,char mark){
        this.name=name;
        this.mark=mark;
    }
    void makeMove(){
        Scanner sc=new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println("Enter a row and col : ");
             row=sc.nextInt();
             col=sc.nextInt();
        }while(!isValidMove(row,col));
        TicTacToe.placemark(row, col, mark);
    }
}
class AI extends Player{
    AI(String name,char mark){
        this.name=name;
        this.mark=mark;
    }
    void makeMove(){
        Scanner sc=new Scanner(System.in);
        int row;
        int col;
        do{
           Random r = new Random();
           row = r.nextInt(3);
           col = r.nextInt(3);
        }while(!isValidMove(row,col));
        TicTacToe.placemark(row, col, mark);
    }
}
public class Game {
    public static void main(String[] args) {
        TicTacToe t=new TicTacToe();
        Human p1=new Human("Bob",'x');
        AI p2 = new AI("tai", 'o');
        //Human p2=new Human("Pri", 'o');
        
        Player cp;
        cp=p1;
        while(true){
        System.out.println(cp.name+" Turn");
        cp.makeMove();
        TicTacToe.dispBoard();
        if(TicTacToe.col()||TicTacToe.row()||TicTacToe.diagonal()){
            System.out.println(cp.name+" has won");
            break;
        }
        else if(TicTacToe.Draw()){
            System.out.println("Game is draw");
            break;
        }
        else{
            if(cp==p1){
                cp=p2;
            }
            else{
                cp=p1;
            }
        }
    }
        // t.dispBoard();
        // System.out.println(t.diagonal());
        // System.out.println(t.row());
        // System.out.println(t.col());
        
        
    }
    
}
