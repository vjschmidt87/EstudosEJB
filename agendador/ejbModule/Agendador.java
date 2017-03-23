import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class Agendador {
	@Schedule(hour="*", minute="*", second="*/10", persistent=false)    
    void agendado() {
        System.out.println("verificando servi�o externo periodicamente");
    }
}
