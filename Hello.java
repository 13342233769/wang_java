/**
 * 
 */
package net.yoodao.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.yoodao.springmvc.pojo.Fruits;
import net.yoodao.springmvc.pojo.User;
import net.yoodao.springmvc.util.DateConverter;

/**
 * @author 王诚
 *
 */
@Controller
public class Hello {
	@RequestMapping ( "/index" )
	public String test () {
		System.out.println ( "现在时间是：" + DateConverter.convertTime ( new Date () ) );
		return "test";
	}
	
	@RequestMapping ( "/login" )
	public String login () {
		return "login";
	}
	
	@RequestMapping ( "/dologin" )
	public String dologin (User user) {
		System.out.println ( user.getName () + "\t" + user.getPassword () );
		return "test";
	}
	
	@RequestMapping ( "/color" )
	public String color (String color, HttpSession session) {
		session.setAttribute ( "color" , color );
		System.out.println ( color );
		return "test";
	}
	
	@RequestMapping ( "/{a}ee/{b}se/{c}/{d}" )
	public String fruit (@PathVariable ( "a" ) String a, @PathVariable ( "b" ) String b, @PathVariable ( "c" ) String c,
			@PathVariable ( "d" ) Integer d, HttpSession session) {
		String string = a + b + c;
		
		Integer count = d;
		count++;
		List<Fruits> fruits = new ArrayList<> ();
		fruits.add ( new Fruits ( "苹果" , 25 , 3.4 , 0 ) );
		fruits.add ( new Fruits ( "香蕉" , 13 , 2.8 , 0 ) );
		fruits.add ( new Fruits ( "葡萄" , 16 , 10.5 , 0 ) );
		fruits.add ( new Fruits ( "山楂" , 7 , 18.5 , 0 ) );
		fruits.add ( new Fruits ( "西瓜" , 33 , 1.82 , 0 ) );
		session.setAttribute ( "fruits" , fruits );
		
		session.setAttribute ( "count" , count );
		return string;
	}
	
}
