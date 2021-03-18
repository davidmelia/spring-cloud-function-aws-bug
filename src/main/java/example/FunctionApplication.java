package example;

import java.util.Map;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
@Slf4j
public class FunctionApplication {

  /*
   * You need this main method or explicit <start-class>example.FunctionConfiguration</start-class> in
   * the POM to ensure boot plug-in makes the correct entry
   */
  public static void main(String[] args) {
    SpringApplication.run(FunctionApplication.class, args);
  }

  // @Bean
  public Function<Flux<Map>, Flux<String>> uppercase2() {
    return scheduledEvents -> scheduledEvents.map(scheduledEvent -> {
      log.info("scheduledEvent {}", scheduledEvent);
      System.out.println("***DAVE");
      return "dave";
    });
  }

  @Bean
  public Function<Flux<Map>, String> uppercase() {
    return event -> {
      log.info("scheduledEvent {}", event);
      System.out.println("***DAVE");
      return "dave";
    };

  }


}
