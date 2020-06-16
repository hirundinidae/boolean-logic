/* Diana Lin
Jan 10 2019
Ms Krasteva
A program that teaches the basics of boolean algebra. There are lessons to teach the beginner concepts of boolean logic. Then, the user has the option to quiz themselves 
on their mastery of boolean logic, aided by a bank of at least 50 questions. Each question has 4 possible answers. 

*/ 
import hsa.Console; // imports the console 
import java.awt.*; // imports all of java.awt
import java.lang.*; // imports all of java.lang - allows for use of threads

public class Move extends Thread
{ 
    private Console c; // declares a private console c - private to avoid interacting with other classes 

    
    /*draw(); 
    used to draw an animation on the output window 
    Local Variable Dictionary 
    type        name        purpose
    Font        largerFont  stores the larger font used to draw string 
		smallerFont stores the smaller font used to draw string
    Color       background  stores the color used for the background 
    
    shows various boolean logic operators moving across the screen 
    */ 
    public void draw ()
    {
	Color background = new Color (240, 194, 194); // declares an initializes a color variable 
	c.setColor (background); // sets the color to the color stored in background 
	c.fillRect (0, 0, 800, 500);//fills a rectangle that covers the entire output screen
	Font largerFont = new Font ("Monospaced", Font.PLAIN, 40); // declares and initializes a font variable 
	Font smallerFont = new Font ("Monospaced", Font.PLAIN, 30);// declares and initializes a font variable 
	for (int i = 0 ; i <= 100 ; i++) // loop 100 times (strings will move 100 pixels from their starting location in various  directions 
	{
	    c.setFont (largerFont); // set the font to the larger font 
	    c.setColor (background); // set the color to the background  - fill the trailing strings to imitate movement 
	    c.drawString ("AND", i - 1, 100); // draw the word within " " at a location that will change with the loop counter variable 
	    c.drawString ("NOT", 200, 450 - i + 1);// draw the word within " " at a location that will change with the loop counter variable 
	    c.setColor (Color.black); // sets the color to black - the strings that appear to be moving will be black 
	    c.drawString ("AND", i, 100);// draw the word within " " at a location that will change with the loop counter variable 
	    c.drawString ("NOT", 200, 450 - i);// draw the word within " " at a location that will change with the loop counter variable 
	    try
	    {
		Thread.sleep (25); // pause 25 ms between each redrawing 
	    }
	    catch (Exception e)
	    {
	    }
	}
	
	for (int i = 0 ; i < 50 ; i++) // loop 50 times (strings will mvoe 50 pixels from their starting location in various directions 
	{
	    c.setFont (smallerFont); // set the font to the smaller font 
	    c.setColor (background);// set the color to the background  - fill the trailing strings to imitate movement 
	    c.drawString ("OR", 601 - i, 100);// draw the word within " " at a location that will change with the loop counter variable 
	     c.drawString ("NOT", 500, 501-i);// draw the word within " " at a location that will change with the loop counter variable 
	     c.drawString ("OR", 300,i-1);// draw the word within " " at a location that will change with the loop counter variable 
	    c.setColor (Color.black); // set the color to black - the strings that appear to be moving will be black 
	    c.setFont (smallerFont);// set the font to the smaller font 
	    c.drawString ("OR", 600 - i, 100);// draw the word within " " at a location that will change with the loop counter variable 
	    c.drawString ("NOT", 500, 500-i);// draw the word within " " at a location that will change with the loop counter variable 
	    c.drawString ("OR", 300,i);// draw the word within " " at a location that will change with the loop counter variable 
	    try
	    {
		Thread.sleep (50);//wait 50 ms between each redrawing 
	    }
	    catch (Exception e)
	    {
	    }
	}
       
    }


    public Move (Console con)  //create Console con
	//splashscreen to display on the same console screen
    {
	c = con;
    }


    public void run ()
    {
	draw ();
    }
}
