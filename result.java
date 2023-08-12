package Number_Guessing_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class result extends JFrame implements ActionListener{

    JButton  continueButton,backToMenuButton;
    int score,roundResult;

    result(String number,int takeAttempts,int score,int round)
    {
        this.score = score;
        roundResult = round;

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

        JLabel l1 = new JLabel("NUMBER GUESSING GAME");
        l1.setBounds(100,40,400,40);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        p1.add(l1);

        JLabel correct,incorrect,correctNo,correctNumber,attemptJLabel,scoreJLabel,roundJLabel;

        if(takeAttempts == 16)
        {
            incorrect = new JLabel("You Lose");
            incorrect.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            incorrect.setBounds(210,85,100,40);
            p1.add(incorrect);
        }
        else
        {

            correct = new JLabel("You Win");
            correct.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            correct.setBounds(210,85,100,44);
            p1.add(correct);

        }

        correctNo = new JLabel("Correct Number");
        correctNo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        correctNo.setBounds(170,130,200,40);
        p1.add(correctNo);

        correctNumber = new JLabel(number);
        correctNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        correctNumber.setBounds(230,160,100,100);
        p1.add(correctNumber);

        attemptJLabel = new JLabel("Attempts: " + takeAttempts);
        attemptJLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        attemptJLabel.setBounds(140,240,150,40);
        p1.add(attemptJLabel);

        roundResult += 1;
        roundJLabel = new JLabel("Rounds: " + roundResult);
        roundJLabel.setBounds(140,270,150,40);
        roundJLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        p1.add(roundJLabel);

        scoreJLabel = new JLabel("Score: " + score);
        scoreJLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        scoreJLabel.setBounds(140,300,100,40);
        p1.add(scoreJLabel);

        continueButton = new JButton("Continue Play");
        continueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        continueButton.setBounds(320,300,100,30);
        continueButton.setBackground(new Color(255, 215, 0));
        continueButton.setBorder(BorderFactory.createEmptyBorder());
        continueButton.addActionListener(this);
        continueButton.setContentAreaFilled(false);
        continueButton.setOpaque(true);
        p1.add(continueButton);

        backToMenuButton = new JButton("Back To Menu");
        backToMenuButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        backToMenuButton.setBounds(10,381,100,30);
        backToMenuButton.setBorder(BorderFactory.createEmptyBorder());
        backToMenuButton.setBackground(new Color(255, 215, 0));
        backToMenuButton.addActionListener(this);
        backToMenuButton.setContentAreaFilled(false);
        backToMenuButton.setOpaque(true);
        p1.add(backToMenuButton);

        getContentPane().setBackground(new Color(255,215,0));
        setSize(600, 500);
        setLocation(350, 40);
        setUndecorated(rootPaneCheckingEnabled);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == continueButton)
        {
            setVisible(false);
            new game(score,roundResult).setVisible(true);
        }
        else
        {
            setVisible(false);
            try {

            Path fileName = Path.of("C:\\Users\\Mohit\\Desktop\\Java\\Number_Guessing_Game\\data.txt");
            String file_content = Files.readString(fileName);
            int index = file_content.indexOf(" ");
            int s1 = Integer.parseInt(file_content.substring(0, index));
            int s2 = Integer.parseInt(file_content.substring(index+1));

            if((score>s1 && roundResult >s2) || (score>s1 && roundResult == s2) || (score==s1 && roundResult ==s2) || (score == s1 && roundResult >s2))
            {
                String text = ""+score+" "+roundResult;
                Files.writeString(fileName, text);
            }

            String fileContent = Files.readString(fileName);
            int s3 = Integer.parseInt(fileContent.substring(0, index).trim());
            int s4 = Integer.parseInt(fileContent.substring(index+1).trim());

            new start(s3, s4).setVisible(true);
            
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new result("",0,0,0);
    }
}
