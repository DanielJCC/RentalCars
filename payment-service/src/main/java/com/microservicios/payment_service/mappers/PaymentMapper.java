package com.microservicios.payment_service.mappers;

import com.microservicios.payment_service.dto.payment.PaymentDto;
import com.microservicios.payment_service.dto.payment.PaymentToSaveDto;
import com.microservicios.payment_service.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment DtoToEntity(PaymentDto paymentDto);
    PaymentDto EntityToDto(Payment payment);
    @Mapping(target = "id", ignore = true)
    Payment toSaveDtoToEntity(PaymentToSaveDto paymentToSaveDto);
}
