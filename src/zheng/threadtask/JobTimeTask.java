package zheng.threadtask;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class JobTimeTask extends QuartzJobBean {
	private static Log log = LogFactory.getLog(JobTimeTask.class);
	private static boolean isRunning = false;

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		//开始时间（用于计算任务执行时间）
		long start = System.currentTimeMillis();  
		try{
			if(!isRunning){
				isRunning = true;
				System.out.println("实时任务");
				isRunning = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			log.info("用时："+(System.currentTimeMillis()-start)+"毫秒"
					+"SystemMemery:freeMemory"+Runtime.getRuntime().freeMemory()+"-------maxMemory"+Runtime.getRuntime().maxMemory()+"-------totalMemory"+Runtime.getRuntime().totalMemory());
		}
	}

}
