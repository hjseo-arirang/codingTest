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

	// 기능별 배포까지 걸리는 시간 구하기

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

	// 순회하며 큰 수가 나오면 이전까지의 기능 갯수 결과 벡터에 추가, 이후 기능 재카운트

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