package com.feb.test.servise;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.test.dao.MemberDao;
import com.feb.test.util.Sha512Encoder;

@Service
public class MemberServise {

	@Autowired
	MemberDao memberDao;
	
	public int join(HashMap<String, String> params) {
		
		System.out.println("memberId2 : " + params.get("memberId")); // memberId : s123s123s
		System.out.println("passwd2 : " + params.get("passwd")); // 123
		System.out.println("passwd22 : " + params.get("passwd2")); // 123
		
		if(!(params.get("passwd").equals(params.get("passwd2")))) { // 비밀번호가 같지 않으면 
			return -1; // -1반환
		}
		
		// 비밀번호 암호화
	    Sha512Encoder encoder = Sha512Encoder.getInstance();
		String passwd = params.get("passwd");
		String encodeTxt = encoder.getSecurePassword(passwd);
		params.put("passwd", encodeTxt); // 암호화한 패쓰워드 추가 
		
		return memberDao.join(params);
	}

}
