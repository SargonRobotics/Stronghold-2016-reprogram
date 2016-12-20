package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.Drive;
import org.usfirst.frc.team2335.robot.commands.MoveArmDown;
import org.usfirst.frc.team2335.robot.commands.MoveArmUp;
import org.usfirst.frc.team2335.robot.commands.MoveShooter;
import org.usfirst.frc.team2335.robot.commands.PullBall;
import org.usfirst.frc.team2335.robot.commands.Reset;
import org.usfirst.frc.team2335.robot.commands.Shoot;
import org.usfirst.frc.team2335.robot.triggers.Axis;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	//Joystick
	private Joystick xbox = new Joystick(0); //Get's controller input from port 0
	
	public OI()
	{	
		//Arm buttons
		Button armUp = new JoystickButton(xbox, Robot.ARMUP);
		Button armDown = new JoystickButton(xbox, Robot.ARMDOWN);
		Button reset = new JoystickButton(xbox, Robot.RESET);
		
		//Axes
		Axis move = new Axis(xbox, Robot.MOVE);
		Axis rotate = new Axis(xbox, Robot.ROTATE);
		Axis shootBall = new Axis(xbox, Robot.SHOOTBALL);
		Axis pullBall = new Axis(xbox, Robot.PULLBALL);
		Axis shooterMove = new Axis(xbox, Robot.AIMSHOOTER);
		
		//Arm commands
		armUp.whileHeld(new MoveArmUp());
		armDown.whileHeld(new MoveArmDown());
		
		//Drive commands
		move.whileActive(new Drive());
		rotate.whileActive(new Drive());
	
		//Shooter commands
		shootBall.whenActive(new Shoot());
		pullBall.whenActive(new PullBall());
		shooterMove.whileActive(new MoveShooter());

		//Reset command
		reset.whenPressed(new Reset());
	}
	
	//Gets the joystick value for other commands to use
	public double getAxis(int axis, double max)
	{
		return Robot.deadzone(xbox.getRawAxis(axis), max);
	}
}