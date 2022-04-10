package tw.mingchang.loomtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@SpringBootApplication
@Controller
public class LoomTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoomTestApplication.class, args);
    }

    private String createStr() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    @GetMapping("/")
    public @ResponseBody
    Mono<String> hello(@RequestParam Integer virtualThread) {
        if (virtualThread == 1) {
            return Mono.just("")
                    .map(data -> {
                        var strBuilder = new StringBuilder();
                        try {
                            var result1 = new createStringClass();
                            Thread thread1 = Thread.startVirtualThread(result1);
                            thread1.join();
                            var result2 = new createStringClass();
                            Thread thread2 = Thread.startVirtualThread(result2);
                            thread2.join();
                            var result3 = new createStringClass();
                            Thread thread3 = Thread.startVirtualThread(result3);
                            thread3.join();
                            var result4 = new createStringClass();
                            Thread thread4 = Thread.startVirtualThread(result4);
                            thread4.join();
                            var result5 = new createStringClass();
                            Thread thread5 = Thread.startVirtualThread(result5);
                            thread5.join();
                            var result6 = new createStringClass();
                            Thread thread6 = Thread.startVirtualThread(result6);
                            thread6.join();
                            var result7 = new createStringClass();
                            Thread thread7 = Thread.startVirtualThread(result7);
                            thread7.join();
                            var result8 = new createStringClass();
                            Thread thread8 = Thread.startVirtualThread(result8);
                            thread8.join();
                            var result9 = new createStringClass();
                            Thread thread9 = Thread.startVirtualThread(result9);
                            thread9.join();
                            var result10 = new createStringClass();
                            Thread thread10 = Thread.startVirtualThread(result10);
                            thread10.join();
                            return strBuilder
                                    .append(result1.getValue())
                                    .append(result2.getValue())
                                    .append(result3.getValue())
                                    .append(result4.getValue())
                                    .append(result5.getValue())
                                    .append(result6.getValue())
                                    .append(result7.getValue())
                                    .append(result8.getValue())
                                    .append(result9.getValue())
                                    .append(result10.getValue())
                                    .toString();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "";
                    }).log();
        } else {
            return Mono.just("")
                    .flatMap(data -> Mono.just(new StringBuilder()
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .append(createStr())
                            .toString())
                    ).log();
        }
    }

}

class createStringClass implements Runnable {

    private volatile String value;

    private String createStr() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    @Override
    public void run() {
        value = createStr();
    }

    public String getValue() {
        return value;
    }
}
