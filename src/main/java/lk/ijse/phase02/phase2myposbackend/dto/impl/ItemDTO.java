package lk.ijse.phase02.phase2myposbackend.dto.impl;

import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus{

    private String itemCode;
    private String description;
    private String qty;
    private String price;

    @Override
    public String getItemId() {
        System.out.println("Fixer method run...");
        return "Fixer method run...";
    }
}
