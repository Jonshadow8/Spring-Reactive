import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;



public class MonoTest {

    @Test
    void firstMono(){
        Mono.just("A");
    }
    @Test
    void MonoWithConsumer() {
        Mono.just("A")
                .log()
                .subscribe(s -> System.out.println(s));
    }

    @Test
    void monoWithDoOn() {
        Mono.just("A")
                .log()
                .doOnSubscribe(subs -> System.out.println("Subscribed: " + subs))
                .doOnRequest(request -> System.out.println("Request: " + request))
                .doOnSuccess(complete -> System.out.println("Complete: " + complete))
                .subscribe(System.out::println);

    }
    @Test
    void emptyMono() {
        Mono.empty()
                .log().subscribe(System.out::println);
    }
    @Test
    void errorRuntimeExceptionMono() {
        Mono.error(new RuntimeException())
                .log().subscribe();
    }
}
