package com.prabhu.lombokExample;

import com.prabhu.beans.User;

public class LombokExample {

	public static void main(String[] args) {

		User u1 = new User();
		System.out.println(u1.toString());
		System.out.println(u1.hashCode());

	}

}
