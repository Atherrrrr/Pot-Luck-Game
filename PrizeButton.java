import javax.swing.JButton;
import java.awt.*;
/**
 * Implementation of Button for Prize
 * @author Maher Athar Ilyas
 * @version 30.03.2021
*/
public class PrizeButton extends JButton
{

    // Properties
    private static final long serialVersionUID = 1L;

    private boolean reveal; //reveal bomb or not

    // Constructors
    public PrizeButton(int index){
        setText("" + index);
        reveal = false;
    }

    // Methods

    /**
     * Calculates Star's Fontsize According to button size
     * @return fontsize for the Star
     */
    public int getFontSize(){
        Dimension buttonSize = getSize();
        int size = (int) Math.round(buttonSize.getHeight());
        size = (int) (size * 0.75);
        repaint();
        return size;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        //Only display Star after reveal() is called
        if (reveal) {
            setText("★");
            setForeground(Color.ORANGE);
            setFont(new Font(getFont().getName(),getFont().getStyle(), getFontSize()));
        }
    }

    /**
    * Set instance property reveal = true
    */
    public void reveal(){
        reveal = true;
    }
    
}