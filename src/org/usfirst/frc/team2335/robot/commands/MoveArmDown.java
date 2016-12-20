package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmDown extends Command
{
    public MoveArmDown()
    {
    	//Uses arm subsystem
    	requires(Robot.arm);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.arm.down();
    }

    protected boolean isFinished()
    {
    	//The return false means that once the axis stops being active it will run end()
        return false;
    }

    protected void end()
    {
    	Robot.arm.stop();
    }

    //This is called when the command is interrupted (duh)
    //So incase something crashes it still stops the drive train
    protected void interrupted()
    {
    	Robot.arm.stop();
    }
}
