package org.usfirst.frc.team4571.robot.commands.auto;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnCommand extends Command {
	private double angle;

    public TurnCommand(double angle) {
    	requires(Robot.DRIVE_SYSTEM);
    	this.angle = angle;
    }

    protected void initialize() {
    	Robot.DRIVE_SYSTEM.resetNavX();
    	Robot.DRIVE_SYSTEM.setAnglePIDParameter(angle);
    	SmartDashboard.putData("angle pid", Robot.DRIVE_SYSTEM.getTurnController());
    }

    protected void execute() {}

    protected boolean isFinished() {
        return Robot.DRIVE_SYSTEM.isAngleOnTarget();
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    	Robot.DRIVE_SYSTEM.disablePID();
    }

    protected void interrupted() {}
}
