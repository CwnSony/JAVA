/**
 * 
 */
package com.biz;

import java.util.Date;
import java.util.Scanner;

import com.entity.Dvd;
import com.test.DateUtil;

/**
 * @author @������
 *
 * @{date}����ʱ�䣺2017��4��9������7:32:27
 */
public class DvdMgr {

	Dvd[] dvd = new Dvd[6];
	Scanner input = new Scanner(System.in);
	/**
	 * ��ʼ��״̬
	 */
	public void init(){
		Dvd d1 = new Dvd();
		d1.name = "����֮��";
		d1.state = 1;
		d1.date = "          ";
		d1.price = 3;
		dvd[0] = d1;
		
		Dvd d2 = new Dvd();
		d2.name = "����Σ��";
		d2.state = 0;
		d2.date = "2017-04-03";
		d2.price = 5;
		dvd[1] = d2;
		
		Dvd d3 = new Dvd();
		d3.name = "2012";
		d3.state = 0;
		d3.date = "2017-04-06";
		d3.price = 7;
		dvd[2] = d3;
		
		Dvd d4 = new Dvd();
		d4.name = "Ѫ����";
		d4.state = 1;
		d4.date = "          ";
		d4.price = 4;
		dvd[3] = d4;
	}
	/**
	 * ��ʼ���˵�
	 */
	public void startMenu(){
		System.out.println("��ӭ��������dvd������");
		System.out.println("----------------------------");
		System.out.println("1:����dvd");
		System.out.println("2:�鿴dvd");
		System.out.println("3:ɾ��dvd");
		System.out.println("4:���dvd");
		System.out.println("5:�黹dvd");
		System.out.println("6:�˳�");
		System.out.println("----------------------------");
		System.out.println("��ѡ��");
		if(input.hasNextInt()){
			int num = input.nextInt();
			switch (num) {
			case 1:
				System.out.println("--->��������dvd���ܣ�\n");
				search();
				addMenu();
				search();
				returnMenu();
				break;
			case 2:
				System.out.println("--->����鿴dvd���ܣ�\n");
				search();
				returnMenu();
				break;
			case 3:
				System.out.println("--->����ɾ��dvd���ܣ�\n");
				search();
				deleteMenu();
				search();
				returnMenu();
				break;
			case 4:
				System.out.println("--->������dvd���ܣ�\n");
				search();
				lendMenu();
				search();
				returnMenu();
				break;
			case 5:
				System.out.println("--->����黹dvd���ܣ�\n");
				search();
				giveMenu();
				search();
				returnMenu();
				break;
			case 6:
				System.out.println("--->�˳���\n");
				System.exit(0);
				break;
			default:
				System.out.println("--->û�д���ܣ�\n");
				break;
			}
		}
	}
	/**
	 * ���ؿ�ʼ�˵�
	 */
	public void returnMenu(){
		System.out.println("****************************");
		System.out.println("����0���أ�");
		if(input.hasNextInt()){
			int num = input.nextInt();
			if(num==0){
				startMenu();
			}else{
				System.out.println("������������ϵͳ�˳���ллʹ�ã�");
				System.exit(0);
			}
		}else {
			System.out.println("������������ϵͳ�˳���ллʹ�ã�");
			System.exit(0);
		}
	}
	/**
	 * �鿴dvd����
	 */
	public void search(){
		System.out.println("���\t����\t״̬\t���ʱ��\t\t���");
		for (int i = 0; i < dvd.length; i++) {
			if(null!=dvd[i]){
				Dvd d = dvd[i];
				String statestr = null;
				statestr = d.state == 0?"���":"�ɽ�";
				System.out.println((i+1)+"\t"+d.name+"\t"+statestr+"\t"+d.date+"\t"+d.price);
			}
		}
	}
	/**
	 * ���dvd����
	 */
	public void addMenu(){
		System.out.println("��������Ҫ��ӵ�dvd���ƣ�");
		String name = input.next();
		System.out.println("����������ӵ�dvd���Ƽ۸�");
		double price = input.nextDouble();
		int count = 0;
		for (int i = 0; i < dvd.length; i++) {
			if(null==dvd[i]){
				Dvd d = new Dvd();
				d.name = name;
				d.state = 1;
				d.date = "          ";
				d.price = 6;
				dvd[i] = d;
				System.out.println("��ӳɹ���");
				break;
			}else{
				count++;
			}
		}
		if(count==dvd.length){
			System.out.println("����������޷���ӣ�");
		}
	}
	/**
	 * ɾ��dvd����
	 */
	public void deleteMenu(){
		System.out.println("��������Ҫɾ����dvd���ƣ�");
		String name = input.next();
		int find = 0;
		for (int i = 0; i < dvd.length; i++) {
			if(null!=dvd[i]){
				if(dvd[i].name.equals(name)){
					find++;
					if(dvd[i].state==1){
						int j = i;
						while(null!=dvd[j]){
							dvd[j]=dvd[j+1];
							j++;
						}
						dvd[j]=null;
						System.out.println("ɾ���ɹ���");
						break;
					}else{
						System.out.println(name+"dvd�ѽ��������ɾ����");
						break;
					}
				}
			}
		}
		if(find==0){
			System.out.println("û���ҵ���dvd���޷�ɾ����");
		}
	}
	/**
	 * ���dvd����
	 */
	public void lendMenu(){
		System.out.println("��������Ҫ�����dvd���ƣ�");
		String name = input.next();
//		System.out.println("��������ʱ�䣺(yyyy-MM-dd)");
//		String time = input.next();
		int find = 0;
		for (int i = 0; i < dvd.length; i++) {
			if(null!=dvd[i]){
				if(dvd[i].name.equals(name)){
					find++;
					if(dvd[i].state==1){
						dvd[i].state = 0;
//						dvd[i].date = time;
						Date d = new Date();
						dvd[i].date = DateUtil.fromDate(d);
						System.out.println("����ɹ���");
						break;
					}else{
						System.out.println("��dvd�ѽ������ѡ��������dvd!");
						break;
					}
				}
			}
		}
		if(find==0){
			System.out.println("û���ҵ���dvd�����ʧ�ܣ�");
		}
	}
	/**
	 * �黹dvd����
	 */
	public void giveMenu(){
		System.out.println("��������Ҫ�黹��dvd���ƣ�");
		String name = input.next();
		int find = 0;
		for (int i = 0; i < dvd.length; i++) {
			if(null!=dvd[i]){
				if(dvd[i].name.equals(name)){
					find++;
					if(dvd[i].state==0){
						dvd[i].state = 1;
						String lenddate = dvd[i].date;
						Date lend = DateUtil.fromString(lenddate);
						Date d = new Date();
						int day = DateUtil.getDay(d, lend);
						System.out.println("Ӧ�����"+(day*dvd[i].price));
						dvd[i].date = "          ";
						System.out.println("�黹�ɹ���");
						break;
					}else{
						System.out.println("��dvd�Ѿ��黹��");
						break;
					}
				}
			}
		}
		if(find==0){
			System.out.println("û���ҵ���dvd���黹ʧ�ܣ�");
		}
	}
}
