import java.util.Scanner;
import javax.swing.JFrame;

/**
 * App that allows Number Conversions between, hex, binary and decimal
 * @author Maher Athar Ilyas
 * @version 30.03.2021
*/ 
public class PotLuckGame
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Constants
        
        // Variables
        JFrame frame;

        // Program Code
        frame = new PotLuckFrame();    
        
        frame.setTitle("Pot Luck Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        scan.close();
    }
    
}