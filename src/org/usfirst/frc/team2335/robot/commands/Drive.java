package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command
{	
    public Drive()
    {
    	//Uses the driveTrain subsystem
        requires(Robot.driveTrain);
    }

    protected void initialize() { }

    protected void execute()
    {
    	//Gets joystick values from OI file and uses arcadeDrive to drive the robot
    	Robot.driveTrain.arcade(Robot.oi.getAxis(Robot.MOVE, 0.95), Robot.oi.getAxis(Robot.ROTATE, 0.75));
    }

    protected boolean isFinished()
    {
    	//The return false means that once the axis stops being active it will run end()
        return false;
    }

    protected void end()
    {
    	Robot.driveTrain.stop();
    }

    //This is called when the command is interrupted (duh)
    //So incase something crashes it still stops the drive train
    protected void interrupted()
    {
    	end();
    }
}
