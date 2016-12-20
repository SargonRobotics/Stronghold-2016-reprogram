package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;
import org.usfirst.frc.team2335.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem
{
	//For auto
	double speed = 0;
	
	//Drive train
	RobotDrive drive;
	
	public DriveTrain()
	{
		super();
		
		//Defines drive train
		drive = new RobotDrive(Robot.LEFTDRIVE, Robot.RIGHTDRIVE);
	}
	
	public void arcade(double moveAmount, double rotateAmount)
	{
		//arcadeDrive method moves the drive motors
		drive.arcadeDrive(moveAmount, rotateAmount);
		SmartDashboard.putString("DB/String 0", Double.toString(moveAmount));
		SmartDashboard.putString("DB/String 1", Double.toString(rotateAmount));
	}
	
	//Gradually increases speed for auto commands
	public void driveForward()
	{
		drive.arcadeDrive(speed, 0);
		
		if(speed < 1)
		{
			speed += 0.005;
		}
	}
	
    public void initDefaultCommand()
    {
    	setDefaultCommand(new Drive());
    }
	
	public void stop()
	{
		drive.arcadeDrive(0, 0);
	}	
}

