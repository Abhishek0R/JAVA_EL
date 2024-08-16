package java_el;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Game extends info implements scenario1, scenario2, scenario3, fighting{
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
    load l=new load();    
    l.setVisible(true);    
    l.iterate(); 
    l.setVisible(false);
    new Game();
    }
    
    public Game(){
      
        window = new JFrame();
        window.setSize(940, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("MEDIEVIL");
        titleNameLabel.setForeground(Color.orange);
        titleNameLabel.setFont(titleFont);    
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.cyan);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        
        window.setVisible(true);
    }
    
    public void createGameScreen(){
        
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(70, 70, 850, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);        
        mainTextArea = new JTextArea("This is the main text area.");
        mainTextArea.setBounds(70, 70, 850, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.orange);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true); 
        mainTextArea.setEditable(false);     
        
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);        
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.cyan);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler); 
        choice1.setActionCommand("c1"); 
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.cyan);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.cyan);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.cyan);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        
        

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setBackground(Color.red);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }
    public void playerSetup(){
        
        playerHP = 18;
        monsterHP = 33;
        charisma = 0;
        weapon[0] = "Rusty Knife";
        weaponLabelName.setText(weapon[0]);
        hpLabelNumber.setText("" + playerHP);
        
        castle();
    }
    public void castle(){
        
        position = "castle";
        mainTextArea.setText("You are at the gate of the castle. \nTwo guards are standing in front of you. \n\nWhat do you do?");        
        choice1.setText("Talk to the guards");
        choice2.setText("Attack the guard");
        choice3.setText("Use your charisma");
        choice4.setText("Cross Roads");
    }
    public void talkGuard(){
               stk.push(position);
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger. We have never seen you around this area before. \nWhy don't you offer something to us in exchange for safe passage inside the castle. ");
        choice1.setText("Blank stare");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void attackGuard(){
               stk.push(position);
        position = "attackGuard";
        mainTextArea.setText("Guard: Are you seriously going to attack the king's security?\n(You receive 3 damage)");
        playerHP -=3;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText("Bad idea");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void crossRoad(){      
        stk.push(position);
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIt's time to choose a path");
        choice1.setText("Forest");
        choice2.setText("Bridge");
        choice3.setText("Hills");
        choice4.setText("Castle");
    }
    public void forest(){
               stk.push(position);
        position = "forest";
        mainTextArea.setText("You arrive at the forest.\nHome to many endangered species which hope not to cross paths with you");
        choice1.setText("Dragon");
        choice2.setText("Warehouse");
        choice3.setText("Explore nature");
        choice4.setText("Cross Roads");        
    }
    public void bridge(){
           stk.push(position);
        position = "bridge";
        
        mainTextArea.setText("You are currently in the valleys where the River Stinks flows with a giant cable stayed bridge built on top if it.\nThere's rumours of a troll lurking in this area.");
        choice1.setText("Troll");
        choice2.setText("Ship Crash");
        choice3.setText("River");
        choice4.setText("Cross Road");
        
    }
    public void dragon(){
               stk.push(position);
        position = "dragon";
        location=1;
        mainTextArea.setText("The dragon tries to avoid you and slowly sneaks away.\nBut you tackle it and start a fight.\nMonster HP: " + monsterHP);
        choice1.setText("Attack");
        choice2.setText("Hyper charge");
        choice3.setText("Pray");
        choice4.setText("Flee");
    }
    public void troll(){
               stk.push(position);
        position = "troll";
        location=2;
        mainTextArea.setText("The troll refused to allow you to cross the bridge without a donation.\nSo you decide to offer the troll as a sacrifice.\nMonster HP: " + monsterHP);
        choice1.setText("Attack");
        choice2.setText("Hyper charge");
        choice3.setText("Pray");
        choice4.setText("Flee");
    }
        public void nature(){
                   stk.push(position);
        position = "nature";
        if(counter==0){
        mainTextArea.setText("You find an arrow pierced through the tree with a note and apple attached to it.\nThe note has your name written in red.\nYou eat the apple which restores your health.\nHope it's not an assassination attempt!");
        playerHP = playerHP + 7;
        counter++;}
        else mainTextArea.setText("You can do that only once.");
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(";)");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
        public void river(){
                   stk.push(position);
        position = "river";
        if(counter==0){
        mainTextArea.setText("You decide to go for a swim and come out with a sinking feeling.\nIt's caused by the quicksand pulling you down.\nIt ends up not harming you but instead restores your health!");
        playerHP = playerHP + 7;
        counter++;}
        else mainTextArea.setText("You can do that only once.");
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(";)");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void hills(){
               stk.push(position);
        position = "hills";
        mainTextArea.setText("Situated at a height of over 3000 metres, this mountain range is the point of origin for River Stinks.\nThis place isn't for the faint hearted.\nChoose your path:");
        choice1.setText("Yeti");
        choice2.setText("Ancient temple");
        choice3.setText("Meditate");
        choice4.setText("Cross Roads");
    }
    public void playerAttack(){
               stk.push(position);
        position = "playerAttack";
        
        int playerDamage = 0;
        String ch=weaponLabelName.getText();
        if(ch.equals("Rusty Knife")){
            playerDamage = new java.util.Random().nextInt(3);
        }
        else if(ch.equals("Talwar")){
            playerDamage = new java.util.Random().nextInt(12); 
        }
        else if(ch.equals("Revolver")){
            playerDamage = new java.util.Random().nextInt(13); 
        }
        else if(ch.equals("BroomStick")){
            playerDamage = new java.util.Random().nextInt(12); 
        }
        
        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
        
        monsterHP = monsterHP - playerDamage;
        
        choice1.setText(":)");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");        
    }
    public void monsterAttack(){
        position = "monsterAttack";
        
        int monsterDamage = 0;
        
        monsterDamage = new java.util.Random().nextInt(6); 
        
        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
        
        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText(":(");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");    
    }
    public void hyper(){
        position = "hyper";
        
        int monsterDamage = 0;
        int i=new java.util.Random().nextInt(7);
        monsterDamage = new java.util.Random().nextInt(12); 
        
        mainTextArea.setText("You attacked the monster and gave " + monsterDamage + " damage!\nYou lost "+i+" health in the process.");
        playerHP-=i;
        monsterHP = monsterHP - monsterDamage;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText(":\\");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");    
    }
    public void pray(){
        position = "pray";
        
        int monsterDamage = 0;;
        
        monsterDamage = new java.util.Random().nextInt(6); 
        
        mainTextArea.setText("You gained " + monsterDamage + " health!");
        
        playerHP = playerHP + monsterDamage;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText(":)");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");    
    }
    public void win(){
        position = "win";
        
        mainTextArea.setText("You defeated the monster!\nThe monster dropped a \"10 days Zero to Hero\" guide!\n\n(You pick up the guide)");
        
        silverRing = 1;
        
        choice1.setText("Go crossroads");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }
    public void lose(){
        position = "lose";
        
        mainTextArea.setText("You are dead!\n\nGAME OVER");
        
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void ending(){
        position = "ending";
        
        mainTextArea.setText("The guard grabs the guide.\nGuard: I always wanted to be a hero and slay monsters.\nThanks for the guide, you can meet the king now.\n\nTHE END");
        
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void yeti(){
               stk.push(position);
        position = "yeti";
        location=0;
        mainTextArea.setText("You followed the road less travelled\nand found out there's a reason for it being an unpopular choice.\nYou encounter the legendary creature of the hills, The Yeti\nMonster HP: " + monsterHP);
        choice1.setText("Attack");
        choice2.setText("Hyper charge");
        choice3.setText("Pray");
        choice4.setText("Flee");
    }
    public void meditate(){
               stk.push(position);
        position = "meditate";
        if(counter==0){
        mainTextArea.setText("You increase your HP by just being a man of focus, commitment and sheer will.");
        playerHP = playerHP + 7;
        counter++;}
        else mainTextArea.setText("You can do that only once.");
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(";)");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void temple(){
               stk.push(position);
        position = "temple";
        mainTextArea.setText("In the heart of the snowy hills stands the Enigmatic Temple, known for its intricate mosaics that hold hidden meanings.\n1. Ganesha Mosaic: Depicts Ganesha with five modak sweets. 2. Shiva Mosaic: Shows the duality of Shiva's nature and his cosmic dance. 3. Vishnu Mosaic: Presents Vishnu with his four arms, holding his iconic symbols.\n4. Devi Mosaic: Displays Devi wielding eight weapons. Pattern?");       
       
        choice1.setText("5428");
        choice2.setText("5248");
        choice3.setText("4582");
        choice4.setText("4852");
    }
        public void ware(){
                   stk.push(position);
        position = "ware";
        mainTextArea.setText("You find the locker in the warehouse with the following riddle.\n4876-One digit correct but wrongly placed\n9641-Two digits are correct but one is wrongly placed and one is rightly placed\n4253-One digit is correct and rightly placed\n8395-Two digits are correct and rightly placed\nWhat's the combination?");       
       
        choice1.setText("wr");
        choice2.setText("rw");
        choice3.setText("answer");
        choice4.setText("wr");
    }
     public void ship(){
                stk.push(position);
        position = "ship";
        mainTextArea.setText("?");       
       
        choice1.setText("answer");
        choice2.setText("rw");
        choice3.setText("rw");
        choice4.setText("wr");
    }




    public class TitleScreenHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            createGameScreen();
        }
    }
    

    public class ChoiceHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            String yourChoice = event.getActionCommand();
            
            switch(position){
            case "castle":
                switch(yourChoice){
                case "c1": 
                    if(silverRing==1){
                        ending();
                    }
                    else{
                        talkGuard();
                    }
                    break;
                case "c2": attackGuard();break;
                case "c3": int up=11;
                           charisma = rand.nextInt(up);
                           if(charisma>=ni) ending();
                           else mainTextArea.setText("Your words do not mean anything to us.\nGive us something or do not return.\nNo bargaining");
                           ni++;
                           break;
                case "c4": crossRoad();break;
                }
                break;
            case "talkGuard":
                switch(yourChoice){
                case "c1": position=stk.pop();
                castle(); break;
                }
                break;
            case "attackGuard":
                switch(yourChoice){
                case "c1": position=stk.pop(); castle(); 
                if(playerHP==0) lose(); break;
                }
                break;
            case "crossRoad":
                switch(yourChoice){
                case "c1": forest(); break;
                case "c2": bridge();break;
                case "c3": hills(); break;
                case "c4": position=stk.pop();  castle();break;
                }
                break;
            case "hills":
                switch(yourChoice){
                case "c1": yeti(); break;
                case "c2": temple();break;
                case "c3": meditate(); break;
                case "c4":  position=stk.pop(); crossRoad();break;
                }break;
            case "temple":
                switch(yourChoice){
                case "c1": lose(); break;
                case "c2": weapon[1] = "Talwar";
                           weaponLabelName.setText(weapon[1]);
                           position=stk.pop();hills(); break;
                case "c3": lose(); break;
                case "c4": lose();break;
                }break;
            case "ware":
                switch(yourChoice){
                case "c1": lose(); break;
                case "c3": weapon[2] = "Revolver";
                           weaponLabelName.setText(weapon[2]);
                            position=stk.pop();  forest(); break;
                case "c2": lose(); break;
                case "c4": lose();break;
                }break;
            case "ship":
                switch(yourChoice){
                case "c1": weapon[3] = "BroomStick";
                           weaponLabelName.setText(weapon[3]);
                            position=stk.pop(); bridge(); break;
                case "c2": lose(); break;
                case "c3": lose(); break;
                case "c4": lose(); break;
                }break;
            case "yeti":
                switch(yourChoice){
                case "c1": playerAttack(); break;
                case "c2": hyper();break;
                case "c3": pray(); break;
                case "c4":  position=stk.pop();  hills();break;
                }break;
            case "dragon":
                switch(yourChoice){
                case "c1": playerAttack(); break;
                case "c2": hyper();break;
                case "c3": pray(); break;
                case "c4": position=stk.pop();  forest();break;
                }break;
            case "troll":
                switch(yourChoice){
                case "c1": playerAttack(); break;
                case "c2": hyper();break;
                case "c3": pray(); break;
                case "c4": position=stk.pop();  bridge();break;
                }break;
            case "meditate":
                switch(yourChoice){
                case "c1":  position=stk.pop();  hills();break;
                }break;
            case "nature":
                switch(yourChoice){
                case "c1": position=stk.pop();  forest();break;
                }break;
            case "river":
                switch(yourChoice){
                case "c1":  position=stk.pop(); bridge();break;
                }break;
            case "forest":
                switch(yourChoice){
                case "c1": dragon(); break;
                case "c2": ware(); break;
                case "c3": nature(); break;
                case "c4": position=stk.pop();crossRoad();break;
                }
                break;
            case "bridge":
                switch(yourChoice){
                case "c1": troll(); break;
                case "c2": ship(); break;
                case "c3": river(); break;
                case "c4":  position=stk.pop(); crossRoad();break;
                }
                break;
            case "fight":
                switch(yourChoice){
                case "c1": playerAttack();break;
                case "c2":   position=stk.pop();  crossRoad(); break;
                }
                break;
            case "playerAttack":
                switch(yourChoice){
                case "c1": 
                    if(monsterHP <1 ){
                        win();
                    }
                    else{
                        monsterAttack();
                    }
                    
                    break;
                }
                break;
            case "hyper":
                switch(yourChoice){
                case "c1": 
                    if(monsterHP <1 ){
                        win();
                    }
                    else{
                        monsterAttack();
                    }
                    
                    break;
                }
                break;
            case "pray":
                switch(yourChoice){
                case "c1": 
                    if(monsterHP <1 ){
                        win();
                    }
                    else{
                        monsterAttack();
                    }
                    
                    break;
                }
                break;
            case "monsterAttack":
                switch(yourChoice){
                case "c1": 
                    if(playerHP <1 ){
                        lose();
                    }
                    else{if(location==0)
                        yeti(); else if(location==1) dragon();
                        else if(location==2) troll();
                    }
                    
                    break;
                }
                break;
            case "win":
                switch(yourChoice){
                case "c1": crossRoad();
                }
                break;
                
            }
            
            
        }
    }
}
    

