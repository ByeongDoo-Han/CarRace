package com.example.carrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
public class CarRaceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CarRaceApplication.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
		bw.flush();

//		StringTokenizer st = new StringTokenizer(br.readLine());
//		String inputString = st.nextToken();
		StringBuilder sb3 = new StringBuilder();
		StringBuffer ss = new StringBuffer();

		String inputString = br.readLine();

		for(int i=0;i<inputString.length();i++){
			Character j = inputString.charAt(i);
			if(j!=' '){
				sb3.append(j);
			}
		}
		String resultString = sb3.toString();
		System.out.println(resultString);
		String[] names = resultString.split(",");
		for (String name : names) {
			if(name.length()>5){
				bw.write("자동차 이름은 5자를 초과할 수 없습니다.");
				bw.flush();
				System.exit(0);
			}
		}
		System.out.println(Arrays.toString(names));
		bw.write("시도할 횟수는 몇회인가요?\n");
		bw.flush();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer inputNum = Integer.parseInt(st.nextToken());
		Integer[] score = new Integer[names.length];
		for (int i = 0; i < names.length; i++) {
			score[i] = 1;
		}



		bw.write("실행 결과\n");
		for (int i = 0; i < names.length; i++) {
			bw.write(names[i]+ " : -\n" );
		}
		bw.write("\n");
		bw.flush();

		for (int i = 0; i < inputNum; i++) {
			for (int j = 0; j< names.length;j++) {
				Double r = Math.random();
				Integer t = Math.toIntExact(Math.round(r * 10));
				if(t>=4)score[j]++;
				StringBuilder sb2 = new StringBuilder();
				for (int k = 0; k < score[j]; k++) {
					sb2.append("-");
				}
				bw.write(names[j]+" : "+sb2+"\n");
				bw.flush();
				Thread.sleep(100);
			}
			bw.write("\n");
			bw.flush();
		}
		StringBuilder sb = new StringBuilder();
		Integer temp = 0;
		Integer[] maxList = new Integer[score.length];
		Integer m = 0;
		for(Integer i : score){
			if(i>=m) m=i;
		}

		for (int i = 0; i < score.length; i++) {

			if(score[i].equals(m)){
				if(temp>0)sb.append(", ");
				sb.append(names[i]);
				temp++;
			}
		}

		sb.append("가 최종 우승했습니다.");
		String result = sb.toString();
		bw.write(result);
		bw.flush();
		bw.close();
	}
}
