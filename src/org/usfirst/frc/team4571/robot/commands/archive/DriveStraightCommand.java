//package org.usfirst.frc.team4571.robot.commands.auto;
//
//import org.usfirst.frc.team4571.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.TimedCommand;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
//public class DriveStraightCommand extends TimedCommand {
//	private double speed;
//
//    public DriveStraightCommand(double timeout, double speed) {
//        super(timeout);
//        requires(Robot.DRIVE_SYSTEM);
//        this.speed = speed;
//    }
//
//    protected void initialize() {
//    	Robot.DRIVE_SYSTEM.resetNavX();
//    	Robot.DRIVE_SYSTEM.setAngleMaintainingParameters();
//    }
//
//    protected void execute() {
//    	double output = Robot.DRIVE_SYSTEM.getAngleMaintainingOutput();
//    	Robot.DRIVE_SYSTEM.drive(speed + output, speed - output);
//    	log();
//    }
//    
//    private void log() {
//    	SmartDashboard.putData("drive straight", Robot.DRIVE_SYSTEM.getAngleMaintainer());
//    	SmartDashboard.putNumber("angle", Robot.DRIVE_SYSTEM.getAngle());
//    }
//
//    protected void end() {
//    	Robot.DRIVE_SYSTEM.stop();
//    	Robot.DRIVE_SYSTEM.disableAnglePID();
//    	Robot.DRIVE_SYSTEM.resetNavX();
//    }
//
//    protected void interrupted() {}
//}
