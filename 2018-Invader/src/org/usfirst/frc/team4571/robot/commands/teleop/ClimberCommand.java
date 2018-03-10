package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberCommand extends Command {

    public ClimberCommand() {
    	requires(Robot.CLIMBER_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.CLIMBER_SYSTEM.setPower(Robot.LEFT_JOYSTICK.getYAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.CLIMBER_SYSTEM.stop();
    }

    protected void interrupted() {
    }
}
