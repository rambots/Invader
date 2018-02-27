package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleOPDrive extends Command {

    public TeleOPDrive() {
        requires(Robot.DRIVE_SYSTEM);
    }

    protected void initialize() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void execute() {
    	double left 	= Robot.LEFT_JOYSTICK.getYAxis();
    	double right 	= Robot.RIGHT_JOYSTICK.getYAxis();
    	
    	Robot.DRIVE_SYSTEM.drive(left, right, true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void interrupted() {}
}
