package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This subsystem contains all the components of the drive system.
 * Such as:
 * 
 * <li> The motors for the transmissions
 * <li> The encoders
 * <li> A gyroscope
 * 
 * @author Mahim
 */
public class DriveSystem extends Subsystem {
	private WPI_TalonSRX 	  topLeftMotor,
							  bottomLeftMotor,
						      topRightMotor,
							  bottomRightMotor;
	private DifferentialDrive differentialDrive;
	
	public DriveSystem() {
		this.topLeftMotor 	  = new WPI_TalonSRX(RobotMap.TOP_LEFT_MOTOR);
		this.bottomLeftMotor  = new WPI_TalonSRX(RobotMap.BOTTOM_LEFT_MOTOR);
		this.topRightMotor 	  = new WPI_TalonSRX(RobotMap.TOP_RIGHT_MOTOR);
		this.bottomRightMotor = new WPI_TalonSRX(RobotMap.BOTTOM_RIGHT_MOTOR);
		
		this.topLeftMotor.setExpiration(0.1);
		this.bottomLeftMotor.setExpiration(0.1);
		this.topRightMotor.setExpiration(0.1);
		this.bottomRightMotor.setExpiration(0.1);
		
		this.topLeftMotor.setSafetyEnabled(false);
		this.bottomLeftMotor.setSafetyEnabled(false);
		this.topRightMotor.setSafetyEnabled(false);
		this.bottomRightMotor.setSafetyEnabled(false);
		
		topLeftMotor.setNeutralMode(NeutralMode.Brake);
		bottomLeftMotor.setNeutralMode(NeutralMode.Brake);
		topRightMotor.setNeutralMode(NeutralMode.Brake);
		bottomRightMotor.setNeutralMode(NeutralMode.Brake);
		
		SpeedControllerGroup leftMotors  = new SpeedControllerGroup(topLeftMotor, bottomLeftMotor);
		SpeedControllerGroup rightMotors = new SpeedControllerGroup(topRightMotor, bottomRightMotor);
		
		this.differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
		this.differentialDrive.setExpiration(0.1);
		this.differentialDrive.setSafetyEnabled(false);
	}
	
	public void initDefaultCommand() {}
	
	/**
	 * This method is used to drive the robot. It can also be used to directly set
	 * the power of the motors during autonomous if wanted.
	 * 
	 * @param left	The robot left side's speed along the X axis [-1.0..1.0]. Forward is
	 *              positive.
	 * @param right	The robot right side's speed along the X axis [-1.0..1.0]. Forward is
	 *              positive.
	 */
	public void drive(double left, double right) {
		this.differentialDrive.tankDrive(left, right);
	}
	
	/**
	 * This method is used to drive the robot. This method should only be used for teleOP.
	 * 
	 * @param left		  	The robot left side's speed along the X axis [-1.0..1.0]. Forward is
	 *                      positive.
	 * @param right			The robot right side's speed along the X axis [-1.0..1.0]. Forward is
	 *                      positive.
	 * @param squaredInputs	If set, decreases the input sensitivity at low speeds.
	 */
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
}