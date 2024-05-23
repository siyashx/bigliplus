package com.biglikuryer.bigliplus.service.impl.superadmin;

import com.biglikuryer.bigliplus.dao.superadmin.SuperAdminRepository;
import com.biglikuryer.bigliplus.dto.superadmin.SuperAdminDto;
import com.biglikuryer.bigliplus.model.superadmin.SuperAdmin;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl {

    private final SuperAdminRepository superAdminRepository;

    private final ModelMapper modelMapper;

    public SuperAdminServiceImpl(SuperAdminRepository superAdminRepository, ModelMapper modelMapper) {
        this.superAdminRepository = superAdminRepository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<SuperAdminDto> getAllSuperAdmin() {
        List<SuperAdmin> list = superAdminRepository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, SuperAdminDto.class))
                .toList();
    }

    //ById
    public SuperAdminDto getSuperAdminById(Long id) {
        Optional<SuperAdmin> optional = superAdminRepository.findById(id);
        return optional.map(det -> modelMapper.map(det, SuperAdminDto.class)).orElse(null);
    }

    //Save
    public SuperAdminDto saveSuperAdmin(SuperAdminDto dto) {
        SuperAdmin det = modelMapper.map(dto, SuperAdmin.class);
        det = superAdminRepository.save(det);
        return modelMapper.map(det, SuperAdminDto.class);
    }

    //Update
    public SuperAdminDto updateSuperAdmin(Long id, SuperAdminDto superAdminDto) {
        Optional<SuperAdmin> superAdminOptional = superAdminRepository.findById(id);

        if (superAdminOptional.isPresent()) {
            SuperAdmin superAdmin = superAdminOptional.get();

            if (superAdminDto.getIsActive() != null) {
                superAdmin.setIsActive(superAdminDto.getIsActive());
            }

            if (superAdminDto.getLatestVersion() != null) {
                superAdmin.setLatestVersion(superAdminDto.getLatestVersion());
            }

            if (superAdminDto.getIsGoogleTest() != null) {
                superAdmin.setIsGoogleTest(superAdminDto.getIsGoogleTest());
            }


            superAdmin = superAdminRepository.save(superAdmin);
            return modelMapper.map(superAdmin, SuperAdminDto.class);
        }
        return null;
    }


}
