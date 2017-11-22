package finalproject2;

import java.awt.BorderLayout;



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.text.DefaultStyledDocument;

public class Interface1 extends JFrame implements  ActionListener {
	JPanel timeJP = new JPanel();
	JLabel timeJL = new JLabel();
	Timer countingTimer = new Timer();
	Timer countintTimer1 = new Timer();
	Timer countingTimer2 = new Timer();
	Container cp=getContentPane();
	JLabel btnJL  = new JLabel();
	JButton add= new JButton("新增事項");
	JButton del = new JButton("刪除事項");
	JButton edi = new JButton("編輯事項");
	JLabel memor = new JLabel("備註",JLabel.CENTER);
	JButton[] workJB = new JButton[20];
	JTextArea textarea = new JTextArea();
	JTextPane textpane = new JTextPane();
	JTextArea test1 = new JTextArea(); 
	ImageIcon test = new ImageIcon("Enemy.png");
    JLabel work = new JLabel("今日事項",JLabel.CENTER);
    JButton save = new JButton("儲存");
    FileWriter memorfw;
    FileWriter workfw;
    FileWriter workf;
    FileReader memorfr;
    int worknum = 0;
    double []hourorder = new double [100];
    double []minuteorder = new double [100];
    double []workorder = new double[100];
    double []workorder2 = new double[100];
    boolean delete = false;
    boolean edit = false;
    int []order = new int[100];
    int deletenum[] = new int[20];
    JPanel workJP = new JPanel();
    FlowLayout FL = new FlowLayout();
    String workthing2;
    int deletetime = 0;
    String s;
    int wnum = 0;
    Interface1(){
		setTitle("Calender");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		cp.setLayout(null);
		
		SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String sdate = nowdate.format(new java.util.Date());
		//System.out.print("目前時間"+sdate);
		timeJL.setBounds(0, 0, 200, 100);
		timeJL.setText(sdate);
		cp.add(timeJL);
		
		add.setBounds(600,0,100,50);
		add.addActionListener(this);
		del.setBounds(600,50,100,50);
		del.addActionListener(this);
		edi.setBounds(600,100,100,50);
		edi.addActionListener(this);
		add(add);
		add(del);
		add(edi);
		cp.add(btnJL);
		
		memor.setBounds(0, 100, 100, 50);
		try {
	         char buffer[] = new char[1024];
	         memorfr= new FileReader("memorfw.txt");
	         int len = memorfr.read(buffer);
	         s = new String(buffer,0,len);
	         memorfr.close();
	     }catch(IOException e){
	         e.printStackTrace();
	     }
		textarea.setLineWrap(true);//文字過長自動換行
        textarea.setWrapStyleWord(true);//文字過長自動換行
		textarea.setText(s);
		
		JScrollPane jsp=new JScrollPane(textarea);
		jsp.setBounds(0,150,200,300);
		cp.add(jsp);
		cp.add(memor);
		
		work.setBounds(200,0,400,100);
		cp.add(work);
		
		save.setBounds(100,100,100,50);
		save.addActionListener(this);
		cp.add(save);
		
		countingTimer.schedule(new setTime(), 0, 1000);
		countingTimer2.schedule(new checktime(),0,60*1000);
		
		try {
	         workfw = new FileWriter("workfw.txt");
	         workfw.write("no");
	         workfw.close();
	     }catch(IOException e){
	         e.printStackTrace();
	     }
		
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
	     
	     workorder();
	     addwork();
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
	class setTime extends TimerTask {
		@Override
	    public void run() {
	    	SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			String sdate = nowdate.format(new java.util.Date());
			timeJL.setText("目前時間"+sdate);
	    }

	}
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		getworknum();
		if(event.getSource() == save){
			try {
				 JOptionPane.showMessageDialog(this, "已儲存");
				 memorfw = new FileWriter("memorfw.txt");
		         memorfw.write(textarea.getText());
		         memorfw.close();
		     }catch(IOException e){
		         e.printStackTrace();
		     }
		}
		if(event.getSource() == add){
			add add = new add();
			setVisible(false);
			stop();
			removeAll();
			wnum++;//每按一次工作量+1
		}
		
		if(event.getSource() == del){
			delete = true;
			JOptionPane.showMessageDialog(this, "請點選要刪除的事項");
			//System.out.print("del");
			deletetime++;
		}
		if(event.getSource() == edi){
			edit = true;
			JOptionPane.showMessageDialog(this, "請點選要編輯的事項");
		}
		for(int i=0;i<(worknum);i++){
			if(event.getSource() == workJB[i] ){
				if(delete && !edit){
					delete = false;	
					deletenumber(order[i]+1);//傳入的是檔案名稱，這是在處理檔案問題 與按鈕獨立
					resetbutton(i);//傳入的是按鈕
					worknum--;
					//刪除該檔案，並將工作數減一，在將其後面的檔案名稱都減一
					workorder();
				}
				else if(edit && !delete){
					edit e = new edit(order[i]+1);
					//傳入檔案
					setVisible(false);
					stop();
					edit = false;
				}
				else{
					moreinformation mi = new moreinformation(order[i]+1);
				}
			}
		}
	}
	
	class checktime extends TimerTask {
		@Override
	    public void run() {
	    	java.util.Date i = new java.util.Date();
	    	// 取的電腦內部的年、月、日、星期、時、分、秒
	    	String hour = "";
	    	String minute = "";
	    	int hournum=0;
	    	int minutenum = 0;
			int Year = i.getYear()+1900;
			int Month = i.getMonth()+1;
			int Day = i.getDate();
			int WeekDay = i.getDay();
			int Hour = i.getHours();
			int Minute = i.getMinutes();
			int Second = i.getSeconds();
			getworknum();
			for(int j=1;j<=(worknum);j++){
				try {
			         FileReader fr= new FileReader(j+".txt");
			         BufferedReader BufferedStream=new BufferedReader(fr);
			         String w1 = BufferedStream.readLine();
			         String w2 = BufferedStream.readLine();
			         String w3 = BufferedStream.readLine();
			         String w4 = BufferedStream.readLine();
			         String w5 = BufferedStream.readLine();
			         
			         hour  = w5.substring(0,2);
			         minute = w5.substring(3);
			         
			         hournum = Integer.parseInt(hour);
			         minutenum = Integer.parseInt(minute);
			         fr.close();
				     }catch(IOException e){
				         e.printStackTrace();
				     }	
				if(Hour == hournum && Minute == minutenum){
					message message = new message(j);
					setVisible(false);
					stop();
				}
			}
	    }
	}
	public void addwork(){
		String workthing = "";
		for(int i=0;i<worknum;i++){
			workJB[i] = new JButton();
			int num = order[i]+1;
			try {
				 int filename = i+1;//檔案名稱
		         //char buffer[] = new char[1024];
		         FileReader fr= new FileReader(num+".txt");
		         BufferedReader BufferedStream=new BufferedReader(fr);
		         workthing=BufferedStream.readLine();
		         workthing2 = BufferedStream.readLine();
		         fr.close();
		     }catch(IOException e){
		         e.printStackTrace();
		     }
			int y=(100)*i;
			workJB[i].setText(workthing+" "+workthing2);
			workJB[i].setSize(400,100);
			workJB[i].addActionListener(this);
			GridLayout GL= new GridLayout(20,1);
			workJP.setLayout(GL);
			workJP.add(workJB[i]);
		}
		JScrollPane jsp2=new JScrollPane(workJP);
		jsp2.setBounds(200,100,400,500);
		jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		cp.add(jsp2);
	}
	
	public void deletenumber(int b){
		//刪除該檔案  直接將檔案寫入前一個 刪掉最後一個即可
		try {
	         workf = new FileWriter("worknum.txt");
	         workf.write(Integer.toString(worknum-1));
	         workf.close();
	     }catch(IOException e){
	         e.printStackTrace();
	     }
		for(int i=(b+1);i<=worknum;i++){
			try {
		         char buffer[] = new char[1024];
		         FileReader fr = new FileReader(i+".txt");
		         int len = fr.read(buffer);
		         String workk = new String(buffer,0,len);
		         fr.close();
		         try {
			         workfw = new FileWriter((i-1)+".txt");
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
	public void resetbutton(int n){
		getworknum();//記得要處理刪掉案你的事
		for(int i=n;i<worknum;i++){
			workJB[i].setText(workJB[i+1].getText());
		}
		workJP.remove(workJB[worknum]);
		workJP.repaint();
		workorder();
	}
	
	public void workorder(){
		String data = "";
		for(int i=0;i<worknum;i++){
			//讀檔案的第一行，存進矩陣 比較大小
			//將檔案名稱排好存進矩陣 讀檔照那個順序
			try {
		         //char buffer[] = new char[1024];
		         FileReader fr= new FileReader((i+1)+".txt");
		         BufferedReader BufferedStream=new BufferedReader(fr);
		         data=BufferedStream.readLine();
		         double hour = Double.parseDouble(data.substring(0,2));
		         hourorder[i] = hour;//活動1的小時儲存於hourorder[0]
		         double minute = Double.parseDouble(data.substring(3));
		         minuteorder[i] = minute;//活動1的分鐘儲存於minuteorder[0]
		         workorder[i] = hourorder[i] + (minuteorder[i]/60);
		         fr.close();
		         
		     }catch(IOException e){
		         e.printStackTrace();
		     }
		}
		//接著要比較workorder的大小(使用LINKLIST)
		//印出矩陣順序，便是讀檔順序
		for(int i=0;i<worknum;i++){
			workorder2[i] = workorder[i]; //原本的
		}
		List<Double> dataList2 = new ArrayList<Double>();
		for (int i = 0; i < worknum; i++)
        {
            dataList2.add(i,workorder2[i]);//把原本的變成linklisted的形式
        }
		double temp;
		for(int j=1;j<worknum;j++){
			for(int k=worknum-1;k>=1;k--){
				if(workorder[k]<workorder[k-1]){
					temp = workorder[k];
					workorder[k] = workorder[k-1];
					workorder[k-1] = temp;
				}
			}
		}
		for(int i=0;i<worknum;i++){
				order[i]= dataList2.indexOf(workorder[i]);//在dataList2中找數字，問題是datalist2中會有數字重複，只會找第一個，所以是要對datalist2做處理，讓他不要一直找相同的數字
				//先判斷那個datalist2的值有沒有被找到過，也就是index值有沒有被用過
				dataList2.set(order[i],(dataList2.get(order[i])+(0.0000001)*(i+1))) ;
				//重新設定使用過的數字 加上一個極小的數字改變值又不會影響大小
		}
	}
	
	public void stop(){
		countingTimer.cancel();
		countingTimer2.cancel();
		System.out.println("時間取消");
	}
}
