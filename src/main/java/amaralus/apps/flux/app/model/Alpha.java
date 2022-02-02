package amaralus.apps.flux.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
public class Alpha {

    private String str;

    public static List<Alpha> byCount(int count) {
        var alphas = new ArrayList<Alpha>(count);
        for (int i = 0; i < count; i++)
            alphas.add(new Alpha(String.valueOf(i)));
        return alphas;
    }

    public void setStr(String str) {
        log.debug("set str={}", str);
        this.str = str;
    }
}
