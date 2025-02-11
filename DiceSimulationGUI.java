import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.BorderLayout; 
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;

public class DiceSimulationGUI extends JPanel
{
    public DiceSimulationGUI()                       // set up graphics window
    {
        super();
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);            // call superclass to make panel display correctly
        g.setColor(Color.WHITE);
        //output a message at top of screen (x = 50, y = 50)
        g.drawString("Dice Simulation.  How many times does it take to roll doubles on average?", 50, 50);

        //initialize the following variables, r1=0, r2=1, counter, startX = 70, startY = 70
        int r1 = 0;
        int r2 = 2;
        int startX = 70;
        int startY = 70;
        int counter = 0;

        //create a while loop that checks that r1 and r2 are not equal
        while (r1 != r2) {
        // get two random numbers and assign it to r1 and r2
        r1 = getRandomNumber();
        r2 = getRandomNumber();
        

        // do this last -- if counter = 10 assign startX=300, startY = 70; moves to new column and back to top.  Do the same for 20 and 30.
        if (counter == 7) {
            startX = 300;
            startY = 70;
        }
        if (counter == 14) {
            startX = 500;
            startY = 70;
        }

        if (counter == 21) {
            startX = 700;
            startY = 70;
        }

        // call showDie method sending Graphics object, the die filename "die" + r1 + ".jpg", the value (1-6), x, y
        showDie(g, "dice/die" + r1 + ".jpg", startX, startY);
        showDie(g, "dice/die" + r2 + ".jpg",startX+75, startY);
        //increment the startY value by 75 (moves down 75 if it's not equal)
        startY+=75;
        //increment counter by 1
        counter ++;
        }
        // draw a message on screen that outputs "Total times: " + counter.
        g.drawString("Total times: " + counter, startX, startY + 50);
        
    }

    public static void showDie(Graphics g, String fn, int x, int y) {

        // method locads the filename (fn) and draws it at x, y
        try {
            BufferedImage img = ImageIO.read(new File(fn));
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            g.drawImage(img, x, y, null);
 
        } catch (IOException e) {
            System.out.println("Image could not be read");

        }
    }

    public static int getRandomNumber() {
       return (int) Math.floor(Math.random() * 6);
    }

    public static void main(String[] args)
    {
        DiceSimulationGUI panel = new DiceSimulationGUI();
        JFrame application = new JFrame();                            // the program itself
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
                                                                      // when it is closed
        application.add(panel);           

        application.setSize(1000, 1000);         // window is 500 pixels wide, 400 high
        application.setVisible(true);          
    }
    
    

}
