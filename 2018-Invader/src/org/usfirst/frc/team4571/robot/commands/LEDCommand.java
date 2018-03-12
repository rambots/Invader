package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDCommand extends Command {

    public LEDCommand() {
    	requires(Robot.LEDS_SUBSYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.LEDS_SUBSYSTEM.heartbeatGray();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
