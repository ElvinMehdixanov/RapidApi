package turboaz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CarsDataDto {
    public int id;
    public int year;
    public String make;
    public String model;
    public String type;
}
