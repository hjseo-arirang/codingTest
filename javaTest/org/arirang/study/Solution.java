package org.arirang.study;

import java.util.HashMap;
import java.util.Map;

// 2021 카카오 채용연계형 인턴십_숫자 문자열과 영단어 
// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Solution {
	private Map<String, Integer> numberMatchMap = new HashMap<>();

	public int solution(String s) {
		int answer = 0;

		// 맵 셋팅 (파일로 관리되면 좋을텐데)
		initNumberMap();

		// for문 돌면서 파싱
		StringBuilder builder = new StringBuilder();
		StringBuilder alphabet = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				builder.append(ch);
			} else {
				alphabet.append(ch);
				String word = alphabet.toString();
				if (isComplateWord(word)) {
					builder.append(numberMatchMap.get(word));
					alphabet = new StringBuilder(); // 검사했기 때문에 비워주기 
				} 
			}
		}

		// 결과 반환
		answer = Integer.valueOf(builder.toString());

		return answer;
	}

	private boolean isComplateWord(String word) {
		return numberMatchMap.containsKey(word);
	}

	private void initNumberMap() {
		numberMatchMap.put("zero", 0);
		numberMatchMap.put("one", 1);
		numberMatchMap.put("two", 2);
		numberMatchMap.put("three", 3);
		numberMatchMap.put("four", 4);
		numberMatchMap.put("five", 5);
		numberMatchMap.put("six", 6);
		numberMatchMap.put("seven", 7);
		numberMatchMap.put("eight", 8);
		numberMatchMap.put("nine", 9);
	}
}
