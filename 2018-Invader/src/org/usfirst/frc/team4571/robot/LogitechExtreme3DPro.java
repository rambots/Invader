package org.usfirst.frc.team4571.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class LogitechExtreme3DPro extends Joystick {
	private Button 	button1,  button2,
					button3,  button4,
					button5,  button6,
					button7,  button8,
					button9,  button10,
					button11, button12; 

	public LogitechExtreme3DPro(int port) {
		super(port);
		this.button1  = new JoystickButton(this, 1);
		this.button2  = new JoystickButton(this, 2);
		this.button3  = new JoystickButton(this, 3);
		this.button4  = new JoystickButton(this, 4);
		this.button5  = new JoystickButton(this, 5);
		this.button6  = new JoystickButton(this, 6);
		this.button7  = new JoystickButton(this, 7);
		this.button8  = new JoystickButton(this, 8);
		this.button9  = new JoystickButton(this, 9);
		this.button10 = new JoystickButton(this, 10);
		this.button11 = new JoystickButton(this, 11);
		this.button12 = new JoystickButton(this, 12);
	}
	
	public double getYAxis() {
		return this.getRawAxis(1);
	}
	
	public double getXAxis() {
		return this.getRawAxis(0);
	}
		
	public Button getButton1() {
		return this.button1;
	}
	
	public Button getButton2() {
		return this.button2;
	}
	
	public Button getButton3() {
		return this.button3;
	}
	
	public Button getButton4() {
		return this.button4;
	}
	
	public Button getButton5() {
		return this.button5;
	}
	
	public Button getButton6() {
		return this.button6;
	}
	
	public Button getButton7() {
		return this.button7;
	}
	
	public Button getButton8() {
		return this.button8;
	}
	
	public Button getButton9() {
		return this.button9;
	}
	
	public Button getButton10() {
		return this.button10;
	}
	
	public Button getButton11() {
		return this.button11;
	}
	
	public Button getButton12() {
		return this.button12;
	}
	
	public LogitechExtreme3DPro button1WhenPressed(Command command) {
		this.button1.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button2WhenPressed(Command command) {
		this.button2.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button3WhenPressed(Command command) {
		this.button3.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button4WhenPressed(Command command) {
		this.button4.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button5WhenPressed(Command command) {
		this.button5.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button6WhenPressed(Command command) {
		this.button6.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button7WhenPressed(Command command) {
		this.button7.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button8WhenPressed(Command command) {
		this.button8.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button9WhenPressed(Command command) {
		this.button9.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button10WhenPressed(Command command) {
		this.button10.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button11WhenPressed(Command command) {
		this.button11.whenPressed(command);
		return this;
	}
	
	public LogitechExtreme3DPro button12WhenPressed(Command command) {
		this.button12.whenPressed(command);
		return this;
	}
}