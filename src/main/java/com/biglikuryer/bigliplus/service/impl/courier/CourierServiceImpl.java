package com.biglikuryer.bigliplus.service.impl.courier;

import com.biglikuryer.bigliplus.dao.courier.CourierRepository;
import com.biglikuryer.bigliplus.dto.courier.CourierDto;
import com.biglikuryer.bigliplus.model.courier.Courier;
import com.biglikuryer.bigliplus.service.inter.courier.CourierServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImpl implements CourierServiceInter {

    private final CourierRepository courierRepository;
    private final ModelMapper modelMapper;

    public CourierServiceImpl(CourierRepository courierRepository, ModelMapper modelMapper) {
        this.courierRepository = courierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourierDto> getAllCouriers() {
        List<CourierDto> listDto = new ArrayList<>();

        List<Courier> listEntity = courierRepository.findAll();

        for (Courier entity : listEntity) {
            CourierDto dto = modelMapper.map(entity, CourierDto.class);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public CourierDto getCourierById(Long id) {
        Courier entity = courierRepository.findById(id).orElse(null);
        if (entity != null) {
            return modelMapper.map(entity, CourierDto.class);
        }
        return null;
    }

    @Override
    public ResponseEntity<CourierDto> createCourier(CourierDto courierDto) {
        Courier courierEntity = modelMapper.map(courierDto, Courier.class);
        if (isCourierPhoneNumberTaken(courierEntity.getPhoneNumber())) {
            return ResponseEntity.badRequest().build();
        }
        courierEntity.setIsDisable(false);
        Courier savedCourier = courierRepository.save(courierEntity);
        return ResponseEntity.ok(modelMapper.map(savedCourier, CourierDto.class));
    }

    @Override
    public CourierDto updateCourier(Long id, CourierDto courierDto) {
        Optional<Courier> courierOptional = courierRepository.findById(id);
        if (courierOptional.isPresent()) {
            Courier courier = courierOptional.get();

            if (courierDto.getOneSignal() != null) {
                courier.setOneSignal(courierDto.getOneSignal());
            }
            if (courierDto.getName() != null) {
                courier.setName(courierDto.getName());
            }

            if (courierDto.getPhoneNumber() != null) {
                courier.setPhoneNumber(courierDto.getPhoneNumber());
            }

            if (courierDto.getMotoPhoto() != null) {
                courier.setMotoPhoto(courierDto.getMotoPhoto());
            }

            if (courierDto.getMotoDescription() != null) {
                courier.setMotoDescription(courierDto.getMotoDescription());
            }
            if (courierDto.getIsMutedGlobalMessages() != null) {
                courier.setIsMutedGlobalMessages(courierDto.getIsMutedGlobalMessages());
            }


            if (courierDto.getRating() != null) {
                courier.setRating(courierDto.getRating());
            }

            if (courierDto.getRatedCustomers() != null) {
                courier.setRatedCustomers(courierDto.getRatedCustomers());
            }

            if (courierDto.getRatedPoints() != null) {
                courier.setRatedPoints(courierDto.getRatedPoints());
            }

            if (courierDto.getPassword() != null) {
                courier.setPassword(courierDto.getPassword());
            }
            if (courierDto.getLatLong() != null) {
                courier.setLatLong(courierDto.getLatLong());
            }

            if (courierDto.getRadius() != null) {
                courier.setRadius(courierDto.getRadius());
            }

            if (courierDto.getWorkType() != null) {
                courier.setWorkType(courierDto.getWorkType());
            }

            if (courierDto.getIsActiveWorkTypeRequest() != null) {
                courier.setIsActiveWorkTypeRequest(courierDto.getIsActiveWorkTypeRequest());
            }

            if (courierDto.getIsAllowedEconomOrders() != null) {
                courier.setIsAllowedEconomOrders(courierDto.getIsAllowedEconomOrders());
            }

            if (courierDto.getCurrentlyDelivery() != null) {
                courier.setCurrentlyDelivery(courierDto.getCurrentlyDelivery());
            }

            if (courierDto.getMap() != null) {
                courier.setMap(courierDto.getMap());
            }
            if (courierDto.getOnline() != null) {
                courier.setOnline(courierDto.getOnline());
            }

            if (courierDto.getCreatedDate() != null) {
                courier.setCreatedDate(courierDto.getCreatedDate());
            }

            if (courierDto.getLastActiveDate() != null) {
                courier.setLastActiveDate(courierDto.getLastActiveDate());
            }

            if (courierDto.getDeviceId() != null) {
                courier.setDeviceId(courierDto.getDeviceId());
            }

            if (courierDto.getIsDisable() != null) {
                courier.setIsDisable(courierDto.getIsDisable());
            }

            courier = courierRepository.save(courier);
            return modelMapper.map(courier, CourierDto.class);
        }
        return null;
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }

    @Override
    public Boolean isCourierPhoneNumberTaken(String phoneNumber) {
        return courierRepository.findCourierByPhoneNumber(phoneNumber) != null;
    }

    @Override
    public CourierDto findCourierByPhoneNumber(String phoneNumber) {
        Courier courier = courierRepository.findCourierByPhoneNumber(phoneNumber);
        if (courier != null) {
            return modelMapper.map(courier, CourierDto.class);
        }
        return null;
    }
}
