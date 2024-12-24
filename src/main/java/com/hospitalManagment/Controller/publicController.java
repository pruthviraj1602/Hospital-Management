package com.hospitalManagment.Controller;

import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class publicController {


    @Autowired
    private userServiceIMPL userServiceIMPL;
}
