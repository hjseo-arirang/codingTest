package forthtest;

public class Solution4 {
    public int[] solution(int n, int[] info) {
        
        // 제일 높은 점수 가져오면 됨. 못 그럴 경우에 다음, 다음 해서... 날릴 수 있는 화살 총합n < 날려야 할 화살 수 면 -1 리턴
        // info는 총 11개짜리 배열

        int[] appInfo = new int[11];
        int[] ryanInfo = new int[11];
        int k = 0;
        for (int num : info) {
        	appInfo[k] = num;
        	ryanInfo[k++] = 0;
        }
        
        ryanInfo = getFitScore(info, n, ryanInfo, 0, 0);
        
        // 이걸... 재귀로 돌려서....
        int except = 0; // 맘에 안드는 예외처리 
        for (int r : ryanInfo) {
        	except += r;
        }
        if (except == 0) {
        	return new int[] {-1};
        }
        	
        return ryanInfo;
    }
    
    /*
     * @param appBaseScore 기본적으로 어피치한테 주고 들어가는 점수 0 -> 10 -> 19...
     * @param base 알고리즘 시작하는 점수판 0 -> 1 -> 2...
     */
    private int[] getFitScore(int[] info, int n, int[] preRyanInfo, int appBaseScore, int base) {
    	
    	if (base == 11) {
    		return preRyanInfo;
    	}
    	
    	int[] answer = {};
    	
        int arrowCount = 0; // 라이언이 쏜 화살 수 
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
        		// 주어진 화살보다 많이 쏴버린 경우, break
        		break;
        	}
        	// appNum보다는 많이 쏴야만 해당 점수 가져올 수 있음.
        	
        	if (arrowCount + appNum + 1 > n) {
        		// 주어진 화살 내로 쏠 수 있는가? 못쏜다면 다음 점수 노리기. 
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
        
        // preRyanInfo, answer 비교해서 더 정답에 근접한 ryanInfo 반환.
        // 1. 더 큰 점수를 가지고 있는가?
        // 2. 더 작은 점수에 대한 화살이 더 많은가?
        
        // 이기는게 불가능할 경우.
        if (answer.length == 1) {
        	return getFitScore(info, n, preRyanInfo, appBaseScore + info[base] * (10-base), base+1);
        }
        
        // 더 큰 점수를 가진 경우
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
