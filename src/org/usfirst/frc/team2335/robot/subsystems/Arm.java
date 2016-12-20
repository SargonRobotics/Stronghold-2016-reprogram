package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem
{
	//Arm motor
	Victor armMotor;
	
	//Digital inputs for the encoder
	DigitalInput armEncodeA, armEncodeB;
	
	//Encoder
	Encoder armEncoder;
    
    public Arm()
    {
    	super();
    	
    	//Defines motor
        armMotor = new Victor(Robot.ARM);
        
        //Defines digital inputs
        armEncodeA = new DigitalInput(Robot.ARMCHANNELA);
        armEncodeB = new DigitalInput(Robot.ARMCHANNELB);
        
        //Defines encoder
        armEncoder = new Encoder(armEncodeA, armEncodeB, true, EncodingType.k4X);
        
        //Sets encoder constants        
        armEncoder.setMaxPeriod(0.1);
        armEncoder.setMinRate(10);
        armEncoder.setDistancePerPulse(5);
        armEncoder.setReverseDirection(true);
        armEncoder.setSamplesToAverage(7);
        
        //Starts counting for the encoder
        armEncoder.reset();
    }
    
    public void initDefaultCommand() { }
    
    //Arm motor commands
    public void down()
    {
    	armMotor.set(0.8);    	
    	printEncoder();
    }
    
    public void up()
    {
    	//If the arm isn't at max height, it moves up
    	if(encoderAt0())
    	{
    		stop();
    		DriverStation.reportWarning("Can't move arm up", true);
    	}
    	else
    	{
    		armMotor.set(-0.8);
    	}

    	printEncoder();
    }
    
    public void stop()
    {
    	armMotor.set(0);
    }
    
    //Encoder commands
    public boolean encoderAt0()
    {
    	if(armEncoder.get() >= -5)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    private void printEncoder()
    {
    	//Prints to the dashboard
    	SmartDashboard.putString("DB/String 4", "eArm: " + Integer.toString(armEncoder.get()));
    }
}