package finalproject2;

import java.awt.Choice;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class add extends JFrame implements ActionListener, ItemListener{
	//記得做一個清空鍵
	JLabel name = new JLabel("事件名稱");
	JLabel type = new JLabel("事件類型");
	JLabel time = new JLabel("時間");
	JLabel other = new JLabel("備註");
	JLabel word1 = new JLabel("時");
	JLabel word2 = new JLabel("分");
	JLabel messageJL = new JLabel("提醒");
	JButton save = new JButton("儲存");
	JButton cancel = new JButton("取消");
	JCheckBox imp = new JCheckBox();
	JTextArea textarea =new JTextArea("無");
	JTextField namefield = new JTextField("事件名稱");
	JTextField typefield = new JTextField("事件類型");
	JTextField timefield = new JTextField();
	Container cp=getContentPane();
	Choice hourchoice = new Choice();
	Choice minutechoice = new Choice();
	boolean important = false;
	Choice message = new Choice();
	FileWriter workfw;
	FileWriter numfw;
	FileReader numfr;
	Properties props;
	int hour = 0;
	int minute = 0;
	add(){
		setTitle("new");
		setSize(300, 500);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		cp.setLayout(null);
		
		name.setBounds(0, 10, 100, 30);
		cp.add(name);
		namefield.setBounds(100,10,180,30);
		cp.add(namefield);
		
		type.setBounds(0, 70, 100, 30);
		cp.add(type);
		typefield.setBounds(100,70,180,30);
		cp.add(typefield);
		
		time.setBounds(0, 130, 100, 30);
		cp.add(time);
		
		hourchoice.add("00");
		hourchoice.add("01");
		hourchoice.add("02");
		hourchoice.add("03");
		hourchoice.add("04");
		hourchoice.add("05");
		hourchoice.add("06");
		hourchoice.add("07");
		hourchoice.add("08");
		hourchoice.add("09");
		hourchoice.add("10");
		hourchoice.add("11");
		hourchoice.add("12");
		hourchoice.add("13");
		hourchoice.add("14");
		hourchoice.add("15");
		hourchoice.add("16");
		hourchoice.add("17");
		hourchoice.add("18");
		hourchoice.add("19");
		hourchoice.add("20");
		hourchoice.add("21");
		hourchoice.add("22");
		hourchoice.add("23");
		hourchoice.setBounds(100,130,50,30);
		hourchoice.addItemListener(this);
		cp.add(hourchoice);
		word1.setBounds(160, 130, 30, 30);
		cp.add(word1);
		
		minutechoice.add("00");
		minutechoice.add("01");
		minutechoice.add("02");
		minutechoice.add("03");
		minutechoice.add("04");
		minutechoice.add("05");
		minutechoice.add("06");
		minutechoice.add("07");
		minutechoice.add("08");
		minutechoice.add("09");
		minutechoice.add("10");
		minutechoice.add("11");
		minutechoice.add("12");
		minutechoice.add("13");
		minutechoice.add("14");
		minutechoice.add("15");
		minutechoice.add("16");
		minutechoice.add("17");
		minutechoice.add("18");
		minutechoice.add("19");
		minutechoice.add("20");
		minutechoice.add("21");
		minutechoice.add("22");
		minutechoice.add("23");
		minutechoice.add("24");
		minutechoice.add("25");
		minutechoice.add("26");
		minutechoice.add("27");
		minutechoice.add("28");
		minutechoice.add("29");
		minutechoice.add("30");
		minutechoice.add("31");
		minutechoice.add("32");
		minutechoice.add("33");
		minutechoice.add("34");
		minutechoice.add("35");
		minutechoice.add("36");
		minutechoice.add("37");
		minutechoice.add("38");
		minutechoice.add("39");
		minutechoice.add("40");
		minutechoice.add("41");
		minutechoice.add("42");
		minutechoice.add("43");
		minutechoice.add("44");
		minutechoice.add("45");
		minutechoice.add("46");
		minutechoice.add("47");
		minutechoice.add("48");
		minutechoice.add("49");
		minutechoice.add("50");
		minutechoice.add("51");
		minutechoice.add("52");
		minutechoice.add("53");
		minutechoice.add("54");
		minutechoice.add("55");
		minutechoice.add("56");
		minutechoice.add("57");
		minutechoice.add("58");
		minutechoice.add("59");
		minutechoice.setBounds(190,130,50,30);
		minutechoice.addItemListener(this);
		cp.add(minutechoice);
		
		word2.setBounds(250,130,30,30);
		cp.add(word2);
		
		messageJL.setBounds(0, 190, 100, 30);
		cp.add(messageJL);
		
		message.setBounds(110,190,150,30);
		cp.add(message);
		
		other.setBounds(0,230,100,30);
		cp.add(other);
		textarea.setLineWrap(true);//文字過長自動換行
        textarea.setWrapStyleWord(true);//文字過長自動換行
		JScrollPane jsp=new JScrollPane(textarea);
		
		jsp.setBounds(100,230,170,100);
		add(jsp);
		message.add("準時");
		message.add("10分鐘前");
		message.add("30分鐘前");
		
		save.setBounds(40,400,100,50);
		save.addActionListener(this);
		cp.add(save);
		
		cancel.setBounds(150,400,100,50);
		cancel.addActionListener(this);
		cp.add(cancel);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		int minus = 0;
		int messagehour = 0;
		int messageminute = 0;
		String messagehourstring = "";
		String messageminutestring = "";
		if(event.getSource() == save){
			hour = Integer.parseInt(hourchoice.getSelectedItem());
			minute = Integer.parseInt(minutechoice.getSelectedItem());
			try {
			         workfw = new FileWriter(getworknum()+".txt");
			         workfw.write(hourchoice.getSelectedItem()+":"+minutechoice.getSelectedItem()+"\r\n");
			         workfw.write(namefield.getText()+"\r\n");
			         workfw.write(typefield.getText()+"\r\n");
			         workfw.write(textarea.getText()+"\r\n");
			         //要寫入提醒的時間
			         if(message.getSelectedItem() == "準時"){
			        	 minus = 0;
			         }
			         else if(message.getSelectedItem() == "10分鐘前"){
			        	 minus = 10;
			         }
			         else if(message.getSelectedItem() == "30分鐘前"){
			        	 minus = 10;
			         }
			         if(minute - minus >=0){
			        	 messagehour = hour;
			        	 messageminute = (minute - minus);
			        	 if(messagehour<10){
			        		 messagehourstring  = "0"+String.valueOf(messagehour); 
			        	 }
			        	 else{
			        		 messagehourstring = String.valueOf(messagehour);
			        	 }
			        	 if(messageminute<10){
			        		 messageminutestring = "0"+String.valueOf(messageminute);
			        	 }
			        	 else{
			        		 messageminutestring = String.valueOf(messageminute);
			        	 }
			        	 
			        	 
			         }
			         else{
			        	 messagehour = hour-1;
			        	 messageminute = (minute-minus+60);
			        	 if(messagehour<10){
			        		 messagehourstring = "0"+String.valueOf(messagehour);
			        	 }
			        	 else{
			        		 messagehourstring = String.valueOf(messagehour);
			        	 }
			        	 if(messageminute<10){
			        		 messageminutestring = "0"+String.valueOf(messageminute);
			        	 }
			        	 else{
			        		 messageminutestring = String.valueOf(messageminute);
			        	 }
			         }
			         workfw.write(messagehourstring+":"+messageminutestring+"\r\n");
			         workfw.write(message.getSelectedItem());
			         workfw.close();
			         namefield.setText("");
			         typefield.setText("");
			     }catch(IOException e){
			         e.printStackTrace();
			     }
			
			Interface1 i1 = new Interface1();
		}
		if(event.getSource() == cancel){
			setVisible(false);
			Interface1 i2 = new Interface1();
		}
		
	}
	public String getworknum(){
		int w;
		String wn = "";
		 try {
	         char buffer[] = new char[1024];
	         numfr= new FileReader("worknum.txt");
	         int len = numfr.read(buffer);
	         String s = new String(buffer,0,len);
	         int i = Integer.parseInt(s);
	         w = i+1;
	         numfr.close();
	         try {
		         
	        	 numfw = new FileWriter("worknum.txt");
	        	 wn = Integer.toString(w); 
		         numfw.write(wn);
		         numfw.close();
		         
		     }catch(IOException e){
		         e.printStackTrace();
		     }
	     }catch(IOException e){
	         e.printStackTrace();
	     }
		 setVisible(false);
		 
		 return(wn);
	        
	}
	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		
	}
}
