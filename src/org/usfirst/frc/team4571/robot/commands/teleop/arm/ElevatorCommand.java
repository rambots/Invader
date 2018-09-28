package org.usfirst.frc.team4571.robot.commands.teleop.arm;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends Command {

    public ElevatorCommand() {
    	requires(Robot.ELEVATOR);
    }

    protected void initialize() {
    	Robot.ELEVATOR.resetEncoder();
    }
    
    protected void execute() {
    	SmartDashboard.putNumber("Raw Elevator Encoder Tick", Robot.ELEVATOR.getTick());
    	if(Robot.ELEVATOR.isLimitSwitchPressed() && Robot.GAMEPAD.getRightYAxis() < 0) {
    	    Robot.ELEVATOR.stopElevator();
        } else {
            Robot.ELEVATOR.setElevatorMotor(Robot.GAMEPAD.getRightYAxis());
        }
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