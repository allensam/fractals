package part2;
import java.awt.Color;
import java.awt.geom.Point2D;
import draw.StdDraw;


public class SierpinskiTriangle { 
   
	private Point2D.Double top, right, left;
	private Color background = new Color(34, 129, 34);
	private Color foreground = StdDraw.YELLOW;
	
	public SierpinskiTriangle() {
		StdDraw.setXscale(0, 150); 
		StdDraw.setYscale(75, 150); 
		
		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);
		 
		StdDraw.clear(StdDraw.GRAY); 
	}
   
	public void sierpinski(Point2D.Double top, Point2D.Double left, Point2D.Double right, int n) {
		if (n <= 0) return;

		Point2D.Double lr = new Point2D.Double(midpoint(right.x, left.x), right.y);
		Point2D.Double tr = new Point2D.Double(midpoint(top.x, right.x), midpoint(top.y, right.y));
		Point2D.Double tl = new Point2D.Double(midpoint(top.x, left.x), midpoint(top.y, left.y));
		drawTriangle(tl,lr,tr, Color.black);
		sierpinski(top, tr, tl, n-1);
		sierpinski(tr, right, lr, n-1);
		sierpinski(tl,lr,left, n-1);
	}

	public double midpoint(double p1, double p2) {
		return ((p1 + p2) /2.0);
	}
   
	public void drawTriangle(Point2D.Double a, Point2D.Double b, Point2D.Double c, Color color) {
	   double[] x = {a.x, b.x, c.x};
	   double[] y = {a.y, b.y, c.y};
	   StdDraw.setPenColor(color);
	   StdDraw.filledPolygon(x, y);
	}
	
	public void draw(int n) {
		drawTriangle(top, right, left, Color.white);
		sierpinski(this.top, this.right, this.left, n-1);
	}
	
	
	
	public static void main(String[] args) { 
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(6);
	}
}
