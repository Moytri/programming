package amazon.com.all.frequencies.string;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/robot-bounded-in-circle/
 *
 */
public class RobotBoundedInCircle {

	public static void main(String[] args) {
		RobotBoundedInCircle circle = new RobotBoundedInCircle();
		System.out.println(circle.isRobotBounded("GGLLGG"));
	}
	
	enum Direction {
		NORTH, EAST, SOUTH, WEST
	}
	
	public boolean isRobotBounded(String instructions) {
	    int x = 0; int y = 0;        
	    Direction direction = Direction.NORTH;
	    
	    for (int i = 0; i < instructions.length(); i++) {
	        char ch = instructions.charAt(i);
	        
	        if (ch == 'G') {
	            switch(direction) {
	                case NORTH: y++; break;
	                case WEST: x--; break;
	                case EAST: x++; break;
	                default: y--; break;
	            }
	        }
	        else if (ch == 'L') {
	            switch(direction) {
	                case NORTH: direction = Direction.WEST; break;
	                case WEST: direction = Direction.SOUTH; break;
	                case EAST: direction = Direction.NORTH; break;
	                default: direction = Direction.EAST; break;
	            }                
	        }
	        else if (ch == 'R') {
	            switch(direction) {
	                case NORTH: direction = Direction.EAST; break;
	                case WEST: direction = Direction.NORTH; break;
	                case EAST: direction = Direction.SOUTH; break;
	                default: direction = Direction.WEST;; break;
	            }                
	        }
	    }
	
	    if (x == 0 && y == 0) return true;
	    if (direction == Direction.NORTH) return false;
	    return true;
	}	

}
