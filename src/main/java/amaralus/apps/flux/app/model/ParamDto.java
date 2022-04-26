package amaralus.apps.flux.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class ParamDto {
    private String str;
    private BigInteger[] numId;
}
