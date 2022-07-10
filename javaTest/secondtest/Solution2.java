package secondtest;

public class Solution2 {

    public int solution(int n, int k) {
        int answer = -1;
        
        String targetString = convertNumber(n, k);
        
        // ��ȯ�� K���� ���ڵ��� ���캸�� �Ҽ� üũ�ϱ�
        
        answer = countSpecialPrimeNumber(targetString);
        
        return answer;
    }

	private int countSpecialPrimeNumber(String targetString) {
		
		String target = "";
		int count = 0;
		
		if (!targetString.contains("0")) {
			if (isPrime(target)) {
				count++;
			}
		} else {
			for (char ch : targetString.toCharArray()) {
				if (ch == '0') {
					if (!target.isEmpty()) {
						// �˻� �߿� 0�� ����
						if (isPrime(target)) {
							count++;
						}
						target = "";
					}
				} else {
					// �Ҽ����� �˻� ��...
					target = target + ch;
				}
			}

			// �� ���� ��, ������ ���� ģ���� �˻�

			if (!target.isEmpty()) {
				if (isPrime(target)) {
					count++;
				}
			}
			
		}

		return count;
	}

	private boolean isPrime(String target) {
		boolean result = true;
		int num = Integer.valueOf(target);
		int limitNum = (int)Math.sqrt(num);
		
		if (num == 1) {
			return false;
		}
		
        for(int i = 2; i <= limitNum; i++) {
            if( num%i == 0) {
                result = false;
                break; 
            } 
        }   
		return result;
	}

	private String convertNumber(int n, int k) {
		String convertString = "";
		while(n > 0) {
			convertString = (n % k) + convertString;
			n /= k;
		}
		return convertString;
	}
	
}
