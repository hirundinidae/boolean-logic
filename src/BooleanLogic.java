/* Diana Lin
Jan 10 2019
Ms Krasteva
A program that teaches the basics of boolean algebra. There are lessons to teach the beginner concepts of boolean logic. Then, the user has the option to quiz themselves
on their mastery of boolean logic, aided by a bank of at least 50 questions. Each question has 4 possible answers.

Global Variable Dictionary
type    name        description
int     menu        used to control program flow from the menu page. - used in various methods (in mainMenu method and used in main method)
int     gameDiff    used to store the user's desired game difficulty. - used in various methods (in difficulty and in test when taking user input)
		    decides how many chances the user has to get the right answer
int     userScore   stores the user's score after each test done. - used in various methods to calculate user's position on the leaderboard, as well as keeping count of the user's
		    success in answering questions
String  userName    stores the user's name after the test is done - used to save the user in the leaderboard if their score qualifies them for that
Font    fMenu       font variable used for visual purposes - global as the font is mostly the same thoughout the game, allows for setting of font with the same variable (as opposed to
		    several ones for different instances that hold the same font
Color   body        Color variables used to set the color in the game, body is a lighter pink,
	border      border creates deeper pink edges at top and bottom of screen
	text        where text is drawn as a string, this color used to set the color of the text
*/

import hsa.*; // imports all of hsa
import java.awt.*; // imports all of java.awt
import javax.swing.JOptionPane; // to use the error message box
import java.io.*; // imports all of java.io

public class BooleanLogic
{
    //global variables:
    Console c = new Console ("BooLog"); // creates console variable c, assigns the console to it
    int menu;
    int gameDiff = 0;
    int userScore;
    String userName;
    Font fMenu = new Font ("Monospaced", Font.PLAIN, 20);
    Color body = new Color (240, 194, 194);
    Color border = new Color (242, 100, 92);
    Color text = new Color (26, 0, 0);


    /* splashScreen();
    method to display the splashscreen to the user
    Local Variable Dictionary
    type        name        purpose
    Instance    t           connects the title class to this class
		p           connects the popUp class to this class
		m           connects the move class to this class
    joins each class to this class, then starts the animations at different times
    */
    public void splashScreen ()
    {
	Title t = new Title (c); // creates instance
	PopUp p = new PopUp (c); // creates instance
	Move m = new Move (c); // creates instance
	m.start (); // start the Move class
	try
	{
	    Thread.sleep (6000); // wait 6 sec
	}
	catch (Exception e)
	{
	}
	p.start (); // start the popUp class
	try
	{
	    Thread.sleep (1000); // wait 1 second
	}
	catch (Exception e)
	{
	}
	t.start (); // start the title class

	try
	{
	    Thread.sleep (3000); // wait 3 seconds
	}
	catch (Exception e)
	{
	}
	m.stop (); // stop the move class
	p.stop (); // stop the popup class
	t.stop (); // stop the title class
    }


    /* background();
    used to redraw the background behind each new screen
    - more efficient than having the same 7 lines in each method to have a visual background
    clears the background, sets the color to the body color to draw the entire screen as that color
    sets the color to the border color to draw the 2 top and bottom rectangles
    sets the textbackgroundcolor to the same one as the body --> prevents the white line produced with println()
    */
    public void background ()
    { // used to redraw the background 2 end lines, body color
	c.clear (); // clear the screen
	c.setColor (body); // set the color to the body color (light pink)
	c.fillRect (0, 0, 800, 500); // fill a rect that covers the entire output screen
	c.setColor (border); // set the color to the borders 2 top and bottom rectangles
	c.fillRect (0, 0, 800, 50); // fill the rect as the top bar
	c.fillRect (0, 450, 800, 50); // fill the rect as the bottom bar
	c.setTextBackgroundColor (body); // set the textbackgroundcolor to the same as the body
    }


    /* mainMenu();
    shows the menu options to the user
    takes user input to control if the next method called should be instructions, learn, test, or exit
    while(true) loop used for error trapping against user input that is out of range of 1-4, or is not an integer
    */
    public void mainMenu ()
    {
	background (); //call the background method to clear the screen
	c.setColor (text); // set the color to text color
	c.setFont (fMenu); // set the font to fMenu font
	String menuString = ""; // declares and initialises String variable to use for error trapping
	c.drawString ("Menu:", 0, 80); // draw the text within " " at the location x,y
	c.drawString ("1. Instructions ", 0, 150); // draw the text within " " at the location x,y
	c.drawString ("2. Learn", 0, 200); // draw the text within " " at the location x,y
	c.drawString ("3. Test", 0, 250); // draw the text within " " at the location x,y
	c.drawString ("4. Highscores", 0, 300);
	c.drawString ("5. Exit", 0, 350); // draw the text within " " at the location x,y
	c.drawString ("Please select an option: ", 0, 415); // draw the text within " " at the location x,y
	while (true) // continue until the loop is broken out from
	{
	    try
	    {
		c.setCursor (21, 37); // set the cursor to x,y
		c.println (); // draw an empty line (use to erase bad input
		c.setCursor (21, 37); // set the cursor to x,y
		menuString = c.readLine (); // assigns the user input to menuString
		menu = Integer.parseInt (menuString); // try to parse the user input to an integer variable
		if (menu < 1 || menu > 5) // if the integer is not within the range
		{
		    throw new Exception (); // throw an exception

		}
		break; // if this part is reached, break out from the loop
	    }
	    catch (NumberFormatException e)  // catch if the user doesn't input an integer
	    {
		JOptionPane.showMessageDialog (null, "Please enter a valid menu choice.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
	    }
	    catch (Exception e)  // catch if the user's input is out of range
	    {
		JOptionPane.showMessageDialog (null, "Please enter a valid menu choice.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
	    }
	}
    }


    /* instruction();
    displays a brief introduction of the program/game to the user
    returns the user to the main menu after they have completed reading
    */
    public void instruction ()
    {
	// make it appear as though typing : )
	background (); //call the background method to clear the screen
	c.setCursor (4, 1); // set the cursor to x,y
	c.println ("Boolean Logic"); // print this message
	c.println ("\n\nThis is a program designed to help you learn the basics of Boolean Logic. \n\nYou can access informative powerpoints in Learn and test your knowledge in Test. \nAdditionally, you can see how your mastery of boolean measures up with past \nlearners in 'High Scores'!"); //print this message
	c.println ("\n\n\nPress any key to return to the main menu."); // print this message
	c.getChar ();
    }


    /* learn();
    gives the user access to 3 powerpoints they can use to learn the basics of boolean logic.
    asks the user for the powerpoint they would like to see / return to main menu
    if the user chooses a lesson, that "slideshow" is shown to the user.
    slide change is triggered by user input
    the first while(true) loop acts as a main method controlling flow from the learn menu
	second while(true) loop used for error trapping user input for menu items (if not in range 1-4, if not an integer)
    for each menu option, local string variables are used to count the number of lines in the file indicating the number of slides the file has
	each slide (~24 lines) is printed to the user at the end of  each powerpoint, the learnMenu is shown again
    Local Variable Dictionary
    type        name        purpose
    int         lMenu       stores the user inputted desired lesson/ return to the main menu
			    indicate which powerpoint to open/ display
    String      line        used to store the line read from the file - line read from file is printed 24x per "slide"
    int         lineCnt     keeps a count of the number of lines in a file - indicates the number of slides in the file
			    the number of slides calculated from the lineCnt is (int) (double) (lineCnt / 25 + 0.5) + 1
    */
    public void learn ()
    {

	while (true) // continue until the loop is broken out form
	    // mimics main method to keep returning to the learning menu until the user chooses to return to the main menu
	    {
		int lMenu; // declares an integer variable called lMenu
		String lMenuString = ""; // declare and initialise a string variable called lMenuString to use for errortrapping
		background (); // call the background to clear the screen
		c.setCursor (4, 1); // sets the cursor to x,y
		c.println ("Lessons: "); // prints this message
		c.println ("1. What is Boolean Logic?"); // prints this message
		c.println ("2. NOT, AND, OR"); // prints this message
		c.println ("3. Combining Operators"); // prints this message
		c.println ("4. Return to main menu"); // prints this message
		while (true) // continue until this loop is broken out from
		{
		    try
		    {
			c.setCursor (9, 1); // set the cursor to x,y
			c.println (); // print an empty line to erase bad input
			c.setCursor (9, 1); // set the cursor to x,y
			c.print ("Please select an option: "); // prints this message
			lMenuString = c.readLine (); // assigns the user input to the variable lMenuString
			lMenu = Integer.parseInt (lMenuString); // try to parse the user input to an integer variable
			if (lMenu < 1 || lMenu > 4) // if the user input is outside of the range,
			    throw new Exception (); // throw an exception
			break; // if this part of the code is reached, break out of the loop
		    }
		    catch (NumberFormatException e)  // catch if the user doesn't enter an integer
		    {
			JOptionPane.showMessageDialog (null, "Please enter a valid menu choice.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
		    }
		    catch (Exception e)  // if the user's integer is out side of the range, catch the exception
		    {
			JOptionPane.showMessageDialog (null, "Please enter a valid menu choice.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
		    }
		}

		if (lMenu == 1) // if the user chooses the first powerpoint
		{
		    String line = "  "; // declare and initialise a string variable called line
		    int lineCnt = 0; // declare and initlaise an int variable called lineCnt

		    while (true) // continue until the loop is broken out of
		    {
			try
			{
			    BufferedReader reader = new BufferedReader (new FileReader ("WHATISBL.txt")); // try to read from the file WHATISBL.txt
			    while (line != null) // while the line is not null,
			    {
				line = reader.readLine (); // read the line from the file and assign it to the line variable

				lineCnt++; // increase the count of lines
			    }
			    reader.close (); // stop reading from the file
			    break; // if this part of the code is reached, break out of the loop
			}
			catch (IOException e)  // catch exception if the file cannot be read to
			{
			    c.println ("can't");
			}
		    }
		    while (true) // until the loop is broken out of
		    {
			BufferedReader reader; // declare a buffered reader
			try
			{
			    c.clear (); // clear the screen
			    reader = new BufferedReader (new FileReader ("WHATISBL.txt")); // try to read from the WHATISBL.txt file
			    for (int i = 1 ; i <= (int) (double) (lineCnt / 25 + 0.5) + 1 ; i++) // each slide
			    {

				for (int k = 1 ; k <= 24 ; k++) // each line of the slide
				{
				    line = (reader.readLine ()); // assign the line read from the file to the variable line
				    c.setCursor (k, 1); // set the cursor to x,y
				    c.println (line); // print the line
				    c.setCursor (k, 79); // set the cursor to x,y
				    c.print ("|"); // print the end of the slide
				    try
				    {
					Thread.sleep (5); // wait 5 ms between each line drawn
				    }
				    catch (Exception e)
				    {
				    }
				}
				c.getChar (); // get char to continue to the next slide

			    }
			    reader.close (); // when the slides are done
			    c.clear (); // clear the screen
			    c.println (); // enter a blank line
			    c.print (' ', 10); // print 10 blank spaces
			    c.println ("end of powerpoint. press any key to return to lesson menu."); // display this message
			    c.getChar (); // get char to continue to the next line
			    break; // when this part of the code is reached, break out of the loop

			}
			catch (IOException e)  // catch an exception if the file cannot be read from
			{
			    c.println ("can't");
			}
		    }
		}
		if (lMenu == 2) // if the user chooses the second powerpoint
		{
		    String line = "  "; // declare and initialise a string variable called line
		    int lineCnt = 0; // declare and initlaise an int variable called lineCnt
		    while (true) // continue the loop until it is broken out of
		    {
			try
			{
			    BufferedReader reader = new BufferedReader (new FileReader ("NOTANDOR.txt")); // try to read from the file NOTANDOR.txt
			    while (line != null) // while the line is not null
			    {
				line = reader.readLine (); // assign the line read from the file to the line variable
				lineCnt++; // increase the count of lines
			    }
			    reader.close (); // stop reading from the file
			    break; // when this part of the code is reached, break out of the loop
			}
			catch (IOException e)  // catch an exception if the file cannot be read from
			{
			    c.println ("can't");
			}
		    }
		    while (true) // continue until the loop is broken out of
		    {
			BufferedReader reader; // declare a new bufferedreader
			try
			{
			    c.clear (); // clear the screen
			    reader = new BufferedReader (new FileReader ("NOTANDOR.txt")); // try to read from the NOTANDOR.txt file
			    for (int i = 1 ; i <= (int) (double) (lineCnt / 25 + 0.5) + 1 ; i++) // each slide
			    {

				for (int k = 1 ; k <= 24 ; k++) // each line of the slide
				{
				    line = (reader.readLine ()); // assign the line read from the file to the line variable
				    c.setCursor (k, 1); // set the cursor to x,y
				    c.println (line); // print the line
				    c.setCursor (k, 79); // set the cursor to x,y
				    c.print ("|"); //print the end of the slide side
				    try
				    { // wait for 5 ms between each line printed
					Thread.sleep (5);
				    }
				    catch (Exception e)
				    {
				    }
				}
				c.getChar (); // take user input to continue to the next slide

			    }
			    reader.close (); // stop reading from the file
			    c.clear (); // clear the screen
			    c.println (); // print an empty line
			    c.print (' ', 10); //print 10 blank spaces
			    c.println ("end of powerpoint. press any key to return to lesson menu."); // display this message
			    c.getChar (); // takes user input before continuing
			    break; // when this part of the code is reached, break out of the loop

			}
			catch (IOException e)  // catch an exception if the file cannot be read from
			{
			    c.println ("can't");
			}
		    }

		}
		if (lMenu == 3) // if the user choosese the third powerpoint
		{
		    String line = "  "; // declare and initialise a string variable called line
		    int lineCnt = 0; // declare and initlaise an int variable called lineCnt

		    while (true) // continue until the loop is broken out of
		    {
			try
			{
			    BufferedReader reader = new BufferedReader (new FileReader ("COMBINEOP.txt")); //try to read from the file COMBINEOP.txt
			    while (line != null) // while the line is not null,
			    {
				line = reader.readLine (); // assign the line read from the file to the line variable
				lineCnt++; // increment the count of lines
			    }
			    reader.close (); //stop reading from the file
			    break; // when this part of the code is reached, break out of the loop
			}
			catch (IOException e)  //catch an exception if the file cannot be read from
			{
			    c.println ("can't");
			}
		    }

		    while (true) //continue this loop until it is broken out of
		    {
			BufferedReader reader; // declare a bufferedreader
			try
			{
			    c.clear (); // clear the screen
			    reader = new BufferedReader (new FileReader ("COMBINEOP.txt")); // read from the file COMBINEOP.txt
			    for (int i = 0 ; i <= (int) (double) (lineCnt / 25 + 0.5) + 1 ; i++) // each slide
			    {

				for (int k = 1 ; k <= 24 ; k++) // each line of the slide
				{
				    line = (reader.readLine ()); // assign the line read from the file to the line variable
				    c.setCursor (k, 1); // set the cursor to x,y
				    c.println (line); // print the line
				    c.setCursor (k, 79); // set the cursor to x,y
				    c.print ("|"); // print the right edge of the slide
				    try
				    {
					Thread.sleep (5); // wait for 5 ms between each line printed
				    }
				    catch (Exception e)
				    {
				    }
				}
				c.getChar (); // get user input to continue to the next slide

			    }
			    reader.close (); // stop reading from the file
			    c.clear (); // clear the screen
			    c.println (); // enter an empty line
			    c.print (' ', 10); // print 10 blank spaces
			    c.println ("end of powerpoint. press any key to return to lesson menu."); // print this message to the user
			    c.getChar (); // take user input to continue to the next part of code
			    break; // when this part of the code is reached, break out of the loop

			}
			catch (IOException e)  //catch an exception if the file cannot be read to
			{
			    c.println ("can't");
			}
		    }

		}
		else if (lMenu == 4) // if the user chooses to return to the main menu
		{
		    c.println ("Returning to the main menu..."); // display this message to the user
		    for (int i = 1 ; i <= 10 ; i++) // loop 10 times
		    {
			try
			{
			    Thread.sleep (100); // wait for 100 ms
			}
			catch (Exception e)
			{
			}
		    }
		    break; // exit the loop continuing the learn menu
		}
	    } //this method is now finshed running
    }


    /* difficulty();
    stores the user input for desired difficulty of the test
    Local Variable Dictionary
    type        name             purpose
    String      gameDiffString   error trapping purposes - is later parsed to an integer, if the user input is not an integer, NumberFormatException is thrown
				 prevents string input when integer is needed
    */
    public void difficulty ()
    {
	background (); //call the background method to clear the screen
	String gameDiffString = ""; // declare a string variable named gameDiffString to use for error trapping
	c.setCursor (4, 15); // set the cursor to x,y
	c.println ("It's time to test your mastery of boolean algebra!"); // display this message to the user
	c.setCursor (7, 1); // set the cursor to x,y
	c.println ("Game Modes: "); // display this message to the user
	c.setCursor (9, 1); // set the cursor to x,y
	c.println ("1.Beginner (you have 3 chances to get the right answer)"); // display this message to the user
	c.setCursor (11, 1); // set the cursor to x,y
	c.println ("2.Expert (no extra chances to get the right answer)"); // display this message to the user
	c.setCursor (15, 1);
	c.println ("At any time during the quiz, enter 'e' to restart");
	while (true)
	{
	    try
	    {
		c.setCursor (13, 1); // set the cursor to x,y
		c.println (); // print an empty line to erase bad input
		c.setCursor (13, 1); // set the cursor to x,y
		c.print ("Please select a game difficulty: "); // display this message to the user

		gameDiffString = c.readLine (); // assign the user input to the variable gameDiffString
		gameDiff = Integer.parseInt (gameDiffString);  // try to parse the user input to an int variable
		if (gameDiff < 1 || gameDiff > 2) // if the user input is not in the range
		    throw new Exception (); // throw an exception
		break;
	    }
	    catch (NumberFormatException e)  // catch an exception if the user doesn't enter an integer
	    {
		JOptionPane.showMessageDialog (null, "Please enter a valid game difficulty.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
	    }
	    catch (Exception e)  // catch an exception if the user's input is not within the range
	    {
		JOptionPane.showMessageDialog (null, "Please enter a valid game difficulty.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
	    }
	}


    }


    /* test();
    tests the user on their knowledge of boolean logic
    retrieves questions, the correct answer, the available answers to choose from and stores the user's guess, 10 times (10 questions in test)
    at the end, displays the user's success at the test
    Local Variable Dictionary
    type        name        purpose
    int         tries       used to count the number of tries the user has left to get the right answer
			    changes based on the game difficulty - if beginner is selected, user has 3 tries for each question
								    if expert is selected, user has 1 try for each question
    int []      lineNum     used to store the 10 lines (questions) chosen for the 10 question quiz.
			    lines chosen are stored in an array to ensure that a line is not chosen twice
    String[]    question    used to store the 10 questions located at the lineNum line in the questions.txt file
			    stored in array to compare the current question in the test (index's) question to the answer
		attempt     used to store the user's guess for each of the 10 questions
			    stored in array to compare the user's current attempt to the current question
		answers     stores the 4 options the user can choose from
			    stored in array to allow for randomization of which option the possible answers are displayed in (mixing up a), b), c), d))
    String      correctAns  stores the correct answer (the first line in each set of 4)
    int         answersRead keeps count of the number of answers read from the file (if the randomAnswer chooses the same number, loop will continue until 4 answers have been read or the answers array has been filled)
		randomAnswer    randomly chooses an index in the answers array to store the line read from the file
				allows for randomization of location of the correct answer in the available options

    Firstly, a question is chosen with lineNum selecting a random number, each corresponding to a question. The question is stored at the i th index in the question array
    Then, the correct answer from the answers.txt file is stored in the correctAns string.
    Next, the possible answers are randomly assigned to an index in the answers array
    The question and the 4 options are displayed to the user. They will choose a,b,c or d as their answer. Depending on the game difficulty they chose, they may have additional chances to attempt the question
    The above 4 lines are repeated 9 more times for a total of 10 questions in the test
    After the test has run, the user is prompted to enter a name to save their score in the leaderboard
    */
    public void test ()
    {
	int tries; // declares int variable tries to keep track of how many chances the user has left to guess the right answer
	userScore = 0; // resets the user score
	int[] lineNum = new int [10]; //store each line question, make sure that the line has not been chosen before
	background ();
	try
	{
	    String line; // use to store the line read from the file
	    BufferedReader reader = new BufferedReader (new FileReader ("Example.txt"));
	    for (int i = 1 ; i <= 18 ; i++)
	    {
		c.setCursor (i + 3, 1);
		line = (reader.readLine ());
		c.println (line);
		c.setCursor (22, 1);
		c.println ("Press any key to continue, or press 's' to skip this example.");
		if (c.getChar () == 's')
		    i = 18;
	    }
	}
	catch (IOException e)
	{
	}

	try
	{
	    background ();
	    c.setCursor (4, 1);
	    c.println ("Ready to start your quiz? Press any key to begin testing");
	    c.getChar ();
	    c.println ("\nStarting test...");
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}

	for (int i = 0 ; i < 10 ; i++) //10 times for 10 questions
	{

	    String[] question = new String [10]; // prevent lineNum from choosing the same number twice
	    String[] attempt = new String [10]; // stores the user inputted attempt to answer the question
	    String[] answers = new String [4]; // stores the possible answers
	    String correctAns = ""; //used to store the correct answer to the current question

	    try
	    {
		BufferedReader reader = new BufferedReader (new FileReader ("questions.txt")); // creates a buffered reader to read from the questions file
		lineNum [i] = (int) (Math.random () * 50); // randomly selects a line (1-50) to choose from
		for (int k = 0 ; k < 10 ; k++) // loop 10 times
		{
		    if (k != i) // check all the indices except the current one (that would always be equal)
		    {
			while (lineNum [i] == lineNum [k]) // if the current line chosen is equal to another
			{
			    lineNum [i] = (int) (Math.random () * 50); // randomly selects a line (1-50) to choose from
			    //^ randomly select a line
			}
		    }
		}
		for (int k = 1 ; k < lineNum [i] ; k++) // until the line before it, read empty lines
		{
		    reader.readLine (); // don't assign to anything
		}

		question [i] = reader.readLine (); // assign the lineNumth line to the index in the array
		reader.close (); // close the reader
	    }
	    catch (IOException e)  // catch an exception if the file cannot be read from
	    {
	    }

	    try // retrieve the correct answer and store it
	    {
		BufferedReader reader = new BufferedReader (new FileReader ("answers.txt")); // creates a buffered reader to read from the answers file
		for (int k = 1 ; k <= (lineNum [i] - 1) * 4 ; k++) // until the 4 * lineNum before the desired answers,
		{
		    reader.readLine (); // do nothing to the line read from the file
		}
		correctAns = reader.readLine (); // store the correct answer in this variable
		reader.close ();
		//randomize the index it is assigned to
	    }
	    catch (Exception e)  // catch an exception if the file cannot be read from
	    {
	    }

	    try
	    { // randomly assign the answer options to the array
		BufferedReader reader = new BufferedReader (new FileReader ("answers.txt")); // declares a bufferedreader to read from the file answers.txt
		int answersRead = 0; // used to keep track of how many answers have been read from the file
		int randomAnswer = 0; // used to randomly choose an index in the answers array to assign the line read from the file to
		for (int k = 1 ; k <= (lineNum [i] - 1) * 4 ; k++) // until the 4 * lineNum before the desired answers,
		{
		    reader.readLine (); // do nothing to the line read from the file
		}
		while (true) // continue until the loop is broken out of
		{
		    randomAnswer = (int) (Math.random () * 4); // randomly choose an index to store the line read from the file
		    if (answers [randomAnswer] == null) // only write if that index doesn't already have an answer
		    {
			answers [randomAnswer] = reader.readLine (); // store the line read from the file in the index in the array
			answersRead++; // increment the number of answers that have been read
		    }
		    if (answersRead == 4) // when all 4 answers that correspond to the question have been read,
		    {
			break; // exit the loop
		    }
		}
		reader.close (); // close the reader
	    }
	    catch (IOException e)  // catch an exception if the file cannot be read to
	    {
		c.println ("error");
	    }
	    // displaying the question, answers, taking user input
	    background (); // calls the background method to clear the screen
	    c.setCursor (5, 1); // set the cursor to x,y
	    if (lineNum [i] > 50) // if the question type is of guess the input
	    {
		c.println ("Guess the input: "); // instruct the user to guess the input
	    }
	    else
	    { // otherwise the question type is true/false
		c.println ("Evaluate how true the statement is: "); // instruct the user to evaluate the accuracy of the statement
	    }
	    c.setCursor (8, (78 - (question [i].length ())) / 2); // set the cursor to here
	    c.println (question [i]); //  print the question
	    c.setCursor (14, 1); // set the cursor to x,y
	    c.print ("a) " + answers [0]); // print the first option
	    c.setCursor (14, 40); // set the cursor to x,y
	    c.print ("b) " + answers [1]); // print the second option
	    c.setCursor (16, 1); //set the cursor x,y
	    c.print ("c) " + answers [2]); // print the third option
	    c.setCursor (16, 40); //set the cursor to x,y
	    c.print ("d) " + answers [3]); // prin the fourth option
	    if (gameDiff == 1) // if the user chose beginner
		tries = 3; // give them 3 tires
	    else
		tries = 1; // otherwise they hvae 1 try per questoin
	    while (tries != 0) // while the user still has tries
	    {
		while (true) // continue the loop until it is broken out of
		{
		    try
		    {
			c.setCursor (20, 1); // set the cursor to x,y
			c.print (' ', 80); // print an empty line to erase bad input
			c.setCursor (20, 1); // set the cursor to x,y
			c.print ("Please choose an option: "); // print this message to the user
			attempt [i] = c.readString (); // assign the user input to the attempt for the current question

			if (attempt [i].equalsIgnoreCase ("a") || attempt [i].equalsIgnoreCase ("b") || attempt [i].equalsIgnoreCase ("c") || attempt [i].equalsIgnoreCase ("d") || attempt [i].equalsIgnoreCase ("e"))
			    break; // if the user input is accepted as a,b,c or d, exit the loop
			else // otherwise throw a new exception
			    throw new Exception ();
		    }
		    catch (Exception e)  // catch the exception for invalid answers
		    {
			JOptionPane.showMessageDialog (null, "Please enter a valid answer.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
		    }

		}
		if (attempt [i].equalsIgnoreCase ("e"))
		{
		    tries = 0;
		    i = 10;
		    c.println ("Exiting the test...");
		    try
		    {
			Thread.sleep (1000);
		    }
		    catch (Exception e)
		    {
		    }
		    menu = 6; // indicate to reset game - game mode is restart game
		    break;
		}
		else if (answers [(int) (attempt [i].charAt (0) - 97)].equals (correctAns)) // if the user's attempt is equal to the answer,
		{
		    c.println ("Correct!"); // let them know they are correct
		    userScore++;  // increment their score
		    try
		    {
			Thread.sleep (1000); // pauses for 1 second , then goes to next question
		    }
		    catch (Exception e)
		    {
		    }
		    break;

		}
		else // if the user's answer is not equal to the correct answer,
		{
		    c.print ("Sorry, that is incorrect. "); //let them know they are incorrect
		    tries--; // decrement the number of tries the user has left
		    if (gameDiff == 1) // if the user chose beginner, let them know how many tries they have left
			c.print ("You have " + tries + " chance(s) left."); // display this message
		    if (tries == 0) // if the user has no tries left
		    { //only when the user has no tries left (this question is wrong, moving onto next one)
			try
			{
			    Thread.sleep (1000); // pauses, then goes to next question
			}
			catch (Exception e)
			{
			}
		    }
		}
	    }
	}
	if (menu != 6)
	{

	    while (true) // continue the loop until it is broken out of
	    {
		try
		{
		    background (); // call the background method to clear the screen
		    c.setCursor (4, 1); // set the cursor to x,y
		    c.println ("You scored : " + userScore + " out of 10 questions "); // print this message to the user

		    c.setCursor (6, 1); //set the cursor to x,y
		    c.print ("Please enter your name to save your score (Limited to 8 characters) : "); // print this message
		    userName = c.readString (); // assign the user input to the userName variable
		    if (userName.length () > 8) // if the length of the user input exceeds the length
			throw new Exception (); // throw a new exception
		    break; // if this part of the code is reached, break out of the loop
		}
		catch (Exception e)  // catch an exception if the user name isn ot valid
		{
		    JOptionPane.showMessageDialog (null, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
		}

	    }
	}
	menu = 6;
	/* c.setCursor (8, 1); // set the cursor to x,y
	  c.println ("Loading the leaderboard..."); // print this message to the user
	  try
	  {
	      Thread.sleep (2000); // wait 2 seconds before continuing
	  }
	  catch (Exception e)
	  {
	  }
	  */

    }


    /* private return method
    calculates the user's standings on the leaderboard, returns the leaderboard as an array
    Local Variable Dictionary
    type        name        purpose
    String[][]  readArray   reads the lines in the file, assigns it to a 2d array organized as a table.
			    "reads the leaderboard from the file"
		writeArray  based on the userScore, will "copy" some or all of the same values from the readArray
			    "writes the updated leaderboard to the file"
    int         place       used to store the calcualted position of the user's score on the leaderboard (if the user is 1st, 2nd, etc)
			    when the place is equal to 0, the user did not make it onto the leaderboard
    Firstly, the leaderboard is read from the HiScores.txt file and stored in the readArray array
    Then, the user's position on the leaderboard is calculated by when the score is still larger than the 2 column of each row in the array
    If the user's place isn't 0 ( didn't make the leaderboard ), everything from the 1st to place th scores is the same from the readArray to the writeArray
    the place th row in the writeArray will be assigned the user's name, score and chosen difficulty
    then, the remaining rows in the writeArray are filled with the remaining rows of the readArray
	for example, if the user's score qualifies them for the 4th position on the leaderboard, the first 3 rows from the readArray are assigned to the first 3 rows of the writeArray
	then, the 4th row of the writeArray is assigned the user's name, score and difficulty.
	the remaining 6 rows in the writeArray is assigned the next 6 rows of the readArray (readArray[4] is writeArray[5], etc)
	this leads to every row past 4th to be "pushed down" 1 row
    The writeArray is written to the HiScores.txt file as the updated leaderboard
    The writeArray is returned
    */
    private String[] [] calculateHiScore (int userScore, String userName, int gameDiff, boolean clear)
    {
	String[] [] readArray = new String [11] [3]; // declares and dimensions array to read the leaderboard from the file
	String[] [] writeArray = new String [11] [3]; // declares and dimensions array to update the leaderboard
	int place = 0; // used to store the position of the current userScore, name and difficulty on the leaderboard
	try
	{
	    BufferedReader reader = new BufferedReader (new FileReader ("HiScores.txt")); // declare a bufferedreader that tries to read from the HiScores.txt file
	    for (int i = 0 ; i < 10 ; i++) // loop for each of the 10 rows
	    {
		for (int k = 0 ; k < 3 ; k++) // loop for each of the 3 columns in each row
		{
		    readArray [i] [k] = reader.readLine (); // read the leaderboard's contents from the file, assigning it to the appropriate index in the 2d array

		}
	    }
	    reader.close (); // close the reader
	}
	catch (IOException e)  // catch an exception if the file cannot be read from
	{
	    c.println ("can't open file");
	}
	if (clear == true)
	{
	    for (int i = 0 ; i < 10 ; i++)
	    {
		for (int k = 0 ; k < 3 ; k++)
		{
		    writeArray [i] [k] = "0";
		}
	    }
	}
	else
	{
	    //vv calculating the new leaderboard & writing it to a new array
	    for (int i = 9 ; i >= 0 ; i--) // looping from the lowest to highest scores
	    {
		if (userScore > Integer.parseInt (readArray [i] [1])) // if the userscore is better than the ith score
		{
		    place = i + 1; // the userscore is placeth place on the leaderboard
		}
	    }

	    if (place == 0) // if the user is not in the top 10
		writeArray = readArray;  // the leaderboard stays the same

	    else // otherwise (when the user makes the leaderboard, it must be updated)
	    {
		for (int i = 0 ; i < place ; i++) // for the positions ahead of the userscore's place,
		{
		    for (int k = 0 ; k < 3 ; k++) // loop through each of the 3 columns of each row
		    {
			writeArray [i] [k] = readArray [i] [k]; // the value is the same in writeArray as readArray
		    }
		}
		writeArray [place - 1] [0] = userName; // assign the username to the place-1th row's first column
		writeArray [place - 1] [1] = String.valueOf (userScore); // assign the user's score to the place-1th row's
		if (gameDiff == 1) // if the uesr's difficulty is beginner
		    writeArray [place - 1] [2] = "Beginner"; //set the user's difficulty to beginner
		else // otherwise the difficulty is expert
		    writeArray [place - 1] [2] = "Expert"; // set the user's difficulty to expert
		for (int i = place ; i < 10 ; i++) // for the rest of the rows
		{
		    for (int k = 0 ; k < 3 ; k++) // for each column in the remaining rows
		    {
			writeArray [i] [k] = readArray [i - 1] [k]; // assign the previous row of readArray to the current row of writeArray
		    }
		}
	    }
	}
	try
	{
	    PrintWriter writer = new PrintWriter (new FileWriter ("HiScores.txt")); // declare a printwriter and try to write to the file HiScores.txt
	    for (int i = 0 ; i < 10 ; i++) // for each of the 10 rows
	    {
		for (int k = 0 ; k < 3 ; k++) // for each of the 3 columns in each row
		{
		    writer.println (writeArray [i] [k]); // write the value to the file
		}
	    }
	    writer.close (); // close the printWriter
	}
	catch (IOException e)  // catch an exception if the file cannot be written to
	{
	    c.println ("can't write to file");
	}

	return writeArray; // return writeArray (updated leaderboard)
    }


    /* highscores();
    displays the leaderboard to the user
    returns to the main menu after leaderboard is viewed
    Local Variable Dictionary
    type        name            purpose
    String [][] displayArray    used to store the writeArray returned by the private return method that updates the leaderboard

    headers are displayed, then each row is printed after the row number
    user is prompted to press any key to return to the main menu
    */
    public void highscores ()
    {
	int hMenu;  // if the user wants to clear the score board or return to the main menu
	String hMenuString; // used to error trap against non integer input
	boolean clear = false;
	while (true)
	{
	    background (); // call the background method to clear the screen
	    String[] [] displayArray = new String [10] [3]; // declare and dimension an array used to display the leaderboard to the user
	    displayArray = calculateHiScore (userScore, userName, gameDiff, clear); // assign the returned array from the private return method to the displayArray
	    userScore = 0;
	    c.setCursor (4, 35); // set the cursor to x,y
	    c.println ("Leaderboard"); // print this message
	    c.setCursor (6, 10); // set the cursor to x,y
	    c.print ("Name"); // print this message
	    c.setCursor (6, 35); // set the cursor to x,y
	    c.print ("Score"); // print this message
	    c.setCursor (6, 50); // set the cursor to x,y
	    c.print ("Difficulty");  // print this message
	    for (int i = 0 ; i < 10 ; i++) //loop 10 times, for each row of the leaderboard
	    {
		c.setCursor (7 + i, 10); // set the cursor to x,y
		c.print (i + 1 + "."); // print the row number
		if (!displayArray [i] [2].equals ("0"))
		{
		    c.print (displayArray [i] [0]); // print the first column of the ith row of the displayArray
		    c.setCursor (7 + i, 35); // set the cursor to x,y
		    c.print (displayArray [i] [1]); // print the second column of the ith row of the displayArray
		    c.setCursor (7 + i, 50); // set the cursor to x,y
		    c.print (displayArray [i] [2]); // print the third column of the ith row of the displayArray
		}
	    }
	    while (true)
	    {
		try
		{
		    c.setCursor (20, 1); // set the cursor to x,y
		    c.println (); // print an empty line to erase bad input
		    c.println(); 
		    c.println(); 
		    c.setCursor (20, 1);
			c.println ("Press 1 to clear the leaderboard."); // display this message
		    c.println ("Press 2 to return to the main menu.");
		    c.print("Please enter your choice: ");
		    hMenuString = c.readLine ();
		    hMenu = Integer.parseInt (hMenuString);
		    if (hMenu < 1 || hMenu > 2)
			throw new Exception ();
			break; // if this part of the code is reached, exit the loop 
		}
		catch (NumberFormatException e)
		{
		 JOptionPane.showMessageDialog (null, "Please enter a valid choice.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
		}
		catch (Exception e)
		{
		 JOptionPane.showMessageDialog (null, "Please enter a valid choice.", "Error", JOptionPane.ERROR_MESSAGE); // display this error message
		}
		}
  
		if (hMenu == 2)
		    break;
		else{
		background();
		c.setCursor(4,1);
		c.println("Clearing the scoreboard..."); 
		try { 
		Thread.sleep(1000); 
		} 
		catch(Exception e) {}
		    calculateHiScore (userScore, userName, gameDiff, true);
		}
	    }
	}


	/* exit();
	displays a goodbye message to the user before closing the output window
	redraws the background, then displays a message to the user
	after 5 seconds, c.close(); runs and the console window is closed
	*/
	public void exit ()
	{
	    background ();
	    c.setColor(Color.black);// sets the color to black 
	    c.drawString ("Thank you for using the", 175, 100); //draw this string at x,y
	    c.drawString ("BooLog program to learn", 175, 200); // draw this string at x,y
	    c.drawString ("Boolean Algebra!", 215, 300); // draw this string at x,y
	    c.drawString ("See you soon!", 225, 400); // draw this string at x,y
	    for (int i = 1 ; i <= 10 ; i++) //loop 10 times
	    {
		try
		{
		    Thread.sleep (500); // wait 500 ms 10 times
		}
		catch (Exception e)
		{
		}

	    }
	    c.close (); // close the output window
	}


	/* main method
	*/
	public static void main (String[] args)
	{
	    BooleanLogic bl = new BooleanLogic (); // creates instance
	    //bl.splashScreen (); // calls the splashscreen

	    while (true) // continue until the loop is broken from
	    {
		bl.mainMenu (); // call the main menu (every time)
		if (bl.menu == 1) // if the user chooses 1,
		{
		    bl.instruction (); // call the introduction method
		}
		else if (bl.menu == 2) // if the user chooses 2,
		{
		    bl.learn (); //calls the learn method
		}
		else if (bl.menu == 3) // if the user chooses 3,
		{ // starts the test sequence
		    bl.difficulty (); // asks the user for their desired difficulty
		    bl.test (); // tests the user
		    //bl.highscores (); // displays the leaderboard to the user
		}
		else if (bl.menu == 4)
		{
		    bl.highscores (); // show the scoreboard separately
		}
		else // otherwise, the user has chosen 4, exit
		{
		    break; // break out of this loop
		}
	    }
	    bl.exit (); // calls the exit method


	}
    }



