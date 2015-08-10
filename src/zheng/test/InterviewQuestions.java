package zheng.test;

import org.junit.Test;

public class InterviewQuestions {
	/**
	 * 一个二维数组array,每一行、每一列都是按照从小到大顺序排列，输入一个数组，判断数组中是否存在该数
	 * 1  2  8   9
	 * 2  4  9   12
	 * 4  7  10  13
	 * 6  8  11  15
	 * 解决方案：(可以从右上角和左下角开始)从最后一列开始比较，如果比传入的数字大就排除这一列，然后倒数第二列，如果比传入的数字小则排除此行，然后向下一行移动
	 * @param array
	 * @param num
	 * @return
	 */
	public boolean isContains(int array[][],int num){
		/*先校验*/
		if(array == null){
			return false;
		}
		if(array.length==0){
			return false;
		}
		if(array[0] == null){
			return false;
		}
		if(array[0].length == 0){
			return false;
		}
		int row = 0;
		int col = array[0].length -1;
		while(row<array.length && col>0){
			if(array[row][col]==num){
				return true;
			}else if(array[row][col]>num){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
	@Test
	public void testIsContains(){
		int array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int num = 3;
		System.out.println(isContains(array,num));
	}
}
