package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StartShoot extends Command
{
	public StartShoot()
    {
    	//Uses shooter subsystem
        requires(Robot.shooter);
        
        //Sets the command to run for 0.5 seconds
        setTimeout(0.5);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.shootBall();
    }

    protected boolean isFinished()
    {
    	//After the timeout (0.5 seconds) it runs end()
        return isTimedOut();
    }
    
    //Since after this runs there will be a StopShooter command we don't need to have anything in end()
    protected void end() { }

    protected void interrupted() { }
}
