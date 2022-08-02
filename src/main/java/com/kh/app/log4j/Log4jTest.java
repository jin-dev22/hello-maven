package com.kh.app.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {

	static final Logger log = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		log.fatal("FATAL!");//아주 심각한 에러
		log.error("ERROR!");//처리도중 오류(예외) 발생
		log.warn("WARN!");//현재 프로그램 실행에는 문제되지 않지만, 향후 시스템의 잠재적 오류가 될 수 있는경우(예: deprecated method..)
		log.info("INFO!");//프로그램 실행중에 상태변경 등 메세지
		log.debug("DEBUG!");//개발도중 필요한 메세지
		log.trace("TRACE!");//흐름의 시작과 끝을 정의하는 용도(작동 구간 나눠서 보기용)
	}

}
