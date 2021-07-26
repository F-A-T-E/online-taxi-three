package com.lvpf.serviceverificationcode.controller;

import com.lvpf.internalcommon.dto.ResponseResult;
import com.lvpf.serviceverificationcode.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify-code")
public class VerifyCodeController {

	@Autowired
	VerifyCodeService verifyCodeService;

	/**
	 * 根据身份，手机号，生成验证码
	 *
	 * @param identity
	 * @param phoneNumber
	 * @return
	 */
	@GetMapping("/generate/{identity}/{phoneNumber}")
	public ResponseResult generate(@PathVariable("identity") int identity, @PathVariable("phoneNumber") String phoneNumber) {
		// 校验参数
		return verifyCodeService.generate(identity, phoneNumber);
	}

/*	@PostMapping("/verify")
	public ResponseResult verify(@RequestBody VerifyCodeRequest request) {
		//获取手机号和验证码
		String phoneNumber = request.getPhoneNumber();
		int identity = request.getIdentity();
		String code = request.getCode();

		return verifyCodeService.verify(identity,phoneNumber,code);

	}*/
}
