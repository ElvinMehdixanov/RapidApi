package turboaz.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import turboaz.client.CarsClient;
import turboaz.dto.CarsDataDto;


@RestController
@RequiredArgsConstructor
public class TurboController {

  private final  CarsClient carsClient;

    @RequestMapping(value = "/cars")
    public ResponseEntity<?> carsInfo() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "3ccd66b01dmsh09712a545cdaedap146142jsn9c8fc8e82b5f");
        headers.set("X-RapidAPI-Host", "car-data.p.rapidapi.com");


        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CarsDataDto[]> cars = restTemplate.exchange(
                "https://car-data.p.rapidapi.com/cars?limit=10&page=0",
                HttpMethod.GET, entity, CarsDataDto[].class);


        for (CarsDataDto car: cars.getBody()) {
            System.out.println(car.getMake());

            if (car.getMake().equals("GMC")){
                return new ResponseEntity<>("Yes We have volvo", HttpStatus.OK);
            }

        }


        return new ResponseEntity<>(cars.getBody(), HttpStatus.OK);
    }


}
