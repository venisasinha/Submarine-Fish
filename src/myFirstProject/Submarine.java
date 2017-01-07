package myFirstProject;

import javax.swing.JOptionPane;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PFont;

public class Submarine extends PApplet
{
	
	ArrayList <BlueFish> fishArray = new ArrayList<BlueFish>();
	ArrayList <OtherFish> fishArr = new ArrayList<OtherFish>();

	int foodx;
	int foody;
	int score = 0;
		
	// generate the random integers for r, g and b value
	PFont f;
	Random generator = new Random();
		//Fish fish = new Fish();

	public float speed = 4.75f;
	public float speedFish = 7;
	public float foodspeed = 2;
	
	//Submarine
	public boolean moveForward = false;
	public boolean moveBackwards = false;
	public boolean moveUp = false;
	public boolean moveDown = false;
	public boolean moving = false;
	//fish
	public boolean moveForwardFish = false;
	public boolean moveBackwardsFish = false;
	public boolean moveUpFish = false;
	public boolean moveDownFish = false;
	public boolean movingFish = false;
	Rectangle Submarine;
	Rectangle Fish;
	Rectangle FishFood;
	//background fish
	public boolean moveForwardFish2 = true;
	public boolean moveBackwardsFish2 = true;
	public boolean movingFish2 = true;
	//more fish
	public boolean moveForwardFish3 = true;
	public boolean moveBackwardsFish3 = true;
	public boolean movingFish3 = true;
	//food
	public boolean movingdown = true;
	public boolean movingfood = true;
	//Collision
	public boolean message = false;
//FoodSubmarine
	public boolean FoodSubmarine = false;
	public void setup()
	{
		JOptionPane.showMessageDialog(null, "This is a multi-player Game: one has to be a submarine and the other the red fish. If you are the submarine then you would have to catch the fish. \nThe fish, however, has to catch the white/black circles (food) that will be falling from the top of the screen. If the fish is able to get the food, then it gains a point. If not, then it loses a point. \nThe fish should get a maximum score of 6 and should also try to avoid the submarine to win. \n To control the fish, use the a, s, d, w keys while the submarine will use the arrowkeys to move. \nAs it is harder to be the fish, the speed of the submarine is lower to make it fairer for the fish. \nPoints to keep in mind for: \n1) If the submarine/fish reaches the edge of the screen it will come out from the other side. \n2) If you are the submarine, you should not block the food at any costs. If the submarine comes in contact with the food, then the fish wil gain a point.", "Welcome", JOptionPane.INFORMATION_MESSAGE);
		size (2000, 1000); 
		newFishFood();
		f = createFont ("Ariel", 20, true);

		for(int i = 0; i < 20; i++)
		{
			fishArray.add( new BlueFish(( generator.nextInt(1850)), (generator.nextInt(900) ), ( generator.nextInt(10)+1)));

		}
		
		for (int i = 0; i < 20; i++)
		{
			fishArr.add(new OtherFish(( generator.nextInt(1850)), (generator.nextInt(900) ), ( generator.nextInt(10)+1)));
		}
		
	}

	public void draw()
	{
		clear();
		background(4, 176, 251);


		//Move and control the submarine and fish.
		move();
		
		for(int i = 0; i < fishArray.size(); i++)
		{
			drawFish2(fishArray.get(i));
		}
		
		for (int i = 0; i < fishArr.size(); i++)
		{
			drawOtherFish(fishArr.get(i));
		}
		
		drawFood();
		drawFish();
		drawSubmarine();
		
		collision();
		collisionFishFood();
		collisionSubmarine();
		
	}
	private void collisionSubmarine() {
		// TODO Auto-generated method stub
		if(Submarine.intersects(FishFood) && FoodSubmarine == false){
			score++;
			 FoodSubmarine = true;
		}
		
	}

	//Set up and draw the background fish.
	public void drawFish2(BlueFish fish)
	{
		//Body Color.
		noStroke();
		fill (generator.nextInt(255), generator.nextInt(255), generator.nextInt(255));
		//Body
		ellipse(fish.x, fish.y, 50, 15);
		//Efish.ye Color.
		noStroke();
		fill (255, 255, 255);
		//Eye
		ellipse(fish.x - 18, fish.y, 4, 4);
		//Everything else
		noStroke();
		fill (generator.nextInt(255), generator.nextInt(255), generator.nextInt(255));
		//Tail
		triangle(fish.x + 20, fish.y, fish.x + 50, fish.y - 14, fish.x + 50, fish.y + 15);
		//Top Fin.
		triangle(fish.x, fish.y - 8, fish.x + 25, fish.y - 18, fish.x + 25, fish.y -8);
		//Bottom Fin.
		triangle(fish.x, fish.y + 8, fish.x + 25, fish.y + 20, fish.x + 25, fish.y + 10);
		fish.x -= fish.speed;
		
		if( fish.x > 2000)
		{
			fish.x = 0;
		}
		if( fish.x < 0)
		{
			fish.x = 2000;
		}
	}
		
		//Set up and draw the other background fish.
		
		public void drawOtherFish(OtherFish fish)
		{
			//Body Color.
			noStroke();
			fill (generator.nextInt(255), generator.nextInt(255), generator.nextInt(255));
			//Body
			ellipse(fish.x1, fish.y1, 50, 15);
			//fish eye Color.
			noStroke();
			fill (255, 255, 255);
			//Eye
			ellipse(fish.x1 + 18, fish.y1, 4, 4);
			//Everything else
		 	noStroke();
			fill (generator.nextInt(255), generator.nextInt(255), generator.nextInt(255));
			//Tail
			triangle(fish.x1 - 10, fish.y1, fish.x1 - 40, fish.y1 - 14, fish.x1 - 40, fish.y1 + 15);
			//Top Fin.
			triangle(fish.x1, fish.y1 - 8, fish.x1-25, fish.y1 - 18, fish.x1-25, fish.y1 -8);
			//Bottom Fin.
			triangle(fish.x1, fish.y1 + 8, fish.x1 - 25, fish.y1 + 20, fish.x1 - 25, fish.y1 + 10);

		

		fish.x1 += fish.speed1;
		if( fish.x1 > 2000)
		{
			fish.x1 = 0;
		}
		if( fish.x1 < 0)
		{
			fish.x1 = 2000;
		}
	}
	


	public void drawFish()
	{
		Fish = new Rectangle(fishX,fishY,80,60);
		//Body Color.
		stroke(0, 0, 0);
		fill (255, 0, 0);
		//Body
		ellipse(fishX, fishY, 75, 35);
		//Eye Color.
		noStroke();
		fill (0, 0, 0);
		//Eye
		ellipse(fishX - 25, fishY - 2, 8, 8);
		//Tail
		triangle(fishX + 37, fishY, fishX + 60, fishY - 14, fishX + 60, fishY + 18);
		//Top Fin.
		triangle(fishX, fishY - 18, fishX + 25, fishY - 30, fishX + 25, fishY -18);
		//Bottom Fin.
		triangle(fishX, fishY + 18, fishX + 25, fishY + 31, fishX + 25, fishY + 20);
		if(movingFish)
		{
			//Bubbles for Fish.
			noFill();
			stroke (255, 255, 255);
			ellipse(fishX - 44, fishY - 15, 10, 10);
			ellipse(fishX - 44, fishY - 30, 10, 10);
			ellipse(fishX - 44, fishY - 45, 10, 10);
		}

		textFont(f, 20);
		fill(0,0,0);
		text("Your score is now " + score, 800, 900);
	}

	//Set up and draw the submarine.
		public int submarineX = 100;
		public int submarineY = 100;

		public void drawSubmarine()
		{
			Submarine = new Rectangle(submarineX, submarineY, 80,60);
			//Body Color.
			stroke(255, 128, 0);
			fill (0, 0, 64);
			//Top Body
			ellipse(submarineX, submarineY -25, 75,50);
			//Bottom Body
			ellipse(submarineX, submarineY, 100, 55);
			//WindowRight
			ellipse(submarineX - 25, submarineY - 7, 8, 8);
			//WindowMiddle
			ellipse(submarineX + 3, submarineY - 7, 8, 8);
			//WindowLeft
			ellipse(submarineX + 30, submarineY - 7, 8, 8);

			if(moving)
			{
				//Bubbles for Submarine.
				fill(128, 128, 255);
				noStroke();
				ellipse(submarineX - 20, submarineY + 40, 10, 10);
				ellipse(submarineX + 20, submarineY + 50, 10, 10);
				ellipse(submarineX - 40, submarineY + 41, 10, 10);
			}
		}
		//Set up and draw the fish.
		public int fishX = 1800;
		public int fishY = 850;

	public void keyPressed() 
	{
		if(keyCode == LEFT)
		{
			moveBackwards = true;
			moving = true;
		}
		if(keyCode == RIGHT)
		{
			moveForward = true;
			moving = true;
		}
		if(keyCode == UP) 
		{
			moveUp = true;
			moving = true;
		} 
		if(keyCode == DOWN)
		{
			moveDown = true;
			moving = true;
		}

		//fish
		if(key == 'a')
		{
			moveBackwardsFish = true;
			movingFish = true;
		}
		if(key == 'd')
		{
			moveForwardFish = true;
			movingFish = true;
		}
		if(key == 'w') 
		{
			moveUpFish = true;
			movingFish = true;
		} 
		if(key == 's')
		{
			moveDownFish = true;
			movingFish = true;
		}
	}

	public void keyReleased() 
	{
		if(keyCode == LEFT)
		{
			moveBackwards = false;
			moving = false;
		}
		if(keyCode == RIGHT)
		{
			moveForward = false;
			moving = false;
		}
		if(keyCode == UP) 
		{
			moveUp = false;
			moving = false;
		} 
		if(keyCode == DOWN)
		{
			moveDown = false;
			moving = false;
		}


		//fish
		if(key == 'a')
		{
			moveBackwardsFish = false;
			movingFish = false;
		}
		if(key == 'd')
		{
			moveForwardFish = false;
			movingFish = false;
		}
		if(key == 'w') 
		{
			moveUpFish = false;
			movingFish = false;
		} 
		if(key == 's')
		{
			moveDownFish = false;
			movingFish = false;
		}
	}


	public void move()
	{
		if(moveForward)
		{
			submarineX += speed;
			if( submarineX > 2000)
			{
				submarineX = 0;
			}
		}
		if(moveUp)
		{
			submarineY -= speed;
			if( submarineY < 0)
			{
				submarineY = 1000;
			}
		}
		if(moveBackwards)
		{
			submarineX -= speed;
			if( submarineX < 0)
			{
				submarineX = 2000;
			}
		}
		if(moveDown)
		{
			submarineY += speed;
			if( submarineY > 1000)
			{
				submarineY = 0;
			}
		}
		//fish
		if(moveForwardFish){

			fishX += speedFish;
			if( fishX > 2000)
			{
				fishX = 0;
			}
		}
		if(moveUpFish)
		{
			fishY -= speedFish;
			if( fishY < 0)
			{
				fishY = 1000;
			}
		}
		if(moveBackwardsFish)
		{
			fishX -= speedFish;
			if( fishX < 0)
			{
				fishX = 2000;
			}
		}
		if (moveDownFish)
		{
			fishY += speedFish;
			if( fishY > 1000)
			{
				fishY = 0;
			}

		}

	}//end of move
	
	public void newFishFood() 
	{
		foodx = generator.nextInt(1850);
		foody = generator.nextInt(500);


	}
	public void drawFood(){
		FishFood = new Rectangle(foodx,foody,50,50);
		stroke(0,0,0);
		fill(255, 255, 255);
		ellipse(foodx, foody, 16, 16);
		
		foody += foodspeed;
		if( foody > 950)
		{	if (score > 0)
			score--;
			foody = 5;
			foodx = (generator.nextInt(1850)-500);
		}
		
	}

	public void collision(){
			if(Submarine.intersects(Fish) && message == false){
			JOptionPane.showMessageDialog(null, "Submarine, You Won! Let's Celebrate!");
			message = true;

		}
	}

	public void collisionFishFood(){
		if(Fish.intersects(FishFood)){
			newFishFood();
			score++;

		}
		
			
		if(score == 6 && message == false){
			JOptionPane.showMessageDialog(null, "Fish, You Won! Time for Fireworks!");
			message = true;
		}
		
	
	}


}
