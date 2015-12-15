public class TTTBoard {

    private char[][] board;

    public TTTBoard() {
        board = new char[3][3];
        reset();
    }

    public void reset() {
        for (int row = 0; row < 3; row++)
            for (int colum = 0; colum < 3; colum++)
                board[row][colum] = '-';
    }

    public boolean full() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getWinner(char player) {
        //horizontal
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != player)
                    break;
                if (col == board.length - 1)
                    return player;
            }
        }
        //vertical
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != player)
                    break;
                if (row == board.length - 1)
                    return player;
            }
        }
        //diagonal (L-R)
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player)
                break;
            if (i == board.length - 1)
                return player;
        }
        //diagonal (R-L)
        int row = 0;
        for (int col = board.length - 1; col < board.length; col--) {
            if (board[row][col] != player)
                break;
            if (col == 0)
                return player;
            row++;
        }
        return '-';
    }

    public String toString() {
        String result = "\n";
        for (int row = 0; row < 3; row++) {
            for (int colum = 0; colum < 3; colum++)
                result += board[row][colum];
            result += "\n";
        }
        return result;
    }

    public boolean placeXorO(char player, int row, int colum) {
        if (board[row - 1][colum - 1] == '-') {
            board[row - 1][colum - 1] = player;
            return true;
        } else
            return false;
    }
}
