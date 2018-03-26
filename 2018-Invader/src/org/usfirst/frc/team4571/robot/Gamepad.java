package org.usfirst.frc.team4571.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is for the logitech gamepad F310
 * 
 * @author Mahim
 */
public class Gamepad extends Joystick {
	private Button a, b, x, y,
				   leftBumperButton,
				   rightBumperButton,
				   backButton,
				   startButton,
				   leftStickButton,
				   rightStickButton;

	public Gamepad(int port) {
		super(port);
		this.a = new JoystickButton(this, 1);
		this.b = new JoystickButton(this, 2);
		this.x = new JoystickButton(this, 3);
		this.y = new JoystickButton(this, 4);
		
		this.leftBumperButton  = new JoystickButton(this, 5);
		this.rightBumperButton = new JoystickButton(this, 6);
		
		this.backButton  = new JoystickButton(this, 7);
		this.startButton = new JoystickButton(this, 8);
		
		this.leftStickButton  = new JoystickButton(this, 9);
		this.rightStickButton = new JoystickButton(this, 10);
	}
	
	public double getLeftXAxis() {
		return this.getRawAxis(0);
	}
	
	public double getLeftYAxis() {
		return -this.getRawAxis(1); // negative because controls are reversed
	}
	
	public double getRightXAxis() {
		return this.getRawAxis(4);
	}
	
	public double getRightYAxis() {
		return -this.getRawAxis(5); // negative because controls are reversed
	}
	
	public double getLeftTrigger() {
		return this.getRawAxis(2);
	}
	
	public double getRightTrigger() {
		return this.getRawAxis(3);
	}
	
	public Button getButtonA() {
		return this.a;
	}
	
	public Button getButtonB() {
		return this.b;
	}
	
	public Button getButtonX() {
		return this.x;
	}
	
	public Button getButtonY() {
		return this.y;
	}
	
	public Button getLeftBumper() {
		return this.leftBumperButton;
	}
	
	public Button getRightBumper() {
		return this.rightBumperButton;
	}
	
	public Button getBackButton() {
		return this.backButton;
	}
	
	public Button getStartButton() {
		return this.startButton;
	}
	
	public Button getLeftJoystickButton() {
		return this.leftStickButton;
	}
	
	public Button getRightJoystickButton() {
		return this.rightStickButton;
	}
	
	public boolean isDPadPressedUp() {
		if(this.getPOV() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDPadPressedDown() {
		if(this.getPOV() == 180) {
			return true;
		} else {
			return false;
		}
	}
	 
	public Gamepad buttonAWhenPressed(Command command) {
		a.whenPressed(command);
		return this;
	}
	
	public Gamepad buttonBWhenPressed(Command command) {
		b.whenPressed(command);
		return this;
	}
	
	public Gamepad buttonXWhenPressed(Command command) {
		x.whenPressed(command);
		return this;
	}
	
	public Gamepad buttonYWhenPressed(Command command) {
		y.whenPressed(command);
		return this;
	}
	
	public Gamepad leftBumperWhenPressed(Command command) {
		leftBumperButton.whenPressed(command);
		return this;
	}
	
	public Gamepad rightBumperWhenPressed(Command command) {
		rightBumperButton.whenPressed(command);
		return this;
	}
	
	public Gamepad backButtonWhenPressed(Command command) {
		backButton.whenPressed(command);
		return this;
	}
	
	public Gamepad startButtonWhenPressed(Command command) {
		startButton.whenPressed(command);
		return this;
	}
	
	public Gamepad leftStickWhenPressed(Command command) {
		leftStickButton.whenPressed(command);
		return this;
	}
	
	public Gamepad rightStickWhenPressed(Command command) {
		rightStickButton.whenPressed(command);
		return this;
	}
}
