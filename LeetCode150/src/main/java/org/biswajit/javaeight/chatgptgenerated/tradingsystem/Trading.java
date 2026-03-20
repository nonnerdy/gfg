package org.biswajit.javaeight.chatgptgenerated.tradingsystem;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Trading {
    private String clientId;
    private String stock;
    private int quantity;
    private int price;
    private TradeType type; // BUY or SELL
}
