// https://programmers.co.kr/learn/courses/30/lessons/72411

#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

/*
string���� ���� �� �ִ�, �ִ� maxCombinationNumber ������ ���ڿ� ���� 
*/
vector<string> getAllPossibleCombination(string order, int maxCombinationNumber) {
	vector<string> allPossible;

	for (char c : order) {
		// TODO...
	}
}

/*
comb���� �ߺ��� string�� �ߺ� ���� ��ȯ
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

		// maxCombinationNumber�� �ִ���̷� ���� ��� ������ ���� string�� ��´�. 
		vector<string> allPossibleCombination;

		for (string order : orders) {
			vector<string> temp = getAllPossibleCombination(order, maxCombinationNumber);
			allPossibleCombination.insert(allPossibleCombination.end(), temp.begin(), temp.end());
		}

		sort(allPossibleCombination.begin(), allPossibleCombination.end());
		map<string, int> combMap = getMaxCountCombination(allPossibleCombination);
		// combMap ���� ���� ū value�� ���� ���ڿ��� answer�� �־��ֱ� 
	}



	return answer;
}
