package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmUp extends Command
{

    public MoveArmUp()
    {
        requires(Robot.arm);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.arm.up();
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    	Robot.arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	Robot.arm.stop();
    }
}
