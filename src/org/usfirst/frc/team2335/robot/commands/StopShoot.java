package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopShoot extends Command
{
	public StopShoot()
    {
        //Uses shooter subsystem
        requires(Robot.shooter);
        
        //Sets the command to run for 0.5 seconds
        setTimeout(0.5);
    }

    protected void initialize() { }
    
    protected void execute()
    {
    	Robot.shooter.stopBall();
    }

    protected boolean isFinished()
    {
    	//After the timeout (0.5 seconds) it runs end()
        return isTimedOut();
    }

    //Since we've already stopped the shoot motors there's no need to have anything in end()
    protected void end() { }

    protected void interrupted() { }
}
