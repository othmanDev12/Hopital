package org.essalami.hospital.web;

import org.essalami.hospital.entities.Doctor;
import org.essalami.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/doctor")
public class DoctorMvcController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "")
    public String patients2(Model model,
                            @RequestParam(name = "page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "5") int size,
                            @RequestParam(name = "keyword",defaultValue = "") String keyword
    ){
        Page<Doctor> pageDoctors= this.doctorService.getDoctorByReference(keyword,page,size);
        model.addAttribute("doctors",pageDoctors.getContent());
        model.addAttribute("pages",new int[pageDoctors.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "doctor/index";
    }

    @GetMapping(path = "/")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword
    ){
        Page<Doctor> pageDoctors= this.doctorService.getDoctorByReference(keyword,page,size);
        model.addAttribute("doctors",pageDoctors.getContent());
        model.addAttribute("pages",new int[pageDoctors.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "doctor/index";
    }

    @GetMapping("delete")
    public RedirectView delete(Long id, String keyword, int page) {
        doctorService.deleteDoctor(id);
        return new RedirectView("?page="+page+"&keyword="+keyword, true);
        //   return "redirect:patient?page="+page+"&keyword="+keyword;
    }
}