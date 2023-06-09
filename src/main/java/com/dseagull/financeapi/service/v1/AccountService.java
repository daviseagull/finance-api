package com.dseagull.financeapi.service.v1;

import com.dseagull.financeapi.document.Account;
import com.dseagull.financeapi.exception.ResourceNotFoundException;
import com.dseagull.financeapi.mapper.AccountMapper;
import com.dseagull.financeapi.model.dto.account.AccountCreationDto;
import com.dseagull.financeapi.model.dto.account.AccountDto;
import com.dseagull.financeapi.model.dto.account.AccountUpdateDto;
import com.dseagull.financeapi.repository.AccountRepository;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository repository;
  private final AccountMapper mapper;

  public Set<AccountDto> findByUserId(String id) {
    Set<AccountDto> accounts = mapper.toDto(repository.findAllByUser(id));
    log.info("Got accounts by user: { 'id': {}}", id);
    return accounts;
  }

  public Map<String, String> create(AccountCreationDto accountDto) {
    Account account = mapper.toEntity(accountDto);
    account = repository.save(account);

    log.info("Created account for user: { 'user': {}}", accountDto.user());
    return Map.of("id", account.getId());
  }

  public void update(AccountUpdateDto accountDto) {
    Account account =
        repository
            .findById(accountDto.id())
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        String.format("Account with id %s not found", accountDto.id())));

    account.setDescription(accountDto.description());
    repository.save(account);
    log.info("Updated account with id: { 'id': {}}", accountDto.id());
  }
}
