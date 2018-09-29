/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4571.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4571.robot.commands.auto.GetSwitchLeft;
import org.usfirst.frc.team4571.robot.commands.auto.GetSwitchRight;
import org.usfirst.frc.team4571.robot.commands.auto.RunMotors;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.ArmCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.ElevatorCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.arm.PulleyCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.climber.ClimberCommand;
import org.usfirst.frc.team4571.robot.commands.teleop.drive.TeleOPDrive;
import org.usfirst.frc.team4571.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
    private DriverStation ds = DriverStation.getInstance();

    // JOYSTICKS
    public static final DriveStick LEFT_DRIVE_STICK  = new DriveStick(RobotMap.LEFT_JOYSTICK);
    public static final DriveStick RIGHT_DRIVE_STICK = new DriveStick(RobotMap.RIGHT_JOYSTICK);
    public static final Gamepad	   GAMEPAD			 = new Gamepad(RobotMap.GAMEPAD);

    // SUBSYSTEMS
    public static final Elevator	ELEVATOR	 = new Elevator();
    public static final DriveSystem DRIVE_SYSTEM = new DriveSystem();
    public static final ArmSystem	ARM_SYSTEM	 = new ArmSystem();
    public static final Pulley		PULLEY		 = new Pulley();
    public static final Climber		CLIMBER		 = new Climber();

    // DRIVE
    private static final TeleOPDrive TELE_OP_DRIVE = new TeleOPDrive();

    // ARM
    private static final ArmCommand	     ARM_COMMAND = new ArmCommand();
    private static final ElevatorCommand ELEVATOR_COMMAND = new ElevatorCommand();
    private static final PulleyCommand   PULLEY_COMMAND = new PulleyCommand();

    // CLIMBER
    private static final ClimberCommand CLIMBER_COMMAND = new ClimberCommand();

    public enum Placement {
        Left, Middle, Right;

        Placement() {

        }
    }

    private Command m_autonomousCommand;
    private Placement placement;
    private SendableChooser<Command> autoChooser = new SendableChooser<>();
    private SendableChooser<Placement> placementChooser = new SendableChooser<>();

    @Override
    public void robotInit() {
        autoChooser.addDefault("Cross Line", new RunMotors(4.5, 0.5));
        autoChooser.addObject("if left", new GetSwitchLeft());
        autoChooser.addObject("if right", new GetSwitchRight());
        SmartDashboard.putData("Auto mode", autoChooser);

        placementChooser.addObject("left", Placement.Left);
        placementChooser.addObject("middle", Placement.Middle);
        placementChooser.addObject("right", Placement.Right);
        SmartDashboard.putData("alliance placement", placementChooser);
    }

    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
        DRIVE_SYSTEM.resetNavX();
        ELEVATOR.resetEncoder();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        String gameData = ds.getGameSpecificMessage();
        m_autonomousCommand = autoChooser.getSelected();
        placement = placementChooser.getSelected();

        if (m_autonomousCommand != null && gameData.charAt(0) == 'R' && m_autonomousCommand.getName().equals("right")) {
            m_autonomousCommand.start();
        } else if (m_autonomousCommand != null && gameData.charAt(0) == 'L' && m_autonomousCommand.getName().equals("left")) {
            m_autonomousCommand.start();
        } else {
            Scheduler.getInstance().add(new RunMotors(4.5, 0.5));
//			Scheduler.getInstance().add(new GetSwitchLeft());
        }
    }

    /**
     * This method contains the information you want to track an test during tele
     * operated period
     */
    private void log() {
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
        SmartDashboard.putNumber("Climber Motor Speed", CLIMBER.getClimberSpeed());
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("angle", DRIVE_SYSTEM.getAngle());
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
//		LEFT_DRIVE_STICK.button1WhenPressed(GO_HALF);
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    @Override
    public void testPeriodic() {
    }

    @Override
    public String toString() {
        return "Robot [m_autonomousCommand=" + m_autonomousCommand + ", autoChooser=" + autoChooser + "]";
    }
}