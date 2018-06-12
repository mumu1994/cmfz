package com.baizhi.controller;



import java.io.IOException;
import java.io.OutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.baizhi.entity.CreateValidateCode;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes(value="code")
public class YanZhengMaAction {

	@RequestMapping(value="/yanzheng")
	public String createYan(ModelMap map, OutputStream os) {
		//得到一个随机数
		CreateValidateCode cvc= new CreateValidateCode();
		String code = cvc.getCode();
		// 将随机数存入session作用域
		map.addAttribute("code", code);
		//调用工具类的方法画图片
		try {

			cvc.write(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
