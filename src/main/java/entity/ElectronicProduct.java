package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ElectronicProduct {
    Radio(20),TV(3000),IPHONE13(150),Camera(80),USB(20),VR(200),Xbox(250),PS5(300),Ipad(180);

    private double prize;
}
