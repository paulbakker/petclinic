package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.dao.ClinicReporting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Controller
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    ClinicReporting reporting;

    @RequestMapping(method = RequestMethod.GET)
    public String showReports(Model model) {
        int visits = reporting.countVisitsAtDate(new Date());
        model.addAttribute("visitsToday", visits);

        return "reports";
    }
}
