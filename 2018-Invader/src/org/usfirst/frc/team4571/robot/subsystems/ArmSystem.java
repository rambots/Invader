package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSystem extends Subsystem {
	WPI_TalonSRX leftArmMotor,
				 rightArmMotor;
	
	private static final double INTAKE_SPEED  = -0.5,
								OUTTAKE_SPEED =  0.5;
	
	public ArmSystem() {
		this.leftArmMotor  = new WPI_TalonSRX(RobotMap.LEFT_ARM_MOTOR);
		this.rightArmMotor = new WPI_TalonSRX(RobotMap.RIGHT_ARM_MOTOR);
		this.leftArmMotor.setInverted(true);
		this.leftArmMotor.setExpiration(0.1);
		this.rightArmMotor.setExpiration(0.1);
		this.leftArmMotor.setSafetyEnabled(false);
		this.rightArmMotor.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {}
    
    private void setMotors(double power) {
    	this.leftArmMotor.set(power);
    	this.rightArmMotor.set(power);
    }
    
    public void startIntake() {
    	setMotors(INTAKE_SPEED);
    }
    
    public void stop() {
    	setMotors(0.0);
    }
    
    public void startOuttake() {
    	setMotors(OUTTAKE_SPEED);
    }
}

