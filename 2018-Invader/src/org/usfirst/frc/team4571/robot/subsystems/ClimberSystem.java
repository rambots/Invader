package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem contains all the components of the climber system.
 * This only consists of one motor that will elevate the claws to grab 
 * the bar.
 * 
 * @author Mahim
 */
public class ClimberSystem extends Subsystem {
	private WPI_TalonSRX climberMotor;
	private final static double UP_SPEED   =  0.9,
								DOWN_SPEED = -0.9;
	
	public ClimberSystem() {
		this.climberMotor = new WPI_TalonSRX(RobotMap.CLIMBER_MOTOR);
		this.climberMotor.setExpiration(0.1);
		this.climberMotor.setSafetyEnabled(false);
	}
	
    public void initDefaultCommand() {}
    
	public void setPower(double power) {
		climberMotor.set(power);
	}
	
	public void goUp() {
		climberMotor.set(UP_SPEED);
	}
	
	public void goDown() {
		climberMotor.set(DOWN_SPEED);
	}
	
	public void stop() {
		climberMotor.set(0.0);
	}
	
	public double getClimberSpeed() {
		return climberMotor.get();
	}
}