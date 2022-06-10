package amaralus.apps.flux.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@ToString
public class ParamDto {
    private String str;
    private Date date;
    private BigInteger[] numId;

    public void setDate(String unixTime) {
        date = new Date(Long.parseLong(unixTime));
    }
}
