/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.commands.StartCompressor;
import org.usfirst.frc.team4571.robot.commands.StopCompressor;
import org.usfirst.frc.team4571.robot.commands.auto.RunMotors;
import org.usfirst.frc.team4571.robot.commands.teleop.ArmCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.TeleOPDrive;
import org.usfirst.frc.team4571.robot.commands.teleop.ToggleShifter;
import org.usfirst.frc.team4571.robot.subsystems.ArmSystem;
import org.usfirst.frc.team4571.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4571.robot.subsystems.Pneumatics;

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
	public static final RobotJoystick 		LEFT_JOYSTICK 		= new RobotJoystick(RobotMap.LEFT_JOYSTICK);
	public static final RobotJoystick 		RIGHT_JOYSTICK 		= new RobotJoystick(RobotMap.RIGHT_JOYSTICK);
	
	// SUBSYSTEMS
	public static final DriveSystem 		DRIVE_SYSTEM 		= new DriveSystem();
	public static final Pneumatics			PNEUMATICS			= new Pneumatics();
	public static final ArmSystem			ARM_SYSTEM			= new ArmSystem();
	
	// COMMANDS
	public static final TeleOPDrive 		TELE_OP_DRIVE 		= new TeleOPDrive();
	public static final StopCompressor		STOP_COMPRESSOR		= new StopCompressor();
	public static final ToggleShifter		TOGGLE_SHIFTER		= new ToggleShifter(Robot.LEFT_JOYSTICK.getButton1());
	public static final ArmCommand			ARM_COMMAND			= new ArmCommand(LEFT_JOYSTICK.getButton11(), LEFT_JOYSTICK.getButton12());

	Command m_autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		autoChooser.addDefault("Run Motors", new RunMotors(60*30, 0.4));
		autoChooser.addObject("Run Motors Reversed", new RunMotors(60*30, -0.25));
		SmartDashboard.putData("Auto mode", autoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Scheduler.getInstance().add(STOP_COMPRESSOR);
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
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		Scheduler.getInstance().add(STOP_COMPRESSOR);
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
		Scheduler.getInstance().add(ARM_COMMAND);
		Robot.LEFT_JOYSTICK.button1WhenPressed(TOGGLE_SHIFTER);
		SmartDashboard.putData("Start Compressor", new StartCompressor());
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("top left speed", DRIVE_SYSTEM.getTopLeftMotorSpeed());
    	SmartDashboard.putNumber("bottom left speed", DRIVE_SYSTEM.getBottomLeftMotorSpeed());
    	SmartDashboard.putNumber("top right speed", DRIVE_SYSTEM.getTopRightMotorSpeed());
    	SmartDashboard.putNumber("bottom right speed", DRIVE_SYSTEM.getBottomRightMotorSpeed());
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