package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PullBall extends Command
{
    public PullBall()
    {
    	//Uses shooter subsystem
        requires(Robot.shooter);
        
        //Sets the command to run for 5 seconds
        setTimeout(0.5);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.pullBall();
    }

    protected boolean isFinished()
    {
    	//After the timeout (0.5 seconds) it runs end()
        return isTimedOut();
    }

    protected void end() 
    {
    	Robot.shooter.stopBall();
    }

    //This is called when the command is interrupted (duh)
    //So incase something crashes it still stops the drive train
    protected void interrupted()
    {
    	end();
    }
}
