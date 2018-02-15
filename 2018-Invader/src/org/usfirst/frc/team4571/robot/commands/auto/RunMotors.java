package org.usfirst.frc.team4571.robot.commands.auto;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class RunMotors extends TimedCommand {
	private double speed;

    public RunMotors(double timeout, double speed) {
        super(timeout);
        requires(Robot.DRIVE_SYSTEM);
        this.speed = speed;
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.DRIVE_SYSTEM.drive(speed, speed);
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void interrupted() {}
}