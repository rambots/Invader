package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PulleyCommand extends Command {

    public PulleyCommand() {
    	requires(Robot.PULLEY_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.GAMEPAD.isDPadPressedUp()) {
    		Robot.PULLEY_SYSTEM.goUp();
    	} else if (Robot.GAMEPAD.isDPadPressedDown()) {
    		Robot.PULLEY_SYSTEM.goDown();
    	} else {
    		Robot.PULLEY_SYSTEM.setPulley(0.0);
    	}
    }
    
    public void log() {
    	SmartDashboard.putBoolean("is d pad pressed up", Robot.GAMEPAD.isDPadPressedUp());
    	SmartDashboard.putBoolean("is d pad pressed down", Robot.GAMEPAD.isDPadPressedDown());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {}
}
