package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.ArmCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem contains all the components of the arm system.
 * Such as:<br>
 * + The motors for the arms to intake and outtake the power cubes.<br>
 * + The motor to elevate the arms.<br>
 * + The motors that controls the pulley to raise the arms up
 * 	    and down.<br>
 * 
 * @author Mahim
 */
public class ArmSystem extends Subsystem {
	WPI_TalonSRX  		 leftArmMotor,
				   		 rightArmMotor;
	SpeedControllerGroup armMotors;
	
	private static final double INTAKE_SPEED  = -0.5,
								OUTTAKE_SPEED =  0.5;
	
	public ArmSystem() {
		this.leftArmMotor  = new WPI_TalonSRX(RobotMap.LEFT_ARM_MOTOR);
		this.rightArmMotor = new WPI_TalonSRX(RobotMap.RIGHT_ARM_MOTOR);
		
		//TODO: figure out if these should be actually inverted or not
		this.leftArmMotor.setInverted(true); 
		
		this.leftArmMotor.setExpiration(0.2);
		this.rightArmMotor.setExpiration(0.2);
		
		this.leftArmMotor.setSafetyEnabled(false);
		this.rightArmMotor.setSafetyEnabled(false);
		
		this.armMotors = new SpeedControllerGroup(leftArmMotor, rightArmMotor);
		
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmCommand());
    }
    
    public void setArmMotors(double power) {
    	armMotors.set(power);
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
    
    public double getLeftArmSpeed() {
    	return leftArmMotor.get();
    }
    
    public double getRightArmSpeed() {
    	return rightArmMotor.get();
    }
}

