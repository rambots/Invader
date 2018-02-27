package org.usfirst.frc.team4571.robot.commands.auto;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class RunMotors extends TimedCommand {
	private double power;

    public RunMotors(double timeout, double power) {
        super(timeout);
        requires(Robot.DRIVE_SYSTEM);
        this.power = power;
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.DRIVE_SYSTEM.drive(power, power, true);
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void interrupted() {}
}