package u8pp;


public class TicTacToeBoard {

    String[][] data;

    public TicTacToeBoard(String[][] data) {
        this.data = data;
    }

    public String toString() {
        String output = "";
        for(int r = 0; r < data.length; r++) {
            if(r != 0) {
                output += "\n";
                output += "-+".repeat(data[r].length - 1);
                output += "-";
                output += "\n";
            }
            for(int c = 0; c < data[r].length; c++) {
                if(c != 0) {
                    output += "|";
                }
                output += data[r][c];
            }
        }
        return output;
    }

    public boolean hasWin() {
        return hasDiagonalWin() || hasHorizontalWin() || hasVerticalWin();
    }

    public boolean hasHorizontalWin() {
        /* Your code here */
        for(int row = 0 ; row < data.length; row++){
            boolean result = true;
            String toCompare = data[row][0];
            if(!toCompare.equals("X") && !toCompare.equals("O")){
                result = false;
            }
            for(int col = 0; col < data[0].length; col++){
                if(!toCompare.equals(data[row][col])){
                    result = false;
                }
            }
            if(result == true)
                return true;
        }
        return false;
    }

    public boolean hasVerticalWin() {
        /* Your code here */
        for(int col = 0 ; col < data[0].length; col++){
            boolean result = true;
            String toCompare = data[0][col];
            if(!toCompare.equals("X") && !toCompare.equals("O")){
                result = false;
            }
            for(int row = 0; row < data.length; row++){
                if(!toCompare.equals(data[row][col])){
                    result = false;
                }
            }
            if(result == true)
                return true;
        }
        return false;
    }

    public boolean hasDiagonalWin() {
        /* Your code here */
        boolean result = true;
        String toCompare = data[0][0];
        if(!toCompare.equals("X") && !toCompare.equals("O"))
            result = false;

        for(int row = 0 ; row < data.length; row++){
            for(int col = 0; col < data[0].length; col++){
                if(row == col){
                    if(!toCompare.equals(data[row][col])){
                        result = false;
                    }
                }
            }
        }
        if(result == true)
                return true;
        

        result = true;
        toCompare = data[0][data.length - 1];

        for(int row = 0 ; row < data.length; row++){
            
            if(!toCompare.equals("X") && !toCompare.equals("O")){
                result = false;
            }
            for(int col = 0; col < data[0].length; col++){
                if(row == data.length - col - 1){
                    if(!toCompare.equals(data[row][col])){
                        result = false;
                    }
                }
            }
        }
        if(result == true)
                return true;
        return false;
    }

    /* helper functions go here */
   
}
