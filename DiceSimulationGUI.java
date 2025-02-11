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
      
        super.paintComponent(g);            // call superclass to make panel display correctly
        g.setColor(Color.WHITE);
        //output a message at top of screen (x = 50, y = 50)
        g.drawString("Dice Simulation.  How many times does it take to roll doubles on average?", 50, 50);

        //initialize the following variables, r1=0, r2=1, counter, startX = 70, startY = 70
        int r1 = 0;
       
        r1 = getRandomNumber();
        
        // call showDie method sending Graphics object, the die filename "die" + r1 + ".jpg", the value (1-6), x, y
        showDie(g, "dice/die" + r1 + ".jpg", startX, startY);
        //increment the startY value by 75 (moves down 75 if it's not equal)
       
        g.drawString("You rolled a : " + (r1+1));
        
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
