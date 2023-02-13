package view;

import java.awt.event.MouseWheelListener;

import javax.swing.event.ChangeListener;

import model.entities.Draw;
import model.entities.Point;

public class ViewDesktop {

	private ViewFrame frame;
	
	public ViewDesktop(Draw aDraw) {
		frame = new ViewFrame(aDraw);
	}
	
	public int getVertices() {
		return frame.getVertices();
	}
	
	public Point getValueSTranslade() {
		return frame.getValueSTranslade();
	}
	
	public double getValueAngleRotation() {
		return frame.getValueAngleRotation();
	}
	
	public double getValueScaleX() {
		return frame.getValueScaleX();
	}
	
	public double getValueScaleY() {
		return frame.getValueScaleY();
	}
	
	public double getValueShearingX() {
		return frame.getValueShearingX();
	}
	
	public double getValueShearingY() {
		return frame.getValueShearingY();
	}
	
	public void addSliderListener(ChangeListener cl) {
		frame.addSliderListener(cl);
	}
	
	public void addSliderChangeVerticesListener(ChangeListener cl) {
		frame.addSliderChangeVerticesListener(cl);
	}
	public void updateDraw(Draw aDraw) {
		frame.updateDraw(aDraw);
	}
	
	public void addMouseWheelListener(MouseWheelListener ml) {
		frame.addMouseWheelListener(ml);
	}
	
	public void setZoom(double aZoom) {
		frame.setZoom(aZoom);
	}
	
}
