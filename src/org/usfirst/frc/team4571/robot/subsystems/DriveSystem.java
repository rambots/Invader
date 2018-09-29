package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.subsystems.pid.TurnOutput;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSystem extends Subsystem {
	private WPI_TalonSRX 	    topLeftMotor,
							    bottomLeftMotor,
						        topRightMotor,
							    bottomRightMotor;
	private DifferentialDrive   differentialDrive;
	private final AHRS		    navX;

	private final PIDController turnController;
	
	/**
	 * For rotating
	 */
	private static final double rotate_K = 1.3,
								rotate_I = 0.0,
								rotate_D = 3.1;
	
	/**
	 * For maintaining steady angle
	 */
	private static final double tuning_K = 0,
								tuning_I = 0,
								tuning_D = 0;
								
	public DriveSystem() {
		this.topLeftMotor 	  = new WPI_TalonSRX(RobotMap.TOP_LEFT_MOTOR);
		this.bottomLeftMotor  = new WPI_TalonSRX(RobotMap.BOTTOM_LEFT_MOTOR);
		this.topRightMotor 	  = new WPI_TalonSRX(RobotMap.TOP_RIGHT_MOTOR);
		this.bottomRightMotor = new WPI_TalonSRX(RobotMap.BOTTOM_RIGHT_MOTOR);
		
		this.topLeftMotor.setExpiration(Robot.DEFAULT_PERIOD);
		this.bottomLeftMotor.setExpiration(Robot.DEFAULT_PERIOD);
		this.topRightMotor.setExpiration(Robot.DEFAULT_PERIOD);
		this.bottomRightMotor.setExpiration(Robot.DEFAULT_PERIOD);
		
		this.topLeftMotor.setSafetyEnabled(false);
		this.bottomLeftMotor.setSafetyEnabled(false);
		this.topRightMotor.setSafetyEnabled(false);
		this.bottomRightMotor.setSafetyEnabled(false);
		
		topLeftMotor.setNeutralMode(NeutralMode.Brake);
		bottomLeftMotor.setNeutralMode(NeutralMode.Brake);
		topRightMotor.setNeutralMode(NeutralMode.Brake);
		bottomRightMotor.setNeutralMode(NeutralMode.Brake);
		
		topLeftMotor.setInverted(true);
		bottomLeftMotor.setInverted(true);
		topRightMotor.setInverted(true);
		bottomRightMotor.setInverted(true);
		
		SpeedControllerGroup leftMotors  = new SpeedControllerGroup(topLeftMotor, bottomLeftMotor);
		SpeedControllerGroup rightMotors = new SpeedControllerGroup(topRightMotor, bottomRightMotor);
		
		this.differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
		this.differentialDrive.setExpiration(Robot.DEFAULT_PERIOD);
		this.differentialDrive.setSafetyEnabled(false);
		
		this.navX 		    = new AHRS(Port.kMXP);

		TurnOutput turnOutput = new TurnOutput(differentialDrive);
		this.turnController = new PIDController(rotate_K, rotate_I, rotate_D, navX, turnOutput);
	}
	
	public void initDefaultCommand() {}
	
	public void drive(double left, double right) {
		this.differentialDrive.tankDrive(left, right);
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
		this.drive(0.0, 0.0);
	}
	
	public void resetNavX() {
		this.navX.reset();
	}
	
	public double getAngle() {
		return this.navX.getAngle();
	}
	
	public boolean isTurnAngleOnTarget() {
		return this.turnController.onTarget();
	}
	
	public PIDController getTurnController() {
		return this.turnController;
	}
	
	
	/**
	 * used for making big turns
	 * 
	 * @param angleSetPoint angle in degrees
	 */
	public void setTurnPIDParameter(double angleSetPoint) {
		turnController.reset();	
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-0.8, 0.8);
		turnController.setSetpoint(angleSetPoint);
		turnController.setAbsoluteTolerance(5.0f);
		turnController.enable();
	}
	
	
	
	public void disableTurnPID() {
		this.turnController.disable();
	}
	
}