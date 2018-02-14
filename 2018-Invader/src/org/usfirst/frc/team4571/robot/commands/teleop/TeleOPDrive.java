package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleOPDrive extends Command {

    public TeleOPDrive() {
        requires(Robot.DRIVE_SYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    private void smartDashboard() {
    	SmartDashboard.putNumber("top left speed", Robot.DRIVE_SYSTEM.getTopLeftMotorSpeed());
    	SmartDashboard.putNumber("bottom left speed", Robot.DRIVE_SYSTEM.getBottomLeftMotorSpeed());
    	SmartDashboard.putNumber("top right speed", Robot.DRIVE_SYSTEM.getTopRightMotorSpeed());
    	SmartDashboard.putNumber("bottom right speed", Robot.DRIVE_SYSTEM.getBottomRightMotorSpeed());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DRIVE_SYSTEM.drive(	Robot.LEFT_JOYSTICK.getY_Axis(),
    									Robot.RIGHT_JOYSTICK.getY_Axis());
    	smartDashboard();
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
