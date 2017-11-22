package finalproject2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class message extends JFrame implements ActionListener{
	Container cp=getContentPane();
	JButton close = new JButton("確認");
	JButton delay = new JButton("延後(5分鐘)");
	int file = 0;
	int worknum = 0;
	File clip = new File("music.wav");
	sound music = new sound(clip);
	
	message(int a){
		
		file = a;
		setTitle("message");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		
		String time = "";
		String name = "";
		String type = "";
		String remark = "";
		
		try {
	         FileReader fr= new FileReader(a+".txt");
	         BufferedReader BufferedStream=new BufferedReader(fr);
	         time = BufferedStream.readLine();
	         name = BufferedStream.readLine();
	         type = BufferedStream.readLine();
	         remark = BufferedStream.readLine();
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
		typeJL.setBounds(10,90,100,30);
		cp.add(typeJL);
		
		JLabel remarkJL = new JLabel("備註  : ");
		remarkJL.setBounds(10,130,100,30);
		cp.add(remarkJL);
		
		JTextPane jtp = new JTextPane();
		jtp.setText(remark);
		JScrollPane jsp=new JScrollPane(jtp);
		jsp.setBounds(60,130,200,100);
		cp.add(jsp);
		
		close.setBounds(10,240,100,50);
		close.addActionListener(this);
		cp.add(close);
		
		delay.setBounds(120,240,200,50);
		delay.addActionListener(this);
		cp.add(delay);
		
		//要讀有幾個工作量
	     try {
	         char buffer[] = new char[1024];
	         FileReader fr = new FileReader("worknum.txt");
	         int len = fr.read(buffer);
	         String m = new String(buffer,0,len);
	         worknum = Integer.parseInt(m);
	         fr.close();
	     }catch(IOException e){
	         e.printStackTrace();
	     }	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == close){
			setVisible(false);
			deletenumber(file);
			Interface1 i1 = new Interface1();
			music.stopmusic();
		}
		if(e.getSource()== delay){
			setVisible(false);
			edittime(file);
			Interface1 i1 = new Interface1();
		}
	}
	public void deletenumber(int b){
		//刪除該檔案  直接將檔案寫入前一個 刪掉最後一個即可
		try {
	         FileWriter workf = new FileWriter("worknum.txt");
	         //System.out.println("worknumberr"+(worknum-1));
	         workf.write(Integer.toString(worknum-1));
	         workf.close();
	     }catch(IOException e){
	         e.printStackTrace();
	     }
		for(int i=(file+1);i<=worknum;i++){
			try {
		         char buffer[] = new char[1024];
		         FileReader fr = new FileReader(i+".txt");
		         int len = fr.read(buffer);
		         String workk = new String(buffer,0,len);
		         fr.close();
		         try {
			         FileWriter workfw = new FileWriter((i-1)+".txt");
			         workfw.write(workk);
			         workfw.close();
			     }catch(IOException e){
			         e.printStackTrace();
			     }
		     }catch(IOException e){
		         e.printStackTrace();
		     }	
		}
		try {
		java.io.File myDelFile = new java.io.File(worknum+".txt");
		myDelFile.delete();
		 }
		catch(Exception e) {
		System.out.println("刪除檔操作出錯");
		e.printStackTrace();
		}
	}
	public void edittime(int c){
		String hour = "";
		String minute = "";
		String w1 = "";
		String w2 = "";
		String w3 = "";
		String w4 = "";
		String w5 = "";
		String w6 = "";
		int hournum = 0;
		int minutenum= 0;
		int editminute = 0;
		int edithour = 0;
		String hourstring = "";
		String minutestring = "";
		try {// 先讀入原本的時間 修改後再寫入
	         //char buffer[] = new char[1024];
	         FileReader fr= new FileReader(c+".txt");
	         BufferedReader BufferedStream=new BufferedReader(fr);
	         w1 = BufferedStream.readLine();
	         w2 = BufferedStream.readLine();
	         w3 = BufferedStream.readLine();
	         w4 = BufferedStream.readLine();
	         w5 = BufferedStream.readLine();
	         w6 = BufferedStream.readLine();
	         hour  = w5.substring(0,2);
	         minute = w5.substring(3);
	         hournum = Integer.parseInt(hour);
	         minutenum = Integer.parseInt(minute);
	         editminute = minutenum+5;
	         if(editminute<10){
	        	 minutestring ="0" + String.valueOf(editminute);
	        	 if(hournum<10){
	        		 hourstring  = "0" + String.valueOf(hournum);
	        	 }
	        	 else{
	        		 hourstring = String.valueOf(hournum);
	        	 }
	         }
	         else if(editminute>=60){
	        	 edithour = hournum+1;
	        	 editminute = editminute - 60;
	        	 if(edithour<10){
	        		 hourstring = "0" + String.valueOf(edithour);
	        	 }
	        	 else{
	        		 hourstring = String.valueOf(edithour);
	        	 }
	        	 if(editminute<10){
	        		 minutestring = "0"+ String.valueOf(editminute);
	        	 }
	        	 else{
	        		 minutestring = String.valueOf(editminute);
	        	 }
	         }
	         else{
	        	 minutestring = String.valueOf(editminute);
	        	 if(hournum<10){
	        		 hourstring = "0" + String.valueOf(hournum);
	        	 }
	        	 else{
	        		 hourstring = String.valueOf(hournum);
	        	 }
	         }
	         fr.close();
		     }catch(IOException e){
		         e.printStackTrace();
		     }	
		try {
	         FileWriter workfw = new FileWriter(c+".txt");
	         workfw.write(w1+"\r\n");
	         workfw.write(w2+"\r\n");
	         workfw.write(w3+"\r\n");
	         workfw.write(w4+"\r\n");
	         workfw.write(hourstring+":"+minutestring+"\r\n");
	         workfw.write(w6);
	         //要寫入提醒的時間
	         workfw.close();
	        }catch(IOException e){
	         e.printStackTrace();
	     }
	}
	public void getworknum(){
		try {
	         char buffer[] = new char[1024];
	         FileReader fr = new FileReader("worknum.txt");
	         int len = fr.read(buffer);
	         String m = new String(buffer,0,len);
	         worknum = Integer.parseInt(m);
	         fr.close();
	     }catch(IOException e){
	         e.printStackTrace();
	     }	
	}
}


