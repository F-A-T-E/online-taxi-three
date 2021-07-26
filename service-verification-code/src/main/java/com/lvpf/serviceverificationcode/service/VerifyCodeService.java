package com.lvpf.serviceverificationcode.service;

import com.lvpf.internalcommon.dto.ResponseResult;

public interface VerifyCodeService {

	public ResponseResult<VerifyCodeService> generate(int identity, String phoneNumber);
}
