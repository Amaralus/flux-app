package amaralus.apps.flux.app.service

import amaralus.apps.flux.app.model.Alpha
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class AlphaServiceTest extends Specification {

    @Autowired
    AlphaService alphaService;

    def "alpha by count sorted"() {
        given:
        def alphas = Alpha.byCount 5
        alphas.forEach(alpha -> alpha.setStr "map " + alpha.getStr() )

        when:
        def result = new ArrayList(alphaService.byCount(5).toIterable() as Collection)

        then:
        alphas == result
    }
}
