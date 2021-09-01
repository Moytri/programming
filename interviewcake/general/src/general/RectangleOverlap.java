package general;

import java.util.*;
public class RectangleOverlap {
	public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return String.format("(left: %d, bottom: %d, width: %d, height: %d)",
                leftX, bottomY, width, height);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Rectangle)) {
                return false;
            }
            final Rectangle r = (Rectangle) o;
            return leftX == r.leftX && bottomY == r.bottomY
                   && width == r.width && height == r.height;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + leftX;
            result = result * 31 + bottomY;
            result = result * 31 + width;
            result = result * 31 + height;
            return result;
        }
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

        // calculate the overlap between the two rectangles
        RangeOverlap overlapX = findRangeOverlap(rect1.getLeftX(), rect1.getWidth(), 
                                                rect2.getLeftX(), rect2.getWidth());
                                                  
        RangeOverlap overlapY = findRangeOverlap(rect1.getBottomY(), rect1.getHeight(),
                                                rect2.getBottomY(), rect2.getHeight());
                                                
        if (overlapX.getLength() == 0 || overlapY.getLength() == 0) {
            return new Rectangle();
        }

        return new Rectangle(overlapX.getStartPoint(), overlapY.getStartPoint(), 
                             overlapX.getLength(), overlapY.getLength());
    }
    
    public static RangeOverlap findRangeOverlap(int start1, int length1, int start2, int length2) {
        int highestStart = Math.max(start1, start2);
        int lowestEnd = Math.min((start1 + length1), (start2 + length2));
        
        if (highestStart > lowestEnd) {
            return new RangeOverlap(0, 0);
        }
        
        int length = lowestEnd - highestStart;
        
        return new RangeOverlap(highestStart, length);
    }
    
    private static class RangeOverlap {
        int startPoint;
        int length;
        
        public RangeOverlap(int startPoint, int length) {
            this.startPoint = startPoint;
            this.length = length;
        }
        
        public int getStartPoint() {
            return startPoint;
        }
        
        public int getLength() {
            return length;
        }
    }

}
