package org.nicoardizzoli.fraud;

import com.nicoardizzoli.clients.fraud.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean fraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulentCustomer);
    }
}
