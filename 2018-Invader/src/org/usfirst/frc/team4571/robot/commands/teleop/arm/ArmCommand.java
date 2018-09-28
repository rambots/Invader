package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command controls the wheels of the arms, it will spin when a button
 * is held, one button will spin it forward for out take and spin the other way 
 * for intake
 * 
 * @author Mahim
 */
public class ArmCommand extends Command {
	private static final double OPTIMAL_OUTTAKE_SPEED = 0.50,
								LOWER_SPEED			  = 0.3;

    public ArmCommand() {
    	requires(Robot.ARM_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double rightTrigger = Robot.GAMEPAD.getRightTrigger();
    	double leftTrigger  = Robot.GAMEPAD.getLeftTrigger();
    	
    	if (rightTrigger > 0 && rightTrigger > leftTrigger) {
    		Robot.ARM_SYSTEM.setArmMotors(-rightTrigger);
    	} else if (leftTrigger > 0 && leftTrigger > rightTrigger) {
    		Robot.ARM_SYSTEM.setArmMotors(leftTrigger);
    	} else if (Robot.GAMEPAD.getButtonB().get()) {
    		Robot.ARM_SYSTEM.setArmMotors(OPTIMAL_OUTTAKE_SPEED);
    	} else if (Robot.GAMEPAD.getButtonA().get()) {
    		Robot.ARM_SYSTEM.setArmMotors(LOWER_SPEED);
    	} else {
    		Robot.ARM_SYSTEM.stop();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ARM_SYSTEM.stop();
    }

    protected void interrupted() {}
}
