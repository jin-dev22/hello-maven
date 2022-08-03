package com.kh.app.emp.model.service;

import com.kh.app.emp.model.dao.EmpDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpDao empDao;
}
