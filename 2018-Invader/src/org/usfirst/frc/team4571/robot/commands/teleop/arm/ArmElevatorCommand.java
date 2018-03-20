package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command controls the arm elevator.
 * 
 * @author Mahim
 */
public class ArmElevatorCommand extends Command {

    /**
     * This command requires two buttons for it to operate.
     * 
     * @param upButton   This button controls the elevator going up.
     * @param downButton This button controls the elevator going down.
     */
    public ArmElevatorCommand() {
    	requires(Robot.ARM_SYSTEM);
    }

    protected void initialize() {}

    protected void execute() {
//    	Robot.ARM_SYSTEM.setElevatorMotor(Robot.GAMEPAD.getRightYAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ARM_SYSTEM.stopElevator();
    }

    protected void interrupted() {}
}