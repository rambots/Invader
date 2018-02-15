package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftOut extends Command {

    public ShiftOut() {
    	requires(Robot.PNEUMATICS);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.PNEUMATICS.pushOutShifter();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
