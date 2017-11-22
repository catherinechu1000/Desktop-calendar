package finalproject2;

import java.awt.Choice;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class edit extends JFrame implements ActionListener, ItemListener{
	JLabel nameJL = new JLabel("事件名稱");
	JLabel typeJL = new JLabel("事件類型");
	JLabel timeJL = new JLabel("時間");
	JLabel otherJL = new JLabel("備註");
	JLabel word1JL = new JLabel("時");
	JLabel word2JL = new JLabel("分");
	JLabel messageJL = new JLabel("提醒");
	Container cp=getContentPane();
	String name = "";
	String type = "";
	String remark = "";
	String hour = "";
	String minute = "";
	String message = "";
	String messagetime = "";
	int file = 0;
	Choice hourchoice = new Choice();
	Choice minutechoice = new Choice();
	Choice messagechoice = new Choice();
	JButton save = new JButton("儲存");
	JButton cancel = new JButton("取消");
	JCheckBox imp = new JCheckBox();
	JTextField namefield = new JTextField();
 	JTextField typefield = new JTextField();
 	JTextArea textarea =new JTextArea();
	edit(int a){
		file = a;
		setTitle("edit");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
	         FileReader fr= new FileReader(a+".txt");
	         BufferedReader BufferedStream=new BufferedReader(fr);
	         String time = BufferedStream.readLine();
	         hour = time.substring(0, 2);//hour是原本的時間
	         minute = time.substring(3);
	         name = BufferedStream.readLine();
	         type = BufferedStream.readLine();
	         remark = BufferedStream.readLine();
	         messagetime = BufferedStream.readLine();
	         message  = BufferedStream.readLine();
	         namefield.setText(name);
	         typefield.setText(type);
	         textarea.setText(remark);
		     if(remark == null){
		    	 remark = "無";
		     }
		     fr.close();
		     System.out.println("testing" + time +" " +  name + " " + type + " " + remark);
		     }catch(IOException e){
		         e.printStackTrace();
		     }	
		setLayout(null);
		nameJL.setBounds(0, 10, 100, 30);
		cp.add(nameJL);
		namefield.setBounds(100,10,180,30);
		cp.add(namefield);
		
		typeJL.setBounds(0, 70, 100, 30);
		cp.add(typeJL);
		typefield.setBounds(100,70,180,30);
		cp.add(typefield);
		
		timeJL.setBounds(0, 130, 100, 30);
		cp.add(timeJL);
		
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
		word1JL.setBounds(160, 130, 30, 30);
		cp.add(word1JL);
		
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
		
		word2JL.setBounds(250,130,30,30);
		cp.add(word2JL);
		
		messageJL.setBounds(0, 190, 100, 30);
		cp.add(messageJL);
		
		messagechoice.setBounds(110,190,150,30);
		cp.add(messagechoice);
		
		otherJL.setBounds(0,230,100,30);
		cp.add(otherJL);
		textarea.setLineWrap(true);//文字過長自動換行
        textarea.setWrapStyleWord(true);//文字過長自動換行
		JScrollPane jsp=new JScrollPane(textarea);
		
		jsp.setBounds(100,230,170,100);
		add(jsp);
		messagechoice.add("準時");
		messagechoice.add("10分鐘前");
		messagechoice.add("30分鐘前");
		
		hourchoice.select(hour);
		minutechoice.select(minute);
		messagechoice.select(message);
		System.out.println(message);
	
		save.setBounds(40,400,100,50);
		save.addActionListener(this);
		cp.add(save);
		
		cancel.setBounds(150,400,100,50);
		cancel.addActionListener(this);
		cp.add(cancel);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		int minus = 0;
		int minuteint = 0;
		int hourint = 0;
		int messagehour = 0;
		int messageminute = 0;
		String messagehourstring = "";
		String messageminutestring = "";
		if(event.getSource() == save){
			hour =hourchoice.getSelectedItem();
			minute =minutechoice.getSelectedItem();
			if(messagechoice.getSelectedItem() == "準時"){
				minus = 0;
			}
			else if (messagechoice.getSelectedItem() == "10分鐘前"){
				minus = 10;
			}
			else if (messagechoice.getSelectedItem() == "30分鐘前"){
				minus = 30;
			}
			minuteint = Integer.parseInt(minute);
			hourint = Integer.parseInt(hour);
			if(minuteint - minus >=0){
	        	 messagehour = hourint;
	        	 messageminute = (minuteint - minus);
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
	        	 messagehour = hourint-1;
	        	 messageminute = (minuteint-minus+60);
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
			try {
			         FileWriter workfw = new FileWriter(file+".txt");
			         workfw.write(hourchoice.getSelectedItem()+":"+minutechoice.getSelectedItem()+"\r\n");
			         workfw.write(namefield.getText()+"\r\n");
			         workfw.write(typefield.getText()+"\r\n");
			         workfw.write(textarea.getText()+"\r\n");
			         workfw.write(messagehourstring+":"+messageminutestring+"\r\n");
			         workfw.write(messagechoice.getSelectedItem());
			         workfw.close();
			         namefield.setText("");
			         typefield.setText("");
			     }catch(IOException e){
			         e.printStackTrace();
			     }
			setVisible(false);
			Interface1 i1 = new Interface1();
		}
		if(event.getSource() == cancel){
			setVisible(false);
			Interface1 i2 = new Interface1(); 
		}
	}
}
