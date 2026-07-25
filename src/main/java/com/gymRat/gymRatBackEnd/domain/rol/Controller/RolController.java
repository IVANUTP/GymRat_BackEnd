package com.gymRat.gymRatBackEnd.domain.rol.Controller;

import com.gymRat.gymRatBackEnd.domain.rol.Services.RolService;
import com.gymRat.gymRatBackEnd.domain.rol.entity.RolEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor

public class RolController {

    private  final RolService rolService;

    @GetMapping
    public List<RolEntity>lsitar(){
        return  rolService.obtenerRoles();
    }

}
