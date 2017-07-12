package com.hanbit.lotto.domain;

import java.io.Serializable;

public class LottoBean implements Serializable{
	private static final long serialVersionUID = 1L;//스트림을 통해 전송 가능한 객체라서 네트워크(DB)에서 사용할 수 있다
	private int money,number; //instance variable 두가지를 직렬화한다

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getNumber() {
		setNumber();
		return number;
	}

	public void setNumber() {
		this.number = (int)(Math.random()*45+1);
	}
	@Override
	public String toString() {
		return "LottoBean [money=" + money + ", number=" + number + "]";
	}
}
