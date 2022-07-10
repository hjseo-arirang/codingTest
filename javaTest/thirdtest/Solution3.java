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
        // �⺻������ �ð��� �� �ѷ����� �������.
        
        // �� ��ȣ, �����忡 �ִ� �ð��� ���� map... ������ �ʾҴٸ� 0���� ����
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
        		// �ʰ��ع��� ���
        		int additionalFee = ((int) Math.ceil((totalTime - baseTime) / (float) timer)) * timerFee; 
        		fee = baseFee + additionalFee;
        	}
        	answer[index++] = fee;
        }
        
        return answer;
    }

    // ���� �ð��� ����-����
	private Map<String, Integer> getParkInfo(String[] records) {
		Map<String, Integer> parKInfoMap = new TreeMap<>(); // ���ĵǳ�?
		Map<String, Integer> carInInfoMap = new HashMap<>(); // "����" ���鿡 ���� ���
		
		for (String record : records) {
			String[] messages = record.split(" ");
			
			int timeInfo = getTime(messages[0]);
			String carNumber = messages[1];
			
			if (!carInInfoMap.containsKey(carNumber)) {
				carInInfoMap.put(carNumber, timeInfo);
			} else { // �̹� ���� �����... �翬�� ������ ���̴�.
				// ������ �̹� �Դٰ��� ����� �ִ� �����?
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
		
		// �� ������ �ȳ��� ������ ����...
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
