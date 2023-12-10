package org.example.remittance.application.port.out.money;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//  송금서비스에서 필요한 머니의 정보
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyInfo {

    private String membershipId;
    private int balance;
}