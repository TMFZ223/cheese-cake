package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Desserts {
    TARTLETS("Тарталетки"),
    CHEESECAKEE("Чизкейк"),
    DONUTS("Пончики");
    private final String dessertTitle;
}
