/*
 * https://programmers.co.kr/learn/courses/30/lessons/42586
*/

#include <string>
#include <vector>

#include <iostream>

using namespace std;

const static int MAX_PROGRESS = 100;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	vector<int> answer;

	// ��ɺ� �������� �ɸ��� �ð� ���ϱ�

	vector<int> remainTime;

	for (int index = 0; index < progresses.size(); ++index) {
		int time = MAX_PROGRESS - progresses[index];
		int speed = speeds[index];
		int remain;
		if (time % speed == 0) {
			remain = time / speed;
		} else {
			remain = time / speed + 1;
		}

		remainTime.push_back(remain);
	}

	// ��ȸ�ϸ� ū ���� ������ ���������� ��� ���� ��� ���Ϳ� �߰�, ���� ��� ��ī��Ʈ

	int currentReleaseSize = 0;
	int currentReleaseDay = remainTime[0];

	for (int time : remainTime) {
		if (currentReleaseDay >= time) {
			++currentReleaseSize;
		} else {
			answer.push_back(currentReleaseSize);
			currentReleaseSize = 1;
			currentReleaseDay = time;
		}
	}

	answer.push_back(currentReleaseSize);

	return answer;
}

int main() {
	
	//TEST

	vector<int> progress1 = { 40, 93, 30, 55, 60, 65 };

	vector<int> speed1 = { 60, 1, 30, 5, 10, 7 };

	for (int num : solution(progress1, speed1)) {
		cout << num << ",";
	}
	cout << endl; // answer: 2, 1

}