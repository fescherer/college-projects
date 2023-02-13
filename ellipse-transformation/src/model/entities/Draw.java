package model.entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Transformation;

public class Draw {

	private List<Point> points;
	private List<Point> initialPoints;
	private Color[] colors;
	private Random rand = new Random();
	
	
	public Draw(List<Point> aPoints) {
		this.points = aPoints;
		this.initialPoints = aPoints;
		this.chooseColors();
	}
	
	public Color[] getColors() {
		return colors;
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void setInitialPoints(List<Point> initialPoints) {
		this.initialPoints = initialPoints;
	}
	
	public Point getMidPoint() {
		Point midPoint = new Point();
		for(Point p: points) {
			midPoint.x += p.x;
			midPoint.y += p.y;
		}
		midPoint.x /= points.size();
		midPoint.y /= points.size();
		return midPoint;
	}
	
	public void reset() {
		this.points = initialPoints;
	}

	public void chooseColors() {
		colors = new Color[points.size()];
		for(int i=0; i< points.size(); i++) {
			colors[i] = new Color(
					rand.nextFloat(),
					rand.nextFloat(),
					rand.nextFloat()
					);
		}
	}
	
	public void doTranslade(double aX, double aY) {
		List<Point> aux = new ArrayList<>();
		for(Point p : points) {
			Point newP = Transformation.translade(p, aX, aY);
			aux.add(newP);
		}	
		this.points = aux;
	}
	
	public void doRotation(double angle) {
		List<Point> aux = new ArrayList<>();
		Point midPoint = this.getMidPoint();
		for(Point p : points) {
			Point newP = new Point(p.x, p.y);
			newP = Transformation.translade(newP, -midPoint.x, -midPoint.y);
			newP = Transformation.rotate(newP, angle);
			newP = Transformation.translade(newP, midPoint.x, midPoint.y);
			aux.add(newP);
		}
		this.points = aux;	
	}
	
	public void doScale(double aX, double aY) {
		List<Point> aux = new ArrayList<>();
		Point midPoint = this.getMidPoint();
		for(Point p : points) {
			Point newP = new Point(p.x, p.y);
			newP = Transformation.translade(newP, -midPoint.x, -midPoint.y);
			newP = Transformation.scale(newP, aX, aY);
			newP = Transformation.translade(newP, midPoint.x, midPoint.y);
			aux.add(newP);
		}
		this.points = aux;
	}
	
	public void doShearingX(double m) {
		List<Point> aux = new ArrayList<>();
		Point midPoint = this.getMidPoint();
		for(Point p : points) {
			Point newP = new Point(p.x, p.y);
			newP = Transformation.translade(newP, -midPoint.x, -midPoint.y);
			newP = Transformation.shearingX(newP, m);
			newP = Transformation.translade(newP, midPoint.x, midPoint.y);
			aux.add(newP);
		}
		this.points = aux;
	}
	
	public void doShearingY(double m) {
		List<Point> aux = new ArrayList<>();
		Point midPoint = this.getMidPoint();
		for(Point p : points) {
			Point newP = new Point(p.x, p.y);
			newP = Transformation.translade(newP, -midPoint.x, -midPoint.y);
			newP = Transformation.shearingY(newP, m);
			newP = Transformation.translade(newP, midPoint.x, midPoint.y);
			aux.add(newP);
		}
		this.points = aux;
	}


	@Override
	public String toString() {
		String res = "";
		for (Point p: this.points) {
			res += p;
			res += "\n";
		}
		return res;
	}
	
	
}
