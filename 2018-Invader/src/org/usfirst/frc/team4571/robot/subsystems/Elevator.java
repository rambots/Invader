package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	WPI_TalonSRX elevatorMotor;
	private static final int 	MAX_HEIGHT_ENCODER_TICK = -29000;
	private static final double MAX_HEIGHT_IN_INCHES    =  89;
	private static final double p = 0.0,
								i = 0.0,
								d = 0.0;
	
	public Elevator() {
		this.elevatorMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);
		this.elevatorMotor.setExpiration(Robot.DEFAULT_PERIOD);
		this.elevatorMotor.setSafetyEnabled(false);
		this.elevatorMotor.setNeutralMode(NeutralMode.Brake);
		this.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.PERIOD_IN_MS);
		
		this.elevatorMotor.config_kP(0, p, RobotMap.PERIOD_IN_MS);
		this.elevatorMotor.config_kI(0, i, RobotMap.PERIOD_IN_MS);
		this.elevatorMotor.config_kD(0, d, RobotMap.PERIOD_IN_MS);
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
    
    public void setHeight(double height) {
    	this.elevatorMotor.set(ControlMode.Position, convertSetpoint(height));
    }
    
    public void setParameters(double height) {
    	
    }
    
    public int getRawEncoderTick() {
    	return elevatorMotor.getSelectedSensorPosition(0);
    }
    
    public void resetEncoder() {
    	elevatorMotor.setSelectedSensorPosition(0, 0, RobotMap.PERIOD_IN_MS);
    }
    
    public void stopElevator() {
    	elevatorMotor.set(0.0);
    }
    
    public double getElevatorSpeed() {
    	return elevatorMotor.get();
    }

    public void setElevatorMotor(double power) {
    	elevatorMotor.set(power);
    }
}