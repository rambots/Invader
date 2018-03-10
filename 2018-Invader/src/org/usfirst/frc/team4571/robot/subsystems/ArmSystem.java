package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem contains all the components of the arm system.
 * Such as:
 * 
 * <li>The motors for the arms to intake and outtake the power cubes.
 * 
 * <li>The motor to elevate the arms.
 * 
 * <li>The motors that controls the pulley to raise the arms up
 * 	   and down.
 * 
 * @author Mahim
 */
public class ArmSystem extends Subsystem {
	WPI_TalonSRX  leftPulleyMotor,
				  rightPulleyMotor;
	WPI_VictorSPX leftArmMotor,
				  rightArmMotor;
	
	private static final double INTAKE_SPEED  = -0.5,
								OUTTAKE_SPEED =  0.5;
	
	public ArmSystem() {
		this.leftArmMotor     = new WPI_VictorSPX(RobotMap.LEFT_ARM_MOTOR);
		this.rightArmMotor 	  = new WPI_VictorSPX(RobotMap.RIGHT_ARM_MOTOR);
		this.leftPulleyMotor  = new WPI_TalonSRX(RobotMap.LEFT_PULLEY_MOTOR);
		this.rightPulleyMotor = new WPI_TalonSRX(RobotMap.RIGHT_PULLEY_MOTOR);
		
		//TODO: figure out if these should be actually inverted or not
		this.leftArmMotor.setInverted(true); 
		this.leftPulleyMotor.setInverted(true);
		
		this.leftArmMotor.setExpiration(0.1);
		this.rightArmMotor.setExpiration(0.1);
		this.leftPulleyMotor.setExpiration(0.1);
		this.rightPulleyMotor.setExpiration(0.1);
		
		this.leftArmMotor.setSafetyEnabled(false);
		this.rightArmMotor.setSafetyEnabled(false);
		this.leftPulleyMotor.setSafetyEnabled(false);
		this.rightPulleyMotor.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {}
    
    public void setArmMotors(double power) {
    	this.leftArmMotor.set(power);
    	this.rightArmMotor.set(power);
    }
    
    public void setPulleyMotor(double power) {
    	this.leftPulleyMotor.set(power);
    	this.rightPulleyMotor.set(power);
    }
    
    public void startIntake() {
    	setArmMotors(INTAKE_SPEED);
    }
    
    public void stop() {
    	setArmMotors(0.0);
    }
    
    public void startOuttake() {
    	setArmMotors(OUTTAKE_SPEED);
    }
}

