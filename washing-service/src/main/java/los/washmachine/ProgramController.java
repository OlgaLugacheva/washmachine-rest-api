package los.washmachine;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping({"/wash", "/", "/api/wash"})
public class ProgramController {

    private final Map<Integer, Program> users = new ConcurrentHashMap<Integer, Program>();

    private final AtomicInteger ids = new AtomicInteger(0);
    private final AtomicBoolean busy = new AtomicBoolean(false);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Program> list() {
        return users.values();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)

    public Program getById(@PathVariable String id) {
        return users.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Program create(@RequestBody Program program) {
        if (busy.get() == false) {
            final int id = ids.incrementAndGet();
            program.setId(id);
            program.setStatus("Is running");
            this.users.put(id, program);
            busy.set(true);
            return program;
        }
        else return null;

    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Program update(@RequestBody Program program) {
        program.setStatus("Finished");
        busy.set(false);
        this.users.put(program.getId(), program);
        return program;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Program delete(@RequestBody Program program) {
        this.users.remove(program);
        return program;
    }
}
