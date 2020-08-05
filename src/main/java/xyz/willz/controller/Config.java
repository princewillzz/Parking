package xyz.willz.controller;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Config implements ServletContextListener, Runnable {
	
	 public void contextInitialized(ServletContextEvent event) {
	        // Webapp startup.
		 System.out.println("Event ran");
		 Config obj = new Config();
		 
		 Thread t = new Thread(obj);
		 
		 t.start();
		 
		 for(int i = 0; i < 1000; i++) {
			 System.out.println("Moved ahead");
		 }
		 
		 
	 }

    public void contextDestroyed(ServletContextEvent event) {
        // Webapp shutdown.
    	System.out.println("Event shutdown");
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		final Timer timer = new Timer();
		timer.schedule( new TimerTask()
		{
		    private int i = 10;
		    public void run()
		    {
		        System.out.println("30 Seconds Later");
		        if (--i < 1) timer.cancel(); // Count down ten times, then cancel
		    }
		}, 30000, 30000 //Note the second argument for repetition
		);
		
		try {int i = 0;
			while(i++ < 5) {
				try {
					System.out.println("In Thread");
					Thread.sleep(1000);;
					
				} catch(Exception e) {
					System.out.println("Exception: " + e);
				}
			}
		}catch(Exception e) {
			System.out.println("Exception in thread");
		}
		System.out.println("Finished thread");
		
	}

}
