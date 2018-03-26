package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command controls the arm elevator.
 * 
 * @author Mahim
 */
public class ElevatorCommand extends Command {

    /**
     * This command requires two buttons for it to operate.
     * 
     * @param upButton   This button controls the elevator going up.
     * @param downButton This button controls the elevator going down.
     */
    public ElevatorCommand() {
    	requires(Robot.ELEVATOR);
    }

    protected void initialize() {
    	System.out.println("Elevator command INITIALIZE");
    }
    
    protected void execute() {
    	Robot.ELEVATOR.setElevatorMotor(Robot.GAMEPAD.getRightYAxis());
    	System.out.println(Robot.GAMEPAD.getRightYAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ELEVATOR.stopElevator();
    }

    protected void interrupted() {}
}