package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ElectronicProduct {

    CAMERA("CAMERA"),
    TV("TV");


    private String name;

}
