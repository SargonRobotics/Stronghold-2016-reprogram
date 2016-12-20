package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShort extends Command
{
    public AutoShort()
    {
    	//Uses the shooter subsystem
        requires(Robot.shooter);
        
        //Sets the command to run for 5 seconds
        setTimeout(5);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.driveTrain.driveForward();
    }

    protected boolean isFinished()
    {
    	//After the timeout (5 seconds) it runs end()
        return isTimedOut();
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
