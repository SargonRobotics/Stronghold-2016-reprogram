package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command
{	
    public Drive()
    {
        requires(Robot.driveTrain);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.driveTrain.arcade(
    			Robot.oi.getAxis(Robot.MOVE, 0.95),
    			Robot.oi.getAxis(Robot.ROTATE, 0.75));
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() { }
}
