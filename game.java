package Number_Guessing_Game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class game extends JFrame implements  ActionListener{

    int rounds = 0;
    int numberAttempts = 0;
    int Score = 0;
    int generatedNumber;
    JTextField guessField;
    JButton enter, giveup;
    JLabel error;
    JLabel attempts,highScore,roundLabel;

    game(int score, int round)
    {  
        rounds = round;
        Score = score;
        generatedNumber = (int)(Math.random()*(100-1) + 1);

        JPanel p1 = new JPanel();
        p1.setBounds(40,40,520,420);
        p1.setBackground(Color.white);
        p1.setLayout(null);
        add(p1);

        String imagePath = "C:\\Users\\Mohit\\Desktop\\Java\\Number_Guessing_Game\\image\\i1.png";
        ImageIcon image = new ImageIcon(imagePath);
        Image i1 = image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel imageLabel = new JLabel(i2);
        imageLabel.setBounds(300, 190, 400, 400);
        p1.add(imageLabel);

        String imagePath2 = "C:\\Users\\Mohit\\Desktop\\Java\\Number_Guessing_Game\\image\\i2.jpg";
        ImageIcon image2 = new ImageIcon(imagePath2);
        Image i3 = image2.getImage().getScaledInstance(146, 192, Image.SCALE_DEFAULT);
        ImageIcon i4= new ImageIcon(i3);
        JLabel imageLabel2 = new JLabel(i4);
        imageLabel2.setBounds(35, 130, 146, 192);
        p1.add(imageLabel2);

        JLabel l1 = new JLabel("NUMBER GUESSING GAME");
        l1.setBounds(95,40,400,40);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        p1.add(l1);

        JLabel l2=new JLabel("Guess The Number Between 1 And 100");
        l2.setFont(new Font("Comic Sans MS",Font.PLAIN,12));
        l2.setBounds(140,80,400,40);
        p1.add(l2);

        highScore = new JLabel("Score: "+Score);
        highScore.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        highScore.setBounds(370,170,100,40);
        p1.add(highScore);

        attempts = new JLabel("Attempts: 0");
        attempts.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        attempts.setBounds(370,210,200,40);
        p1.add(attempts);

        roundLabel = new JLabel("Rounds: " + rounds);
        roundLabel.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        roundLabel.setBounds(370,250,200,40);
        p1.add(roundLabel);

        JLabel label4 = new JLabel("Enter Number");
        label4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        label4.setBounds(210,155,300,40);
        p1.add(label4);

        guessField = new JTextField();
        guessField.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        guessField.setBorder(BorderFactory.createEmptyBorder());
        guessField.setBackground(Color.gray);
        guessField.setBounds(240,200,55,55);
        guessField.setOpaque(true);
        p1.add(guessField);

        error = new JLabel();
        error.setBounds(185,315,250,40);
        error.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        p1.add(error);

        enter = new JButton("ENTER");
        enter.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        enter.setBounds(220,265,100,30);
        enter.setBorder(BorderFactory.createEmptyBorder());
        enter.setBackground(new Color(255, 215, 0));
        enter.addActionListener(this);
        enter.setBorderPainted(false);
        enter.setContentAreaFilled(false);
        enter.setOpaque(true);
        p1.add(enter);

        giveup = new JButton("GIVE UP!");
        giveup.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        giveup.setBounds(10,381,100,30);
        giveup.setBorder(BorderFactory.createEmptyBorder());
        giveup.setBackground(new Color(255, 215, 0));
        giveup.addActionListener(this);
        giveup.setBorderPainted(false);
        giveup.setContentAreaFilled(false);
        giveup.setOpaque(true);
        p1.add(giveup);

        getContentPane().setBackground(new Color(255, 215, 0));
        setSize(600, 500);
        setLocation(350, 40);
        setUndecorated(rootPaneCheckingEnabled);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == giveup)
        {
            setVisible(false);
            try {
                new start(Score,rounds).setVisible(true);
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == enter)
        {
            try
            {
                if(guessField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter Value");
                }
                else
                {
                    if(Integer.parseInt(guessField.getText()) >100 || Integer.parseInt(guessField.getText()) <1)
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Number Between 1 and 100");
                    }
                    if(Integer.parseInt(guessField.getText()) == generatedNumber)
                    {
                        numberAttempts += 1;

                        if(numberAttempts >=1 && numberAttempts <=4 )
                        {
                            Score +=5;
                        }
                        else if(numberAttempts >4 && numberAttempts<=8)
                        {
                            Score += 2;
                        }
                        else
                        {
                            Score += 1;
                        }
                        setVisible(false);
                        new result(""+generatedNumber,numberAttempts,Score,rounds).setVisible(true);
                    }
                    else if(Integer.parseInt(guessField.getText()) < generatedNumber && Integer.parseInt(guessField.getText()) >=1 && Integer.parseInt(guessField.getText()) >= (generatedNumber - 20))
                    {
                        error.setText("Low!! Try Again");
                    }
                    else if(Integer.parseInt(guessField.getText()) > generatedNumber && Integer.parseInt(guessField.getText()) <=100 && Integer.parseInt(guessField.getText()) <= (generatedNumber + 20))
                    {
                        error.setText("High!! Try Again ");
                    }
                    if(Integer.parseInt(guessField.getText()) < (generatedNumber-20) && Integer.parseInt(guessField.getText()) > 0)
                    {
                        error.setText("Too Low!! Try Again");
                    }
                    else if(Integer.parseInt(guessField.getText()) > (generatedNumber+20) && Integer.parseInt(guessField.getText()) < 101)
                    {
                        error.setText("Too High!! Try Again");
                    }

                    numberAttempts = numberAttempts + 1;
                    attempts.setText("Attempts: "+numberAttempts);

                    if(numberAttempts == 16)
                    {
                        Score = 0;
                        setVisible(false);
                        new result(""+generatedNumber,numberAttempts,Score,rounds).setVisible(true);
                    }
                }
    
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Only Integer Number");
            }
        }
    }
    public static void main(String[] args) {
        new game(0,0);
    }
}
