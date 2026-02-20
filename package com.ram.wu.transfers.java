package com.ram.wu.transfers.api;

import com.ram.wu.transfers.model.TransferRequest;
import com.ram.wu.transfers.model.TransferResponse;
import com.ram.wu.transfers.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

  private final TransferService transferService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TransferResponse create(@Valid @RequestBody TransferRequest request) {
    return transferService.createTransfer(request);
  }

  @GetMapping("/{transferId}")
  public TransferResponse get(@PathVariable String transferId) {
    return transferService.getTransfer(transferId);
  }

  @GetMapping
  public List<TransferResponse> list(@RequestParam(required = false) String senderId) {
    return transferService.listTransfers(senderId);
  }
}