package com.myspring.pro30.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro30.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member);
	public ModelAndView removeMember(@RequestParam("id") String id);
	public ModelAndView form(@RequestParam(value = "action", required = false) String action,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request) throws Exception;
	
}
