package org.usfirst.frc.team3676.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain {
	
	Talon LeftFrontWheel, LeftBackWheel, RightFrontWheel, RightBackWheel, FrontWheel, BackWheel;
	Joystick controller;
	
	//Manages all of the sockets for each wheel
	public DriveTrain(Joystick controller, int a, int b, int c, int d, int e, int f) {
		LeftFrontWheel = new Talon(a);
		LeftBackWheel = new Talon(b);
		RightFrontWheel = new Talon(c);
		RightBackWheel = new Talon(d);
		FrontWheel = new Talon(e);
		BackWheel = new Talon(f);
		this.controller = controller;
	}
	
	public void ripInPeace()
	{
		LeftFrontWheel.disable();
		LeftBackWheel.disable();
		RightFrontWheel.disable();
		RightBackWheel.disable();
		FrontWheel.disable();
		BackWheel.disable();
	}
	
	
	public void update()
	{
		double xValue = controller.getX();
		double yValue = controller.getY();
		
		//LB
		if(controller.getRawButton(6))
		{
			LeftFrontWheel.set(-0.5);
			LeftBackWheel.set(-0.5);
			RightFrontWheel.set(0.5);
			RightBackWheel.set(0.5);
			FrontWheel.set(1);
			BackWheel.set(-1);
		}
		//RB
		else if(controller.getRawButton(5))
		{
			LeftFrontWheel.set(0.5);
			LeftBackWheel.set(0.5);
			RightFrontWheel.set(-0.5);
			RightBackWheel.set(-0.5);
			FrontWheel.set(-1);
			BackWheel.set(1);
		}
		else {
			LeftFrontWheel.set((yValue/32767));
			LeftBackWheel.set((yValue/32767));
			RightFrontWheel.set(yValue/32767);
			RightBackWheel.set(yValue/32767);
			FrontWheel.set(xValue/32767);
			BackWheel.set(xValue/32767);
		}
		
	}
}
