import java.util.*;
public class TTTGame {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        TTTBoard board = new TTTBoard();

        Random gen = new Random();
        char player;
        if(gen.nextInt(2)== 1)
            player = 'O';
        else
            player = 'X';

        while(board.getWinner(player) == '-' && !board.full()){

            System.out.println(board.toString());
            System.out.println(player + "'s turn");
            System.out.println("Enter the row and colum[1-3, space, 1-3]:");

            int row = reader.nextInt();
            int colum =reader.nextInt();

            boolean success = board.placeXorO(player, row, colum);
            if(! success)
                System.out.println("Error: cell already occupied!");
            else{
                if (board.getWinner(player) != '-') {
                    break;
                }
                if(player == 'X')
                    player = 'O';
                else
                    player = 'X';
            }
        }

        char winner = board.getWinner(player);
        if(winner != '-') {
            System.out.println(board.toString());
            System.out.println(winner + "'s win!");
        }
        else
            System.out.println("Its a draw!");
    }
}




