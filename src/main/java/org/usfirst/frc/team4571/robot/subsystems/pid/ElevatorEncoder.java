package org.usfirst.frc.team4571.robot.subsystems.pid;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class ElevatorEncoder implements PIDSource {
	private WPI_TalonSRX elevatorMotor;
	
	public ElevatorEncoder(WPI_TalonSRX elevatorMotor) {
		this.elevatorMotor = elevatorMotor;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return -elevatorMotor.getSelectedSensorPosition(0);
	}
	
	public void reset() {
		elevatorMotor.setSelectedSensorPosition(0, 0, RobotMap.PERIOD_IN_MS);
	}
}
