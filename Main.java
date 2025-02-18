import java.awt.event.*;
import javax.swing.*;

/*! \file
The Main class is responsible for setting up the main display window, registering the proper PacmanKeyboard objects to recieve keyboard input, and starting the timer that cues the GraphicsPanel object (or objects, in two-player mode) to update their internal game state and redraw their graphics every 17 milliseconds.
*/

class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1"); //Must be done BEFORE everything else or it won't work!

        boolean singlePlayer = JOptionPane.showOptionDialog(null, "How many players?", "Mode Select", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"1 Player", "2 Players"}, 0) == 0;

        JFrame frame = new JFrame("Pac-Man (beta)");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        layout.setHorizontalGroup(hGroup);
        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup();
        layout.setVerticalGroup(vGroup);

        final GraphicsPanel gp1, gp2;

        if(singlePlayer){
            PacmanKeyboard kbl = new KeyboardBothListener(frame);
            gp1 = new GraphicsPanel(kbl);
            gp2 = null;
            hGroup.addComponent(gp1);
            vGroup.addComponent(gp1);
        } else {
            PacmanKeyboard kb1 = new KeyboardLettersListener(frame);
            PacmanKeyboard kb2 = new KeyboardArrowsListener(frame);
            gp1 = new GraphicsPanel(kb1);
            gp2 = new GraphicsPanel(kb2);
            hGroup.addComponent(gp1);
            vGroup.addComponent(gp1);
            hGroup.addComponent(gp2);
            vGroup.addComponent(gp2);
        }

        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final ActionListener al;
        if(singlePlayer){
            al = new ActionListener() {
                public void actionPerformed(ActionEvent evt){
                    gp1.updateState();
                    gp1.repaint();
                }
            };
        } else {
            al = new ActionListener() {
                public void actionPerformed(ActionEvent evt){
                    gp1.updateState();
                    gp2.updateState();
                    gp1.repaint();
                    gp2.repaint();
                }
            };
        }

        Timer t = new Timer(17, al); // The number 17 is used because 1000 / 60 ≈ 17
        t.setRepeats(true);
        t.start();
    }
}