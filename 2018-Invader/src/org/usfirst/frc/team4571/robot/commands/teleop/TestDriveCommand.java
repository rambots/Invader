package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestDriveCommand extends Command {

    public TestDriveCommand() {
    	requires(Robot.DRIVE_SYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.RIGHT_JOYSTICK.isButton1Pressed()) {
    		Robot.DRIVE_SYSTEM.drive(0.3, 0.3);
    	} else if(Robot.LEFT_JOYSTICK.isButton1Pressed()) {
    		Robot.DRIVE_SYSTEM.drive(-0.3, -0.3);
    	} else {
    		Robot.DRIVE_SYSTEM.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
