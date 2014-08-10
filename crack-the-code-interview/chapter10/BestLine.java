package chapter10;

import java.util.HashMap;

public class BestLine {
	public static Line findBestLine(GraphPoint[] points){
		Line bestLine = null;
		HashMap<Line, Integer> line_count = new HashMap<Line, Integer>();
		for (int i = 0; i < points.length; i++){
			for (int j = i + 1; j < points.length; j++){
				Line line = new Line(points[i], points[j]);
				if (!line_count.containsKey(line)){
					line_count.put(line, 0);
				}
				line_count.put(line, line_count.get(line) + 1);
				if (bestLine == null || line_count.get(line) > line_count.get(bestLine)){
					bestLine = line;
				}
			}
		}
		return bestLine;
	}
	
	public class Line {
		private static double epsilon = .0001;
		public double slope;
		public double intercept;
		private boolean infinite_slope = false;
		public Line(GraphPoint p, GraphPoint q){
			if (Math.abs(p.x - q.x) > epsilon){
				slope = (p.x - q.y) / (p.x - q.x);
				intercept = p.y -slope * p.x;
			} else {
				infinite_slope = true;
				intercept = p.x;
			}
		}
	}
	
	public boolean isEqual(double a, double b){
		return (Math.abs(a-b) < epsilon);
	}
	
	@override
	public int hashCode() {
		int sl = (int)(slope * 1000);
		int in = (int)(intercept * 1000);
		return sl | in;
	}
	
	@override
	public boolean equals(Object o){
		Line l = (Line) o;
		if (isEqual(l.slope, slope) && isEqual(l.intercept, intercept) && (infinite_slope == l.infinite_slope)){
			return true;
		}
		return false;
	}
}
