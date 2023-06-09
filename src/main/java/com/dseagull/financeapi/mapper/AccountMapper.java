package com.dseagull.financeapi.mapper;

import com.dseagull.financeapi.document.Account;
import com.dseagull.financeapi.model.dto.account.AccountCreationDto;
import com.dseagull.financeapi.model.dto.account.AccountDto;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);
    Set<AccountDto> toDto(Set<Account> accounts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creditCards", ignore = true)
    @Mapping(target = "balance", source = "initialBalance")
    Account toEntity(AccountCreationDto accountCreationDto);

}
