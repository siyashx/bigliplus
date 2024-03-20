package com.biglikuryer.bigliplus.service.impl.admin;

import com.biglikuryer.bigliplus.dao.admin.AdminRepository;
import com.biglikuryer.bigliplus.dto.admin.AdminDto;
import com.biglikuryer.bigliplus.model.admin.Admin;
import com.biglikuryer.bigliplus.service.inter.admin.AdminServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServiceInter {

    private final AdminRepository adminRepository;

    private final ModelMapper modelMapper;

    public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdminDto getAdminById(Long id) {
        Admin entity = adminRepository.findById(id).orElse(null);
        if (entity != null) {
            return modelMapper.map(entity, AdminDto.class);
        }
        return null;
    }

    @Override
    public AdminDto updateAdmin(Long id, AdminDto adminDto) {
        Optional<Admin> adminOptional = adminRepository.findById(id);

        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();

            if (adminDto.getOneSignal() != null) {
                admin.setOneSignal(adminDto.getOneSignal());
            }

            if (adminDto.getNotificationDisable() != null) {
                admin.setNotificationDisable(adminDto.getNotificationDisable());
            }

            if (adminDto.getDeviceId() != null) {
                admin.setDeviceId(adminDto.getDeviceId());
            }

            admin = adminRepository.save(admin);
            return modelMapper.map(admin, AdminDto.class);
        }
        return null;
     }

    @Override
    public ResponseEntity<AdminDto> createAdmin(AdminDto adminDto) {
        Admin adminEntity = modelMapper.map(adminDto, Admin.class);
        Admin savedAdmin = adminRepository.save(adminEntity);
        return ResponseEntity.ok(modelMapper.map(savedAdmin, AdminDto.class));
    }
}
