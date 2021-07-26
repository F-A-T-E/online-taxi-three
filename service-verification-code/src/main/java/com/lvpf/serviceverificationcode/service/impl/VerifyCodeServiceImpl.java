package com.lvpf.serviceverificationcode.service.impl;

import com.lvpf.internalcommon.constant.CommonStatusEnum;
import com.lvpf.internalcommon.dto.ResponseResult;
import com.lvpf.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;
import com.lvpf.serviceverificationcode.service.VerifyCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

	@Override
	public ResponseResult<VerifyCodeService> generate(int identity, String phoneNumber) {
		//校验三档验证。乌云 安全检测 业务方控制 不能无限制发短信
		//redis 1分钟发了3次，限制你5分钟不让你发了，小时发了十次，24小时之内不能发了

		String code = String.valueOf((int) (Math.random() * 9 + 1) * Math.pow(10, 5));

		VerifyCodeResponse data = new VerifyCodeResponse();
		data.setCode(code);
		return ResponseResult.success(data);
	}

	//三档校验
	public ResponseResult verify(int identity, String phoneNumber, String code) {
		//三档验证
		//生成redis key

/*			String keyPre = generateKeyPreByIdentity(identity);
			String key = keyPre + phoneNumber;
			BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
			String redisCode = codeRedis.get();
			if(StringUtils.isNotBlank(code)
					&& StringUtils.isNotBlank(redisCode)
					&& code.trim().equals(redisCode.trim())) {

				return ResponseResult.success("");
			}else {
				return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
			}
		}*/
		return null;
	}

	/**
	 * 估算线程数
	 * 16核 应该开几个线程。
	 * 线程数 = cpu可用核数/1-阻塞系数（io密集型接近1，计算密集型接近0）
	 * <p>
	 * 提高QPS
	 * 提高并发数
	 * {
	 * 1、能用多线程的用多线程
	 * 2、增加各种连接数，tomcat、mysql、redis等等
	 * 3、增加实例  服务无状态，便于横向拓展。扩机器
	 * 4、让服务能力对等。（serviceUrl：打乱顺序）
	 * }
	 * 减少响应时间
	 * 1、异步（最终一致性，不需要及时）    流量削峰
	 * 2、缓存。（减少DB读取，减少磁盘io，读多，写少）
	 * 3、数据库优化。
	 * 4、多的数据，分批次返回。
	 * 5、减少 调用链。
	 * 6、长连接。不要轮询（）
	 * 7、
	 */

	public static void main(String[] args) {

		int sum = 1000000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < sum; i++) {
			String code = (Math.random() + "").substring(2, 8);
		}
		long end = System.currentTimeMillis();
		System.out.println("时间消耗：" + (end - start));

		long start1 = System.currentTimeMillis();
		for (int i = 0; i < sum; i++) {
			String code1 = String.valueOf((int) (Math.random() * 9 + 1) * Math.pow(10, 5));
		}
		long end1 = System.currentTimeMillis();
		System.out.println("时间消耗：" + (end1 - start1));
		/**
		 * 不要
		 */
/*		for(int i = 0; i < 100; i ++){
			String code = String.valueOf(new Random().nextInt(1000000));
			System.out.println(code);
		}*/
	}
}
