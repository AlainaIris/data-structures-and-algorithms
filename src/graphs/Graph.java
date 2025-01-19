/**
 * Purpose	2D graph implementation
 * Status	In progress
 *
 * @author	Alaina Iris
 * @version	01.16.25
 */
import java.util.HashMap;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.lang.Math;

public class Graph {
	private int[][] graph;
	private int[][] movements;
	/**
	 * Construct a new graph that is m rows and n columns
	 *
	 * @param  m Rows
	 * @param  n Columns
	 */
	public Graph(int m, int n) {
		graph = new int[m][n];
		movements = new int[8][];
		movements[0] = new int[] {1, 1};
		movements[1] = new int[] {1, 0};
		movements[2] = new int[] {1, -1};
		movements[3] = new int[] {0, 1};
		movements[4] = new int[] {0, -1};
		movements[5] = new int[] {-1, 1};
		movements[6] = new int[] {-1, 0};
		movements[7] = new int[] {-1, -1};
	}

	public Graph(int[][] graph) {
		this.graph = graph;
		movements = new int[8][];
		movements[0] = new int[] {1, 1};
                movements[1] = new int[] {1, 0};
                movements[2] = new int[] {1, -1};
                movements[3] = new int[] {0, 1};
                movements[4] = new int[] {0, -1};
                movements[5] = new int[] {-1, 1};
                movements[6] = new int[] {-1, 0};
                movements[7] = new int[] {-1, -1};
	}

	/**
	 * Return if location exists in the graph
	 *
	 * @param  location Location to check
	 * @return If exists
	 */
	private boolean isValidLocation(int[] location) {
		return (location.length == 2 &&
			location[0] >= 0 && location[0] < graph.length &&
			location[1] >= 0 && location[1] < graph[0].length);
	}

	/**
	 * Return if location is blocked
	 *
	 * @param  location Location to check
	 * @return If blocked
	 * @throws IllegalArgumentException If invalid location
	 */
	private boolean isBlocked(int[] location) {
		if (!isValidLocation(location)) {
			return true;
		}
		return graph[location[0]][location[1]] == -1;
	}

	/**
	 * Return if pathing is valid
	 *
	 * @param  start Start location
	 * @param  end End location
	 * @return Valid pathing
	 */
	private boolean validPathing(int[] start, int[] end) {
		return isValidLocation(start) && isValidLocation(end) &&
		    	!isBlocked(start) && !isBlocked(end);
	}

	/**
	 * Get the distance between two points
	 *
	 * @param  p1 First point
	 * @param  p2 Second point
	 * @return Distance between points
	 */
	private double getDistance(int[] p1, int[] p2) {
		int x = p1[0] - p2[0];
		int y = p1[1] - p2[1];
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Heuristic for remaining distance to end goal in 8 directions
	 * Used in A* implementation
	 *
	 * @param  start Start
	 * @param  end End
	 * @return Estimate for distance
	 */
	private double estimateDistance(int[] start, int[] end) {
		int changeX = Math.abs(start[0] - end[0]);
		int changeY = Math.abs(start[1] - end[1]);
		int minChange = changeX > changeY ? changeY : changeX;
		return changeX + changeY + (Math.sqrt(2) - 2) * minChange;
	}

	/**
	 * Reconstruct path found via A* search
	 *
	 * @param  cells Cell chart
	 * @param  start Start location
	 * @param  end End location
	 * @return Path to get to location
	 */
	public ArrayList<Integer[]> buildPath(Cell[][] cells, int[] start, Cell end) {
		ArrayList<Integer[]> path = new ArrayList<Integer[]>();
		Integer[] location = new Integer[] { end.row, end.col };
		path.add(location);
		while (location[0] != start[0] || location[1] != start[1]) {
			Cell cell = cells[location[0]][location[1]];
			location = new Integer[] { cell.past_row, cell.past_col };
			path.add(0, location);
		}
		return path;
	}

	/**
	 * A* algorithm implementation
	 *
	 * @param  start Start location
	 * @param  end End location
	 * @return Shortest path
	 */
	public ArrayList<Integer[]> aStarPath(int[] start, int[] end) {
		if (graph.length < 1 || graph[0].length < 1) {
			throw new IllegalArgumentException("Graph must have cells");
		} else if (!validPathing(start, end)) {
			throw new IllegalArgumentException("Please enter a valid start and end");
		}
		int rows = graph.length;
		int cols = graph[0].length;
		Cell[][] cellInfo = new Cell[rows][cols]; // Minimal paths
		boolean[][] closedVisits = new boolean[rows][cols];
		for (int i = 0; i < cellInfo.length; i++) {
			for (int j = 0; j < cellInfo[i].length; j++) {
				cellInfo[i][j] = new Cell(i, j);
			}
		}
		// Initialize start cell as base case
		Cell startCell = cellInfo[start[0]][start[1]];
		startCell.total = 0;
		startCell.dist = 0;
		startCell.dist_left = 0;
		startCell.past_row = start[0];
		startCell.past_col = start[1];
		
		Comparator<Cell> cellCompare = (c1, c2) -> Double.compare(c1.total, c2.total);
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(cellCompare);
		queue.add(startCell);
		int[] still = new int[] {0, 0};
		while (!queue.isEmpty()) {
			Cell location = queue.poll();
			if (location.row == end[0] && location.col == end[1]) {
				return buildPath(cellInfo, start, location);
			}
			for (int[] dir : movements) {
				double moveDist = getDistance(still, dir);
				double newDist = moveDist + location.dist;
				int[] newLocation = new int [] {
					location.row + dir[0],
					location.col + dir[1]
				};
				if (isBlocked(newLocation)) {
					continue;
				}
				double newDistLeft = estimateDistance(newLocation, end);
				double newTotal = newDist + newDistLeft;
				Cell prior = cellInfo[newLocation[0]][newLocation[1]];
				if (newTotal < prior.total) {
					prior.total = newTotal;
					prior.past_row = location.row;
					prior.past_col = location.col;
					prior.dist = newDist;
					prior.dist_left = newDistLeft;
					queue.add(prior);
				}

			}
		}
		return null;
	}

	/**
	 * Get the graph as a string
	 *
	 * @return String graph
	 */
	public String toString() {
		String str = "";
		for (int[] row : graph) {
			for (int col : row) {
				str = str + col + " ";
			}
			str = str + "\n";
		}
		return str;
	}

	public class Cell {
		public int past_row;
		public int past_col;
		public int col;
		public int row;
		public double dist;
		public double dist_left;
		public double total;
		public Cell(int row, int col) {
			past_row = -1;
			past_col = -1;
			dist = Double.MAX_VALUE;
			dist_left = Double.MAX_VALUE;
			total = Double.MAX_VALUE;
			this.row = row;
			this.col = col;
		}
		public String toString() {
			return "" + past_row + "," + past_col + " | " + dist
				+ "," + dist_left + " | " + total;
		}
	}
}
