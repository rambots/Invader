package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartCompressor extends Command {

    public StartCompressor() {
    	requires(Robot.PNEUMATICS);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.PNEUMATICS.startCompressor();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.PNEUMATICS.stopCompressor();
    }

    protected void interrupted() {}
}