package com.gymRat.gymRatBackEnd.domain.rol.Services;

import com.gymRat.gymRatBackEnd.domain.rol.entity.RolEntity;
import com.gymRat.gymRatBackEnd.domain.rol.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RolService {
     private  final RolRepository rolRepository;

     public List<RolEntity>obtenerRoles(){
         return  rolRepository.findAll();
     }
}
