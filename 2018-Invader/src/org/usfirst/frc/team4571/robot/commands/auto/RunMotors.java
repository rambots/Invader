package org.usfirst.frc.team4571.robot.commands.auto;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;


/**
 * This is an autonomous command, this is used to test the new transmissions
 * it is used to run for 30 minutes, however this class is designed that you can
 * make other commands to run for however long you want.
 * 
 * @author Mahim
 */
public class RunMotors extends TimedCommand {
	private double power;

    /**
     * This will run the motors of the transmission for the given time.
     * 
     * @param runtime How long it will run in seconds
     * @param power The power the motors will run in
     */
    public RunMotors(double runtime, double power) {
        super(runtime);
        requires(Robot.DRIVE_SYSTEM);
        this.power = power;
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.DRIVE_SYSTEM.drive(power, power);
    }

    protected void end() {
    	Robot.DRIVE_SYSTEM.stop();
    }

    protected void interrupted() {}
}