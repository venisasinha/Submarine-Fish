package myFirstProject;

import processing.core.PApplet;


public class MyFirstProject extends PApplet {

	public void setup() 
	{
	
		 size(800, 700);
	        background(255, 255, 255);
	}

	public void draw() 
	{ 
		face();
		eyes();
		mouth();
		leftEar();
		rightEar();
		
		
	}
	 
    public void face() 
    {
    	fill (0, 149, 185);
    	rect(100, 300, 500, 300, 4);
    }
    
    public void eyes()
    {
    	fill(255, 255, 255);
        ellipse(200, 400, 100, 100);
        ellipse(500, 400, 25, 25);
    }
    
    public void mouth()
    {
    	fill(255, 255, 255);
        triangle(250, 500, 500, 500, 350, 575);
    }
    public int pointAX = 75;
    public int pointAY = 400;
 
    public void leftEar()
    {
        fill(244, 121, 0);
        rect(pointAX, pointAY, 25, 100);
        rect(pointAX - 25, pointAY + 12, 25, 75);
        line(pointAX - 35, 430, pointAX - 35, 100);
        rect(pointAX - 50, pointAY + 24, 25, 50);
        fill(255, 255, 255);
        ellipse(pointAX - 35, 100, 30, 30);
    }
    public int pointBX = pointAX + 25 + 500;
    public int pointBY = pointAY;
     
    public void rightEar()
    {
        fill(244, 121, 0);
        rect(pointBX, pointBY, 25, 100);
        rect(pointBX + 25, pointBY + 12, 25, 75);
        line(pointBX + 65, 430, pointBX + 65, 100);
        rect(pointBX + 50, pointBY + 24, 25, 50);
        fill(255, 255, 255);
        ellipse(pointBX + 65, 100, 30, 30);
    }
}
