/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.commands.PulleyCommand;
import org.usfirst.frc.team4571.robot.commands.auto.RunMotors;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.ArmCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.ElevatorCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.climber.ClimberCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.drive.TeleOPDrive;
import org.usfirst.frc.team4571.robot.subsystems.ArmSystem;
import org.usfirst.frc.team4571.robot.subsystems.ClimberSystem;
import org.usfirst.frc.team4571.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4571.robot.subsystems.Elevator;
import org.usfirst.frc.team4571.robot.subsystems.PulleySystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	// JOYSTICKS
	public static final DriveStick 	    	LEFT_DRIVE_STICK 	 = new DriveStick(RobotMap.LEFT_JOYSTICK);
	public static final DriveStick 	    	RIGHT_DRIVE_STICK 	 = new DriveStick(RobotMap.RIGHT_JOYSTICK);
	public static final Gamepad				GAMEPAD			 	 = new Gamepad(RobotMap.GAMEPAD);
	
	// SUBSYSTEMS
	public static final Elevator			ELEVATOR			 = new Elevator();
	public static final DriveSystem 		DRIVE_SYSTEM 		 = new DriveSystem();
	public static final ArmSystem			ARM_SYSTEM			 = new ArmSystem();
	public static final PulleySystem		PULLEY_SYSTEM		 = new PulleySystem();
	public static final ClimberSystem		CLIMBER_SYSTEM		 = new ClimberSystem();
	
	// DRIVE
	public static final TeleOPDrive 		TELE_OP_DRIVE 		 = new TeleOPDrive();
	
	// ARM
	public static final ArmCommand			ARM_COMMAND			 = new ArmCommand();
	public static final ElevatorCommand		ELEVATOR_COMMAND	 = new ElevatorCommand();
	public static final PulleyCommand		PULLEY_COMMAND		 = new PulleyCommand();
	
	// CLIMBER
	public static final ClimberCommand		CLIMBER_COMMAND      = new ClimberCommand();
	
	Command m_autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		autoChooser.addDefault("Cross Line", new RunMotors(4.5, 0.5));
		autoChooser.addObject("run reversed", new RunMotors(3, -0.5));
		SmartDashboard.putData("Auto mode", autoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		DRIVE_SYSTEM.resetNavX();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = autoChooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default"); 
		 * switch(autoSelected) { 
		 * case "My Auto": 
		 * autonomousCommand = new MyAutoCommand(); 
		 * break; 
		 * case "Default Auto": 
		 * default:
		 * autonomousCommand = new ExampleCommand();
		 * break; 
		 * }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}
	
	/**
	 * This method contains the information you want to track an test during tele 
	 * operated period
	 */
	public void log() {
		// Transmission Motors
		SmartDashboard.putNumber("top left speed", DRIVE_SYSTEM.getTopLeftMotorSpeed());
    	SmartDashboard.putNumber("bottom left speed", DRIVE_SYSTEM.getBottomLeftMotorSpeed());
    	SmartDashboard.putNumber("top right speed", DRIVE_SYSTEM.getTopRightMotorSpeed());
    	SmartDashboard.putNumber("bottom right speed", DRIVE_SYSTEM.getBottomRightMotorSpeed());
    	// Arm Motors
		SmartDashboard.putNumber("Elevator Motor Speed", ELEVATOR.getElevatorSpeed());
		SmartDashboard.putNumber("left arm speed", ARM_SYSTEM.getLeftArmSpeed());
		SmartDashboard.putNumber("right arm speed", ARM_SYSTEM.getRightArmSpeed());
		// Climber Motor
		SmartDashboard.putNumber("Climber Motor Speed", CLIMBER_SYSTEM.getClimberSpeed());
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
		Scheduler.getInstance().add(TELE_OP_DRIVE);
		Scheduler.getInstance().add(CLIMBER_COMMAND);
		Scheduler.getInstance().add(ARM_COMMAND);
		Scheduler.getInstance().add(ELEVATOR_COMMAND);
		Scheduler.getInstance().add(PULLEY_COMMAND);
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	@Override
	public String toString() {
		return "Robot [m_autonomousCommand=" + m_autonomousCommand + ", autoChooser=" + autoChooser + "]";
	}
}