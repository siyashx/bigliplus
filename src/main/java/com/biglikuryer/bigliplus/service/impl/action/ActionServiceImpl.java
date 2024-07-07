package com.biglikuryer.bigliplus.service.impl.action;

import com.biglikuryer.bigliplus.dao.action.ActionRepository;
import com.biglikuryer.bigliplus.dto.action.ActionDto;
import com.biglikuryer.bigliplus.model.action.Action;
import com.biglikuryer.bigliplus.service.inter.action.ActionServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActionServiceImpl implements ActionServiceInter {

    private final ActionRepository actionRepository;
    private final ModelMapper modelMapper;

    public ActionServiceImpl(ActionRepository actionRepository, ModelMapper modelMapper) {
        this.actionRepository = actionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ActionDto createAction(ActionDto actionDto) {
        Action action = modelMapper.map(actionDto, Action.class);
        action = actionRepository.save(action);
        return modelMapper.map(action, ActionDto.class);
    }

    @Override
    public List<ActionDto> getAllActions() {
        List<Action> actions = actionRepository.findAll();
        return actions.stream()
                .map(action -> modelMapper.map(action, ActionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActionDto getActionById(Long actionId) {
        Optional<Action> actionOptional = actionRepository.findById(actionId);
        return actionOptional.map(action -> modelMapper.map(action, ActionDto.class)).orElse(null);
    }

    @Override
    public ActionDto updateAction(Long actionId, ActionDto actionDto) {
        Optional<Action> actionOptional = actionRepository.findById(actionId);
        if (actionOptional.isPresent()) {
            Action action = actionOptional.get();

            if (actionDto.getMainUserId() != null) {
                action.setMainUserId(actionDto.getMainUserId());
            }

            if (actionDto.getInviteDate() != null) {
                action.setInviteDate(actionDto.getInviteDate());
            }

            if (actionDto.getCreatedByCustomer() != null) {
                action.setCreatedByCustomer(actionDto.getCreatedByCustomer());
            }

            if (actionDto.getIsDisAllowedCustomerJoin() != null) {
                action.setIsDisAllowedCustomerJoin(actionDto.getIsDisAllowedCustomerJoin());
            }

            if (actionDto.getSubCustomersId() != null) {
                action.setSubCustomersId(actionDto.getSubCustomersId());
            }

            if (actionDto.getSubCouriersId() != null) {
                action.setSubCouriersId(actionDto.getSubCouriersId());
            }

            if (actionDto.getPickupLocationTitle() != null) {
                action.setPickupLocationTitle(actionDto.getPickupLocationTitle());
            }

            if (actionDto.getPickupLocation() != null) {
                action.setPickupLocation(actionDto.getPickupLocation());
            }
            if (actionDto.getToLocationTitle() != null) {
                action.setToLocationTitle(actionDto.getToLocationTitle());
            }

            if (actionDto.getMaxSubSize() != null) {
                action.setMaxSubSize(actionDto.getMaxSubSize());
            }

            if (actionDto.getPickupTime() != null) {
                action.setPickupTime(actionDto.getPickupTime());
            }

            if (actionDto.getPickupDate() != null) {
                action.setPickupDate(actionDto.getPickupDate());
            }

            if (actionDto.getStatus() != null) {
                action.setStatus(actionDto.getStatus());
            }

            if (actionDto.getDescription() != null) {
                action.setDescription(actionDto.getDescription());
            }

            if (actionDto.getCreatedDate() != null) {
                action.setCreatedDate(actionDto.getCreatedDate());
            }

            action = actionRepository.save(action);
            return modelMapper.map(action, ActionDto.class);

        }
        return null;
    }

    @Override
    public Boolean removeById(Long actionId) {
        Optional<Action> actionOptional = actionRepository.findById(actionId);
        if (actionOptional.isPresent()) {
            Action action = actionOptional.get();
            actionRepository.delete(action);
            return true;
        }
        return false;
    }
}
