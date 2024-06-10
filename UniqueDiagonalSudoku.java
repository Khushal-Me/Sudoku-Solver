/*In this class we extend the Sudoku class to create a Sudoku,
puzzle where the diagonal also need to be unique.*/

public class UniqueDiagonalSudoku extends Sudoku {
	
	//Constructor to initialize the Sudoku grid using the parent class
	
    public UniqueDiagonalSudoku(int[][] numbers) {
        super(numbers);
    }

    
    // Checks if the Sudoku solution is valid, including diagonals!
    
    @Override
    public boolean isValidSolution() {
        if (!super.isValidSolution()) {
            return false;
        }

        
        // Arrays to track numbers on diagonals
        
        boolean[] seenDiag1 = new boolean[getSize() + 1];
        boolean[] seenDiag2 = new boolean[getSize() + 1];

        
        // Loop through diagonals.
        
        for (int i = 0; i < getSize(); i++) {
        	//Get values on diagonals.
            int valueDiag1 = getDigitAt(i, i);
            int valueDiag2 = getDigitAt(i, getSize() - i - 1);

            
         //Check if values are valid and unique.
            
            if ((valueDiag1 < 1 || valueDiag1 > getSize() || seenDiag1[valueDiag1]) &&
                (valueDiag2 < 1 || valueDiag2 > getSize() || seenDiag2[valueDiag2])) {
                return false;
            }
            
            
         // Mark values as seen.
            
            seenDiag1[valueDiag1] = true;
            seenDiag2[valueDiag2] = true;
        }

        
     // If all checks pass, return true.

        return true;
    }
}
