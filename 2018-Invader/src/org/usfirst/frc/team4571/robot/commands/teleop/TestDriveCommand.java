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

    protected void initialize() {}

    protected void execute() {
    	if(Robot.RIGHT_JOYSTICK.isButton1Pressed()) {
    		Robot.DRIVE_SYSTEM.drive(0.3, 0.3);
    	} else if(Robot.LEFT_JOYSTICK.isButton1Pressed()) {
    		Robot.DRIVE_SYSTEM.drive(-0.3, -0.3);
    	} else {
    		Robot.DRIVE_SYSTEM.stop();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void interrupted() {}
}
