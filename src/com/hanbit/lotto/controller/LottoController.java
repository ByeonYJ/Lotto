package com.hanbit.lotto.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

import jdk.jfr.events.FileWriteEvent;

public class LottoController {
	int count=0,money=0;
	public static void main(String[] args) {
		LottoService service = new LottoServiceImpl();
		LottoBean bean = new LottoBean();
		StringBuffer buff = new StringBuffer();
		while(true){
			switch(JOptionPane.showInputDialog("0.종료, 1.구입 금액").toString()){
			case"0":
				JOptionPane.showMessageDialog(null, "시스템 종료");
				return;
			case"1":
				String money = JOptionPane.showInputDialog("금액 입력");
				bean.setMoney(Integer.parseInt(money));
				service.setLottos(bean);//가장 먼저 시작하는 지점이 setLottos 라서 impl에서 setLottos를 작성한다
				int [][] lottos = service.getLottos();
				for(int i=0;i<lottos.length;i++){
					for(int j=0;j<lottos[i].length;j++){
						//System.out.print(lottos[i][j]+"\t");
						buff.append(lottos[i][j]+"\t");
					}
					buff.append("/");
				}
				int lottoSerinalNo=(int)(Math.random()*99999+10000);
				File output=new File("C:\\Users\\hb1002\\JavaProject\\lottos\\"+lottoSerinalNo+".txt");// \\는 \t와 같다
				FileWriter fw=null;;//객체 초기화는 null로 한다
				BufferedWriter bw=null;//객체 초기화는 null로 한다
				String[] lottoPrint=buff.toString().split("/");
				try {
					bw = new BufferedWriter(new FileWriter(output));
					for(String s:lottoPrint){
						s+=System.getProperty("line.separator");//System.getProperty("line.separator") 라인 대행의 의미 
						bw.write(s);
					}
				} catch (Exception e) {//try에서 오류가 생기면 exception으로 빠지게 한다
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {//finally를 걸지않으면 오류발생시 프로그램이 망가진다
					try {
						bw.flush();//bw에 오류가나면 bw에 있는것을 비워버려라
						bw.close();//flush로 bw를 비운것을 뚜껑을 닫아라 의미
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				break;
			default:
				break;
			}
		}
	}
}
