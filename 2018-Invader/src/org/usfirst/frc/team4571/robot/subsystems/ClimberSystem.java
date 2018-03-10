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
	private final static double MOTOR_SPEED = 0.3;
	
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
		climberMotor.set(MOTOR_SPEED);
	}
	
	public void goDown() {
		climberMotor.set(-MOTOR_SPEED);
	}
	
	public void stop() {
		climberMotor.set(0.0);
	}
}