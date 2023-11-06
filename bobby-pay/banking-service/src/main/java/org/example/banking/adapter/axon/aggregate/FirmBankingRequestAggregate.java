package org.example.banking.adapter.axon.aggregate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.banking.adapter.axon.command.CreateFirmBankingRequestCommand;
import org.example.banking.adapter.axon.command.UpdateFirmBankingRequestCommand;
import org.example.banking.adapter.axon.event.FirmBankingRequestCreatedEvent;
import org.example.banking.adapter.axon.event.FirmBankingRequestUpdatedEvent;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@Aggregate()
@Data
public class FirmBankingRequestAggregate {

    @AggregateIdentifier
    private String id;

    private String fromBankName;
    private String fromBankAccountNumber;

    private String toBankName;
    private String toBankAccountNumber;

    private int moneyAmount;

    private int firmBankingStatus;

    @CommandHandler
    public FirmBankingRequestAggregate(CreateFirmBankingRequestCommand command) {
        log.info("CreateFirmBankingRequestCommand Handler");

        apply(new FirmBankingRequestCreatedEvent(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber(),
                command.getMoneyAmount()
        ));
    }

    @CommandHandler
    public String handle(UpdateFirmBankingRequestCommand command) {
        log.info("UpdateFirmBankingRequestCommand Handler");

        id = command.getAggregateIdentifier();
        apply(new FirmBankingRequestUpdatedEvent(command.getFirmBankingStatus()));

        return id;
    }

    @EventSourcingHandler
    public void on(FirmBankingRequestCreatedEvent event) {
        log.info("FirmBankingRequestCreatedEvent Sourcing Handler");

        id = UUID.randomUUID().toString();
        fromBankName = event.getFromBankName();
        fromBankAccountNumber = event.getFromBankAccountNumber();
        toBankName = event.getToBankName();
        toBankAccountNumber = event.getToBankAccountNumber();
    }

    @EventSourcingHandler
    public void on(FirmBankingRequestUpdatedEvent event) {
        log.info("FirmBankingRequestUpdatedEvent Sourcing Handler");

        firmBankingStatus = event.getFirmBankingStatus();
    }

    public FirmBankingRequestAggregate() {
    }
}