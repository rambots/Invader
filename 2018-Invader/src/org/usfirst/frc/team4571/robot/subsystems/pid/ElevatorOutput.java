package org.usfirst.frc.team4571.robot.subsystems.pid;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDOutput;

public class ElevatorOutput implements PIDOutput {
	WPI_TalonSRX elevatorMotor;
	
	public ElevatorOutput(WPI_TalonSRX elevatorMotor) {
		this.elevatorMotor = elevatorMotor;
	}

	@Override
	public void pidWrite(double output) {
		elevatorMotor.set(output);
	}
}
