package com.bigwang.web.timing;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import static org.quartz.SimpleScheduleBuilder.*;

/**
 * pom
 * <!--quartz定时框架  -->
	<dependency>
      <groupId>org.quartz-scheduler</groupId>
      <artifactId>quartz</artifactId>
      <version>2.2.1</version>
	</dependency>
	<dependency>
  		<groupId>org.quartz-scheduler</groupId>
	  	<artifactId>quartz-jobs</artifactId>
	  	<version>2.2.1</version>
	</dependency>   
*/        
/**
 * http://www.quartz-scheduler.org/
 * 
 * @description:Quartz定时 不需要配置xml
 * @author: lw
 * @date : 2018年3月26日
 */
public class QuartzJob implements org.quartz.Job {


	  public void execute(JobExecutionContext context) throws JobExecutionException {
	      System.err.println("Hello World!  MyJob is executing.");
	  }
	      
		public  static void main(String [] args) throws SchedulerException{
		
		  // Grab the Scheduler instance from the Factory
		  Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		  // and start it off
//		  scheduler.start();
		  
		  // define the job and tie it to our MyJob class
		  JobDetail job = newJob(QuartzJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(simpleSchedule()
		              .withIntervalInSeconds(40)
		              .repeatForever())
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		}

}
