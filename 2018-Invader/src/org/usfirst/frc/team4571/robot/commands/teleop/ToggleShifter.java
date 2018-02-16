package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleShifter extends Command {
	private Button 	button;
	private boolean isShiftedIn,
					isShiftedOut;

    public ToggleShifter(Button button) {
    	requires(Robot.PNEUMATICS);
    	this.button = button;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.PNEUMATICS.pushInShifter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isShiftedOut) {
    		Robot.PNEUMATICS.pushOutShifter();
    	} else if (isShiftedIn) {
    		Robot.PNEUMATICS.pushInShifter();
    	}
    	if (button.get() && isShiftedIn == false) {
    		this.isShiftedOut =! isShiftedOut;
    	} else if (button.get() == false) {
    		this.isShiftedIn =! isShiftedIn;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
