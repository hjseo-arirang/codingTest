package forthtest;

public class Solution4 {
    public int[] solution(int n, int[] info) {
        
        // ���� ���� ���� �������� ��. �� �׷� ��쿡 ����, ���� �ؼ�... ���� �� �ִ� ȭ�� ����n < ������ �� ȭ�� �� �� -1 ����
        // info�� �� 11��¥�� �迭

        int[] appInfo = new int[11];
        int[] ryanInfo = new int[11];
        int k = 0;
        for (int num : info) {
        	appInfo[k] = num;
        	ryanInfo[k++] = 0;
        }
        
        ryanInfo = getFitScore(info, n, ryanInfo, 0, 0);
        
        // �̰�... ��ͷ� ������....
        int except = 0; // ���� �ȵ�� ����ó�� 
        for (int r : ryanInfo) {
        	except += r;
        }
        if (except == 0) {
        	return new int[] {-1};
        }
        	
        return ryanInfo;
    }
    
    /*
     * @param appBaseScore �⺻������ ����ġ���� �ְ� ���� ���� 0 -> 10 -> 19...
     * @param base �˰��� �����ϴ� ������ 0 -> 1 -> 2...
     */
    private int[] getFitScore(int[] info, int n, int[] preRyanInfo, int appBaseScore, int base) {
    	
    	if (base == 11) {
    		return preRyanInfo;
    	}
    	
    	int[] answer = {};
    	
        int arrowCount = 0; // ���̾��� �� ȭ�� �� 
        int index = base;
        
        int[] appInfo = new int[11];
        int[] ryanInfo = new int[11];
        int k = 0;
        for (int num : info) {
        	appInfo[k] = num;
        	ryanInfo[k++] = 0;
        }
        
        for ( ; index < info.length; index++) {
        	int appNum = info[index];
        	if (arrowCount >=n) {
        		// �־��� ȭ�캸�� ���� ������ ���, break
        		break;
        	}
        	// appNum���ٴ� ���� ���߸� �ش� ���� ������ �� ����.
        	
        	if (arrowCount + appNum + 1 > n) {
        		// �־��� ȭ�� ���� �� �� �ִ°�? ����ٸ� ���� ���� �븮��. 
        		continue;
        	}
        	
        	ryanInfo[index] = appNum + 1;
        	arrowCount += appNum + 1;
        	appInfo[index] = 0;
        	if (getTotalScore(ryanInfo) > getTotalScore(appInfo) + appBaseScore) {
        		continue;
        	}
        }
        
        if (getTotalScore(ryanInfo) > getTotalScore(appInfo) + appBaseScore) {
        	int idx = 0;
        	answer = new int[ryanInfo.length];
        	for (int r : ryanInfo) {
        		answer[idx++] = r;
        	}
        } else {
        	answer = new int[] {-1};
        }
        
        // preRyanInfo, answer ���ؼ� �� ���信 ������ ryanInfo ��ȯ.
        // 1. �� ū ������ ������ �ִ°�?
        // 2. �� ���� ������ ���� ȭ���� �� ������?
        
        // �̱�°� �Ұ����� ���.
        if (answer.length == 1) {
        	return getFitScore(info, n, preRyanInfo, appBaseScore + info[base] * (10-base), base+1);
        }
        
        // �� ū ������ ���� ���
        if (Integer.compare(getTotalScore(preRyanInfo), getTotalScore(answer)) < 0) {
        	return getFitScore(info, n, answer, appBaseScore + info[base] * (10-base), base+1);
        } else if ((Integer.compare(getTotalScore(preRyanInfo), getTotalScore(answer)) > 0)) {
        	return getFitScore(info, n, preRyanInfo, appBaseScore + info[base] * (10-base), base+1);
		} else {
			for (int reIdx = 10; reIdx >= 0; reIdx--) {
				if (Integer.compare(preRyanInfo[reIdx], answer[reIdx]) < 0) {
					return getFitScore(info, n, answer, appBaseScore + info[base] * (10-base), base+1);
				} else if ((Integer.compare(preRyanInfo[reIdx], answer[reIdx]) > 0)) {
					return getFitScore(info, n, preRyanInfo, appBaseScore + info[base] * (10-base), base+1);
				} else {
					continue;
				}
			}
			
			return getFitScore(info, n, preRyanInfo, appBaseScore + info[base] * (10-base), base+1);
		}
    }

	private int getTotalScore(int[] info) {
		
		int score = 10;
		int total = 0;
		for (int num : info) {
			if (num != 0) {
				total += score;
			}
			score--;
		}
		return total;
	}
}
