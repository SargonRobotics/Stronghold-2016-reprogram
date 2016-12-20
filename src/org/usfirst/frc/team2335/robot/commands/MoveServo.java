package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveServo extends Command
{
    public MoveServo()
    {
    	//Uses shooter subsystem
        requires(Robot.shooter);
        
        //Sets the timeout to 0.4 seconds
        setTimeout(0.4);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.servoForward();
    }

    protected boolean isFinished()
    {
    	//After the timeout (0.4 seconds) it runs end()
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
