package com.sumu.demo;

/**
 * 八皇后问题
 * 
 * @author sumu
 *
 */
public class EightQueen {
	public int sum = 0;// 总共有多少总方式
	private static final int MAX_QUEEN = 8;
	private int[] cols = new int[MAX_QUEEN];// 用来记录8列皇后的位置

	public void getEightQueenCount() {
		getEightQueenCount(0);
	}

	public void getEightQueenCount(int n) {
		boolean[] flags = new boolean[MAX_QUEEN];// 记录当前一列哪些位置是可以放皇后,true不可以，false可以
		for (int i = 0; i < n; i++) {
			flags[cols[i]] = true;// 已经放过了皇后点的那行，不能再放皇后
			int d = n - i;
			// 放过皇后点的斜上对角不能再放皇后
			if (cols[i] - d >= 0) {
				flags[cols[i] - d] = true;
			}
			// 放过皇后点的斜下对角不能再放皇后
			if (cols[i] + d < MAX_QUEEN) {
				flags[cols[i] + d] = true;
			}
		}
		//到此知道了哪些位置不能放皇后
		for (int j = 0; j < MAX_QUEEN; j++) {
			if (flags[j]) {
				//不能放的位置
				continue;
			} else {
				cols[n] = j;// 放置皇后的位置
				if (n < MAX_QUEEN - 1) {
					//还没到最后一列，继续放置后面的皇后位置
					getEightQueenCount(n + 1);
				} else {
					//找到完整的一套方案
					sum++;
					printQueen();
				}
			}
		}
	}

	private void printQueen() {
		// TODO Auto-generated method stub
		System.out.println("八皇后第:"+sum+"种:");
		for (int i = 0; i < MAX_QUEEN; i++) {
			for (int j = 0; j < MAX_QUEEN; j++) {
				if (cols[i]==j) {
					System.out.print("+ ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		EightQueen eightQueen = new EightQueen();
		eightQueen.getEightQueenCount();
		System.out.println("八皇后总共有:" + eightQueen.sum);
	}
}
