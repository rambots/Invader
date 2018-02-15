/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4571.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// JOYSTICKS
	public static final int LEFT_JOYSTICK 	= 0,
							RIGHT_JOYSTICK 	= 1;
	
	// DRIVE SYSTEM
	public static final int TOP_LEFT_MOTOR 		= 1,
							BOTTOM_LEFT_MOTOR 	= 2,
							TOP_RIGHT_MOTOR		= 3,
							BOTTOM_RIGHT_MOTOR	= 4;
}