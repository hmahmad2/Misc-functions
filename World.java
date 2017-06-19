/**
 * 
 */
package GameOfLife;

/**
 * @author Hamaad Ahmad
 *
 */
public class World {
	
	private boolean[][] grid;
	
	/**
	 * This is the standard World constructor. It will build a 10x10
	 * boolean matrix, representing worlds that do exist, and worlds that
	 * don't/could possibly exist. As these are boolean arrays, every
	 * element will initialize to "false," but we need some elements in
	 * the array to be initialized to "true" to run the game. Therefore,
	 * this constructor will initialize 60% of the matrix to "true."
	 */
	public World() {
		this.grid = new boolean[10][10];
		
		for (int r = 0; r < 10; ++r) {
			for (int c = 0; c < 10; ++c) {
				if (Math.random() > 0.6)
					this.grid[r][c] = true;
			}
		}
	}
	
	/**
	 * This World constructor takes an integer in the range [3-20]
	 * and initializes the matrix to be a square with sides of 'len'
	 * length. 60% of the elements will be initialized to 'true'
	 * as the standard constructor does.
	 * 
	 * @param len The length of the rows & columns of the grid.
	 */
	public World(int len) {
		if (len > 20 || len < 3)
			throw new IllegalArgumentException("The length should be in the range of [3,20]");
		
		this.grid = new boolean[len][len];
		for (int r = 0; r < len; ++r) {
			for (int c = 0; c < len; ++c) {
				if (Math.random() > 0.6)
					this.grid[r][c] = true;
			}
		}
	}
	
	/**
	 * This constructor will initialize a World grid of size 10x10, but
	 * the percentage of worlds that will be initialized to "true" will be
	 * altered to the parameter's ratio.
	 * 
	 * @param perc A double between 0 and 1.0, as the percent of active
	 *  worlds initialized in the grid, between 0% and 100% exclusive.
	 */
	public World(double perc) {
		if (perc <= 0 || perc >= 1.0)
			throw new IllegalArgumentException("Provide a percentage within the range (0,100)");
		
		this.grid = new boolean[10][10];
		for (int r = 0; r < 10; ++r) {
			for (int c = 0; c < 10; ++c) {
				if (Math.random() > perc)
					this.grid[r][c] = true;
			}
		}
	}
	
	/**
	 * This World constructor will initialize a rectangular World grid
	 * with standard ratio (60%) of active worlds on the grid.
	 * 
	 * @param row The number of rows to be in the grid (width of the grid)
	 * @param col The number of columns to be in the grid (height of the grid)
	 */
	public World(int row, int col) {
		if (row < 3 || row > 20 || col < 3 || col > 20)
			throw new IllegalArgumentException("The length should be in the range of [3,20]");
		
		this.grid = new boolean[row][col];
		for (int r = 0; r < row; ++r) {
			for (int c = 0; c < col; ++c) {
				if (Math.random() > 0.6)
					this.grid[r][c] = true;
			}
		}
	}
	
	/**
	 * This constructor will adjust the World grid to be square-shaped
	 * with side lengths as given into the parameter. Also, the ratio of
	 * active Worlds to inactive Worlds will be set by the parameter.
	 * 
	 * @param len The length of the rows and columns of the grid
	 * @param perc The percentage of initialized active worlds.
	 */
	public World(int len, double perc) {
		if (len > 20 || len < 3)
			throw new IllegalArgumentException("The length should be in the range of [3,20]");
		if (perc <= 0 || perc >= 1.0)
			throw new IllegalArgumentException("Provide a percentage within the range (0,100)");
		
		this.grid = new boolean[len][len];
		for (int r = 0; r < len; ++r) {
			for (int c = 0; c < len; ++c) {
				if (Math.random() > perc)
					this.grid[r][c] = true;
			}
		}
	}
	
	/**
	 * This last constructor will initialize a rectangular World grid,
	 * with an independent number of rows and columns, and will adjust
	 * the ratio of active worlds as set by the parameter.
	 * 
	 * @param row The number of rows in the grid
	 * @param col The number of columns in the grid
	 * @param perc The percentage of Worlds initialized to "true"
	 */
	public World(int row, int col, double perc) {
		if (row < 3 || row > 20 || col < 3 || col > 20)
			throw new IllegalArgumentException("The length should be in the range of [3,20]");
		if (perc <= 0 || perc >= 1.0)
			throw new IllegalArgumentException("Provide a percentage within the range (0,100)");
		
		this.grid = new boolean[row][col];
		for (int r = 0; r < row; ++r) {
			for (int c = 0; c < col; ++c) {
				if (Math.random() > perc)
					this.grid[r][c] = true;
			}
		}
	}
	
	/**
	 * This function determines how many existing worlds are directly
	 * adjacent to the coordinates provided, be it sides or corners.
	 * 
	 * @return an integer with the number of worlds in the vicinity,
	 * or -1 if there are no worlds in the area.
	 * 
	 * @param row The row where the evaluated world is
	 * @param col The column where the evaluated world is
	 */
	public int neighborCount(int row, int col) {
		int num;
		if (this.grid[row][col])
			num = -1;
		else
			num = 0;
		for (int r = row - 1; r < row + 2; ++r) {
			for (int c = col - 1; c < col + 2; ++c) {
					if (this.isInBounds(r, c) && this.grid[r][c])
						++num;
			}
		}
		return num;
	}
	
	/**
	 * Returns a String representation of the grid.
	 * 
	 * The toString() function will display the entire grid,
	 * displaying which Worlds are active (as denoted with a '*')
	 * and which are inactive (as denoted with a '.'). 
	 */
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (boolean[] row : this.grid) {
			for (boolean exists : row) {
				if (exists)
					s.append("*");
				else
					s.append(".");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	/**
	 * This function determines if a specific coordinate is within
	 * the bounds of the grid.
	 * 
	 * @return A boolean stating whether or not the given
	 * 			coordinates are within the stated boundaries of the
	 * 			grid. "True" if the coordinates are in the grid,
	 * 			"False" otherwise.
	 * 
	 */
	private boolean isInBounds(int row, int column) {
		boolean rowBottom = (row >= 0);
		boolean rowTop = (row < this.grid.length);
		boolean colBottom = (column >= 0);
		boolean colTop = (column < this.grid[0].length);
		
		return rowBottom && rowTop && colBottom && colTop;
	}
	
	/**
	 * Determines if it is possible to occupy a new world based on
	 * the availability of worlds adjacent to the current coordinates
	 * Will return "false" if there are too many worlds or not enough.
	 */
	public boolean occupyNewWorld(int neighbors, boolean occupied) {
		if (occupied && (neighbors == 2 || neighbors == 3))
			return true;
		else if (!occupied && neighbors == 3)
			return true;
		return false;
	}
	
	/**
	 * Updates the grid by activating new worlds and deactivating
	 * old ones, depending on the placement of active worlds on
	 * the grid.
	 */
	public void newGeneration() {
		boolean[][] next = new boolean[this.grid.length][this.grid[0].length];
		int neighbors;
		for (int r = 0; r < this.grid.length; ++r) {
			for (int c = 0; c < this.grid[0].length; ++c) {
				neighbors = this.neighborCount(r, c);
				if (this.occupyNewWorld(neighbors, this.grid[r][c]))
					next[r][c] = true;
			}
		}
		
		this.grid = next;
	}
}
