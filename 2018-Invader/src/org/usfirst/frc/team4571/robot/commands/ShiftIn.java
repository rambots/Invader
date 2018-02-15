package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftIn extends Command {

    public ShiftIn() {
    	requires(Robot.PNEUMATICS);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.PNEUMATICS.pushInShifter();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {}
}
