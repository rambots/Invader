package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command controls the wheels of the arms, it will spin when a button
 * is held, one button will spin it forward for out take and spin the other way 
 * for intake
 * 
 * @author Mahim
 */
public class ArmCommand extends Command {
	private Button button1,
				   button2;

    public ArmCommand(Button button1, Button button2) {
    	requires(Robot.ARM_SYSTEM);
    	this.button1 = button1;
    	this.button2 = button2;
    }

    protected void initialize() {
    	Robot.ARM_SYSTEM.stop();
    }

    protected void execute() {
    	if (button1.get()) {
    		Robot.ARM_SYSTEM.startIntake();
    	} else {
    		Robot.ARM_SYSTEM.stop();
    	}
    	if (button2.get()) {
    		Robot.ARM_SYSTEM.startOuttake();
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
