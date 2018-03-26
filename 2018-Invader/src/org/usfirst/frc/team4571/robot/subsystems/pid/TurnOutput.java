package org.usfirst.frc.team4571.robot.subsystems.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TurnOutput implements PIDOutput {
	private DifferentialDrive myRobot;
	
	public TurnOutput(DifferentialDrive drive) {
		this.myRobot = drive;
	}

	@Override
	public void pidWrite(double output) {
		this.myRobot.tankDrive(-output, output);
	}

}
