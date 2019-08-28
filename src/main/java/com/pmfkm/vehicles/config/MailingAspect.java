//package com.pmfkm.vehicles.config;
//
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.pmfkm.vehicles.config.MailSenderInfo;
//import com.pmfkm.vehicles.model.Employee;
//import com.pmfkm.vehicles.model.TravelOrder;
//
//
//@Aspect
//@Component
//public class MailingAspect {
//
//	@Autowired
//	private MailSenderInfo mailSenderInfo;
////	
//	@AfterReturning(value =  "execution(* com.pmfkm.vehicles.service.EmployeeService.saveEmployee(..))"
//			+ " && args(employee,..)")
//	public void afterUserRegistration(Employee employee) {
//		mailSenderInfo.sendMailToNewUser(employee);
//		mailSenderInfo.sendNewUserMail(employee);
//	}
//	
//	@AfterReturning(value = "execution(* com.pmfkm.vehicles.service.TravelOrderService.addTravelOrder(..))"
//			+ " && args(travelOrder,..)")
//	public void afterInsertTravelOrder(TravelOrder travelOrder) {
//		mailSenderInfo.sendMail(travelOrder);
//	}
//		
//	@AfterReturning(value = "execution(* com.pmfkm.vehicles.service.TravelOrderService.updateTravelOrder(..))"
//			+ " && args(travelOrder,..)")
//	public void afterUpdateTravelOrder(TravelOrder travelOrder) {
//		mailSenderInfo.sendMail(travelOrder);
//	}
//}
//
//
//
//
//
//
//
//
