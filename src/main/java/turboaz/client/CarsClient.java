package turboaz.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carsClient", url = "https://car-data.p.rapidapi.com/cars/")
public interface CarsClient {


    @GetMapping("/{articleName}")
    String carsData(@PathVariable("articleName") String articleName);

}
