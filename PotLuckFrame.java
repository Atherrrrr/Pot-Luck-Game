import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Frame for Pot Luck GUI
*/
public class PotLuckFrame extends JFrame{
   
    // Properties
    private static final long serialVersionUID = 2L;
   
    private JLabel resultLabel;
    private JButton[][] buttons;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    
    private int prizeIndex;
    private int bomb1Index;
    private int bomb2Index;
    private int attempts; 

    // Constructors
    public PotLuckFrame(){
        attempts = 0;
        createComponents();
    }    

    // Methods
    
    /**
     * Disables regular buttons and increments attempts
     */
    class DisableButton implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JButton b = (JButton )event.getSource();
            b.setEnabled(false);
            attempts ++;
            resultLabel.setText("Current Number of Attempts " + attempts);
            
        }
    }

    /**
     * Displays prompt for losing the game
     */
    class PrizeDisplay implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            endDisplay();         
            resultLabel.setText("Sorry! you are blown up at attempt " + attempts + " !");
        }
    }

    /**
     * Displays prompt for winning the game
     */
    class BombDisplay implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            endDisplay();
            resultLabel.setText("You got it in " + attempts + " attempts");
        }
    }

    /**
     * Reveals the prize and bomb buttons
     */
    private void endDisplay(){

        //Reveals the Star on the prize buttons
        ((PrizeButton) buttons[( prizeIndex - 1)/5 ][(( prizeIndex - 1 ) % 5)]).reveal();

        //Reveals the Bomb on the bomb buttons
        ((BombButton) buttons[( bomb1Index - 1)/5 ][(( bomb1Index - 1 ) % 5)]).reveal();
        ((BombButton) buttons[( bomb2Index - 1)/5 ][(( bomb2Index - 1 ) % 5)]).reveal();

        mainPanel.repaint();
    }    

    private void createComponents(){

        buttons = new JButton[5][5];
        buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new GridLayout(0,5));

        //Randomly assigning button index to each bomb and prize button
        prizeIndex = (int) (Math.random() * 25) + 1;
        bomb1Index = (int) (Math.random() * 25) + 1;
        bomb2Index = (int) (Math.random() * 25) + 1;

        //Ensuring that the bomb and prize Buttons are unique
        while (prizeIndex == bomb1Index || prizeIndex == bomb2Index || bomb2Index == bomb1Index){
            bomb1Index = (int) (Math.random() * 25) + 1;
            bomb2Index = (int) (Math.random() * 25) + 1;
        }

        int index;
        index = 1;
        // Initialing the button matrix
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (index == prizeIndex) {
                    buttons[i][j] = new PrizeButton(prizeIndex);
                    buttons[i][j].addActionListener(new BombDisplay());
                }
                else if (index == bomb1Index || index == bomb2Index) {
                    buttons[i][j] = new BombButton("" + index);
                    buttons[i][j].addActionListener(new PrizeDisplay());
                }
                else{
                    buttons[i][j] = new JButton("" + index);
                    buttons[i][j].addActionListener(new DisableButton());
                    
                }                
                buttons[i][j].setBackground(Color.WHITE);
                buttonPanel.add(buttons[i][j]);
                index++;
            }
        }       
        mainPanel = new JPanel();
        resultLabel = new JLabel("Welcome");

        mainPanel.setLayout(new BorderLayout());

        //Adding buttonPanel and resultPanel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(resultLabel, BorderLayout.SOUTH);      
        
        add(mainPanel);        

        setSize(500, 500);
    }

}