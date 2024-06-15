package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.lms.model.Member;
import com.springboot.lms.repo.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/members")
	public String getMembers(Model model) {
		List<Member> member = memberRepository.findAll();
		model.addAttribute("members", member);
		return "members";
	}

	@GetMapping("/member/new")
	public String addNewMember(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "create_member";
	}

	@PostMapping("/addMember")
	public String addMember(Member member) {
		memberRepository.save(member);
		return "redirect:/members";
	}

	@GetMapping("/member/{id}")
	public String getMemberById(@PathVariable("id") Long id, Model model) {
		Member member = memberRepository.findById(id).get();
		model.addAttribute("member", member);
		return "update_member";
	}

	@GetMapping("/delete/member/{id}")
	public String deleteMemberById(@PathVariable("id") Long id, Model model) {
		memberRepository.deleteById(id);
		return "redirect:/members";
	}
}
