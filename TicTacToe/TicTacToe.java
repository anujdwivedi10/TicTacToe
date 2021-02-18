package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame
{
    char PlayerMark = 'X';
    JButton[] jb = new JButton[9];


    TicTacToe()
    {
        super("TIC TAC TOE");
        setBounds(480,200,600,400);
        setLayout(new GridLayout(3,3));
        setVisible(true);
        initializeButtons();
    }

    public void initializeButtons() {
        for (int i = 0; i < 9; i++) {
            jb[i] = new JButton();
            jb[i].setText("-");
            jb[i].setBackground(Color.orange);
            jb[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton buttonClicked = (JButton) e.getSource();
                    buttonClicked.setText(String.valueOf(PlayerMark));

                    if (PlayerMark == 'X') {
                        PlayerMark = 'O';
                        buttonClicked.setBackground(Color.cyan);
                    } else {
                        PlayerMark = 'X';
                        buttonClicked.setBackground(Color.red);
                    }

                    displayWinner();
                }
            });
            add(jb[i]);
        }
    }
        public void displayWinner()
        {
            if(checkForWinner()==true)
            {
                if (PlayerMark == 'X')
                {
                    PlayerMark = 'O';
                } else
                    PlayerMark = 'X';

                JOptionPane jop = new JOptionPane();
                int dialog = JOptionPane.showConfirmDialog(jop, "Game Over. " + PlayerMark + " Wins.Would You Like " +
                        "To Play Again ?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (dialog == JOptionPane.YES_OPTION)
                {
                    resetButtons();
                }
                else
                {
                    System.exit(0);
                }
            }

            else if(checkDraw()==true)
            {
                JOptionPane jop = new JOptionPane();
                int dialog = JOptionPane.showConfirmDialog(jop, "Draw. Play Again ? " ,"Game Over ",JOptionPane.YES_NO_OPTION);
                if (dialog == JOptionPane.YES_OPTION)
                {
                    resetButtons();
                }
                else
                {
                    System.exit(0);
                }
            }
        }

        public void resetButtons()
        {
            PlayerMark = 'X';
            for(int i=0;i<9;i++)
            {
                jb[i].setText("-");
                jb[i].setBackground(Color.green);
            }
        }

        public boolean checkDraw()
        {
            boolean result = true;
            for(int i=0;i<9;i++)
            {
                if(jb[i].getText().charAt(0)=='-') {
                    result = false;
                }
            }
            return result;
        }

        public boolean checkRows()
        {
            int i=0;
            for(int j=0;j<3;j++)
            {
                if(jb[i].getText().equals(jb[i+1].getText()) && jb[i+1].getText().equals(jb[i+2].getText()) &&
                   jb[i].getText().charAt(0)!='-') {
                    return true;
                }
                i = i+3;
            }
            return false;
        }

        public boolean checkColumns()
        {
            int i=0;
            for(int j=0;j<3;j++)
            {
                if(jb[i].getText().equals(jb[i+3].getText()) && jb[i+3].getText().equals(jb[i+6].getText()) &&
                        jb[i].getText().charAt(0)!='-') {
                    return true;
                }
                i = i+1;
            }
            return false;
        }
        public boolean checkDiagonals()
        {
            if(jb[0].getText().equals(jb[4].getText()) && jb[4].getText().equals(jb[8].getText()) &&
                    jb[0].getText().charAt(0)!='-') {
                return true;
            }
            else if(jb[2].getText().equals(jb[4].getText()) && jb[4].getText().equals(jb[6].getText()) &&
                    jb[2].getText().charAt(0)!='-') {
                return true;
            }
            else
                return false;
        }

        public boolean checkForWinner()
        {
            if(checkColumns()==true || checkDiagonals()==true || checkRows()==true)
            {
                return true;
            }
            else
                return false;
        }


    public static void main(String[] args) {

    }
}
