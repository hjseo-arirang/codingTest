package thirdtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution3 {
	private static int LIMIT_TIME = 1439;
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int timer = fees[2];
        int timerFee = fees[3];
        // 기본적으로 시간을 분 총량으로 계산하자.
        
        // 차 번호, 주차장에 있던 시간을 갖는 map... 나가질 않았다면 0으로 두자
        Map<String, Integer> parKInfoMap = getParkInfo(records);
        
        answer = new int[parKInfoMap.size()];
        int index = 0;
        
        for (Entry<String, Integer> entry : parKInfoMap.entrySet()) {
        	String carNumber = entry.getKey();
        	int totalTime = entry.getValue();
        	
        	int fee = 0;
        	
        	if (totalTime <= baseTime) {
        		fee = baseFee;
        	} else {
        		// 초과해버린 경우
        		int additionalFee = ((int) Math.ceil((totalTime - baseTime) / (float) timer)) * timerFee; 
        		fee = baseFee + additionalFee;
        	}
        	answer[index++] = fee;
        }
        
        return answer;
    }

    // 누적 시간은 출차-입차
	private Map<String, Integer> getParkInfo(String[] records) {
		Map<String, Integer> parKInfoMap = new TreeMap<>(); // 정렬되나?
		Map<String, Integer> carInInfoMap = new HashMap<>(); // "들어온" 차들에 대한 기록
		
		for (String record : records) {
			String[] messages = record.split(" ");
			
			int timeInfo = getTime(messages[0]);
			String carNumber = messages[1];
			
			if (!carInInfoMap.containsKey(carNumber)) {
				carInInfoMap.put(carNumber, timeInfo);
			} else { // 이미 들어온 차라면... 당연히 나가는 중이다.
				// 하지만 이미 왔다가서 요금이 있는 차라면?
				int inTime = carInInfoMap.get(carNumber);
				int outTime = timeInfo;
				
				int accumulateTime = outTime - inTime;
				
				if (parKInfoMap.containsKey(carNumber)) {
					Integer preTime = parKInfoMap.get(carNumber);
					parKInfoMap.replace(carNumber, preTime, preTime + accumulateTime);
				} else {
					parKInfoMap.put(carNumber, accumulateTime);
				}
				carInInfoMap.remove(carNumber);
			}
		}
		
		// 다 끝나고 안나간 차량들 관리...
		for (Entry<String, Integer> entry : carInInfoMap.entrySet()) {
			if (parKInfoMap.containsKey(entry.getKey())) {
				int accumulateTime = LIMIT_TIME - entry.getValue();
				Integer preTime = parKInfoMap.get(entry.getKey());
				parKInfoMap.replace(entry.getKey(), preTime, preTime + accumulateTime);
			} else {
				parKInfoMap.put(entry.getKey(), LIMIT_TIME - entry.getValue());
			}
		}
		
		return parKInfoMap;
	}
	
	private int getTime(String time) {
		String[] times = time.split(":");
		int hour = Integer.valueOf(times[0]);
		int min = Integer.valueOf(times[1]);
		return hour * 60 + min;
	}
}
