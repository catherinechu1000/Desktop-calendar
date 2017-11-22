package finalproject2;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class moreinformation extends JFrame {
	Container cp=getContentPane();
	moreinformation(int a){
		setTitle("more information");
		setSize(300, 500);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		String time = "";
		String name = "";
		String type = "";
		String remark = "";
		String remindtime = "";
		String remindstring = "";
		try {
	         FileReader fr= new FileReader(a+".txt");
	         BufferedReader BufferedStream=new BufferedReader(fr);
	         time = BufferedStream.readLine();
	         name = BufferedStream.readLine();
	         type = BufferedStream.readLine();
	         remark = BufferedStream.readLine();
	         remindtime = BufferedStream.readLine();
	         remindstring = BufferedStream.readLine();
		     if(remark == null){
		    	 remark = "無";
		     }
		     fr.close();
		     System.out.println("testing" + time +" " +  name + " " + type + " " + remark);
		     }catch(IOException e){
		         e.printStackTrace();
		     }	
		JLabel timeJL = new JLabel("時間 : " + time);  
		timeJL.setBounds(10,10,100,30);
		cp.add(timeJL);
		
		JLabel nameJL = new JLabel("事件名稱  : " + name);
		nameJL.setBounds(10,50,200,30);
		cp.add(nameJL);
		
		JLabel typeJL = new JLabel("事件類型  : " + type);
		typeJL.setBounds(10,90,200,30);
		cp.add(typeJL);
		
		JLabel remind = new JLabel("提醒 : "+ remindstring);
		remind.setBounds(10,130,200,30);
		cp.add(remind);
		
		JLabel remarkJL = new JLabel("備註  : ");
		remarkJL.setBounds(10,170,100,30);
		cp.add(remarkJL);
		
		JTextPane jtp = new JTextPane();
		jtp.setText(remark);
		jtp.setEditable(false);
		JScrollPane jsp=new JScrollPane(jtp);
		jsp.setBounds(60,170,200,100);
		cp.add(jsp);
		
	}
}
