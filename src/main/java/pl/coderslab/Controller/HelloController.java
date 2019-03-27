package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

@Controller
public class HelloController {
    @GetMapping("/workers")
    public String workersAction(Model model) {
        HashMap<Integer, String> workersMap = new HashMap<>();
        getWorkersMap(workersMap);
        int workerNumber = getRandomWorkerNumber();
        if (null == workersMap.get(workerNumber)) {
            model.addAttribute("worker", "Pracownik nie istniej");
        } else {
            model.addAttribute("worker", workersMap.get(workerNumber));
        }
        return "workers.jsp";
    }

    private int getRandomWorkerNumber() {
        Random random = new Random();
        return random.nextInt(29) + 1;
    }

    private void getWorkersMap(HashMap<Integer, String> workersMap) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Workers.txt").getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                workersMap.put(Integer.valueOf(line[0]), line[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
