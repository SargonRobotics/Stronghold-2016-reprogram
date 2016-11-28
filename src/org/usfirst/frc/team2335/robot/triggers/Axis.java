package org.usfirst.frc.team2335.robot.triggers;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class Axis extends Trigger
{
	//Constants
	public static double DEADZONE = 0.2;
	
	//Axes
	public static int MOVE = 1, ROTATE = 0;
	
	//Motors
	public static int LEFTDRIVE = 1, RIGHTDRIVE = 0, ARM = 8;
	
	//Buttons
	public static int ARMDOWN = 4, ARMUP = 6;

	
    //Variables to store joystick, and button values
	private Joystick _xbox;
	private int _axis;
	
	//Sets the variables to return
	public Axis(Joystick xbox, int axis)
	{
		_xbox = xbox;
		_axis = axis;
	}
	
    public boolean get()
    {
    	if(Robot.deadzone(_xbox.getRawAxis(_axis), 1) > 0 || Robot.deadzone(_xbox.getRawAxis(_axis), 1) < 0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
