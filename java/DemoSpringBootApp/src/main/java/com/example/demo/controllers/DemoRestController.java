package com.example.demo.controllers;

import com.example.demo.services.ActionService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    static Logger log = Logger.getLogger(DemoRestController.class);

    @RequestMapping(value = "/createThreads", method = RequestMethod.GET)
    public String createThreads(@RequestParam String threadCount) {
        int count = Integer.parseInt(threadCount);
        log.info("Creating " + threadCount + " threads");
        ActionService.createThread(count);
        return threadCount;
    }

    @RequestMapping(value = "/gc", method = RequestMethod.GET)
    public String runGC() {
        ActionService.gc();
        return "0";
    }

    @RequestMapping(value = "/loadRam", method = RequestMethod.GET)
    public String loadRam(@RequestParam String mem) {
        int memory = Integer.parseInt(mem);
        log.info("Loading " + mem + " MiB RAM");
        ActionService.loadRam(memory);
        return mem;
    }

    @RequestMapping(value = "/loadCpu", method = RequestMethod.GET)
    public String loadCpu() {
        log.info("Loading CPU");
        ActionService.loadCpu(30);
        return "0";
    }
    //TODO mem and CPU high usage, prob app stop, generate ideas :)
}
