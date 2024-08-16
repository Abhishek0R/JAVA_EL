package java_el;
import java.util.Stack;
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
interface scenario1{
    public void hills();
    public void meditate();
    public void yeti();
    public void temple();
}
interface scenario2{
    public void forest();
    public void ware();
    public void nature();
    public void dragon();
}
interface scenario3{
    public void bridge();
    public void river();
    public void ship();
    public void troll();
}
interface fighting{
    public void playerAttack();
    public void monsterAttack();
    public void hyper();
    public void pray();
}
public class info
{
   JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Georgia", Font.PLAIN, 90);
    Font normalFont = new Font("Georgia", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    String[] weapon = new String[4]; 
    Stack<String> stk=new Stack<>();
    int playerHP, monsterHP, silverRing, charisma,ni=9, counter=0,location=-1;
    String position;
    Random rand=new Random();
    

    ImageIcon logo = new ImageIcon("E://icon.jpg");
}

