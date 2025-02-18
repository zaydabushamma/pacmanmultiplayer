import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*! \file
This class is responsible for running some rudimentary "tests" on various features and subsystems of the project. It writes the results of these tests into the Test Results folder.
*/

class TestRunner {
    private static void setCenteredText(JLabel label, String input){
        label.setText("<html><div style='text-align: center;'>" + input + "</div></html>");
    }
    private static void printResults(PrintWriter pw, String title, boolean first, boolean second, boolean third){
        String s1 = first ? "pass" : "fail";
        String s2 = second ? "pass" : "fail";
        String s3 = third ? "pass" : "fail";
        pw.println("Test " + title + ": " + s1 + " - " + s2 + " - " + s3);
    }
    public static void main(String[] args) throws Exception{
        PrintWriter pw = new PrintWriter(new FileOutputStream("Test Results/Keyboard Test.txt"), true);
        pw.println("KEYBOARD TEST STARTED - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("LLLL d yyyy - h:mm a")));

        System.setProperty("sun.java2d.uiScale", "1");

        JFrame frame = new JFrame("Live Keyboard Test");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(true);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        frame.add(mainPanel);

        JLabel requestText = new JLabel("", SwingConstants.CENTER);
        requestText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
        requestText.setForeground(Color.WHITE);
        mainPanel.add(requestText, BorderLayout.CENTER);

        JLabel timerText = new JLabel("", SwingConstants.CENTER);
        timerText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        timerText.setForeground(Color.WHITE);
        mainPanel.add(timerText, BorderLayout.SOUTH);

        PacmanKeyboard kBoth = new KeyboardBothListener(frame);
        PacmanKeyboard kLett = new KeyboardLettersListener(frame);
        PacmanKeyboard kArro = new KeyboardArrowsListener(frame);

        frame.setVisible(true);

        //Test #1
        setCenteredText(requestText, "Please press and release<br/>the W key.");
        requestText.repaint();
        long startTime = System.currentTimeMillis();
        boolean bothGood = false;
        boolean lettGood = false;
        boolean arroGood = true;
        long timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isUpPressed();
            boolean lettCheck = kLett.isUpPressed();
            boolean arroCheck = kArro.isUpPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = true;
            }
            if(arroCheck){
                arroGood = false;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "W", bothGood, lettGood, arroGood);

        //Test #2
        setCenteredText(requestText, "Please press and release<br/>the S key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = false;
        arroGood = true;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isDownPressed();
            boolean lettCheck = kLett.isDownPressed();
            boolean arroCheck = kArro.isDownPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = true;
            }
            if(arroCheck){
                arroGood = false;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "S", bothGood, lettGood, arroGood);

        //Test #3
        setCenteredText(requestText, "Please press and release<br/>the A key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = false;
        arroGood = true;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isLeftPressed();
            boolean lettCheck = kLett.isLeftPressed();
            boolean arroCheck = kArro.isLeftPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = true;
            }
            if(arroCheck){
                arroGood = false;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "A", bothGood, lettGood, arroGood);

        //Test #4
        setCenteredText(requestText, "Please press and release<br/>the D key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = false;
        arroGood = true;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isRightPressed();
            boolean lettCheck = kLett.isRightPressed();
            boolean arroCheck = kArro.isRightPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = true;
            }
            if(arroCheck){
                arroGood = false;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "D", bothGood, lettGood, arroGood);

        //Test #5
        setCenteredText(requestText, "Please press and release<br/>the Up Arrow key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = true;
        arroGood = false;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isUpPressed();
            boolean lettCheck = kLett.isUpPressed();
            boolean arroCheck = kArro.isUpPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = false;
            }
            if(arroCheck){
                arroGood = true;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "Up", bothGood, lettGood, arroGood);

        //Test #6
        setCenteredText(requestText, "Please press and release<br/>the Down Arrow key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = true;
        arroGood = false;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isDownPressed();
            boolean lettCheck = kLett.isDownPressed();
            boolean arroCheck = kArro.isDownPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = false;
            }
            if(arroCheck){
                arroGood = true;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "Down", bothGood, lettGood, arroGood);

        //Test #7
        setCenteredText(requestText, "Please press and release<br/>the Left Arrow key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = true;
        arroGood = false;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isLeftPressed();
            boolean lettCheck = kLett.isLeftPressed();
            boolean arroCheck = kArro.isLeftPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = false;
            }
            if(arroCheck){
                arroGood = true;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "Left", bothGood, lettGood, arroGood);

        //Test #8
        setCenteredText(requestText, "Please press and release<br/>the Right Arrow key.");
        requestText.repaint();
        startTime = System.currentTimeMillis();
        bothGood = false;
        lettGood = true;
        arroGood = false;
        timer = System.currentTimeMillis() - startTime;
        while(timer < 5000){
            boolean bothCheck = kBoth.isRightPressed();
            boolean lettCheck = kLett.isRightPressed();
            boolean arroCheck = kArro.isRightPressed();
            if(bothCheck){
                bothGood = true;
            }
            if(lettCheck){
                lettGood = false;
            }
            if(arroCheck){
                arroGood = true;
            }
            if(bothCheck){
                mainPanel.setBackground(new Color(0, 0, 80));
            } else {
                mainPanel.setBackground(Color.BLACK);
            }
            timerText.setText(Long.toString(Math.max(5000 - timer, 0)));
            mainPanel.repaint();
            timer = System.currentTimeMillis() - startTime;
        }
        printResults(pw, "Right", bothGood, lettGood, arroGood);

        frame.setVisible(false);
        pw.println("KEYBOARD TEST FINISHED - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm a")));
        pw.close();
        System.exit(0);
    }
}
