/* Diana Lin
Jan 10 2019
Ms Krasteva
A program that teaches the basics of boolean algebra. There are lessons to teach the beginner concepts of boolean logic. Then, the user has the option to quiz themselves 
on their mastery of boolean logic, aided by a bank of at least 50 questions. Each question has 4 possible answers. 
*/
import hsa.Console; // imports the console 
import java.awt.*; // imports all of java.awt
import java.lang.*; // imports all of java.lang - allows for use of threads

public class Title extends Thread
{
    private Console c;// declares a private console c - private to avoid interacting with other classes 
    /*draw(); 
    used to draw an animation on the output window 
    Local Variable Dictionary 
    type        name        purpose
    Font        titleFont   stores the larger font used to draw string title
    Color       titleColor  stores the color used for the title 
    
    shows various boolean logic operators moving across the screen 
    */ 
    public void draw ()
    {
	 Font titleFont = new Font ("Old English Text MT", Font.PLAIN, 50); // declares and initializes a font variable 
	 for (int i = 1 ; i <= 100 ; i++)  // loops 100 times - changes the transparency 
	{   
	    Color titleColor = new Color (0,0,0,i); // sets the color to color that transparency changes 
	    c.setFont(titleFont); // sets the font to the titleFont 
	    c.setColor(titleColor);// sets the color to titleColor 
	    c.drawString("Boolean Logic", 165,200); // draw the word within " " at a location
	    try{ 
	    Thread.sleep(50); // waits 50 ms after each drawing 
	    }
	    catch(Exception e) {} 
	    
	}
    }


    public Title (Console con)//create Console con 
    //splashscreen to display on the same console screen 
    {
	c = con;
    }


    public void run ()
    {
	draw ();
    }
}
