package org.usfirst.frc.team4571.robot.commands.teleop.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This is the teleOP command of controlling the tank drive using 2 Joysticks
 * 
 * @author Mahim
 */
public class TeleOPDrive extends Command {

    public TeleOPDrive() {
        requires(Robot.DRIVE_SYSTEM);
    }

    protected void initialize() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void execute() {
    	double left  = Robot.LEFT_DRIVE_STICK.getYAxis();
    	double right = Robot.RIGHT_DRIVE_STICK.getYAxis();
    	
    	Robot.DRIVE_SYSTEM.drive(left, right);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void interrupted() {}
}
