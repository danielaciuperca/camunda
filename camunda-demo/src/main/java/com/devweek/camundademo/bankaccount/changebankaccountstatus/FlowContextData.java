package com.devweek.camundademo.bankaccount.changebankaccountstatus;

import lombok.*;
import org.camunda.bpm.engine.runtime.*;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowContextData implements Serializable {

    private transient ProcessInstanceWithVariables processInstanceWithVariables;
}
