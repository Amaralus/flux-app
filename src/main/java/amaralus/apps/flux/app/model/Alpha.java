package amaralus.apps.flux.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alpha {

    private String str;

    public static List<Alpha> byCount(int count) {
        var alphas = new ArrayList<Alpha>(count);
        for (int i = 0; i < count; i++)
            alphas.add(new Alpha(String.valueOf(i)));
        return alphas;
    }
}
