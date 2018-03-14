package org.usfirst.frc.team4571.robot.commands.teleop.climber;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command controls the climber elevator.
 * 
 * @author Mahim
 */
public class ClimberCommand extends Command {
	private Button upButton,
	               downButton;
	
	/**
     * This command requires two buttons for it to operate.
     * 
     * @param upButton   This button controls the climber going up.
     * @param downButton This button controls the climber going down.
     */
    public ClimberCommand(Button upButton, Button downButton) {
    	requires(Robot.CLIMBER_SYSTEM);
    	this.upButton   = upButton;
    	this.downButton = downButton;
    	
    }

    protected void initialize() {}

    protected void execute() {
    	if(upButton.get()) {
    		Robot.CLIMBER_SYSTEM.goUp();
    	} else if (downButton.get()) {
    		Robot.CLIMBER_SYSTEM.goDown();
    	} else {
    		Robot.CLIMBER_SYSTEM.stop();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.CLIMBER_SYSTEM.stop();
    }

    protected void interrupted() {
    }
}
