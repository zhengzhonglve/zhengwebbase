package zheng.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import zheng.action.admin.SupervisorAction;

/**
 * 
 * @author zheng
 *	常用排序算法（冒泡排序）
 */
public class Sort {
	public static Log log = LogFactory.getLog(Sort.class);
	public int[] oriarray = {1,9,2,8,4,6,5,3,7};
	
	/**
	 * 打印数组方法
	 * @param oriarray
	 */
	public void printArray(int[] oriarray){
		if(oriarray == null){
			System.out.println("数组为空！");
		}else{
			for(int i=0;i<oriarray.length;i++){
				if(i == oriarray.length-1){
					System.out.print(oriarray[i]);
					System.out.println();
				}else{
					System.out.print(oriarray[i]+",");
				}
				
			}
		}
	}
	
	/**
	 * 1.冒泡排序算法
	 */
	
	public void bubbleSort(int[] oriarray){
		if(oriarray == null){
			log.info("传入的数组为空!");
			return;
		}
		if(oriarray.length==0 || oriarray.length == 1){
			return;
		}else if(oriarray.length >1){
			for(int i=0;i<oriarray.length-1;i++){
				for(int j=i+1;j<oriarray.length;j++){
					if(oriarray[i]>oriarray[j]){
						int temp = oriarray[i];
						oriarray[i] = oriarray[j];
						oriarray[j] = temp;
					}
				}
			}
		}
	}
	/**
	 * 测试冒泡排序
	 */
	@Test
	public void testBubbleSort(){
		printArray(oriarray);
		bubbleSort(oriarray);
		printArray(oriarray);
	}
	
	/**
	 * 2.简单选择排序（不稳定排序）
	 * @param oriarray
	 */
	public void selectionSort(int[] oriarray){
		if(oriarray == null){
			log.info("传入的数组为空!");
			return;
		}
		if(oriarray.length==0 || oriarray.length == 1){
			return;
		}else if(oriarray.length >1){
			for(int i=0;i<oriarray.length-1;i++){
				for(int j=i+1;j<oriarray.length;j++){
					if(oriarray[i]>oriarray[j]){
						int temp = oriarray[i];
						oriarray[i] = oriarray[j];
						oriarray[j] = temp;
					}
				}
				printArray(oriarray);
			}
		}
	}
	/**
	 * 测试选择排序
	 */
	@Test
	public void testSelectionSort(){
		printArray(oriarray);
		selectionSort(oriarray);
		printArray(oriarray);
	}
	
	/**
	 * 3.直接插入排序(稳定排序，数据基本有序时使用)
	 * 算法思想：把数组从第一个开始当成一个有序的数组，后面的每一个数插入到前面的数组中
	 * (1).找到要插入的index
	 * (2).执行插入操作
	 * @param oriarray
	 */
	public void insertSort(int[] oriarray){
		if(oriarray == null){
			log.info("传入的数组为空!");
			return;
		}
		if(oriarray.length==0 || oriarray.length == 1){
			return;
		}else if(oriarray.length >1){
			int temp = 0;
			int insertindex = 0;
			for(int i=1;i<oriarray.length;i++){
				if(oriarray[i]<oriarray[i-1]){
					insertindex = i;//要插入的索引
					temp = oriarray[i];
					int j = i-1;
					while(j>=0 && temp < oriarray[j]){
						insertindex = j;
						oriarray[j+1] = oriarray[j];
						j--;
					}
					oriarray[insertindex] = temp;
				}
			}
		}
	}
	/**
	 * 测试直接插入排序
	 */
	@Test
	public void testInsertSort(){
		printArray(oriarray);
		insertSort(oriarray);
		printArray(oriarray);
	}
	/**
	 * 4.希尔排序（不稳定）
	 * 思想是 缩小增量排序，先定义一个增量gap,序列中间隔gap的分为一组进行插入排序
	 * 逐渐缩小增量直到为1
	 * (1).构造步长
	 * (2).构造数组
	 * (3).插入排序
	 * @param oriarray
	 */
	public void shellSort(int[] oriarray){
		if(oriarray == null){
			log.info("传入的数组为空!");
			return;
		}
		if(oriarray.length==0 || oriarray.length == 1){
			return;
		}
		for(int gap=oriarray.length/2;gap>0;gap/=2){//步长
			for(int i=0;i<gap;i++){//分组
				//每组直接插入排序
				for(int j=i+gap;j<oriarray.length;j+=gap){
					if(oriarray[j]<oriarray[j-gap]){
						int temp = oriarray[j];
						int index = j;
						int k = j-gap;
						while(k>=0 && temp<oriarray[k]){
							index = k;
							oriarray[k+gap] = oriarray[k];
							k = k-gap;
						}
						oriarray[index] = temp;
					}
				}
			}
		}
	}
	/**
	 * 优化希尔排序（不稳定）
	 * 
	 * @param oriarray
	 */
	public void optimizeShellSort(int[] oriarray){
		if(oriarray == null){
			log.info("传入的数组为空!");
			return;
		}
		if(oriarray.length==0 || oriarray.length == 1){
			return;
		}
		for(int gap=oriarray.length/2;gap>0;gap/=2){
			for(int i = gap;i<oriarray.length;i++){//从gap开始插入排序
				if(oriarray[i]<oriarray[i-gap]){
					int temp = oriarray[i];
					int index = i;
					int j = i-gap;
					while(j>=0 && temp<oriarray[j]){
						index = j;
						oriarray[j+gap] = oriarray[j];
						j = j-gap;
					}
					oriarray[index] = temp;
				}
			}
		}
	}
	
	/**
	 * 测试希尔排序
	 */
	@Test
	public void testShellSort(){
		printArray(oriarray);
		shellSort(oriarray);
		printArray(oriarray);
	}
	
	/**
	 * 快速排序（不稳定）
	 * 选择数组的第一个数，进行一次快速排序，让左边的都比这个数小，右边的都比这个数大，然后两边的数组分别再进行快排
	 * 具体解决方案，第一个数为temp值为array[0],两个变量为low=0,high=array[length-1],先从high向前，找到第一个比temp小的然后互换位置没找到high--，
	 * 然后从前往后找到第一个比temp大的互换位置，若没找到则low++,知道low>high
	 * @param oriarray
	 */
	public void quickSort(int[] oriarray,int low,int high){
		if(oriarray == null){
			log.info("传入的数组为空!");
			return;
		}
		if(oriarray.length==0 || oriarray.length == 1){
			return;
		}
		if(low>=high){
			return;
		}
		int l = low;
		int h = high;
		int povit = oriarray[low];
		while(low<high){
			while(low<high && oriarray[high]>povit)
				high--;
			if(low<high){
				int temp = oriarray[low];
				oriarray[low] = oriarray[high];
				oriarray[high] = temp;
			}
			while(low<high && oriarray[low]<povit)
				low++;
			if(low<high){
				int temp = oriarray[low];
				oriarray[low] = oriarray[high];
				oriarray[high] = temp;
			}
		}
		quickSort(oriarray,l,low-1);
		quickSort(oriarray,low+1,h);
	}
	
	@Test
	public void testQuickSort(){
		printArray(oriarray);
		quickSort(oriarray,0,oriarray.length-1);
		printArray(oriarray);
	}
	
}
