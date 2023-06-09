package com.dseagull.financeapi.controller.v1;

import com.dseagull.financeapi.model.dto.account.AccountCreationDto;
import com.dseagull.financeapi.model.dto.account.AccountDto;
import com.dseagull.financeapi.model.dto.account.AccountUpdateDto;
import com.dseagull.financeapi.service.v1.AccountService;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/user/{id}")
  public ResponseEntity<Set<AccountDto>> findByUserId(@PathVariable String id) {
    return ResponseEntity.ok(accountService.findByUserId(id));
  }

  @PostMapping()
  public ResponseEntity<Map<String, String>> create(AccountCreationDto accountDto) {
    return ResponseEntity.ok(accountService.create(accountDto));
  }

  @PatchMapping()
  public ResponseEntity<Object> update(AccountUpdateDto accountDto) {
    accountService.update(accountDto);
    return ResponseEntity.noContent().build();
  }
}
