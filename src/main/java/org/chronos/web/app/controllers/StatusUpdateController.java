package org.chronos.web.app.controllers;

import org.chronos.web.app.model.StatusUpdate;
import org.chronos.web.app.services.StatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatusUpdateController 
{
	@Autowired
	private StatusUpdateService statusUpdateService;
	
	@RequestMapping(value = "/addStatus", method = RequestMethod.GET)
	public ModelAndView addStatus(ModelAndView modelAndView, @ModelAttribute("statusUpdate")StatusUpdate statusUpdate) {

		modelAndView.setViewName("addStatus");

		StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();

		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);

		return modelAndView;
	}

	@RequestMapping(value = "/saveStatusUpdate", method = RequestMethod.POST)
	public ModelAndView saveStatusUpdate(ModelAndView modelAndView, StatusUpdate statusUpdate) {

		modelAndView.setViewName("addStatus");
		
		statusUpdateService.save(statusUpdate);
		
		StatusUpdate latestStatusUpdate = statusUpdateService.getLatest();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		// Refresh the page with a new blank object after saving to the Database
		modelAndView.getModel().put("statusUpdate", new StatusUpdate());
		

		return modelAndView;
	}
}

