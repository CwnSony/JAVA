/**
 * 
 */
package com.biz;

import java.util.Date;
import java.util.Scanner;

import com.entity.Dvd;
import com.test.DateUtil;

/**
 * @author @陈守义
 *
 * @{date}创建时间：2017年4月9日下午7:32:27
 */
public class DvdMgr {

	Dvd[] dvd = new Dvd[6];
	Scanner input = new Scanner(System.in);
	/**
	 * 初始化状态
	 */
	public void init(){
		Dvd d1 = new Dvd();
		d1.name = "狂蟒之灾";
		d1.state = 1;
		d1.date = "          ";
		d1.price = 3;
		dvd[0] = d1;
		
		Dvd d2 = new Dvd();
		d2.name = "生化危机";
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
		d4.name = "血滴子";
		d4.state = 1;
		d4.date = "          ";
		d4.price = 4;
		dvd[3] = d4;
	}
	/**
	 * 开始主菜单
	 */
	public void startMenu(){
		System.out.println("欢迎进入迷你dvd管理器");
		System.out.println("----------------------------");
		System.out.println("1:新增dvd");
		System.out.println("2:查看dvd");
		System.out.println("3:删除dvd");
		System.out.println("4:借出dvd");
		System.out.println("5:归还dvd");
		System.out.println("6:退出");
		System.out.println("----------------------------");
		System.out.println("请选择：");
		if(input.hasNextInt()){
			int num = input.nextInt();
			switch (num) {
			case 1:
				System.out.println("--->进入新增dvd功能！\n");
				search();
				addMenu();
				search();
				returnMenu();
				break;
			case 2:
				System.out.println("--->进入查看dvd功能！\n");
				search();
				returnMenu();
				break;
			case 3:
				System.out.println("--->进入删除dvd功能！\n");
				search();
				deleteMenu();
				search();
				returnMenu();
				break;
			case 4:
				System.out.println("--->进入借出dvd功能！\n");
				search();
				lendMenu();
				search();
				returnMenu();
				break;
			case 5:
				System.out.println("--->进入归还dvd功能！\n");
				search();
				giveMenu();
				search();
				returnMenu();
				break;
			case 6:
				System.out.println("--->退出！\n");
				System.exit(0);
				break;
			default:
				System.out.println("--->没有此项功能！\n");
				break;
			}
		}
	}
	/**
	 * 返回开始菜单
	 */
	public void returnMenu(){
		System.out.println("****************************");
		System.out.println("输入0返回：");
		if(input.hasNextInt()){
			int num = input.nextInt();
			if(num==0){
				startMenu();
			}else{
				System.out.println("您的输入有误！系统退出，谢谢使用！");
				System.exit(0);
			}
		}else {
			System.out.println("您的输入有误！系统退出，谢谢使用！");
			System.exit(0);
		}
	}
	/**
	 * 查看dvd功能
	 */
	public void search(){
		System.out.println("编号\t名称\t状态\t借出时间\t\t金额");
		for (int i = 0; i < dvd.length; i++) {
			if(null!=dvd[i]){
				Dvd d = dvd[i];
				String statestr = null;
				statestr = d.state == 0?"借出":"可借";
				System.out.println((i+1)+"\t"+d.name+"\t"+statestr+"\t"+d.date+"\t"+d.price);
			}
		}
	}
	/**
	 * 添加dvd功能
	 */
	public void addMenu(){
		System.out.println("请输入您要添加的dvd名称：");
		String name = input.next();
		System.out.println("请输入您添加的dvd名称价格：");
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
				System.out.println("添加成功！");
				break;
			}else{
				count++;
			}
		}
		if(count==dvd.length){
			System.out.println("库存已满，无法添加！");
		}
	}
	/**
	 * 删除dvd功能
	 */
	public void deleteMenu(){
		System.out.println("请输入您要删除的dvd名称：");
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
						System.out.println("删除成功！");
						break;
					}else{
						System.out.println(name+"dvd已借出，不能删除！");
						break;
					}
				}
			}
		}
		if(find==0){
			System.out.println("没有找到该dvd，无法删除！");
		}
	}
	/**
	 * 借出dvd功能
	 */
	public void lendMenu(){
		System.out.println("请输入你要借出的dvd名称：");
		String name = input.next();
//		System.out.println("请输入借出时间：(yyyy-MM-dd)");
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
						System.out.println("借出成功！");
						break;
					}else{
						System.out.println("该dvd已借出，请选择借出其他dvd!");
						break;
					}
				}
			}
		}
		if(find==0){
			System.out.println("没有找到该dvd，借出失败！");
		}
	}
	/**
	 * 归还dvd功能
	 */
	public void giveMenu(){
		System.out.println("请输入您要归还的dvd名称：");
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
						System.out.println("应付租金："+(day*dvd[i].price));
						dvd[i].date = "          ";
						System.out.println("归还成功！");
						break;
					}else{
						System.out.println("该dvd已经归还！");
						break;
					}
				}
			}
		}
		if(find==0){
			System.out.println("没有找到该dvd，归还失败！");
		}
	}
}
