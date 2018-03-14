package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsytem controls the LED strips on the robot. This works with the REV 
 * Blinkin, you would use it as by creating a fake motor and set it to a PWM 
 * port. You can use different patterns by setting the "motor" to different 
 * values as well as setting different expiration times for the PWM object.
 * 
 * @see <a href="http://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf">REV Documentation</a>
 * 
 * @author Mahim
 */
public class LEDSubsystem extends Subsystem {
	private Spark spark;
	
	public LEDSubsystem() {
		spark = new Spark(RobotMap.REV_BLINKIN_CHANNEL);
	}
	
	public void initDefaultCommand() {}
	
	/**
	 * Internal method that would set the pulse width and the roboRIO
	 * spark value.
	 * 
	 * @param pulseWidth The pulse width in micro seconds.
	 * @param speed		 The "motor speed" you would set the blinkin LED 
	 * 					 controller to.
	 */
	private void setPatternValues(double pulseWidth, double speed) {
		double timeout = pulseWidth * 10e-4;
		spark.setExpiration(timeout);
		spark.set(speed);
	}
	
	/**
	 * <h1>Rainbow, rainbow palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void rainbow() {
		setPatternValues(1005, -0.99);
	}
	
	/**
	 * <h1>Rainbow, party palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void rainbowPartyPalette() {
		setPatternValues(1015, -0.97);
	}
	
	/**
	 * <h1>Rainbow, ocean palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void rainbowOceanPalette() {
		setPatternValues(1025, -0.95);
	}
	
	/**
	 * <h1>Rainbow, lave palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void rainbowLavePalette() {
		setPatternValues(1035, -0.93);
	}
	
	/**
	 * <h1>Rainbow, forest palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void rainbowForestPalette() {
		setPatternValues(1045, -0.91);
	}
	
	/**
	 * <h1>Rainbow with Glitter</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void rainbowWithGlitter() {
		setPatternValues(1055, -0.89);
	}
	
	/**
	 * <h1>Confetti</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void confetti() {
		setPatternValues(1065, -0.87);
	}
	
	/**
	 * <h1>Shot, Red</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Brightness		  
	 */
	public void shotRed() {
		setPatternValues(1075, -0.85);
	}
	
	/**
	 * <h1>Shot, Blue</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Brightness		  
	 */
	public void shotBlue() {
		setPatternValues(1085, -0.83);
	}
	
	/**
	 * <h1>Shot, White</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Brightness		  
	 */
	public void shotWhite() {
		setPatternValues(1095, -0.81);
	}
	
	/**
	 * <h1>Sinelon, Rainbow Palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void sinelonRainbow() {
		setPatternValues(1105, -0.79);
	}
	
	/**
	 * <h1>Sinelon, Party Palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void sinelonParty() {
		setPatternValues(1115, -0.77);
	}
	
	/**
	 * <h1>Sinelon, Ocean Palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void sinelonOceanPalette() {
		setPatternValues(1125, -0.75);
	}
	
	/**
	 * <h1>Sinelon, Lava Palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void sinelonLavaPalette() {
		setPatternValues(1135, -0.73);
	}
	
	/**
	 * <h1>Sinelon, Forest Palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void sinelonForestPalette() {
		setPatternValues(1145, -0.71);
	}
	
	/**
	 * <h1>Beats per Minute, Rainbow Palette</h1>
	 * This is a fixed palette pattern.
	 * <h1>Adjustments:</h1>
	 * - Pattern Density<br>
	 * - Speed			<br>
	 * - Brightness		  
	 */
	public void BeatsPerMinuteRainbowPalette() {
		setPatternValues(1155, -0.69);
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
	 * End to end blend color 1 and 2
	 */
	public void blend() {
		setPatternValues(1725, 0.47);
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
	public void larsonScanner2() {
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