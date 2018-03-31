package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	Robot.ELEVATOR.resetEncoder();
    }
    
    protected void execute() {
    	Robot.ELEVATOR.setElevatorMotor(Robot.GAMEPAD.getRightYAxis());
    	SmartDashboard.putNumber("Raw Elevator Encoder Tick", Robot.ELEVATOR.getRawEncoderTick());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.ELEVATOR.stopElevator();
    	Robot.ELEVATOR.resetEncoder();
    }

    protected void interrupted() {}
}