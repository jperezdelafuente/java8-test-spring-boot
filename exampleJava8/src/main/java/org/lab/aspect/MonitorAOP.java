package org.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAOP {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* *.*.service.Service*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.debug("--> Start: " + joinPoint);
	}

	@AfterReturning("execution(* *.*.service.Service*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		logger.debug("--> End: " + joinPoint);
	}

}