/* Diana Lin
Jan 10 2019
Ms Krasteva
A program that teaches the basics of boolean algebra. There are lessons to teach the beginner concepts of boolean logic. Then, the user has the option to quiz themselves 
on their mastery of boolean logic, aided by a bank of at least 50 questions. Each question has 4 possible answers. 
*/
import hsa.Console; // imports the console
import java.awt.*; // imports all of java.awt
import java.lang.*; // imports all of java.lang - allows for use of threads

public class PopUp extends Thread
{
    private Console c; // declares a private console c - private to avoid interacting with other classes

    /*draw();
    used to draw an animation on the output window
    Local Variable Dictionary
    type        name        purpose
    Font        notFont     stores the font used to draw "NOT"
		andFont     stores the font used to draw "AND"
		orFont      stores the font used to draw "OR"

    shows various boolean logic operators appearing onto the screen
    */
    public void draw ()
    {
	Font notFont = new Font ("Monospaced", Font.PLAIN, 40); // declares and initializes a font variable
	Font andFont = new Font ("Monospaced", Font.PLAIN, 50); // declares and initializes a font variable
	Font orFont = new Font ("Monospaced", Font.PLAIN, 35); // declares and initializes a font variable
	for (int i = 1 ; i <= 100 ; i++) // loop 100 times transparency increases to 100 
	{
	    c.setColor (new Color (0, 0, 0, i)); // sets the color black with transparency i  
	    c.setFont (notFont); // sets the font to notFont
	    c.drawString ("NOT", 400, 100); // draw the word within " " at a location
	    c.setFont (andFont); // sets the font to andFont
	    c.drawString ("AND", 350, 475);// draw the word within " " at a location
	    c.setFont (orFont); // sets the font to orFont
	    c.drawString ("OR", 100, 300);// draw the word within " " at a location
	    try
	    {
		Thread.sleep (50); // waits 50 ms after each drawing
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public PopUp (Console con)  //create Console con
	//splashscreen to display on the same console screen
    {
	c = con;
    }


    public void run ()
    {
	draw ();
    }
}
