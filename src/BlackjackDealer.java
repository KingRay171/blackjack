import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author haaaw
 */
public class BlackjackDealer extends javax.swing.JFrame{

    /**
     * Creates new form BlackjackDealer
     */
    int chips = 1000;
    static int hs;
    static File f;
    static Scanner s;
    static BufferedWriter bw;
    BlackjackHand playerHand, dealerHand, playerHand2;
    boolean playerHasSplit = false;
    boolean playerIsOnSecondHand = false;

    public BlackjackDealer(String username) {
        initComponents(username);
    }



    private void initComponents(String username) {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        playerHand1Value = new javax.swing.JLabel();
        playerHand1CardsList = new javax.swing.JLabel();
        hitButton = new javax.swing.JButton();
        standButton = new javax.swing.JButton();
        doubleButton = new javax.swing.JButton();
        insuranceButton = new javax.swing.JButton();
        javax.swing.JButton hintButton = new javax.swing.JButton();
        splitButton = new javax.swing.JButton();
        playerHand2Value = new javax.swing.JLabel();
        playerHand2CardsList = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        dealerHandValue = new javax.swing.JLabel();
        dealerCardsList = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        javax.swing.JLabel c = new javax.swing.JLabel();
        chipsLabel = new javax.swing.JLabel();
        betInput = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        hsLabel = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();

        Font largeFont = new java.awt.Font("Segoe UI", Font.PLAIN, 24);
        Font smallFont = new java.awt.Font("Segoe UI", Font.PLAIN, 12);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blackjack");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(largeFont); // NOI18N
        jLabel1.setText(username);

        playerHand1Value.setText("Hand Value:");
        playerHand1Value.setFont(smallFont);

        playerHand1CardsList.setText("Cards:");
        playerHand1CardsList.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerHand1CardsList.setFont(smallFont);

        hitButton.setText("Hit");
        hitButton.setEnabled(false);
        hitButton.setFont(smallFont);
        hitButton.addActionListener(this::hitButtonActionPerformed);

        standButton.setText("Stand");
        standButton.setEnabled(false);
        standButton.setFont(smallFont);
        standButton.addActionListener(this::standButtonActionPerformed);

        doubleButton.setText("Double");
        doubleButton.setEnabled(false);
        doubleButton.setFont(smallFont);
        doubleButton.addActionListener(this::doubleButtonActionPerformed);

        insuranceButton.setText("Insurance");
        insuranceButton.setEnabled(false);
        insuranceButton.setFont(smallFont);
        insuranceButton.addActionListener(this::insuranceButtonActionPerformed);

        hintButton.setText("Hint");
        hintButton.setEnabled(true);
        hintButton.setFont(smallFont);
        hintButton.addActionListener(this::hintButtonActionPerformed);

        splitButton.setText("Split");
        splitButton.setEnabled(false);
        splitButton.setFont(smallFont);
        splitButton.addActionListener(this::splitButtonActionPerformed);

        playerHand2Value.setText("Hand Value: ");
        playerHand2Value.setEnabled(false);
        playerHand2Value.setFont(smallFont);

        playerHand2CardsList.setText("Cards:");
        playerHand2CardsList.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        playerHand2CardsList.setEnabled(false);
        playerHand2CardsList.setFont(smallFont);

        betInput.setFont(smallFont);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(20, 20, 20))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(splitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hintButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(standButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(doubleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(insuranceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(playerHand1CardsList, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(playerHand2CardsList, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(playerHand1Value, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(playerHand2Value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playerHand1Value)
                                        .addComponent(playerHand2Value))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playerHand1CardsList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playerHand2CardsList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hitButton)
                                .addGap(18, 18, 18)
                                .addComponent(standButton)
                                .addGap(18, 18, 18)
                                .addComponent(doubleButton)
                                .addGap(18, 18, 18)
                                .addComponent(insuranceButton)
                                .addGap(18, 18, 18)
                                .addComponent(splitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hintButton)
                                .addGap(13, 13, 13))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(largeFont); // NOI18N
        jLabel2.setText("Computer");

        dealerHandValue.setText("Hand Value:");
        dealerHandValue.setFont(smallFont);

        dealerCardsList.setText("Cards:");
        dealerCardsList.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dealerCardsList.setFont(smallFont);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dealerCardsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(dealerHandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 55, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(dealerHandValue)
                                .addGap(18, 18, 18)
                                .addComponent(dealerCardsList, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(63, Short.MAX_VALUE))
        );

        startButton.setText("Start");
        startButton.setFont(smallFont);
        startButton.addActionListener(this::startButtonActionPerformed);

        c.setFont(smallFont); // NOI18N
        c.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c.setText("Chips:");
        c.setFont(smallFont);

        chipsLabel.setText(String.valueOf(chips));
        chipsLabel.setFont(smallFont);

        jLabel4.setText("Bet:");
        jLabel4.setFont(smallFont);

        hsLabel.setText(Integer.toString(hs));
        hsLabel.setFont(smallFont);

        jLabel5.setText("High Score:");
        jLabel5.setFont(smallFont);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(63, 63, 63)
                                                                                .addComponent(jLabel4))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(28, 28, 28)
                                                                                .addComponent(betInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(40, 40, 40)
                                                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(244, 244, 244)
                                                                .addComponent(c)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                                                .addComponent(chipsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(232, 232, 232)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chipsLabel)
                                        .addComponent(c))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(betInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(hsLabel))
                                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>

    private void updateHighScore()
    {
        if(chips > hs)
        {
            try
            {
                if(bw != null && s != null){
                    bw.close();
                    s.close();
                }

                if(f.delete()){
                    f = new File("highscore.txt");
                    if(f.createNewFile()){
                        bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile(), true));
                        s = new Scanner(f);
                        bw.write(Integer.toString(chips));
                        bw.flush();
                        hs = chips;
                        hsLabel.setText(Integer.toString(chips));
                    }
                }


            } catch (IOException ex) {
                Logger.getLogger(BlackjackDealer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(chips >= 2 * Integer.parseInt(betInput.getText()))
            doubleButton.setEnabled(true);

        if(chips != 0 && Integer.parseInt(betInput.getText()) <= chips)
        {
            startButton.setEnabled(false);
            hitButton.setEnabled(true);
            standButton.setEnabled(true);
            chips -= Integer.parseInt(betInput.getText());
            chipsLabel.setText(Integer.toString(chips));
            betInput.setEnabled(false);
            playerHand = new BlackjackHand();
            playerHand.addCard(new PlayingCard());
            playerHand.addCard(new PlayingCard());
            dealerHand = new BlackjackHand();
            dealerHand.addCard(new PlayingCard());
            insuranceButton.setEnabled(dealerHand.handValue == 11);
            splitButton.setEnabled(playerHand.nthCard(0).getValue() == playerHand.nthCard(1).getValue() ||
                    (playerHand.nthCard(0).getValue() >= 10 && playerHand.nthCard(1).getValue() >= 10));
            playerHand1CardsList.setText("<html><body>" + playerHand.toString() + "</body></html>");
            dealerCardsList.setText("<html><body>" + dealerHand.toString() + "</body></html>");

            playerHand1Value.setText("Hand Value: " + playerHand.handValue());
            dealerHandValue.setText("Hand Value: " + dealerHand.handValue());

            if(playerHand.handValue() == 21)
            {
                JOptionPane.showMessageDialog(this, "You got a blackjack!", "That's game", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "You won " + (Integer.parseInt(betInput.getText())) * 2.5 + " chips", "That's game", JOptionPane.ERROR_MESSAGE);
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                startButton.setEnabled(true);
                doubleButton.setEnabled(false);
                insuranceButton.setEnabled(false);
                chips += Integer.parseInt(betInput.getText()) * 2.5;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
                betInput.setEnabled(true);
            }
        }
        else if(Integer.parseInt(betInput.getText()) > chips)
        {
            JOptionPane.showMessageDialog(this, "You can't bet that much!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void standButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(!playerHasSplit)
        {
            if(doubleButton.isEnabled())
                doubleButton.setEnabled(false);
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            while(dealerHand.handValue() < 17)
            {
                dealerHand.addCard(new PlayingCard());
                dealerHandValue.setText("Hand Value: " + dealerHand.handValue());
                dealerCardsList.setText("<html><body>" + dealerHand + "</body></html>");
                if(dealerHand.handValue() > 21)
                {
                    JOptionPane.showMessageDialog(this, "Dealer bust!", "That's game", JOptionPane.ERROR_MESSAGE);
                    startButton.setEnabled(true);
                    playerHand2Value.setText("Hand Value:");
                    playerHand2CardsList.setText("Cards:");
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                }
            }

            String c = dealerCardsList.getText();
            dealerCardsList.setText(c + dealerHand);
            if(dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() < 22)
            {
                JOptionPane.showMessageDialog(this, "You lose", "That's game", JOptionPane.ERROR_MESSAGE);
                startButton.setEnabled(true);
                betInput.setEnabled(true);
            }
            else if(dealerHand.handValue() < playerHand.handValue())
            {
                JOptionPane.showMessageDialog(this, "You win", "That's game", JOptionPane.ERROR_MESSAGE);
                chips += Integer.parseInt(betInput.getText()) * 2;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
                startButton.setEnabled(true);
                betInput.setEnabled(true);

            }
            else if(dealerHand.handValue() == playerHand.handValue())
            {
                JOptionPane.showMessageDialog(this, "Draw", "That's game", JOptionPane.ERROR_MESSAGE);
                chips += Integer.parseInt(betInput.getText());
                chipsLabel.setText(Integer.toString(chips));
                startButton.setEnabled(true);
                betInput.setEnabled(true);
            }
            splitButton.setEnabled(false);
        }
        else if(!playerIsOnSecondHand)
            playerIsOnSecondHand = true;

        else {
            if(doubleButton.isEnabled())
                doubleButton.setEnabled(false);
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            while(dealerHand.handValue() < 17)
            {
                dealerHand.addCard(new PlayingCard());
                dealerHandValue.setText("Hand Value: " + dealerHand.handValue());
                dealerCardsList.setText("<html><body>" + dealerHand + "</body></html>");
                if(dealerHand.handValue() > 21)
                {
                    JOptionPane.showMessageDialog(this, "Dealer bust!", "That's game", JOptionPane.ERROR_MESSAGE);
                    startButton.setEnabled(true);
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                    playerHasSplit = false;
                    playerIsOnSecondHand = false;
                    playerHand2Value.setText("Hand Value:");
                    playerHand2Value.setEnabled(false);
                    playerHand2CardsList.setText("Cards:");
                    playerHand2CardsList.setEnabled(false);
                }
            }

            String c = dealerCardsList.getText();
            dealerCardsList.setText(c + dealerHand);
            if(playerHand.handValue() != 21) {
                if (dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() < 22) {
                    JOptionPane.showMessageDialog(this, "Hand 1 lost", "That's game", JOptionPane.ERROR_MESSAGE);
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                } else if (dealerHand.handValue() < playerHand.handValue() && playerHand.handValue() < 22) {
                    JOptionPane.showMessageDialog(this, "Hand 1 won", "That's game", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                } else if (dealerHand.handValue() == playerHand.handValue()) {
                    JOptionPane.showMessageDialog(this, "Hand 1 drew", "That's game", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText());
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                }
            }

            if(playerHand2.handValue() != 21) {
                if (dealerHand.handValue() > playerHand2.handValue() && dealerHand.handValue() < 22) {
                    JOptionPane.showMessageDialog(this, "Hand 2 lost", "That's game", JOptionPane.ERROR_MESSAGE);
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                    playerHasSplit = false;
                    playerIsOnSecondHand = false;
                    playerHand2Value.setText("Hand Value: ");
                    playerHand2Value.setEnabled(false);
                    playerHand2CardsList.setText("Cards: ");
                    playerHand2CardsList.setEnabled(false);
                } else if (dealerHand.handValue() < playerHand2.handValue()) {
                    JOptionPane.showMessageDialog(this, "Hand 2 won", "That's game", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                    playerHasSplit = false;
                    playerIsOnSecondHand = false;
                    playerHand2Value.setText("Hand Value: ");
                    playerHand2Value.setEnabled(false);
                    playerHand2CardsList.setText("Cards: ");
                    playerHand2CardsList.setEnabled(false);
                } else if (dealerHand.handValue() == playerHand2.handValue()) {
                    JOptionPane.showMessageDialog(this, "Hand 2 drew", "That's game", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText());
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                    playerHasSplit = false;
                    playerIsOnSecondHand = false;
                    playerHand2Value.setText("Hand Value: ");
                    playerHand2Value.setEnabled(false);
                    playerHand2CardsList.setText("Cards: ");
                    playerHand2CardsList.setEnabled(false);
                }
            }
            if(dealerHand.handValue() > 21 && playerHand.handValue() < 21 && playerHand2.handValue() < 21)
            {
                chips += Integer.parseInt(betInput.getText()) * 2;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
            }
        }
        insuranceButton.setEnabled(false);
    }

    private void hitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(!playerHasSplit)
        {
            if(doubleButton.isEnabled())
                doubleButton.setEnabled(false);
            playerHand.addCard(new PlayingCard());
            playerHand1Value.setText("Hand Value: " + playerHand.handValue());
            playerHand1CardsList.setText("<html><body>" + playerHand + "</body></html>");
            if(playerHand.handValue() > 21)
            {
                JOptionPane.showMessageDialog(this, "You bust!", "That's game", JOptionPane.ERROR_MESSAGE);
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                splitButton.setEnabled(false);
                startButton.setEnabled(true);
                betInput.setEnabled(true);
            }
            else if(playerHand.handValue() == 21)
            {
                JOptionPane.showMessageDialog(this, "You got a blackjack!", "That's game", JOptionPane.ERROR_MESSAGE);
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                startButton.setEnabled(true);
                betInput.setEnabled(true);
                chips += Integer.parseInt(betInput.getText()) * 2.5;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
            }
        }
        else if(!playerIsOnSecondHand)
        {
            if(doubleButton.isEnabled())
                doubleButton.setEnabled(false);

            playerHand.addCard(new PlayingCard());
            playerHand1Value.setText("Hand Value: " + playerHand.handValue());
            playerHand1CardsList.setText("<html><body>" + playerHand + "</body></html>");
            if(playerHand.handValue() > 21)
            {
                JOptionPane.showMessageDialog(this, "First hand busted!", "That's game", JOptionPane.ERROR_MESSAGE);
                playerIsOnSecondHand = true;
                doubleButton.setEnabled(true);
            }
            else if(playerHand.handValue() == 21)
            {
                JOptionPane.showMessageDialog(this, "You win!", "That's game", JOptionPane.ERROR_MESSAGE);
                playerIsOnSecondHand = true;
                chips += Integer.parseInt(betInput.getText()) * 2;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
                doubleButton.setEnabled(true);
            }
        }
        else {
            if(doubleButton.isEnabled())
                doubleButton.setEnabled(false);
            playerHand2.addCard(new PlayingCard());
            playerHand2Value.setText("Hand Value: " + playerHand2.handValue());
            playerHand2CardsList.setText("<html><body>" + playerHand2 + "</body></html>");
            if(playerHand2.handValue() > 21)
            {
                JOptionPane.showMessageDialog(this, "Second hand busted!", "That's game", JOptionPane.ERROR_MESSAGE);
                playerIsOnSecondHand = false;
                hitButton.setEnabled(false);
                standButton.setEnabled(false);
                while(dealerHand.handValue() < 17)
                {
                    dealerHand.addCard(new PlayingCard());
                    dealerHandValue.setText("Hand Value: " + dealerHand.handValue());
                    dealerCardsList.setText("<html><body>" + dealerHand + "</body></html>");
                    if(dealerHand.handValue() > 21)
                    {
                        JOptionPane.showMessageDialog(this, "Dealer bust!", "That's game", JOptionPane.ERROR_MESSAGE);
                        startButton.setEnabled(true);
                        chips += Integer.parseInt(betInput.getText()) * 2;
                        updateHighScore();
                        chipsLabel.setText(Integer.toString(chips));
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                        playerHasSplit = false;
                        playerIsOnSecondHand = false;
                    }
                }

                String c = dealerCardsList.getText();
                dealerCardsList.setText(c + dealerHand);
                if(dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() < 22)
                {
                    JOptionPane.showMessageDialog(this, "Hand 1 lost", "That's game", JOptionPane.ERROR_MESSAGE);
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                }
                else if(dealerHand.handValue() < playerHand.handValue() && playerHand.handValue() < 22)
                {
                    JOptionPane.showMessageDialog(this, "Hand 1 won", "That's game", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                }
                else if(dealerHand.handValue() == playerHand.handValue())
                {
                    JOptionPane.showMessageDialog(this, "Hand 1 drew", "That's game", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText());
                    chipsLabel.setText(Integer.toString(chips));
                    startButton.setEnabled(true);
                    betInput.setEnabled(true);
                }

                startButton.setEnabled(true);
                betInput.setEnabled(true);
                playerHasSplit = false;
                playerIsOnSecondHand = false;
                playerHand2Value.setText("Hand Value: ");
                playerHand2Value.setEnabled(false);
                playerHand2CardsList.setText("Cards: ");
                playerHand2CardsList.setEnabled(false);
            }
            else if(playerHand2.handValue() == 21)
            {
                JOptionPane.showMessageDialog(this, "You got a 21!", "That's game", JOptionPane.ERROR_MESSAGE);
                playerIsOnSecondHand = false;
                chips += Integer.parseInt(betInput.getText()) * 2;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
                doubleButton.setEnabled(true);
                startButton.setEnabled(true);
                betInput.setEnabled(true);
                playerHasSplit = false;
                playerIsOnSecondHand = false;
                playerHand2Value.setText("Hand Value: ");
                playerHand2Value.setEnabled(false);
                playerHand2CardsList.setText("Cards: ");
                playerHand2CardsList.setEnabled(false);
            }
        }
        splitButton.setEnabled(false);
        insuranceButton.setEnabled(false);
    }

    private void doubleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        chips -= Integer.parseInt(betInput.getText());
        chipsLabel.setText(Integer.toString(chips));

        if(!playerHasSplit) {
            playerHand.addCard(new PlayingCard());
            playerHand1Value.setText("Hand Value: " + playerHand.handValue());
            playerHand1CardsList.setText("<html><body>" + playerHand + "</body></html>");
            if (playerHand.handValue() > 21) {
                JOptionPane.showMessageDialog(this, "You bust!", "You lost", JOptionPane.ERROR_MESSAGE);
            } else if (playerHand.handValue == 21) {
                JOptionPane.showMessageDialog(this, "You got a 21!", "You win", JOptionPane.ERROR_MESSAGE);
                chips += Integer.parseInt(betInput.getText()) * 4;
                updateHighScore();
                chipsLabel.setText(Integer.toString(chips));
            } else {
                while (dealerHand.handValue() < 17) {
                    dealerHand.addCard(new PlayingCard());
                    dealerHandValue.setText("Hand Value: " + dealerHand.handValue());
                    dealerCardsList.setText("<html><body>" + dealerHand + "</body></html>");
                    if (dealerHand.handValue() > 21) {
                        JOptionPane.showMessageDialog(this, "Dealer bust!", "You win.", JOptionPane.ERROR_MESSAGE);
                        startButton.setEnabled(true);
                        chips += Integer.parseInt(betInput.getText()) * 4;
                        updateHighScore();
                        chipsLabel.setText(Integer.toString(chips));
                    }
                }

                if (dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() < 22) {
                    JOptionPane.showMessageDialog(this, "You lose", "Game over", JOptionPane.ERROR_MESSAGE);
                } else if (dealerHand.handValue() < playerHand.handValue()) {
                    JOptionPane.showMessageDialog(this, "You win", "Game over", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 4;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                } else if (dealerHand.handValue() == playerHand.handValue()) {
                    JOptionPane.showMessageDialog(this, "Draw", "Game over", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    chipsLabel.setText(Integer.toString(chips));
                }
            }
        }
        else {
            if(!playerIsOnSecondHand){
                playerHand.addCard(new PlayingCard(1));
                playerHand1Value.setText("Hand Value: " + playerHand.handValue());
                playerHand1CardsList.setText("<html><body>" + playerHand + "</body></html>");
                if (playerHand.handValue() > 21) {
                    JOptionPane.showMessageDialog(this, "You bust!", "Hand lost", JOptionPane.ERROR_MESSAGE);
                } else if (playerHand.handValue == 21) {
                    JOptionPane.showMessageDialog(this, "You got a 21!", "Hand won", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 4;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                }
                playerIsOnSecondHand = true;

            }
            else {
                playerHand2.addCard(new PlayingCard(1));
                playerHand2Value.setText("Hand Value: " + playerHand2.handValue());
                playerHand2CardsList.setText("<html><body>" + playerHand2 + "</body></html>");

                while(dealerHand.handValue() < 17)
                {
                    dealerHand.addCard(new PlayingCard());
                    dealerHandValue.setText("Hand Value: " + dealerHand.handValue());
                    dealerCardsList.setText("<html><body>" + dealerHand + "</body></html>");
                    if(dealerHand.handValue() > 21)
                    {
                        JOptionPane.showMessageDialog(this, "Dealer bust!", "You win", JOptionPane.ERROR_MESSAGE);
                        startButton.setEnabled(true);
                        chips += Integer.parseInt(betInput.getText()) * 2;
                        updateHighScore();
                        chipsLabel.setText(Integer.toString(chips));
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                        playerHasSplit = false;
                        playerIsOnSecondHand = false;
                        playerHand2Value.setText("Hand Value:");
                        playerHand2Value.setEnabled(false);
                        playerHand2CardsList.setText("Cards:");
                        playerHand2CardsList.setEnabled(false);
                    }

                }
                if(playerHand.handValue() != 21) {
                    if (dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() < 22) {
                        JOptionPane.showMessageDialog(this, "Hand 1 lost", "Information", JOptionPane.ERROR_MESSAGE);
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                    } else if (dealerHand.handValue() < playerHand.handValue() && playerHand.handValue() < 22) {
                        JOptionPane.showMessageDialog(this, "Hand 1 won", "Information", JOptionPane.ERROR_MESSAGE);
                        chips += Integer.parseInt(betInput.getText()) * 2;
                        updateHighScore();
                        chipsLabel.setText(Integer.toString(chips));
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                    } else if (dealerHand.handValue() == playerHand.handValue()) {
                        JOptionPane.showMessageDialog(this, "Hand 1 drew", "Information", JOptionPane.ERROR_MESSAGE);
                        chips += Integer.parseInt(betInput.getText());
                        chipsLabel.setText(Integer.toString(chips));
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                    }
                }

                if(playerHand2.handValue() != 21) {
                    if (dealerHand.handValue() > playerHand2.handValue() && dealerHand.handValue() < 22) {
                        JOptionPane.showMessageDialog(this, "Hand 2 lost", "Game over", JOptionPane.ERROR_MESSAGE);
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                        playerHasSplit = false;
                        playerIsOnSecondHand = false;
                        playerHand2Value.setText("Hand Value: ");
                        playerHand2Value.setEnabled(false);
                        playerHand2CardsList.setText("Cards: ");
                        playerHand2CardsList.setEnabled(false);
                    } else if (dealerHand.handValue() < playerHand2.handValue()) {
                        JOptionPane.showMessageDialog(this, "Hand 2 won", "Game over", JOptionPane.ERROR_MESSAGE);
                        chips += Integer.parseInt(betInput.getText()) * 2;
                        updateHighScore();
                        chipsLabel.setText(Integer.toString(chips));
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                        playerHasSplit = false;
                        playerIsOnSecondHand = false;
                        playerHand2Value.setText("Hand Value: ");
                        playerHand2Value.setEnabled(false);
                        playerHand2CardsList.setText("Cards: ");
                        playerHand2CardsList.setEnabled(false);
                    } else if (dealerHand.handValue() == playerHand2.handValue()) {
                        JOptionPane.showMessageDialog(this, "Hand 2 drew", "Game over", JOptionPane.ERROR_MESSAGE);
                        chips += Integer.parseInt(betInput.getText());
                        chipsLabel.setText(Integer.toString(chips));
                        startButton.setEnabled(true);
                        betInput.setEnabled(true);
                        playerHasSplit = false;
                        playerIsOnSecondHand = false;
                        playerHand2Value.setText("Hand Value: ");
                        playerHand2Value.setEnabled(false);
                        playerHand2CardsList.setText("Cards: ");
                        playerHand2CardsList.setEnabled(false);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "You got a 21!", "Game over", JOptionPane.ERROR_MESSAGE);
                    chips += Integer.parseInt(betInput.getText()) * 4;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));
                    hitButton.setEnabled(false);
                    standButton.setEnabled(false);
                    doubleButton.setEnabled(false);

                    playerHand2Value.setText("Hand Value:");
                    playerHand2Value.setEnabled(false);
                    playerHand2CardsList.setText("Cards:");
                    playerHand2CardsList.setEnabled(false);
                }
                if(dealerHand.handValue() > 21 && playerHand.handValue() < 21 && playerHand2.handValue() < 21)
                {
                    chips += Integer.parseInt(betInput.getText()) * 2;
                    updateHighScore();
                    chipsLabel.setText(Integer.toString(chips));

                    hitButton.setEnabled(false);
                    standButton.setEnabled(false);
                    doubleButton.setEnabled(false);
                }
            }

        }
        startButton.setEnabled(true);
        splitButton.setEnabled(false);
        betInput.setEnabled(true);
    }

    private void insuranceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        chips -= Integer.parseInt(betInput.getText()) / 2;
        chipsLabel.setText(Integer.toString(chips));
        dealerHand.addCard(new PlayingCard());
        dealerHandValue.setText("Hand Value: " + dealerHand.handValue());
        dealerCardsList.setText("<html><body>" + dealerHand + "</body></html>");
        insuranceButton.setEnabled(false);
        if(dealerHand.handValue() == 21)
        {
            JOptionPane.showMessageDialog(this, "Insurance paid off", "Game over", JOptionPane.ERROR_MESSAGE);
            chips += Integer.parseInt(betInput.getText()) * 1.5;
            chipsLabel.setText(Integer.toString(chips));
            startButton.setEnabled(true);
            betInput.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Insurance lost", "Information", JOptionPane.ERROR_MESSAGE);
            hitButton.setEnabled(true);
            standButton.setEnabled(true);
        }
    }

    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame f = new JFrame();
                HintPanel hp = new HintPanel("optimalplay.png");
                f.getContentPane().add(hp);
                f.setVisible(true);
                f.setSize((int)(hp.getBackgroundImage().getWidth() * 1.05), (int)(hp.getBackgroundImage().getHeight() * 1.05));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void splitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        playerHand2 = new BlackjackHand();
        PlayingCard c1 = playerHand.nthCard(0);
        PlayingCard c2 = playerHand.nthCard(1);
        playerHand2.addCard(c2);
        playerHand = new BlackjackHand();
        playerHand.addCard(c1);
        playerHand2Value.setEnabled(true);
        playerHand2CardsList.setEnabled(true);
        playerHand1Value.setText("Hand Value: " + playerHand.handValue());
        playerHand1CardsList.setText("<html><body>" + playerHand + "</body></html>");
        playerHand2Value.setText("Hand Value: " + playerHand2.handValue());
        playerHand2CardsList.setText("<html><body>" + playerHand2 + "</body></html>");
        playerHasSplit = true;
        splitButton.setEnabled(false);
        chips -= Integer.parseInt(betInput.getText());
        chipsLabel.setText(Integer.toString(chips));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set Windows L&F
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlackjackDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        try {
            f = new File("highscore.txt");
            if (!f.exists()) {
                if (f.createNewFile()) {
                    s = new Scanner(f);
                    bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile(), true));
                    hs = Integer.parseInt(s.nextLine());
                }
            } else {
                s = new Scanner(f);
                bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile(), true));
                hs = Integer.parseInt(s.nextLine());
            }

        } catch (IOException ex) {
            Logger.getLogger(BlackjackDealer.class.getName()).log(Level.SEVERE, null, ex);
        }

        UIManager.put("TextField.font",
                new FontUIResource(new Font("SansSerif",Font.BOLD,16)));

        String name = JOptionPane.showInputDialog("Enter your name (no more than 20 characters)");
        while (name.length() > 21) {
            JOptionPane.showMessageDialog(null, "Invalid name");
            name = JOptionPane.showInputDialog("Enter your name (no more than 20 characters)");
        }

        String finalName = name;
        java.awt.EventQueue.invokeLater(() -> new BlackjackDealer(finalName).setVisible(true));
    }

    private javax.swing.JTextField betInput;
    private javax.swing.JLabel chipsLabel;
    private javax.swing.JLabel dealerCardsList;
    private javax.swing.JLabel dealerHandValue;
    private javax.swing.JButton doubleButton;
    private javax.swing.JButton hitButton;
    private javax.swing.JLabel hsLabel;
    private javax.swing.JButton insuranceButton;
    private javax.swing.JLabel playerHand1CardsList;
    private javax.swing.JLabel playerHand1Value;
    private javax.swing.JLabel playerHand2CardsList;
    private javax.swing.JLabel playerHand2Value;
    private javax.swing.JButton splitButton;
    private javax.swing.JButton standButton;
    private javax.swing.JButton startButton;
}