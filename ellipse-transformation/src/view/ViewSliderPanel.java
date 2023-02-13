package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class ViewSliderPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JSlider sVertices = new JSlider(1,36,15);;
	
	private double rFator = 58;
	private JSlider sRotation = new JSlider(0,(int)(2*Math.PI*rFator),0);
	
	private JSlider sTranslationX = new JSlider(-100,100,0);
	private JSlider sTranslationY = new JSlider(-100,100,0);
	
	private JSlider sScalingX = new JSlider(0,5,1);
	private JSlider sScalingY = new JSlider(0,5,1);
	
	private JSlider sShearingX = new JSlider(0,10,0);
	private JSlider sShearingY = new JSlider(0,10,0);
	
	public ViewSliderPanel() {
		setLayout(new GridLayout(4,2));
		setPreferredSize(new Dimension(650,500));
		add(sVertices);
		add(sRotation);
		add(sTranslationX);
		add(sTranslationY);
		add(sScalingX);
		add(sScalingY);
		add(sShearingX);
		add(sShearingY);
		
		//Setting Title and Border
		sVertices.setBorder(BorderFactory.createTitledBorder("Nº vertices"));
		sRotation.setBorder(BorderFactory.createTitledBorder("Rotation"));
		sTranslationX.setBorder(BorderFactory.createTitledBorder("Translation X"));
		sTranslationY.setBorder(BorderFactory.createTitledBorder("Translation Y"));
		sScalingX.setBorder(BorderFactory.createTitledBorder("Scaling X"));
		sScalingY.setBorder(BorderFactory.createTitledBorder("Scaling Y"));
		sShearingX.setBorder(BorderFactory.createTitledBorder("Shearing X"));
		sShearingY.setBorder(BorderFactory.createTitledBorder("Shearing Y"));
		

		sTranslationX.setMajorTickSpacing(50);
		sTranslationX.setMinorTickSpacing(10);
		sTranslationY.setMajorTickSpacing(50);
		sTranslationY.setMinorTickSpacing(10);

		sVertices.setMajorTickSpacing(5);
		sVertices.setMinorTickSpacing(1);
		
		sRotation.setMajorTickSpacing((int) (2*Math.PI*rFator/12));
		sRotation.setMinorTickSpacing(60);
		
		sShearingX.setMajorTickSpacing(1);
		sShearingY.setMajorTickSpacing(1);
		
		sScalingX.setMajorTickSpacing(1);
		sScalingY.setMajorTickSpacing(1);
		
		//Add Mark Tricks
		for (Component c : this.getComponents()) {
			if(c instanceof JSlider) {
			    ((JSlider) c).setPaintTicks(true);
			    ((JSlider) c).setPaintLabels(true);
			}
		}
	}
	public int getsVertices() {
		return sVertices.getValue();
	}
	
	public double getsRotation() {
		return (double)sRotation.getValue()/(double)rFator;
	}
	
	public int getsTranslationX() {
		return sTranslationX.getValue();
	}

	public int getsTranslationY() {
		return sTranslationY.getValue();
	}

	public int getsScalingX() {
		return sScalingX.getValue();
	}

	public int getsScalingY() {
		return sScalingY.getValue();
	}

	public double getsShearingX() {
		return (double) sShearingX.getValue()/5;
	}

	public double getsShearingY() {
		return (double)  sShearingY.getValue()/5;
	}
	public void addListener(ChangeListener cl) {
		this.sTranslationX.addChangeListener(cl);
		this.sTranslationY.addChangeListener(cl);
		this.sRotation.addChangeListener(cl);
		this.sScalingX.addChangeListener(cl);
		this.sScalingY.addChangeListener(cl);
		this.sShearingX.addChangeListener(cl);
		this.sShearingY.addChangeListener(cl);
	}
	
	public void addListenerChangeVertices(ChangeListener cl) {
		this.sVertices.addChangeListener(cl);
	}
}
