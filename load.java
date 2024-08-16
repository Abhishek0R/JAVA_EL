package java_el;

import javax.swing.*;    
public class load extends JFrame{    
JProgressBar jb;   
int i=0,num=0;     
load(){    
jb=new JProgressBar(0,2000);    
jb.setBounds(100, 100, 600, 150);         
jb.setValue(0);    
jb.setStringPainted(true);    
add(jb);    
setSize(940,600);    
setLayout(null);    
}    
public void iterate(){    
while(i<=2000){    
  jb.setString("Loading...   "+i/20+"%"); 
  jb.setValue(i);
  i=i+20;    
  try{Thread.sleep(150);}catch(Exception e){}    
}    
}    
}    
