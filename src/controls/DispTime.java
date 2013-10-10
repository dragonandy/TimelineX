package controls;

import javax.swing.JLabel;

import modles.Timeline;

public class DispTime extends Thread {

	JLabel time;
	public DispTime(JLabel t){
		time = t;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				time.setText(formatTime(Timeline.getTimeline().getCurrTime()));
				sleep(50);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String formatTime(long t) {
		StringBuilder time = new StringBuilder();
		time.append("00:");
		//获得分钟
		if (t/60000 > 9) {
			time.append(t/60000).append(":");
		}else {
			time.append("0").append(t/60000).append(":");
		}
		//获得秒
		if (t%60000/1000 > 9) {
			time.append(t%60000/1000).append(",");
		}else {
			time.append("0").append(t%60000/1000).append(",");
		}
		//获得毫秒
		if (t%1000 > 99) {
			time.append(t%1000);
		}else if (t%1000 > 9) {
			time.append("0").append(t%1000);
		}else {
			time.append("00").append(t%1000);
		}
		return time.toString();
	}
}
