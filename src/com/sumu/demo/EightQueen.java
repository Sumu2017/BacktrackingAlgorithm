package com.sumu.demo;

/**
 * �˻ʺ�����
 * 
 * @author sumu
 *
 */
public class EightQueen {
	public int sum = 0;// �ܹ��ж����ܷ�ʽ
	private static final int MAX_QUEEN = 8;
	private int[] cols = new int[MAX_QUEEN];// ������¼8�лʺ��λ��

	public void getEightQueenCount() {
		getEightQueenCount(0);
	}

	public void getEightQueenCount(int n) {
		boolean[] flags = new boolean[MAX_QUEEN];// ��¼��ǰһ����Щλ���ǿ��ԷŻʺ�,true�����ԣ�false����
		for (int i = 0; i < n; i++) {
			flags[cols[i]] = true;// �Ѿ��Ź��˻ʺ������У������ٷŻʺ�
			int d = n - i;
			// �Ź��ʺ���б�϶Խǲ����ٷŻʺ�
			if (cols[i] - d >= 0) {
				flags[cols[i] - d] = true;
			}
			// �Ź��ʺ���б�¶Խǲ����ٷŻʺ�
			if (cols[i] + d < MAX_QUEEN) {
				flags[cols[i] + d] = true;
			}
		}
		//����֪������Щλ�ò��ܷŻʺ�
		for (int j = 0; j < MAX_QUEEN; j++) {
			if (flags[j]) {
				//���ܷŵ�λ��
				continue;
			} else {
				cols[n] = j;// ���ûʺ��λ��
				if (n < MAX_QUEEN - 1) {
					//��û�����һ�У��������ú���Ļʺ�λ��
					getEightQueenCount(n + 1);
				} else {
					//�ҵ�������һ�׷���
					sum++;
					printQueen();
				}
			}
		}
	}

	private void printQueen() {
		// TODO Auto-generated method stub
		System.out.println("�˻ʺ��:"+sum+"��:");
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
		System.out.println("�˻ʺ��ܹ���:" + eightQueen.sum);
	}
}
