package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.ElevatorCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	WPI_TalonSRX elevatorMotor;
	private static final double UP_SPEED = 0.5,
							    DOWN_SPEED = -0.5;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Elevator() {
		this.elevatorMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);
		this.elevatorMotor.setExpiration(0.2);
		this.elevatorMotor.setSafetyEnabled(false);

	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ElevatorCommand());
    }
    
    public void elevate() {
    	elevatorMotor.set(UP_SPEED);
    }
    
    public void stopElevator() {
    	elevatorMotor.set(0.0);
    }
    
    public void descend() {
    	elevatorMotor.set(DOWN_SPEED);
    }
    
    public double getElevatorSpeed() {
    	return elevatorMotor.get();
    }

    public void setElevatorMotor(double power) {
    	elevatorMotor.set(power);
    }

}

