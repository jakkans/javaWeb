package com.myspring.pro27.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member);
	public ModelAndView removeMember(@RequestParam("id") String id);
	public ModelAndView form(@RequestParam(value="result", required = false) String result,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request) throws Exception;
	
}
