package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDSubsystem extends Subsystem {
	private Spark spark;
	
	public LEDSubsystem() {
		spark = new Spark(RobotMap.REV_BLINKIN_CHANNEL);
	}
	
	public void initDefaultCommand() {}
	
	private void setPatternValues(double pwm, double speed) {
		double microSec = pwm * Math.pow(10, -4);
		spark.setExpiration(microSec);
		spark.set(speed);
	}
	
	public void rainbow() {
		setPatternValues(1005, -0.99);
	}
	
	public void rainbowPartyPalette() {
		setPatternValues(1015, -0.97);
	}
	
	public void rainbowOceanPalette() {
		setPatternValues(1025, -0.95);
	}
	
	public void rainbowLavePalette() {
		setPatternValues(1035, -0.93);
	}
	
	public void rainbowForestPalette() {
		setPatternValues(1045, -0.91);
	}
	
	public void rainbowWithGlitter() {
		setPatternValues(1055, -0.89);
	}
	
	public void confetti() {
		setPatternValues(1065, -0.87);
	}
	
	public void shotRed() {
		setPatternValues(1075, -0.85);
	}
	
	public void shotBlue() {
		setPatternValues(1085, -0.83);
	}
	
	public void shotWhite() {
		setPatternValues(1095, -0.81);
	}
	
	public void sinelonRainbowPalettte() {
		setPatternValues(1105, -0.79);
	}
	
	public void sinelonPartyPalette() {
		setPatternValues(1115, -0.77);
	}
	
	public void sinelonOceanPalette() {
		setPatternValues(1125, -0.75);
	}
	
	public void fireMedium() {
		setPatternValues(1205, -0.59);
	}
	
	public void heartbeatGray() {
		setPatternValues(1405, -0.19);
	}
	
	public void lightChaseGray() {
		setPatternValues(1365, -0.27);
	}
	
	/**
	 * pattern for colors 1 and 2
	 */
	public void sinelonColors() {
		setPatternValues(1775, 0.55);
	}
	
	/**
	 * pattern for colors 1 and 2
	 */
	public void colorWaves() {
		setPatternValues(1765, 0.53);
	}
	
	/**
	 * pattern for color 2
	 */
	public void larsonScanner() {
		setPatternValues(1595, 0.19);
	}
	
	/**
	 * pattern for color 2
	 */
	public void shotColor2() {
		setPatternValues(1665, 0.33);
	}
	
	/**
	 * sparkle color 1 on 2
	 */
	public void sparkle1() {
		setPatternValues(1685, 0.37);
	}
}