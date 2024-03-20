package com.biglikuryer.bigliplus.service.impl.notification;

import com.biglikuryer.bigliplus.dao.notification.AdminNotificationRepository;
import com.biglikuryer.bigliplus.dto.notification.AdminNotificationDto;
import com.biglikuryer.bigliplus.model.notification.AdminNotification;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminNotificationImpl {

    private final AdminNotificationRepository adminNotificationRepository;
    private final ModelMapper modelMapper;

    public AdminNotificationImpl(AdminNotificationRepository adminNotificationRepository, ModelMapper modelMapper) {
        this.adminNotificationRepository = adminNotificationRepository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<AdminNotificationDto> getAllAdminNotification() {
        List<AdminNotification> list = adminNotificationRepository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, AdminNotificationDto.class))
                .toList();
    }

    //ById
    public AdminNotificationDto getAdminNotificationById(Long id) {
        Optional<AdminNotification> optional = adminNotificationRepository.findById(id);
        return optional.map(det -> modelMapper.map(det, AdminNotificationDto.class)).orElse(null);
    }

    //Save
    public AdminNotificationDto saveAdminNotification(AdminNotificationDto dto) {
        AdminNotification det = modelMapper.map(dto, AdminNotification.class);
        det = adminNotificationRepository.save(det);
        return modelMapper.map(det, AdminNotificationDto.class);
    }

    //Delete
    public Boolean deleteAdminNotification(Long id) {
        Optional<AdminNotification> optional = adminNotificationRepository.findById(id);
        if (optional.isPresent()) {
            AdminNotification det = optional.get();
            adminNotificationRepository.delete(det);
            return true;
        }
        return false;
    }


}

