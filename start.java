package Number_Guessing_Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class start extends JFrame  implements ActionListener{
    
    JButton startGame,quitGame;

    start(int highScore,int numberOfRounds) throws IOException
    {
        JPanel p1 = new JPanel();
        p1.setBounds(40,40,520,420);
        p1.setLayout(null);
        add(p1);

        String imagePath = "C:\\Users\\Mohit\\Desktop\\Java\\Number_Guessing_Game\\image\\i1.png";
        ImageIcon image = new ImageIcon(imagePath);
        Image i1 = image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel imageLabel = new JLabel(i2);
        imageLabel.setBounds(300, 190, 400, 400);
        p1.add(imageLabel);
    
        JLabel label = new JLabel("LET'S PLAY");
        label.setBounds(180,20,200,40);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        p1.add(label);

        JLabel label1 = new JLabel("NUMBER GUESSING GAME");
        label1.setBounds(80,60,400,40);
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        p1.add(label1);


        JLabel label2= new JLabel("Features");
        label2.setBounds(10,107,100,40);
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        p1.add(label2);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 125, 600, 120);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        l1.setText(
            "<html>" + 
            "-> A secret number is generated in the range of 1 to 100" + "<br>" + 
            "-> If you guesses the number from 1st to 4th attempt, the score increases by 5." + "<br>" +
            "-> If guessed correctly from 5th to 8th attempt then +2 otherwise +1." + "<br>" +
            "-> You have only 15 Attempts for guessing the secret Number." + 
            "<html>");
        p1.add(l1);

        JLabel till = new JLabel("TILL NOW:");
        till.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        till.setBounds(200,250,150,40);
        p1.add(till);

        JLabel record = new JLabel("Best Score: "+ highScore + "  Rounds: "+ numberOfRounds);
        record.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        record.setBounds(150,280,250,40);
        p1.add(record);

        startGame = new JButton("START");
        startGame.setBounds(200,330,100,30);
        startGame.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        startGame.setBorder(BorderFactory.createEmptyBorder());
        startGame.setBackground(new Color(255, 215, 0));
        startGame.setBorderPainted(false);
        startGame.setContentAreaFilled(false);
        startGame.setOpaque(true);
        startGame.addActionListener(this);
        p1.add(startGame);


        quitGame = new JButton("QUIT");
        quitGame.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        quitGame.setBounds(200,365,100,30);
        quitGame.setBorder(BorderFactory.createEmptyBorder());
        quitGame.setBackground(new Color(255, 215, 0));
        quitGame.setBorderPainted(false);
        quitGame.setContentAreaFilled(false);
        quitGame.setOpaque(true);;
        quitGame.addActionListener(this);
        p1.add(quitGame);

        getContentPane().setBackground(new Color(255,215,0));
        setSize(600, 500);
        setLocation(350, 40);
        setUndecorated(rootPaneCheckingEnabled);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == quitGame)
        {
            System.exit(0);
        }
        else if(ae.getSource() == startGame)
        {
            setVisible(false);
            new game(0,0).setVisible(true);
        }
    }
    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("C:\\Users\\Mohit\\Desktop\\Java\\Number_Guessing_Game\\data.txt");
        int s1 = 0;
        int s2 = 0;

        try
        {
        String file_content = Files.readString(fileName);
        int index = file_content.indexOf(" ");
        s1 = Integer.parseInt(file_content.substring(0, index));
        s2 = Integer.parseInt(file_content.substring(index+1));
        }
        catch(Exception e)
        {
            String text = ""+0+" "+0;
            Files.writeString(fileName, text);
            new start(0, 0);
        }

        new start(s1,s2);
    }
}
