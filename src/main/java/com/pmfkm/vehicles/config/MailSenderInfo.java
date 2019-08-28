package com.pmfkm.vehicles.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.model.TravelOrder;

@Component
public class MailSenderInfo {

	@Autowired
	private JavaMailSender sender;
	
	public String sendMailToNewUser(Employee employee) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setSubject("Registration was successfull! ");
			helper.setTo(employee.getEmail());
			helper.setText(	"<div>" +
							"<p>Hello <b>" + employee.getFirstName()+ " " + employee.getLastName()+ "</b> you registered with this crentials:" + 
							"<p>Username: <b> " + employee.getUsername() + "</b></p>"+
							"If is not you, neglect this mail ", true);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail";
		}
				sender.send(message);
				return "Mail sent sucessfully";
	}
	
	public String sendNewUserMail(Employee employee) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setSubject("New user registered! ");
			helper.setTo("dacak55@yahoo.com");
			helper.setText("<div>" +
							"<p>Hello! New user <b>" + employee.getFirstName()+ " " + employee.getLastName()+ "</b> is registered with this crentials:" + 
							"<p>Username: <b> " + employee.getUsername() + "</b></p>"+
							"<p>Email <b>" + employee.getEmail() + "</b></p>"+
							"<p>Go to Vehicle Web App to activate the user<a href=\"https://www.youtube.com/watch?v=MgOdvqvF6gk \">Click here</a> </p></div>", true);
	
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail";
		}
				sender.send(message);
				return "Mail sent sucessfully";
	}

	public String sendMail(TravelOrder travelOrder) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setSubject("Mail From Vehicles application");
			helper.setTo(travelOrder.getEmployee().getEmail());
			helper.setText("<div>" + 
							"<h3>Hello "+ travelOrder.getEmployee().getFirstName()+" " +travelOrder.getEmployee().getLastName() +" from Vehicles application</h3>" 
							+ mailChooser(travelOrder) + "</div>", true);		
		} catch (MessagingException e) {
			  e.printStackTrace();
	          return "Error while sending mail ..";
		}
		sender.send(message);
		return "Mail sent successfuly";
	}
	
	private String mailChooser(TravelOrder travelOrder) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		 
		String messageContent=null;
		if(travelOrder.getTravelStatus().getId() == 1) {
			messageContent = "<p>Your request with id: <b>" +travelOrder.getId() + "</b> created at <b>" + dateFormat.format(travelOrder.getCreatedAt())+ "</b> has been <b>CREATED</b></p>" + 
							 "<p>We will try to solve your request as soon as possible<p>" +
							 "<p>Folow internal procedure or access Vehicle app for further details</p>";
		}
		if(travelOrder.getTravelStatus().getId() == 2) {
			messageContent = "<p>Your request with id: <b>" +travelOrder.getId() +"</b> created at <b>" + dateFormat.format(travelOrder.getCreatedAt()) + "</b> has been <b>APPROVED</b></p>" + 
							"<p>You can use company car from <b>"+ dateFormat.format(travelOrder.getDateStart())+ "</b> to <b>" +
							 									dateFormat.format(travelOrder.getDateEnd())+"</b></p>"+
							"<p>Folow internal procedure or access Vehicle app for further details</p>";
			if(travelOrder.getAdminNote() != null) {
				messageContent  += "<p><b>Administrator note:</b> "+travelOrder.getAdminNote() + "</p>";
			}
		}
		if(travelOrder.getTravelStatus().getId() == 3) {
			messageContent = "<p>Your request with id: <b>" +travelOrder.getId() +"</b> created at <b>" + dateFormat.format(travelOrder.getCreatedAt())+ "</b> has been <b>REFUSED</b></p>" + 
							 "<p> Folow internal procedure for further details  <p>";
			if(travelOrder.getAdminNote() != null) {
				messageContent  += "<p><b>Administrator note:</b> "+travelOrder.getAdminNote() + "</p>";
			}
		}
		if(travelOrder.getTravelStatus().getId() == 4) {
			messageContent = "<p>Your request with id: <b>" +travelOrder.getId() +"</b> created at <b>" + dateFormat.format(travelOrder.getCreatedAt())+ "</b> has been <b>FINISHED</b></p>" + 
							 "<p>All information about trip are inserted properly</p> ";	
			if(travelOrder.getAdminNote() != null) {
				messageContent  += "<p><b>Administrator note:</b> "+travelOrder.getAdminNote() + "</p>";
			}
		}
		return messageContent;
		
	}
}
