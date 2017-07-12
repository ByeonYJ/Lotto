/*package com.hanbit.lotto.serviceImpl;
import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class ServiceImpl implements LottoService{
	int[][] lottos;//instance 변수가 있으면 초기화가 이루어져야한다
	int[] lotto;//돈과 상관없이 생성되는 한 줄(숫자 6)로또
	private int count;

	@Override
	public void setCount(LottoBean bean) {
		int count = bean.getMoney()/1000;
		if(count>=5){
			count=5;
		}else{
			count=bean.getMoney()/1000;
		}
		
	}
	
	
	@Override
	public int getCount() {
		//해당 로또 수만큼 출력
		
		return count;
	}
	
	@Override
	public void setLottos(LottoBean bean) {
		//로또 만들기
		
	}
	@Override
	public int[][] getLottos() {
		//만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		//중복된 번호인지 체크(중복이면 true 리턴)
		
		return false;
	}
	@Override
	public void sort(int[] arr) {
		//오름차순으로 정렬
		
	}
}
*/