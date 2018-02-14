package org.usfirst.frc.team4571.robot.commands.auto;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class RunMotors extends TimedCommand {

    public RunMotors(double timeout) {
        super(timeout);
        requires(Robot.DRIVE_SYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DRIVE_SYSTEM.drive(0.35, 0.35);
    }

    // Called once after timeout
    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
