import javax.swing.JButton;
import java.awt.*;
/**
 * Bomb Buttom implementation
 * @author Maher Athar Ilyas
 * @version 30.03.2021
*/
public class BombButton extends JButton
{

    // Properties
    private static final long serialVersionUID = 1L;
    
    private boolean reveal; //reveal bomb or not

    // Constructors
    public BombButton (String text){
        setText(text);
        reveal = false;
    }

     // Methods
    public void paintComponent(Graphics g) {       

        super.paintComponent(g);

        //Only display bomb after reveal() is called
        if (reveal){
            Graphics2D g2 = (Graphics2D) g;        

            Dimension buttonSize = getSize();
            int height = (int) Math.round(buttonSize.getHeight()); 
            int width = (int) Math.round(buttonSize.getWidth());         
    
            //Calculating Circle properties 
            int radius = Math.min(height, width); 
    
            radius = (int) (radius * 0.6); 
    
            int ovalStartY = (height-radius)/2; 
            int ovalStartX = (width-radius)/2;
    
            //Drawing rectangle
            int rectangleStartX = (ovalStartX + radius/4);
    
            g2.setColor(Color.gray);
            g2.fillRect(rectangleStartX, ovalStartY, radius/2, radius/4);
    
            //Drawing arc 
            g2.setColor(Color.BLACK);
            g2.fillOval(ovalStartX, ovalStartY + 5, radius, radius);
            
            //Drawing Oval
            g2.setColor(Color.RED);
            g.drawArc((rectangleStartX + radius/4), ovalStartY - radius/4, radius/2, radius/2, 180, -100);
        }
    }

    /**
     * Set instance property reveal = true
     */
    public void reveal(){
        reveal = true;
    }
   
    
}