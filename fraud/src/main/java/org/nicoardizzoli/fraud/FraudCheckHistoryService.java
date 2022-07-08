package org.nicoardizzoli.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {

        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createAt(LocalDateTime.now())
                .build();

        fraudCheckHistoryRepository.save(fraudCheckHistory);

        return false;
    }
}
