package carServiceAndWash.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPart {
    private String name;
    private String status;
    private int durability;
    private boolean isReplaced;
}