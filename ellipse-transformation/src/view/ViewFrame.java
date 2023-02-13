package view;

import java.awt.BorderLayout;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

import model.entities.Draw;
import model.entities.Point;

public class ViewFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Draw draw;
	private ViewSliderPanel sliders = new ViewSliderPanel();
	private ViewCanvas canvas;
	
	public ViewFrame(Draw aDraw) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		draw = aDraw;
		canvas = new ViewCanvas(draw);
		add(canvas, BorderLayout.LINE_START);
		add(sliders, BorderLayout.CENTER);

		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void updateDraw(Draw aDraw) {
		canvas.updateDraw(aDraw);
	}
	
	public void addSliderListener(ChangeListener cl) {
		sliders.addListener(cl);
	}
	
	public void addSliderChangeVerticesListener(ChangeListener cl) {
		sliders.addListenerChangeVertices(cl);
	}
	
	public int getVertices() {
		return sliders.getsVertices();
	}
	
	public Point getValueSTranslade() {
		return new Point(
				(double) sliders.getsTranslationX(), 
				(double) sliders.getsTranslationY()
				);
	}
	
	public double getValueAngleRotation() {
		return sliders.getsRotation();
	}	
	
	public double getValueScaleX() {
		return sliders.getsScalingX();
	}
	
	public double getValueScaleY() {
		return sliders.getsScalingY();
	}
	public double getValueShearingX() {
		return sliders.getsShearingX();
	}
	
	public double getValueShearingY() {
		return sliders.getsShearingY();
	}
	
	public void addMouseWheelListener(MouseWheelListener ml) {
		canvas.addMouseWheelListener(ml);
	}
	
	public void setZoom(double aZoom) {
		canvas.setZoom(aZoom);
	}

}
