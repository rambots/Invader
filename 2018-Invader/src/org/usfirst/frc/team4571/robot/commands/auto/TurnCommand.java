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
    	Robot.DRIVE_SYSTEM.setTurnPIDParameter(angle);
    }

    protected void execute() {
    	log();
    }
    
    private void log() {
    	SmartDashboard.putData("angle pid", Robot.DRIVE_SYSTEM.getTurnController());
    	SmartDashboard.putNumber("angle", Robot.DRIVE_SYSTEM.getAngle());
    }

    protected boolean isFinished() {
        return Robot.DRIVE_SYSTEM.isTurnAngleOnTarget();
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    	Robot.DRIVE_SYSTEM.disableTurnPID();
    	Robot.DRIVE_SYSTEM.resetNavX();
    }

    protected void interrupted() {
    	Robot.DRIVE_SYSTEM.stop();
    	Robot.DRIVE_SYSTEM.disableTurnPID();
    	Robot.DRIVE_SYSTEM.resetNavX();
    }
}
