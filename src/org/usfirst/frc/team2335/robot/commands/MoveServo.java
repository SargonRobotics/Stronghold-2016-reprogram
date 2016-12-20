package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveServo extends Command
{
    public MoveServo()
    {
    	//Uses shooter subsystem
        requires(Robot.shooter);
        
        //Sets the timeout to 1 second
        setTimeout(1);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.servoForward();
    }

    protected boolean isFinished()
    {
    	//After the timeout (1 second) it runs end()
        return isTimedOut();
    }

    protected void end()
    {
    	Robot.shooter.servoBackwards();
    }

    //This is called when the command is interrupted (duh)
    //So incase something crashes it still stops the drive train
    protected void interrupted()
    {
    	end();
    }
}
