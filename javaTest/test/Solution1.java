package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1 {
	  public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = {};
	        
	        Map<String, Integer> members = getMembers(id_list); // ���� id + �Ű���� Ƚ��
	        Map<String, Set<String>> reports = getReportSet(members, report); // ���� id + �Ű��� ��� set
	        
	        // �������� ģ���� ����Ʈ 
	        List<String> badMembers = new ArrayList<>();
	        for (Map.Entry<String, Integer> entry : members.entrySet()) {
	            if (entry.getValue() >= k) {
	                badMembers.add(entry.getKey());
	            }
	        }
	        
	        // ��� ���� ����
	        Map<String, Integer> answers = new LinkedHashMap<>();
	        for (String member : members.keySet()) {
	            answers.put(member, 0);    
	        }
	        
	        for (String badMember : badMembers) {
	            for (Map.Entry<String, Set<String>> entry : reports.entrySet()) {
	                if (entry.getValue().contains(badMember)) {
	                	Integer val = answers.get(entry.getKey());
	                	answers.replace(entry.getKey(), val, val+1);
	                }
	            }
	        }
	        
	        int index = 0;
	        answer = new int[answers.size()];
	        for (Integer i : answers.values()) {
	        	answer[index++] = i;
	        }
	        
	        return answer;
	    }
	    
	    private Map<String, Integer> getMembers(String[] id_list) {
	        // id_list�κ��� user info
	        Map<String, Integer> members = new LinkedHashMap<>();
	        
	        for (String id : id_list) {
	            members.put(id, 0);
	        }
	        
	        return members;
	    }
	    
	    private Map<String, Set<String>> getReportSet(Map<String, Integer> members, String[] report) {
	        // members�� report�κ��� �Ű��� ��� ��� map
	        Map<String, Set<String>> reports = new LinkedHashMap<>();
	        
	        for (String id : members.keySet()) {
	        	reports.put(id, new HashSet<>());
	        }
	        
	        for (String msg : report) {
	            String[] msgs = msg.split(" ");
				String reporter = msgs[0];
	            String badMember = msgs[1];
	            
	            Set<String> tempSet = reports.get(reporter);
	            
	            if (!tempSet.contains(badMember)) {
	            	tempSet.add(badMember);
	            	Integer val = members.get(badMember);
	            	members.replace(badMember, val, val+1);
	            }
	        }
	        
	        return reports;
	    }
}
