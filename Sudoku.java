public class Sudoku {
	
	
    private int size;                 //Size of the grid.
    
    private int[][] grid;			  //The sudoku grid itself.

    
    
    //Initializing to initialise sudoku grid and its size
    public Sudoku(int[][] numbers) {
        this.size = numbers.length;
        this.grid = numbers;
    }

    
    //Getter for size
    public int getSize() {
        return this.size;
    }

    
    //Getter for grid
    public int[][] getGrid() {
        return this.grid;
    }
    
    
    //Returns the digit at a specific row and column in the grid
    public int getDigitAt(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return -1;
        }
        return grid[row][col];
    }
    
    
    
    // Checks if a row is valid (took too long to figure out!!!!)
    
    public boolean isValidRow(int row) {
        if (row < 0 || row >= size) {
            return false;
        }

        boolean[] seen = new boolean[size + 1];
        for (int col = 0; col < size; col++) {
            int value = grid[row][col];
            if (value < 1 || value > size || seen[value]) {
                return false;
            }
            seen[value] = true;
        }

        return true;
    }
    
    
    
    // Checks the same for the column
    
    public boolean isValidCol(int col) {
        if (col < 0 || col >= size) {
            return false;
        }

        boolean[] seen = new boolean[size + 1];
        for (int row = 0; row < size; row++) {
            int value = grid[row][col];
            if (value < 1 || value > size || seen[value]) {
                return false;
            }
            seen[value] = true;
        }

        return true;
    }

    
    // Checks if a box is valid
    
    public boolean isValidBox(int row, int col) {
        if (row < 0 || row > size - 3 || col < 0 || col > size - 3) {
            return false;
        }

        boolean[] seen = new boolean[10]; // size of box is always 3, so digits are from 1 to 9
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int value = grid[i][j];
                if (value < 1 || value > 9 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        return true;
    }

    
    //Checks if the solution of the soduku as a whole is valid.
    
    public boolean isValidSolution() {
        for (int i = 0; i < size; i++) {
            if (!isValidRow(i) || !isValidCol(i)) {   //Check the rows and columns.
                return false;
            }
        }

        if (size == 9) {
            for (int i = 0; i < size; i += 3) {       //If its a normal sudoku check all boxes.
                for (int j = 0; j < size; j += 3) {
                    if (!isValidBox(i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    
    // Checks if this Sudoku is equal to another Sudoku object
    
    public boolean equals(Sudoku other) {
        if (this.size != other.size) {                        //Check size.
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.grid[i][j] != other.grid[i][j]) {    //Check elements.
                    return false;
                }
            }
        }

        return true;
    }

    
    //Convert the Sudoku grid to a string for better readability.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}