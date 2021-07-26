package com.lvpf.cloudeureka.listen;


import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class TestEvent {


	public void listen(EurekaInstanceCanceledEvent event){
		//发邮件 短信
		System.out.println("下线：" + event.getServerId());
	}

	public static void main(String[] args) {
		Timer timer = new Timer("w");
		TimerTask t = new TimerTask() {
			@Override
			public void run() {
				System.out.println("ss");
			}
		};
		new Timer().schedule(t,1);
	}
}
