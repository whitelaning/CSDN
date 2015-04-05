package com.zack.csdn.tool;

public class StringTool {
	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			// ȫ�ǿո�Ϊ12288
			if (c[i] == 12288) {
				// ��ǿո�Ϊ32
				c[i] = (char) 32;
				continue;
			}
			// ���(33-126)��ȫ��(65281-65374)�Ķ�Ӧ��ϵ�ǣ����65248
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	public static String CN2EN(String input) {
		String[] regs = {
				"��", "��", "��", "��","��","��","��","��","��","��","�� ","��","����","������������",
				"!", ",", ".", ";" ,"?",":","\"","\"","'","'","( ",")","-","......",
		};
		for (int i = 0; i < regs.length / 2; i++) {
			input = input.replaceAll(regs[i], regs[i + regs.length / 2]);
		}
		
		return ToDBC(input);
	}
}
