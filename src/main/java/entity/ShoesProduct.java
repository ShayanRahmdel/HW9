package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ShoesProduct {
    AIRzoom(200),Adizero(190),EvoSpeed(170),TabrizShoes(150),MashadShoes(160);


    private double prize;
}
