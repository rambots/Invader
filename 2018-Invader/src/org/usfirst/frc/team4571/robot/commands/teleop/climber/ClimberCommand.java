package org.usfirst.frc.team4571.robot.commands.teleop.climber;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command controls the climber elevator.
 * 
 * @author Mahim
 */
public class ClimberCommand extends Command {
	
    public ClimberCommand() {
    	requires(Robot.CLIMBER_SYSTEM);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.CLIMBER_SYSTEM.setPower(Robot.GAMEPAD.getLeftYAxis());
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
