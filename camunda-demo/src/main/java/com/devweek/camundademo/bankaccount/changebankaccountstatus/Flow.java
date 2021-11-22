package com.devweek.camundademo.bankaccount.changebankaccountstatus;

import lombok.*;
import lombok.extern.slf4j.*;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.runtime.*;

@Slf4j
@AllArgsConstructor
public abstract class Flow<T extends FlowContextData> {

    public static final String FLOW_CONTEXT_DATA = "flowContextData";
    protected RuntimeService runtimeService;
    private Class<T> variableType;

    public T runFlow(T flowContextData) {
        ProcessInstanceWithVariables instance = runtimeService.createProcessInstanceByKey(getFlowName().getFlowId())
                .setVariable(FLOW_CONTEXT_DATA, flowContextData)
                .executeWithVariablesInReturn();
        final T flowData = instance.getVariables().getValue(FLOW_CONTEXT_DATA, variableType);
        flowData.setProcessInstanceWithVariables(instance);
        return flowData;

    }

    public abstract FlowName getFlowName();
}
