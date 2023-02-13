package controller;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;
import model.entities.Draw;
import model.entities.Point;
import view.ViewDesktop;

public class ControllerDesktop {


	private ViewDesktop view;
	private Model model;
	private double zoom = 1;
	
	public ControllerDesktop() {
		//Here you can choose the size and initial vertices
		model = new Model(34, 6, 3);

		view = new ViewDesktop(model.getDraw());
		view.addSliderListener(new SliderListener());
		view.addSliderChangeVerticesListener(new SliderVerticesListener());
		view.addMouseWheelListener(new ZoomBehavior());
		
	}
	
	public void updateDraw() {
		Point pointsTransladed = view.getValueSTranslade();
		pointsTransladed.x *= zoom;
		pointsTransladed.y *= zoom;
		double angle = view.getValueAngleRotation();
		double scaleX = view.getValueScaleX();
		double scaleY = view.getValueScaleY();
		double shearX = view.getValueShearingX();
		double shearY = view.getValueShearingY();

		model.doTransformations(
				pointsTransladed, 
				angle, 
				scaleX, 
				scaleY, 
				shearX, 
				shearY);
		
		Draw draw = model.getDraw();
		view.updateDraw(draw);
	}
	
	class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			updateDraw();
		}
	}
	
	class SliderVerticesListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			model.changeVertices(view.getVertices());
			updateDraw();
		}
		
	}
	
	class ZoomBehavior implements MouseWheelListener{

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if(e.getWheelRotation() < 0) {
				//Zoom needs to increase
				zoom += 0.5;
			} else {
				zoom -= 0.5;
				if(zoom < 0.5)
					zoom = 0.5;
			}
			model.setZoom(zoom);	
			view.setZoom(zoom);
			updateDraw();
			
			
		}
	}
	
	
	
	
}
