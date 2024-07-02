package com.biglikuryer.bigliplus.service.inter.action;

import com.biglikuryer.bigliplus.dto.action.ActionDto;

import java.util.List;

public interface ActionServiceInter {

    ActionDto createAction(ActionDto actionDto);

    List<ActionDto> getAllActions();

    Boolean removeById(Long actionId);

    ActionDto getActionById(Long actionId);

    ActionDto updateAction(Long actionId, ActionDto actionDto);
}
