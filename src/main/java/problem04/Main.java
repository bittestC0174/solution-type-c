package problem04;

import java.util.*;



public class Main {
	static Scanner sc;
	static game [] games;
	
	static class problem { // 문제
		int left;
		int right;
		public problem(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
		public int mul() {
			return left*right;
		}
	}
	static class game{ //게임 정보 저장
		int success;
		int fail;
		Integer time;
		public game(int success, int fail, int time) {
			super();
			this.success = success;
			this.fail = fail;
			this.time = time;
		}
	}
	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in); 
		int n = sc.nextInt(); // 시작할 게임 횟수.
		games = new game[n];
		for(int i=0 ;i < n ; i ++) {
			games[i] =start(); //게임 정보저장
		}
		sort();// 시간순 정렬
		gamePrint(); //게임 정보 출력
	}
	
	static void sort() {
		Comparator<game> com = new Comparator<Main.game>() { // 정렬을 위한 Comparator 
			public int compare(game o1, game o2) {
				return o1.time.compareTo(o2.time); //시간순 정렬
			}
		};
		Arrays.sort(games, com); 
	}
	
	
	static void gamePrint() {
		for(int i=0; i<games.length; i++) {
			System.out.println(i+" : "+games[i].success+" /" +" : " +games[i].fail); // i
		}
		
	}
	
	static game start() {
		problem [] problems =set();
		int success=0;
		int fail = 0;
		
		int [] randomNumbers = new int[18];
		for(int i=0 ; i<18; i++) {
			
			randomNumbers[i] = (int)(Math.random()*18);
			for(int j=i-1 ;j>=0; j--) {
				if(randomNumbers[i] == randomNumbers[j]) {
					i--;
					break;
				}
			}
		}
		long start = System.currentTimeMillis();
		for(int i=0; i<18 ; i++) {
			System.out.println(problems[randomNumbers[i]].left +"X" +problems[randomNumbers[i]].right);
			if(problems[randomNumbers[i]].mul() == sc.nextInt()) success++; // 성공
			else fail++; // 실패
			
		}
		long end = System.currentTimeMillis();
		int time = (int) ((end -start) / 1000);
		System.out.println(time);
		
		return new game(success, fail, time);
	}
	
	static problem [] set() {
		problem [] problems = new problem [18];
		int index=0;
		for(int i=1 ; i<=9 ; i++) {
			problems[index++] = new problem(i, (int)(Math.random()*9)+1);
			problems[index++] = new problem(i, (int)(Math.random()*9)+1);
		}
		return problems;
	}
} 