# Sudoku Solver and Validator

This project contains a Java implementation of a Sudoku solver and validator. The main class, `Sudoku`, provides functionalities to validate the Sudoku grid by checking rows, columns, and boxes. Additionally, the `UniqueDiagonalSudoku` class extends `Sudoku` to add the requirement that the diagonals also need to contain unique values.

## Classes

### Sudoku

The `Sudoku` class represents a standard Sudoku grid and provides methods to validate the grid.

#### Fields

- `private int size`: Size of the grid.
- `private int[][] grid`: The Sudoku grid itself.

#### Constructor

- `public Sudoku(int[][] numbers)`: Initializes the Sudoku grid and its size.

#### Methods

- `public int getSize()`: Returns the size of the grid.
- `public int[][] getGrid()`: Returns the Sudoku grid.
- `public int getDigitAt(int row, int col)`: Returns the digit at a specific row and column in the grid.
- `public boolean isValidRow(int row)`: Checks if a row is valid.
- `public boolean isValidCol(int col)`: Checks if a column is valid.
- `public boolean isValidBox(int row, int col)`: Checks if a 3x3 box is valid.
- `public boolean isValidSolution()`: Checks if the entire Sudoku grid is a valid solution.
- `public boolean equals(Sudoku other)`: Checks if this Sudoku is equal to another Sudoku object.
- `public String toString()`: Converts the Sudoku grid to a string for better readability.

### UniqueDiagonalSudoku

The `UniqueDiagonalSudoku` class extends `Sudoku` to add the requirement that the diagonals must also contain unique values.

#### Constructor

- `public UniqueDiagonalSudoku(int[][] numbers)`: Initializes the Sudoku grid using the parent class constructor.

#### Methods

- `@Override public boolean isValidSolution()`: Checks if the Sudoku solution is valid, including the diagonals.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
