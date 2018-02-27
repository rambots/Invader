package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSystem extends Subsystem {
	private WPI_TalonSRX 		topLeftMotor,
								bottomLeftMotor,
								topRightMotor,
								bottomRightMotor;
	private DifferentialDrive 	differentialDrive;
	private final AHRS navX;
	
	public DriveSystem() {
		this.topLeftMotor 		= new WPI_TalonSRX(RobotMap.TOP_LEFT_MOTOR);
		this.bottomLeftMotor 	= new WPI_TalonSRX(RobotMap.BOTTOM_LEFT_MOTOR);
		this.topRightMotor 		= new WPI_TalonSRX(RobotMap.TOP_RIGHT_MOTOR);
		this.bottomRightMotor 	= new WPI_TalonSRX(RobotMap.BOTTOM_RIGHT_MOTOR);
		
		this.topLeftMotor.setSafetyEnabled(false);
		this.bottomLeftMotor.setSafetyEnabled(false);
		this.topRightMotor.setSafetyEnabled(false);
		this.bottomRightMotor.setSafetyEnabled(false);
		
		this.topLeftMotor.setExpiration(0.1);
		this.bottomLeftMotor.setExpiration(0.1);
		this.topRightMotor.setExpiration(0.1);
		this.bottomRightMotor.setExpiration(0.1);
		
		topLeftMotor.setNeutralMode(NeutralMode.Brake);
		bottomLeftMotor.setNeutralMode(NeutralMode.Brake);
		topRightMotor.setNeutralMode(NeutralMode.Brake);
		bottomRightMotor.setNeutralMode(NeutralMode.Brake);
		
		SpeedControllerGroup leftMotors 	= new SpeedControllerGroup(topLeftMotor, bottomLeftMotor);
		SpeedControllerGroup rightMotors 	= new SpeedControllerGroup(topRightMotor, bottomRightMotor);
		
		this.differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
		this.differentialDrive.setExpiration(0.1);
		this.differentialDrive.setSafetyEnabled(false);
		
		this.navX = new AHRS(SPI.Port.kMXP);
	}
	
	//public void drive(double left, double right) {
//		this.differentialDrive.tankDrive(left, right);
//	}
	
	public void drive(double left, double right, boolean squaredInputs) {
		this.differentialDrive.tankDrive(left, right, squaredInputs);
	
	}
	public double getTopLeftMotorSpeed() {
		return this.topLeftMotor.get();
	}
	
	public double getBottomLeftMotorSpeed() {
		return this.bottomLeftMotor.get();
	}
	
	public double getTopRightMotorSpeed() {
		return this.topRightMotor.get();
	}
	
	public double getBottomRightMotorSpeed() {
		return this.bottomRightMotor.get();
	}
	
	public void stop() {
		this.drive(0.0, 0.0, true);
	}

    public void initDefaultCommand() {}
}

