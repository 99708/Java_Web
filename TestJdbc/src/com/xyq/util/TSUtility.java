package com.xyq.util;

import java.util.*;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);
    	/**
    	 * 对输入的菜单值进行校验
    	 * @return
    	 */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
        	/**
        	 * 判断是否为个位数的选项
        	 */
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            //如果输入的数字不是1~4就重新输入
            if (c != '1' && c != '2' && c != '3') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }
	/**
	 * 按回车继续
	 */
    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }
    /**
     * 读取int类型的数值
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
        	/*
        	 * 2 表示可以是2位数字
        	 */
            String str = readKeyBoard(9, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     * 对是否提交的选项进行校验
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
        	/*1：只能输入一个值
        	 * toUpperCase()将输入的字母变为大写
        	 */
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }
    /**
     * 对输入的数据进行校验
     * @param limit  键盘录入的数字
     * @param blankReturn 
     * @return
     */
	private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn)
                	return line;
                else 
                	continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
	
	public static String readString() {
        String str;
        str = scanner.next();
        return str;
    }
	
	public static float readFloat() {
        float f;
        f = scanner.nextFloat();
        return f;
    }
	
}

