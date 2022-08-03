package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VacationPath {
    private static final String START_CITY = "ICN";

	public String[] solution(String[][] tickets) {
        List<String[]> resultList = new ArrayList<>();
        List<String[]> history = new ArrayList<>();
        
        dfsTracking(START_CITY, tickets, resultList, history);
        
        if (resultList.size() > 1) {
        	Collections.sort(resultList, (o1, o2) -> {
        		String[] a1 = (String[]) o1;
        		String[] a2 = (String[]) o2;
        		
        		for (int index = 0 ; index < a1.length ; index++) {
        			int compareTo = a1[index].compareTo(a2[index]);
        			if (compareTo == 0) {
        				continue;
        			}
					return compareTo;
        		}
        		return 0;
        	});
        }
        
        return resultList.get(0);
    }
    
    /**
     * @param currentCity 현재 루트 노드의 도시 
     * @param tickets 입력으로 받은 티켓 목록 
     * @param resultList 결과 넣는 리스트 
     * @param history 지나간 곳... 
     */
    private void dfsTracking(String currentCity, String[][] tickets, List<String[]> resultList, List<String[]> history) {
    	
    	// 항공권을 다 썼다면 반환
//    	if (history.size() == tickets.length) {
//    		return;
//    	}
    	
    	// 순회하면서 가능한 자식 찾음
    	for (String[] ticket : tickets) {
    		// 현재 도시에서 사용할 수 없는 티켓이면 다음 티켓 확인
    		if (!ticket[0].equals(currentCity)) {
    			continue;
    		}
    		
    		// 이미 사용한 항공권이면 다음 티켓 확인
    		if (history.contains(ticket)) {
    			continue;
    		}
    		
    		String nextCity = ticket[1];
    		
    		List<String[]> newHistory = new ArrayList<>();
    		newHistory.addAll(history);
    		newHistory.add(ticket);
    		
    		dfsTracking(nextCity, tickets, resultList, newHistory);
    	}
    	
    	if (history.size() != tickets.length) {
    		return;
    	}
    	
    	String[] result = new String[tickets.length + 1];
    	int index = 0;
    	for (String[] t : history) {
    		result[index++] = t[0];
    	}
    	result[index] = history.get(index-1)[1];
    	resultList.add(result);
    	
    }
}
