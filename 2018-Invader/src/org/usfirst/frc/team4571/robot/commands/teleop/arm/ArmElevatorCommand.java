package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command controls the arm elevator.
 * 
 * @author Mahim
 */
public class ArmElevatorCommand extends Command {
	private Button upButton, 
		           downButton;

    /**
     * This command requires two buttons for it to operate.
     * 
     * @param upButton   This button controls the elevator going up.
     * @param downButton This button controls the elevator going down.
     */
    public ArmElevatorCommand(Button upButton, Button downButton) {
    	requires(Robot.ARM_SYSTEM);
    	this.upButton   = upButton;
    	this.downButton = downButton;
    }

    protected void initialize() {}

    protected void execute() {
    	if(upButton.get()) {
    		Robot.ARM_SYSTEM.elevate();
    	} else if(downButton.get()) {
    		Robot.ARM_SYSTEM.descend();
    	} else {
    		Robot.ARM_SYSTEM.stopElevator();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ARM_SYSTEM.stopElevator();
    }

    protected void interrupted() {}
}