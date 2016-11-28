package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShort extends Command {

    public AutoShort()
    {
        requires(Robot.shooter);
        setTimeout(5);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.driveTrain.driveForward();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end()
    {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() 
    {
    	end();
    }
}
