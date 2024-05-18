package com.autorenta.Payment.mappers;

import com.autorenta.Payment.dto.payment.PaymentDto;
import com.autorenta.Payment.dto.payment.PaymentToSaveDto;
import com.autorenta.Payment.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment DtoToEntity(PaymentDto paymentDto);
    PaymentDto EntityToDto(Payment payment);
    @Mapping(target = "id", ignore = true)
    Payment toSaveDtoToEntity(PaymentToSaveDto paymentToSaveDto);
}
