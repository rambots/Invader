package org.usfirst.frc.team4571.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class RobotJoystick extends Joystick {
	private Button 	button1,
					button2,
					button3,
					button4; 


	public RobotJoystick(int port) {
		super(port);
		this.button1 = new JoystickButton(this, 1);
		this.button2 = new JoystickButton(this, 2);
		this.button3 = new JoystickButton(this, 3);
		this.button4 = new JoystickButton(this, 4);
	}
	
	public double getY_Axis() {
		return this.getRawAxis(1);
	}
	
	public boolean isButton1Pressed() {
		return this.button1.get();
	}
	
	public boolean isButton2Pressed() {
		return this.button2.get();
	}
	
	public boolean isButton3Pressed() {
		return this.button3.get();
	}
	
	public boolean isButton4Pressed() {
		return this.button4.get();
	}
}
