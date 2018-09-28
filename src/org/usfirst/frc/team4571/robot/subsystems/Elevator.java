package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.subsystems.pid.ElevatorEncoder;
import org.usfirst.frc.team4571.robot.subsystems.pid.ElevatorOutput;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private WPI_TalonSRX elevatorMotor;
	
	private static final double MAX_HEIGHT_ENCODER_TICK = 29000;
	private static final double MAX_HEIGHT_IN_INCHES    =  89;
	private static final double p = 0.5,
								i = 0,
								d = 0;
	
	private final PIDController   elevatorController;
	private final ElevatorEncoder elevatorEncoder;
	private final ElevatorOutput  elevatorOutput;
	
	private DigitalInput lowerLimit;
	
	public Elevator() {
		this.elevatorMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);
		this.elevatorMotor.setExpiration(Robot.DEFAULT_PERIOD);
		this.elevatorMotor.setSafetyEnabled(false);
		this.elevatorMotor.setNeutralMode(NeutralMode.Brake);
		
		this.elevatorEncoder 	= new ElevatorEncoder(elevatorMotor);
		this.elevatorOutput  	= new ElevatorOutput(elevatorMotor);
		this.elevatorController = new PIDController(p, i, d, elevatorEncoder, elevatorOutput);
		
		this.lowerLimit = new DigitalInput(RobotMap.LIMIT_SWITCH);
	}
	
    public void initDefaultCommand() {}
    
    /**
     * converts the given heigt in inches to encoder ticks
     * 
     * @param setpointInInches setpoint in inches
     */
    public int convertSetpoint(double setpointInInches) {
    	return (int)((setpointInInches / MAX_HEIGHT_IN_INCHES) * MAX_HEIGHT_ENCODER_TICK);
    }
    
    public double getTick() {
    	return elevatorEncoder.pidGet();
    }
    
    public PIDController getElevatorController() {
    	return this.elevatorController;
    }
    
    public void setParameters(double height) {
    	elevatorEncoder.reset();
    	elevatorController.setInputRange(0, MAX_HEIGHT_ENCODER_TICK);
    	elevatorController.setOutputRange(-0.5, 0.8);
    	elevatorController.setSetpoint(convertSetpoint(height));
    	elevatorController.setAbsoluteTolerance(height * 0.1); // 10% tolerance
    	elevatorController.enable();
    }
    
    public void stopElevator() {
    	elevatorMotor.set(0.0);
    }
    
    public void resetEncoder() {
    	elevatorEncoder.reset();
    }
    
    public void disablePID() {
    	this.elevatorController.disable();
    }
    
    public double getElevatorSpeed() {
    	return elevatorMotor.get();
    }

    public void setElevatorMotor(double power) {
    	elevatorMotor.set(power);
    }
    
    public boolean isOnTarget() {
    	return this.elevatorController.onTarget();
    }
    
    public boolean isLimitSwitchPressed() {
    	return lowerLimit.get();
    }
}