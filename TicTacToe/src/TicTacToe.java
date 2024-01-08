import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @class TicTacToe
 * @implNote ActionListener
 */
public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel allButtons = new JPanel(); //holds all buttons
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;
    String name1;
    String name2;
    TicTacToe(){
 name1 = JOptionPane.showInputDialog("Enter the first player`s name");
 name2 = JOptionPane.showInputDialog("Enter the second player`s name");


frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(800, 800);
frame.getContentPane().setBackground(new Color(50, 50, 50));
frame.setLayout(new BorderLayout());
frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Int Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);

        allButtons.setLayout(new GridLayout(3, 3));
        allButtons.setBackground(new Color(150, 150, 150));

        for (int i=0; i< buttons.length; i++){
            buttons[i] = new JButton();
            allButtons.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(textField, BorderLayout.NORTH);
        frame.add(title);
        frame.add(allButtons);

        firstTurn(name1, name2);
    }

    /**
     * @method actionPerformed
     * to place those "X" and "O"
     * @param e the event to be processed
     */
    @Override

    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<buttons.length; i++){
            if(e.getSource() ==buttons[i]) {
                if(player1Turn) {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText(name2 + "`s turn");
                        check();
                    }
                }   else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText(name2 + "`s turn");
                    }
                    check();
                }
            }
        }
    }

    /**
     * @method firstTurn;
     * @type void
     * decides whose first turn Is
     */
    public void firstTurn(String name1, String name2){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
            if (random.nextInt(2) == 0) {
                player1Turn = true;
                textField.setText(name1 + "`s turn");
            } else {
                player1Turn = false;
                textField.setText(name2 + "`s turn");
            }
        }

    /**
     * @method check
     * checks for the winning combinations
     */
    public void check() {
        //check X winning
       if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X"))
           winner(0,1,2);
       else if (
               (buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")
       )
           winner(3,4,5);
        else if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X"))
            winner(6,7,8);

     else if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X"))
    winner(0,3,6);
       else if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X"))
           winner(1,4,7);
       else if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X"))
           winner(2,5,8);
       else if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X"))
           winner(0,4,8);
       else if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X"))
           winner(2,4,6);
       //check 0 wins

        if ((buttons[0].getText() == "O") && (buttons[1].getText() == "0") && (buttons[2].getText() == "O"))
            winner(0, 1, 2);
        else if (
                (buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")
        )
            winner(3, 4, 5);
        else if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O"))
            winner(6, 7, 8);

        else if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O"))
            winner(0, 3, 6);
        else if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O"))
            winner(1, 4, 7);
        else if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O"))
            winner(2, 5, 8);
        else if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O"))
            winner(0, 4, 8);
        else if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O"))
            winner(2, 4, 6);
}

    /**
     * @method winner
     * detects the winner
     * @param a
     * @param b
     * @param c
     */
    public void winner(int a, int b, int c){
buttons[a].setBackground(Color.GREEN);
buttons[b].setBackground(Color.GREEN);
buttons[c].setBackground(Color.GREEN);

for(int i=0; i< buttons.length; i++){
    buttons[i].setEnabled(false);
}
textField.setText("Congrats");

    }
}
