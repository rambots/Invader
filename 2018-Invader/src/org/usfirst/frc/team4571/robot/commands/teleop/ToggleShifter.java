package org.usfirst.frc.team4571.robot.commands.teleop;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotJoystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command will toggle the state of the transmissions to either low
 * or high gear. 
 * 
 * <p>This command will only work if it is assigned to execute when a button 
 * is pressed, please check this method how to assign it
 * {@link RobotJoystick#button1WhenPressed(Command)}. Make sure it is the same
 * button that is used when instantiating the class.
 * 
 * @author Mahim
 */
public class ToggleShifter extends Command {
	private Button 	button;
	private boolean isAction1Activated,
					isAction2Activated;
	
	
    public ToggleShifter(Button button) {
    	requires(Robot.PNEUMATICS);
    	this.button = button;
    }

    protected void initialize() {
    	Robot.PNEUMATICS.pushInShifter();
    }

    protected void execute() {
    	if (isAction2Activated) {
    		Robot.PNEUMATICS.pushOutShifter();
    	} else if (isAction1Activated) {
    		Robot.PNEUMATICS.pushInShifter();
    	}
    	if (button.get() && isAction1Activated == false) {
    		this.isAction2Activated =! isAction2Activated;
    	} else if (button.get() == false) {
    		this.isAction1Activated =! isAction1Activated;
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
