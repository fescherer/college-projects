package model;

import java.util.ArrayList;
import java.util.List;

import model.entities.Draw;
import model.entities.Point;

public class Model {

	private List<Point> points;
	private Draw draw;
	private int vertices;
	private double zoom = 1;
	
	//Ellipse Size
	private int width;
	private int height;
	
	//The values of x and y points need to follow the equation
	// x = width*cos(t)
	// y = height*sin(t)
	//Changing t, change both x and y
	
	/*Some examples start values
	 t  | x | y
	 ---|---|---
	 0  |4  |0 
	 90 |0  |3
	 180|-4 |0
	 270|0  |-3
	 360|4  |0
	*/
	public Model(int vertices, int aWidth, int aHeight) {
		this.width = aWidth;
		this.height = aHeight;
		this.vertices = vertices;
		this.initPoints(vertices);
		draw = new Draw(points);
	}
	
	public void initPoints(int aVertices){
		points = new ArrayList<>();
		
		for(double t=0; t<=360; t+=360/aVertices) {
			
			double x = width*(Math.cos(Math.toRadians(t)));
			double y = height*(Math.sin(Math.toRadians(t)));
			
			/*This block of code is necessary because the methods 
			 'Math.cos()' and 'Math.sin()' need a value in radian
			 but our for loop calculates in degrees. So pi/2 is an
			 approximation that lead to wrong values of cos90,
			 cos270 and sin180. Because of that, we hard coded 
			 those values to be exactly 0*/
			if(t==90 || t==270)
				x = 0;
			if(t==180)
				y=0;
			
			Point p = new Point(
					x*12*zoom, 
					y*12*zoom
					);

			points.add(p);
		}
	}
	
	public void doTransformations(
			Point point,
			double angle,
			double a,
			double b,
			double mX,
			double mY) {
		
		draw.reset();
		draw.doScale(a, b);
		draw.doTranslade(point.x, point.y);
		draw.doRotation(angle);
		draw.doShearingX(mX);
		draw.doShearingY(mY);
	}
	
	public void doTransformations(Point point) {
		draw.doTranslade(point.x, point.y);
	}
	
	public Draw getDraw() {
		return draw;
	}
	
	public void changeVertices(int aVertices) {
		draw.reset();
		this.vertices = aVertices;
		this.initPoints(aVertices);
		draw = new Draw(points);
	}
	
	public void setZoom(double aValue) {
		this.zoom = aValue;
		this.initPoints(vertices);
		draw.setPoints(points);
		draw.setInitialPoints(points);
	}

}
