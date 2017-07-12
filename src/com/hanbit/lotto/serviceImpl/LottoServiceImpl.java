package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService{
	int[][] lottos;//instance 변수가 있으면 초기화가 이루어져야한다
	int[] lotto;//돈과 상관없이 생성되는 한 줄(숫자 6)로또
	private int count;

	@Override
	public void setCount(LottoBean bean) {
	//몇 줄을 출력할 것인지 로또 수 계산(최대값 5줄)
		/*int momney = bean.getMoney()/1000;
	      this.count=(momney>=5)?momney=5:bean.getMoney()/1000;*/
		count=(bean.getMoney()/1000>=5)?5:bean.getMoney()/1000;
	}
	
	@Override
	public int getCount() {
		//해당 로또 수만큼 출력
		return count;
	}
	
	@Override
	public void setLottos(LottoBean bean) {
		//로또 만들기
		setCount(bean);
		lottos=new int[count][6];//6은 정해진 Max숫자
		//매트릭스 출력
		/*		
         for(int i=0;i<lottos.length;i++){
			for(int j=0;j<lottos[i].length;j++){
				lottos[i][j]=bean.getNumber();
			}
		}
		*/
		for(count=0;count<lottos.length;count++){
			for(int i=0;i<6;i++){
					int num=bean.getNumber();
					if(!isDuplication(count,num)){
						lottos[count][i]=num;
				}else{
					i--;
				}
			}
			sort(lottos[count]);
		}
	}
	@Override
	public int[][] getLottos() {
		//만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		//중복된 번호인지 체크(중복이면 true 리턴)
		boolean flag = false;
		for(int i=0;i<6;i++){
			if(num==lottos[count][i]){
				flag=true;
			}
		}
		/*		
	    boolean flag = true;
		for(int i=0; i<lotto.length; i++){
			lotto[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i; j++){
			if(lotto[i]==lotto[j]){
			i--;
			break;
			}  
		}
		*/
		return flag;
	}
	@Override
	public void sort(int[] arr) {
		//오름차순으로 정렬
		//swap 정렬
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
			if(arr[j]>arr[j+1]){
				int t=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=t;
				}
			}
		}
	}
}
