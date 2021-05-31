// https://programmers.co.kr/learn/courses/30/lessons/72411

#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

/*
string에서 나올 수 있는, 최대 maxCombinationNumber 길이의 문자열 전부 
*/
vector<string> getAllPossibleCombination(string order, int maxCombinationNumber) {
	vector<string> allPossible;

	for (char c : order) {
		// TODO...
	}
}

/*
comb에서 중복된 string과 중복 개수 반환
*/
map<string, int> getMaxCountCombination(vector<string> combinations) {

	map<string, int> combMap;
	string currentString = combinations.front();
	int count = 0;

	for (string comb : combinations) {
		if (comb != currentString) {
			combMap.insert(pair<string, int>(currentString, count));
			currentString = comb;
			count = 1;
		} else {
			count++;
		}
	}

	return combMap;
}

vector<string> solution(vector<string> orders, vector<int> course) {
	vector<string> answer;

	for (int maxCombinationNumber : course) {

		// maxCombinationNumber를 최대길이로 갖는 모든 가능한 조합 string을 담는다. 
		vector<string> allPossibleCombination;

		for (string order : orders) {
			vector<string> temp = getAllPossibleCombination(order, maxCombinationNumber);
			allPossibleCombination.insert(allPossibleCombination.end(), temp.begin(), temp.end());
		}

		sort(allPossibleCombination.begin(), allPossibleCombination.end());
		map<string, int> combMap = getMaxCountCombination(allPossibleCombination);
		// combMap 에서 가장 큰 value를 갖는 문자열을 answer에 넣어주기 
	}



	return answer;
}
