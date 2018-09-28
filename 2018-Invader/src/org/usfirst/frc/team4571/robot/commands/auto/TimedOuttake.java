package org.usfirst.frc.team4571.robot.commands.auto;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedOuttake extends TimedCommand {

    public TimedOuttake(double timeout) {
        super(timeout);
        requires(Robot.ARM_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ARM_SYSTEM.setArmMotors(0.5);
    }

    protected void end() {
    	Robot.ARM_SYSTEM.stop();
    }

    protected void interrupted() {
    }
}
